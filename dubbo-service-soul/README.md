

## 搭建环境和启动流程

* 官网 ：https://dromara.org/zh-cn/docs/soul/joinUp-dubbo.html

* 快速启动 soul-admin
 > wget  https://yu199195.github.io/jar/soul-admin.jar
 > `java -jar soul-admin.jar --spring.datasource.url="jdbc:mysql://你的url:3306/soul?useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=CONVERT_TO_NULL&failOverReadOnly=false&autoReconnect=true&useSSL=false"  
  --spring.datasource.username='you username'  --spring.datasource.password='you password'`
* 快速启动 soul-bootstrap
> wget  https://yu199195.github.io/jar/soul-bootstrap.jar
>  `java -jar soul-bootstrap.jar`

这样soul网关就启动了

