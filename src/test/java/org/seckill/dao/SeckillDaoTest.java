package org.seckill.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.Seckill;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * 配置spring和junit整合，junit启动时加载springIOC容器
 * spring-test,junit
 */
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SeckillDaoTest {

    //注入Dao实现类依赖
    @Resource
    private SeckillDao seckillDao;

    @Test
    /**
     *1000元秒杀华为mate40
     * Seckill
     * {seckillId=1000,
     * name='1000元秒杀华为mate40',
     * number=100,
     * startTime=Fri Feb 05 00:00:00 GMT+08:00 2021,
     * endTime=Sat Feb 06 00:00:00 GMT+08:00 2021,
     * createTime=Wed Feb 03 20:50:11 GMT+08:00 2021}
     */
    public void testQueryById() throws Exception {
        long id = 1000;
        Seckill seckill = seckillDao.queryById(id);
        System.out.println(seckill.getName());
        System.out.println(seckill);
    }

    /**
     * Caused by: org.apache.ibatis.binding.BindingException:
     * Parameter 'offset' not found. Available parameters are [0, 1, param1, param2]
     */
    //List<Seckill> queryAll(int offset, int limit)
    //java没有保存形参的记录：queryAll(int offset, int limit) ——> queryAll(arg0, qrg1)
    //List<Seckill> queryAll(@Param("offset") int offset, @Param("limit") int limit);

    /**
     * Seckill{seckillId=1000, name='1000元秒杀华为mate40', number=100, startTime=Fri Feb 05 00:00:00 GMT+08:00 2021, endTime=Sat Feb 06 00:00:00 GMT+08:00 2021, createTime=Wed Feb 03 20:50:11 GMT+08:00 2021}
     * Seckill{seckillId=1001, name='500元秒杀iPhone12', number=200, startTime=Fri Feb 05 00:00:00 GMT+08:00 2021, endTime=Sat Feb 06 00:00:00 GMT+08:00 2021, createTime=Wed Feb 03 20:50:11 GMT+08:00 2021}
     * Seckill{seckillId=1002, name='300元秒杀OPPO Reno5 Pro', number=300, startTime=Fri Feb 05 00:00:00 GMT+08:00 2021, endTime=Sat Feb 06 00:00:00 GMT+08:00 2021, createTime=Wed Feb 03 20:50:11 GMT+08:00 2021}
     * Seckill{seckillId=1003, name='1000元秒杀小米10', number=400, startTime=Fri Feb 05 00:00:00 GMT+08:00 2021, endTime=Sat Feb 06 00:00:00 GMT+08:00 2021, createTime=Wed Feb 03 20:50:11 GMT+08:00 2021}
     */
    @Test
    public void testQueryAll() throws Exception {
        List<Seckill> seckills = seckillDao.queryAll(0, 100);
        for (Seckill seckill : seckills){
            System.out.println(seckill);
        }
    }

    @Test
    public void testReduceNumber() throws Exception {
        Date killTime = new Date();
        int updateCount = seckillDao.reduceNumber(1000L, killTime);
        System.out.println("updateCount:" + updateCount);
    }


}