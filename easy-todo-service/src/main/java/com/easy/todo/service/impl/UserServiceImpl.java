package com.easy.todo.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.easy.todo.dao.UserDao;
import com.easy.todo.domain.enumerate.PrefixEnum;
import com.easy.todo.domain.enumerate.TerminalEnum;
import com.easy.todo.domain.exception.ExceptionList;
import com.easy.todo.domain.session.SessionInfo;
import com.easy.todo.domain.user.User;
import com.easy.todo.service.BaseService;
import com.easy.todo.service.UserService;
import com.easy.todo.util.other.IDGenerate;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.*;

/**
 * User: zhangtan
 * Date: 12-9-7
 * Time: 上午9:47
 */
@Service
public class UserServiceImpl extends BaseService implements UserService {

    @Resource
    private UserDao userDao;

    @Resource
    private RedisTemplate<Serializable, Serializable> redisTemplate;

    public void insertUser(User user) {
        userDao.insertUser(user);
        log.info("add user sucess! email = " + user.getEmail());
    }

    public String login(User user) throws ExceptionList {
        List<Throwable> causes = new ArrayList<Throwable>();
        boolean rs = false;
        User userRs = userDao.selectUserByEmail(user.getEmail());
        if (StringUtils.isBlank(user.getEmail())) {
            causes.add(new SecurityException("登录名为空"));
        }
        if (StringUtils.isBlank(user.getPwd())) {
            causes.add(new SecurityException("用户名为空"));
        }
        if (!userRs.getPwd().equals(user.getPwd())) {
            causes.add(new SecurityException("用户密码不对"));
        }

        if (!userRs.getPwd().equals(user.getPwd())) {
            log.info("user login sucess! email = " + user.getEmail());
            rs = true;
        }
        if (causes.size() > 0) {
            throw new ExceptionList(causes);
        }

        return cacheLoginInfo(userRs);
    }

    /**
     * 缓存session和用户信息
     * @param userRs  根据登录名查出来的用户信息
     * @return
     */
    public String cacheLoginInfo(User userRs) {
        Map<String, String> data = new HashMap<String, String>();
        BoundHashOperations<Serializable, String, String> ops = redisTemplate.boundHashOps(PrefixEnum.SESSION_MAP.getValue() + userRs.getUserId());
        String sessionID = IDGenerate.generateSessionID(userRs.getUserId());
        SessionInfo sessionInfo = new SessionInfo();
        sessionInfo.setCreateDate(new Date());
        sessionInfo.setUpdateTime(new Date());
        sessionInfo.setSessionId(sessionID);
        sessionInfo.settId(TerminalEnum.Terminal_WEB.getValue());
        data.put(PrefixEnum.SESSION_MAP.getValue() + sessionID, JSONObject.toJSON(sessionInfo).toString());
        ops.putAll(data);
        return sessionID;
    }

}
