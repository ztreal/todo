package com.easy.todo;

import com.easy.todo.domain.user.User;
import org.junit.Test;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;
import java.io.Serializable;

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

}
