**seckill工程文件目录**

├─src
│  ├─main
│  └─test  `单元测试`
└─pom.xml  `第三包jar包的依赖信息`
     

**main文件目录**

├─java  `Java源文件`
│  └─org
│      └─seckill
│          ├─dao  `dao接口`
│          │      SeckillDao.java  `对应Seckill实体类的接口`
│          │      SuccessKilledDao.java  `对应SuccessKilled实体类的接口`
│          │      
│          ├─dto
│          │      Exposure.java
│          │      SeckillExecution.java
│          │      SeckillResult.java
│          │      
│          ├─entity  `实体类`
│          │      Seckill.java  `对应秒杀库存表的实体类`
│          │      SuccessKilled.java  `对应秒杀信息表的实体类`
│          │      
│          ├─enums
│          │      SeckillStateEnum.java
│          │      
│          ├─exception
│          │      RepeatKillException.java
│          │      SeckillCloseException.java
│          │      SeckillException.java
│          │      
│          ├─service
│          │  │  SeckillService.java
│          │  │  
│          │  └─impl
│          │          SeckillServiceImpl.java
│          │          
│          └─web
│                  SeckillController.java
│                  
├─resources
│  │  jdbc.properties  `jdbc配置文件`
│  │  logback.xml
│  │  mybatis-config.xml  `Mybatis全局的配置文件`
│  │  
│  ├─mapper  `存放MyBatis sql映射`
│  │      SeckillDao.xml  `对应于SeckillDao接口，使用标签执行sql语句`
│  │      SuccessKilledDao.xml  `对应于SuccessKilledDao接口，使用标签执行sql语句`
│  │      
│  └─spring  `spring相关配置文件`
│          spring-dao.xml  `所有dao相关配置`
│          spring-service.xml
│          spring-web.xml
│      
└─webapp
    │  index.jsp
    │  
    ├─resources
    │  └─script
    │          seckill.js
    │          
    └─WEB-INF   `Java的WEB应用的安全目录。如果想在页面中直接访问其中的文件，必须通过web.xml文件对要访问的文件进行相应映射才能访问。`
        │  web.xml  `用来配置：欢迎页、servlet、filter等的，并不是Java web工程所必需的，可以不用`
        │  
        └─jsp
            │  detail.jsp
            │  list.jsp
            │  
            └─common
                    head.jsp
                    tag.jsp

**test文件目录**

├─java  `Java源文件`
│  └─org
│      └─seckill
│          ├─dao
│          │      SeckillDaoTest.java
│          │      SuccessKilledDaoTest.java
│          │
│          └─service
│                  SeckillServiceTest.java
│ 
└─resources