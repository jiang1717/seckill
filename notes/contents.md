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
│          │   │ SeckillDao.java  `对应Seckill实体类的接口`
│          │   │ SuccessKilledDao.java  `对应SuccessKilled实体类的接口`
│          │   │  
│          │   └─cache  
│          │          RedisDao.java  `Redis数据访问对象`
│          │
│          ├─dto  `数据传输层，关注web和service之间的数据传递`
│          │      Exposure.java  `暴露秒杀地址`
│          │      SeckillExecution.java `封装秒杀后的执行结果`
│          │      SeckillResult.java  `封装json结果`
│          │      
│          ├─entity  `实体类`
│          │      Seckill.java  `对应秒杀库存表的实体类`
│          │      SuccessKilled.java  `对应秒杀信息表的实体类`
│          │      
│          ├─enums  `枚举类型`
│          │      SeckillStateEnum.java  `使用枚举表述常量数据字典`
│          │      
│          ├─exception  `异常类，存放service所需要的异常`
│          │      RepeatKillException.java  `重复秒杀异常`
│          │      SeckillCloseException.java  `秒杀关闭异常`
│          │      SeckillException.java  `秒杀相关业务异常`
│          │      
│          ├─service  `service层，业务逻辑层`
│          │  │  SeckillService.java  `Service接口`
│          │  │  
│          │  └─impl
│          │          SeckillServiceImpl.java  `Service接口实现`
│          │          
│          └─web  `web层`
│                  SeckillController.java  `实现所有的秒杀api`
│                  
├─resources  `配置文件夹`
│  │  jdbc.properties  `jdbc配置文件`
│  │  logback.xml  `日志配置文件`
│  │  mybatis-config.xml  `Mybatis全局的配置文件`
│  │  
│  ├─mapper  `存放MyBatis sql映射`
│  │      SeckillDao.xml  `对应于SeckillDao接口，使用标签执行sql语句`
│  │      SuccessKilledDao.xml  `对应于SuccessKilledDao接口，使用标签执行sql语句`
│  │      
│  └─spring  `spring相关配置文件`
│          spring-dao.xml  `所有dao相关配置`
│          spring-service.xml  `所有service相关配置`
│          spring-web.xml  `所有web相关配置`
│      
└─webapp
    │  index.jsp  `主页`
    │  
    ├─resources
    │  └─script
    │          seckill.js  `存放主要交互逻辑js代码(cookie登陆交互、计时交互、秒杀交互)`
    │          
    └─WEB-INF   `Java的WEB应用的安全目录。如果想在页面中直接访问其中的文件，必须通过web.xml文件对要访问的文件进行相应映射才能访问。`
        │  web.xml  `用来配置：欢迎页、servlet、filter等的，并不是Java web工程所必需的，可以不用`
        │  
        └─jsp  `存放页面jsp文件`
            │  detail.jsp  `详情页jsp文件`
            │  list.jsp  `列表页jsp文件`
            │  
            └─common  `所有页面的重复部分，通用jsp`
                    head.jsp  `引入Bootstrap等通用部分`
                    tag.jsp  `引入jstl`

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