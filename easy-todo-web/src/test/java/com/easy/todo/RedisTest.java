package com.easy.todo;

import com.alibaba.fastjson.JSONObject;
import com.easy.todo.domain.constants.TodoConstantsUtil;
import com.easy.todo.domain.enumerate.PrefixEnum;
import com.easy.todo.domain.enumerate.TerminalEnum;
import com.easy.todo.domain.session.SessionInfo;
import com.easy.todo.domain.user.User;
import com.easy.todo.util.other.IDGenerate;
import org.junit.Test;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.support.atomic.RedisAtomicLong;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * User: zhangtan
 * Date: 13-8-16
 * Time: 下午3:43
 */
public class RedisTest extends BaseTestCase {

    @Resource
    private RedisTemplate<Serializable, Serializable> redisTemplate;



    @Test
   	public void save() {
        final User user = new User();
        user.setUserId("1");
        user.setEmail("zt@1.com");
   		redisTemplate.execute(new RedisCallback<Object>() {
   			@Override
   			public Object doInRedis(RedisConnection jdedisconnection)
   					throws DataAccessException {
                   jdedisconnection.set(
   						redisTemplate.getStringSerializer().serialize(
   								"user.email." + user.getEmail()),
   						redisTemplate.getStringSerializer().serialize(
   								user.getEmail()));
   				return null;
   			}
   		});
   	}


    @Test
   	public void read() {
        final String uid = "1";
   		User user =  redisTemplate.execute(new RedisCallback<User>() {
   			@Override
   			public User doInRedis(RedisConnection jdedisconnection)
   					throws DataAccessException {
   				byte[] key = redisTemplate.getStringSerializer().serialize(
   						"user.uid." + uid);
   				if (jdedisconnection.exists(key)) {
   					byte[] value = jdedisconnection.get(key);
   					String email = redisTemplate.getStringSerializer()
   							.deserialize(value);
   					User user = new User();
   					user.setEmail(email);
   					user.setUserId(uid);
   					return user;
   				}
   				return null;
   			}
   		});
   	}

    @Test
    public void testAtom() {
        ValueOperations<Serializable, Serializable>   valueOps = redisTemplate.opsForValue();
//   		users = new DefaultRedisList<String>(KeyUtils.users(), template);
//   		timeline = new DefaultRedisList<String>(KeyUtils.timeline(), redisTemplate);
        RedisAtomicLong userIdCounter = new RedisAtomicLong("global:uid", redisTemplate.getConnectionFactory());
        RedisAtomicLong postIdCounter = new RedisAtomicLong("pid:", redisTemplate.getConnectionFactory());      //此时已经在redis中建立对象pid:
        for (int i = 0 ;i<10;i++){
            System.out.println(userIdCounter.incrementAndGet());
        }
    }

    @Test
    public void testMap() {
        Map<String, String> data = new HashMap<String, String>();

//        测试写入map     SESSION_MAPSID_5215c904c2e6edd8f77a4fb6_13776717560001
        BoundHashOperations<Serializable, String, String> ops = redisTemplate.boundHashOps(PrefixEnum.SESSION_MAP.getValue() + "AAAAAA");
        String sessionID = IDGenerate.generateSessionID("");
        SessionInfo sessionInfo = new SessionInfo();
        sessionInfo.setCreateDate(new Date());
        sessionInfo.setUpdateTime(new Date());
        sessionInfo.setSessionId(sessionID);
        sessionInfo.settId(TerminalEnum.Terminal_WEB.getValue());

        data.put(PrefixEnum.SESSION_MAP +  "bbb", JSONObject.toJSON(sessionInfo).toString());
        data.put("aaa","111");
        ops.putAll(data); //这一行才写入数据

//测试取出map
        System.out.println(ops.get(PrefixEnum.SESSION_MAP + "bbb"));
        //取出map中一个value
        SessionInfo sessionObject = JSONObject.parseObject(ops.get(PrefixEnum.SESSION_MAP + "bbb"),SessionInfo.class);
        System.out.println(sessionObject.getCreateDate());
        System.out.println(Calendar.getInstance().getTimeInMillis());

//测试修改map中一个值，其他是否有影响，结果无影响
        System.out.println("star test modify one key of map ,value ="+ops.get("aaa"));
        System.out.println(ops.get(PrefixEnum.SESSION_MAP + "bbb"));
        ops.put("aaa", "1");
        System.out.println("end test modify one key of map ,value = " + ops.get("aaa"));
        System.out.println(ops.get(PrefixEnum.SESSION_MAP + "bbb"));
//       有效期测试
        System.out.println("修改前有效期为："+ops.getExpire());
        ops.expire(30L, TimeUnit.MINUTES);
        System.out.println("修改后有效期为："+ops.getExpire());

    }


    @Test
    public void test(){
        System.out.println(TodoConstantsUtil.domain);
    }

}
