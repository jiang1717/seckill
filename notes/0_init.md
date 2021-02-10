# 项目创建

maven命令创建web骨架项目：`mvn archetype:generate -DgroupId=org.seckill -DartifactId=seckill -DarchetypeArtifactId=maven-archetype-webapp`

> **mvn archetype:generate -DgroupId=com.mycompany.app -DartifactId=myapp -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false**
>
> 　　mvn archetype:generate　                   　  固定写法
>
> 　　-DgroupId　　　　　　　　　　　　　　　　　　　　　　　组织标识（包名）
>
> 　　-DartifactId　　　　　　　　　　　　　　　　　　　　　 　项目名称
>
> 　　-DarchetypeArtifactId　　 　　　　　　　　　　　　　 　 指定ArchetypeId，maven-archetype-quickstart，创建一个Java Project；maven-archetype-webapp，创建一个Web Project
>
> 　　-DinteractiveMode　　　　　　　　　　　　　　　　　　　是否使用交互模式

修改web.xml的servlet版本为3.1：

```xml
<?xml version="1.0" encoding="utf-8"?>
<web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee
                      http://xmlns.jcp.org/xml/ns/javaee/web-app_3_1.xsd"
         version="3.1"
         metadata-complete="true">
</web-app>
```

[pom.xml](../pom.xml)文件是Maven工程自带的，用来添加第三包jar包的依赖信息，补全项目依赖：

1. 使用junit4

2. 日志 java日志：slf4j,log4j,logback,common-logging

   slf4j 是规范/接口

   日志实现：log4j，logback，common-logging

   使用：log4j + logback

3. 数据库相关依赖

   * 数据库驱动及连接池：mysql-connector-java、c3p0

   * DAO框架（MyBatis依赖）：mybatis

   * mybatis自身实现的spring整合依赖：mybatis-spring

4. Servlet web相关依赖：standard、jstl、jackson-databind、javax.servlet-api

5. spring依赖

   * spring 核心依赖：spring-core、spring-beans、spring-context

   * spring dao层依赖：spring-jdbc、spring-tx

   * spring web相关依赖：spring-web、spring-webmvc

   * spring test相关依赖：spring-test