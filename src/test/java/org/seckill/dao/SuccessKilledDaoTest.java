package org.seckill.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.SuccessKilled;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * 配置spring和junit整合，junit启动时加载springIOC容器
 * spring-test,junit
 */
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SuccessKilledDaoTest {

    //注入Dao实现类依赖
    @Resource
    private SuccessKilledDao successKilledDao;

    @Test
    /**
     * 第一次插入：insertCount:1
     * 第二次插入：insertCount:0
     */
    public void testInsertSuccessKilled() throws Exception{
        int insertCount = successKilledDao.insertSuccessKilled(1003L, 79854444L);
        System.out.println("insertCount:" + insertCount);
    }

    @Test
    /**
     * SuccessKilled
     * {seckillId=1003,
     * userPhone=79854444,
     * state=-1,
     * createTime=Sat Feb 06 13:29:23 GMT+08:00 2021}
     * Seckill
     * {seckillId=1003,
     * name='1000元秒杀小米10',
     * number=400,
     * startTime=Fri Feb 05 00:00:00 GMT+08:00 2021,
     * endTime=Sat Feb 06 00:00:00 GMT+08:00 2021,
     * createTime=Wed Feb 03 20:50:11 GMT+08:00 2021}
     */
    public void testQueryByIdWithSeckill() throws Exception{
        SuccessKilled successKilled = successKilledDao.queryByIdWithSeckill(1003L, 79854444L);
        System.out.println(successKilled);
        System.out.println(successKilled.getSeckill());
    }
}