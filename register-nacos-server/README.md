[首页文档](../README.md)

# nacos 注册中心说明文档
[查看官方文档](https://nacos.io/zh-cn/docs/quick-start.html)


## 服务端使用说明
### 1.单机模式
```
3.启动服务器
Linux/Unix/Mac
启动命令(standalone代表着单机模式运行，非集群模式):

sh startup.sh -m standalone

如果您使用的是ubuntu系统，或者运行脚本报错提示[[符号找不到，可尝试如下运行：

bash startup.sh -m standalone

Windows
启动命令：

cmd startup.cmd

或者双击startup.cmd运行文件。

5.关闭服务器
Linux/Unix/Mac
sh shutdown.sh

Windows
cmd shutdown.cmd

或者双击shutdown.cmd运行文件

```

## 浏览器访问 

 [nacos 服务器端浏览器访问链接](../producer-ssh-server/src/main/resources/application-nacos-dev.yml)
 
 ```
 默认用户名 nacos,密码 nacos
 ```

## 客户端使用

### 客户端使用例子
 [nacos配置中心](../producer-nacos-config-server/README.md)

 [producer-ssh-server 中的关于nacos配置文件]()

### pom文件引入依赖(注意,请不要同时引用eureka jar包和nacos jar包,否则会报错)
```

  <!--nacos-config-->
        <dependency>
            <groupId>com.alibaba.cloud</groupId>
            <artifactId>spring-cloud-starter-alibaba-nacos-config</artifactId>
        </dependency>
        <!--nacos-discovery-->
        <dependency>
            <groupId>com.alibaba.cloud</groupId>
            <artifactId>spring-cloud-starter-alibaba-nacos-discovery</artifactId>
        </dependency>
        <!--web + actuator-->

```
### 启动类注解

```
@EnableDiscoveryClient


```

### 配置文件中添加nacos 信息

```
spring:
  application:
    name: producer-ssh-server
  cloud:
    nacos:
      discovery:
      #服务地址为nacos服务地址,集群模式,可以使用Nginx转发的域名地址加端口,nacos不支持多个地址逗号拼接形式,故使用nignx进行负载均衡
        server-addr: 127.0.0.1:8848
        

```
https://github.com/alibaba/nacos/tags
-DServer port=9011

https://github.com/alibaba/Sentinel/releases