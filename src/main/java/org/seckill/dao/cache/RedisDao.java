package org.seckill.dao.cache;

import com.dyuproject.protostuff.LinkedBuffer;
import com.dyuproject.protostuff.ProtostuffIOUtil;
import com.dyuproject.protostuff.runtime.RuntimeSchema;
import org.seckill.entity.Seckill;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class RedisDao {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final JedisPool jedisPool;

    public RedisDao(String ip, int port){
        jedisPool = new JedisPool(ip, port);
    }

    private RuntimeSchema<Seckill> schema = RuntimeSchema.createFrom(Seckill.class);

    public Seckill getSeckill(long seckillId){
        //redis操作逻辑
        try {
            //jedispoll相当于数据库的连接池
            //jedis对象相当于数据库的connection
            Jedis jedis = jedisPool.getResource();
            try {
                String key = "seckill:" + seckillId;
                //redis并没有实现内部序列化操作
                // get到的是一个二进制数组byte[]，而不关心是否为一个java对象
                // 需要通过反序列化去得到Object(Seckill)
                // 采用自定义序列化方法（速度更快）
                // protostuff:要求对象是pojo，也就是有get、set方法的标准的Java对象
                byte[] bytes = jedis.get(key.getBytes());
                //缓存中获取到
                if(bytes != null){
                    //空对象
                    Seckill seckill = schema.newMessage();
                    ProtostuffIOUtil.mergeFrom(bytes, seckill, schema);
                    return seckill;
                }
            } finally {
                jedis.close();
            }
        } catch (Exception e){
            logger.error(e.getMessage(), e);
        }
        return null;
    }

    public String putSeckill(Seckill seckill){
        // set Object(Seckill) --> byte[] 是一个序列化的过程
        try{
            Jedis jedis = jedisPool.getResource();
            try{
                String key = "seckill:" + seckill.getSeckillId();
                byte[] bytes = ProtostuffIOUtil.toByteArray(seckill, schema,
                        LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE));
                int timeout = 60 * 60; //一小时
                String result = jedis.setex(key.getBytes(), timeout,bytes);
                return result;
            } finally {
                jedis.close();
            }
        } catch (Exception e){
            logger.error(e.getMessage(), e);
        }
        return null;
    }
}
