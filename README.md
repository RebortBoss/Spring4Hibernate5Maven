# Spring4Hibernate5Maven

Eclipse搭建Maven工程集成Spring4+Hibernate5

    这里将以Eclipse搭建Maven工程集成Spring4生成的项目为基础，集成Hibernate5.0.7final。

    亲可以参考：

        1、Maven安装以及在eclipse中的配置

        2、Eclipse中使用Maven创建基本的web项目

        3、Maven的Web工程集成Spring4

1、使用Eclipse搭建Maven的Web工程

    请参考：Eclipse中使用Maven创建基本的web项目

2、Maven的Web工程集成Spring4MVC

    请参考：Maven的Web工程集成Spring4

        昨晚太晚就没完成这一篇，今天来公司了就抽点吃饭的时间补上吧。

    从Maven的Web工程集成Spring4将工程下载下来接到后导入到eclipse。

    选择Import：

    01

    选择导入存在的Maven工程：

    02

    选择路径并完成导入：

    03

    导入完成后运行一下，一切正常。

    (可能会碰到一个错误，请参考：Error：HttpServlet was not found on the Java)

3、Spring4MVC的Maven工程集成Hibernate5

    3.1、添加依赖(.jar)

    从官网我们可以看到有以下构件：

    04 
    除了Hibernate需要的jar，还需要数据库驱动等的jar包。

    之前在SpringMVC的Maven工程搭建的时候介绍过通过搜索获取jar在仓库地址信息，但是如果有些jar包在仓库找不到而自己有jar包的话，可以先将jar包通过maven命令添加到本地仓库，然后再使用就可以了，下面是将jar添加到本地仓库的Maven命令：

    mvn install:install-file -Dfile=jar包的位置 -DgroupId=上面的groupId -DartifactId=上面的artifactId -Dversion=上面的version -Dpackaging=jar

    例如，执行以下命令可以将该jar包添加到本地仓库，然后就可以在pom中直接使用了：

mvn install:install-file -DgroupId=mycommons -DartifactId=pool -Dversion=106 -Dpackaging=jar -Dfile=F:\commons-pool-1.6.jar
    配置好后的完整的pom.xml应该是这样：
```xml
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/maven-v4_0_0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <groupId>anxpp.com</groupId>
    <artifactId>Spring4Hibernate5MVC</artifactId>
    <packaging>war</packaging>
    <version>0.0.1</version>
    <name>Spring4Hibernate5MVC Maven Webapp</name>
    <url>http://maven.apache.org</url>
    <dependencies>
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>3.8.1</version>
            <scope>test</scope>
        </dependency>
        <!-- Spring -->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-aop</artifactId>
            <version>4.2.4.RELEASE</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-context</artifactId>
            <version>4.2.4.RELEASE</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-core</artifactId>
            <version>4.2.4.RELEASE</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-web</artifactId>
            <version>4.2.4.RELEASE</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-webmvc</artifactId>
            <version>4.2.4.RELEASE</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-beans</artifactId>
            <version>4.2.4.RELEASE</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-tx</artifactId>
            <version>4.2.4.RELEASE</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-orm</artifactId>
            <version>4.2.4.RELEASE</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-aspects</artifactId>
            <version>4.2.4.RELEASE</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-expression</artifactId>
            <version>4.2.4.RELEASE</version>
        </dependency>
        <!-- Hibernate -->
        <dependency>
            <groupId>org.hibernate</groupId>
            <artifactId>hibernate-core</artifactId>
            <version>5.0.7.Final</version>
        </dependency>
        <!-- for JPA, use hibernate-entitymanager instead of hibernate-core -->
        <dependency>
            <groupId>org.hibernate</groupId>
            <artifactId>hibernate-entitymanager</artifactId>
            <version>5.0.7.Final</version>
        </dependency>
        <!-- optional -->
        <dependency>
            <groupId>org.hibernate</groupId>
            <artifactId>hibernate-osgi</artifactId>
            <version>5.0.7.Final</version>
        </dependency>
        <dependency>
            <groupId>org.hibernate</groupId>
            <artifactId>hibernate-envers</artifactId>
            <version>5.0.7.Final</version>
        </dependency>
        <dependency>
            <groupId>org.hibernate</groupId>
            <artifactId>hibernate-c3p0</artifactId>
            <version>5.0.7.Final</version>
        </dependency>
        <dependency>
            <groupId>org.hibernate</groupId>
            <artifactId>hibernate-proxool</artifactId>
            <version>5.0.7.Final</version>
        </dependency>
        <dependency>
            <groupId>org.hibernate</groupId>
            <artifactId>hibernate-infinispan</artifactId>
            <version>5.0.7.Final</version>
        </dependency>
        <dependency>
            <groupId>org.hibernate</groupId>
            <artifactId>hibernate-ehcache</artifactId>
            <version>5.0.7.Final</version>
        </dependency>
        <dependency>
            <groupId>antlr</groupId>
            <artifactId>antlr</artifactId>
            <version>2.7.7</version>
        </dependency>
        <dependency>
            <groupId>aopalliance</groupId>
            <artifactId>aopalliance</artifactId>
            <version>1.0</version>
        </dependency>
        <dependency>
            <groupId>org.aspectj</groupId>
            <artifactId>aspectjweaver</artifactId>
            <version>1.8.7</version>
        </dependency>
        <dependency>
            <groupId>commons-logging</groupId>
            <artifactId>commons-logging</artifactId>
            <version>1.2</version>
        </dependency>
        <dependency>
            <groupId>commons-collections</groupId>
            <artifactId>commons-collections</artifactId>
            <version>3.2.1</version>
        </dependency>
        <dependency>
            <groupId>commons-dbcp</groupId>
            <artifactId>commons-dbcp</artifactId>
            <version>1.4</version>
        </dependency>
        <dependency>
            <groupId>commons-lang</groupId>
            <artifactId>commons-lang</artifactId>
            <version>2.1</version>
        </dependency>
        <dependency>
            <groupId>commons-pool</groupId>
            <artifactId>commons-pool</artifactId>
            <version>1.6</version>
        </dependency>
        <dependency>
            <groupId>dom4j</groupId>
            <artifactId>dom4j</artifactId>
            <version>1.6.1</version>
        </dependency>
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>5.1.9</version>
        </dependency>
    </dependencies>
    <build>
        <finalName>Spring4Hibernate5MVC</finalName>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <version>2.3.2</version>
                <configuration>
                    <source>1.8</source>
                    <target>1.8</target>
                </configuration>
            </plugin>
        </plugins>
    </build>
</project>
```
    3.2、配置applicationContext.xml

     这里主要是配置数据源、Session工厂和声明事务管理，数据的访问使用了Spring的hibernateTemplate，详情参考：hibernateTemplate详解。配置好后完整的applicationContext.xml应该是这样：
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:context="http://www.springframework.org/schema/context"
    xmlns:aop="http://www.springframework.org/schema/aop" xmlns:p="http://www.springframework.org/schema/p"
    xmlns:tx="http://www.springframework.org/schema/tx" xmlns:mvc="http://www.springframework.org/schema/mvc"
    xsi:schemaLocation="http://www.springframework.org/schema/beans
         http://www.springframework.org/schema/beans/spring-beans-4.2.xsd
         http://www.springframework.org/schema/context
         http://www.springframework.org/schema/context/spring-context-4.2.xsd
         http://www.springframework.org/schema/tx
         http://www.springframework.org/schema/tx/spring-tx-4.2.xsd
         http://www.springframework.org/schema/aop 
         http://www.springframework.org/schema/aop/spring-aop-4.2.xsd
         http://www.springframework.org/schema/mvc 
         http://www.springframework.org/schema/mvc/spring-mvc-4.2.xsd">
    <!-- 开启IOC注解扫描 -->
    <context:component-scan base-package="com.anxpp.demo" />
    <!-- 开启MVC注解扫描 -->
    <mvc:annotation-driven />
    <!-- 以下为数据库和hibernate配置 -->
    <context:property-placeholder location="classpath:/db.properties" />
    <bean id="dataSource" class="org.apache.commons.dbcp.BasicDataSource"
        destroy-method="close">
        <property name="driverClassName" value="${jdbc.mysql.driverClassName}" />
        <property name="url" value="${jdbc.mysql.url}" />
        <property name="username" value="${jdbc.mysql.username}" />
        <property name="password" value="${jdbc.mysql.password}" />
        <property name="maxActive" value="100"></property>
        <property name="minIdle" value="20"></property>
        <property name="maxWait" value="3000"></property>
        <property name="initialSize" value="30"></property>
    </bean>
    <bean id="sessionFactory"
        class="org.springframework.orm.hibernate5.LocalSessionFactoryBean">
        <property name="dataSource" ref="dataSource" />
        <property name="packagesToScan">
            <list>
                <value>com.anxpp.demo.core.entity</value>
            </list>
        </property>
        <property name="hibernateProperties">
            <props>
                <prop key="hibernate.dialect">org.hibernate.dialect.MySQLDialect</prop>
                <prop key="hibernate.show_sql">false</prop>
                <prop key="hibernate.format_sql">true</prop>
                <prop key="hibernate.hbm2ddl.auto">update</prop>
            </props>
        </property>
    </bean>
    <bean id="hibernateTemplateMysql" class="org.springframework.orm.hibernate5.HibernateTemplate">
        <property name="sessionFactory" ref="sessionFactory"></property>
    </bean>
    <!-- 定义事务管理器（声明式的事务） -->
    <bean id="transactionManager"
        class="org.springframework.orm.hibernate5.HibernateTransactionManager">
        <property name="sessionFactory" ref="sessionFactory" />
    </bean>
    <tx:advice id="txAdvice" transaction-manager="transactionManager">
        <tx:attributes>
            <tx:method name="*" propagation="REQUIRED" />
        </tx:attributes>
    </tx:advice>
    <aop:config>
        <aop:pointcut id="interceptorPointCuts"
            expression="execution(* com.anxpp.demo.core.service..*.*(..))" />
        <aop:advisor advice-ref="txAdvice" pointcut-ref="interceptorPointCuts" />
    </aop:config>
    <!-- 以下为视图映射配置 -->
    <bean
        class="org.springframework.web.servlet.view.InternalResourceViewResolver">
        <property name="prefix" value="/WEB-INF/views/" />
        <property name="suffix" value=".jsp" />
    </bean>
    <!-- 其他配置 -->
    <!-- 静态文件访问 -->
    <mvc:default-servlet-handler />
</beans>
```
     这里还要在applicationContext.xml同目录下创建数据库连接配置文件db.properties，可以看到applicationContext.xml中配置的数据库连接时通过<context:property-placeholder location="classpath:/db.properties" />引入的外部文件配置的，这样方便管理，db.properties中的内容如下：
```bash
#mysql
jdbc.mysql.driverClassName=com.mysql.jdbc.Driver
jdbc.mysql.url=jdbc:mysql://127.0.0.1:3306/demo?createDatabaseIfNotExist=true
jdbc.mysql.username=root
jdbc.mysql.password=****
```
    这样，相关的所有配置都完成就，可以直接开始写代码了。

    3.3、编写测试代码

    要写的代码有entity、dao及实现，service及实现和Controller，entity通常是与数据库中表对应的实体，dao是数据库访问的底层实现，service是管理事物的，处理一下逻辑，Controller是对外的接口。

   entity(User.java)：
```java
package com.anxpp.demo.core.entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="DEMO_User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    public User(){}
    public User(String name){
        this.name = name;   }
    @Override
    public String toString() {
        return "{id:" + id + ",name:" + name + "}";
    }
    public int getId() {
        return id;  }
    public void setId(int id) {
        this.id = id;   }
    public String getName() {
        return name;    }
    public void setName(String name) {
        this.name = name;   }
}
```
    Dao(DemoDao.java)：
```java
package com.anxpp.demo.core.dao;
import java.util.List;
import com.anxpp.demo.core.entity.User;
public interface DemoDao {
    String test();
    void save(Object entity);
    Object findById(int id);
    void delete(Object entity);
    List<User> findAll();
}
```
    DaoImpl(DemoDaoImpl.java)：
    (ps:这里用到了java8的新特性，若jdk版本低于1.8，请改为老版写法)
```java
package com.anxpp.demo.core.dao.impl;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import com.anxpp.demo.core.dao.DemoDao;
import com.anxpp.demo.core.entity.User;
@Repository
public class DemoDaoImpl implements DemoDao {
    @Autowired
    protected HibernateTemplate hibernateTemplateMysql;
    public String test() {
        return "hello word!";
    }
    public void save(Object entity) {
        hibernateTemplateMysql.save(entity);
    }
    public void delete(Object entity) {
        hibernateTemplateMysql.delete(entity);
    }
    @SuppressWarnings("unchecked")
    public List<User> findAll() {
        return (List<User>) hibernateTemplateMysql.find("from User");
    }
    @SuppressWarnings({ })
    public Object findById(final int id) {
//      return hibernateTemplateMysql.execute(new HibernateCallback() {
//          @Override
//          public Object doInHibernate(Session session) throws HibernateException {
//              String hql = "from User where id=?";
//              Query query = session.createQuery(hql);
//              query.setParameter(0, id);
//              return query.uniqueResult();
//          }
//      });//这是老版本写法  下面是java8中的写法
        return hibernateTemplateMysql.execute((Session session)-> {
                String hql = "from User where id=?";
                Query query = session.createQuery(hql);
                query.setParameter(0, id);
                return query.uniqueResult();
        });
    }
}
```
    service(DemoService.java)：
```java
package com.anxpp.demo.core.service;
public interface DemoService {
    String test();
    Object save(String name);
    boolean delete(int id);
    String findAll();
}
```
    serviceImpl(DemoServiceImpl.java)：
```java
package com.anxpp.demo.core.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.anxpp.demo.core.dao.DemoDao;
import com.anxpp.demo.core.entity.User;
import com.anxpp.demo.core.service.DemoService;
@Service
public class DemoServiceImpl implements DemoService {
    @Autowired
    DemoDao demoDao;
    public String test() {
        return demoDao.test();  }
    public Object save(String name) {
        User user = new User(name);
        demoDao.save(user);
        return user;    }
    public boolean delete(int id) {
        User user = (User) demoDao.findById(id);
        if(user==null)  return false;
        demoDao.delete(user);
        return true;    }
    public String findAll() {
        String r = "";
        for(User user:demoDao.findAll())    r +=  user;
        return r;   }
}
```
    controller(DemoController.java)：
```java
package com.anxpp.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.anxpp.demo.core.service.DemoService;
@Controller
@RequestMapping("/")
public class DemoConreoller {
    @Autowired
    DemoService demoService;
    @RequestMapping("/")
    public String index(){
        return "index"; }
    @RequestMapping("/test")
    @ResponseBody
    public String testRerutnString(){
        return "Hello Word!";   }
    @RequestMapping(value="/save",produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String save(String name){
        return "save" + demoService.save(name).toString();  }
    @RequestMapping(value="/del",produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String delete(int id){
        return "del:" + demoService.delete(id); }
    @RequestMapping(value="/find",produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String findAll(){
        return "find:" + demoService.findAll(); }
}
```
    到这儿代码就编写完成了，可以开始测试了。

    3.4、运行测试

    终于又到了见证成果的时候了，右键项目在服务器上运行，首先访问首页证明服务可用，起初数据库是空的，我们就增加一条数据后查询全部，再增加一条后查询全部，删除一条后查询全部即可验证功能。

    访问首页(http://localhost:8000/Spring4Hibernate5MVC/)：

05

    添加一条数据(http://localhost:8000/Spring4Hibernate5MVC/save?name=anxpp.com)：

06

    查询全部数据(http://localhost:8000/Spring4Hibernate5MVC/find)：

07

    再次添加一条数据(http://localhost:8000/Spring4Hibernate5MVC/save?name=gianthard)：

08

    查询全部数据(http://localhost:8000/Spring4Hibernate5MVC/find)：

09

    删除一条数据(http://localhost:8000/Spring4Hibernate5MVC/del?id=5)：

10

    查询全部数据(http://localhost:8000/Spring4Hibernate5MVC/find)：

11

    有次可见，所有操作都是有效的，但是如果del的时候传入一个错误的id，就不能有效操作成功，但是服务器会返回del:false的提示。

   3.5、下载

    Spring4Hibernate5MVC.7z
