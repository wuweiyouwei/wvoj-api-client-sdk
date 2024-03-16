## 为什么要开发 Starter？
为用户提供更便捷调用代码沙箱服务的客户端。用户只需要关注我要传递什么参数，不用关注其它参数。
开发步骤：
0）首先明确客户端 SDK 的定位和功能，不要把 SDK 设计得过于繁重。

1）引入相关依赖。如 spring-boot-configuration-processor、spring-boot-autoconfigure 等，用于开启自动导入以及给出配置文件的编辑提示。

2）编写配置类，用于创建一个客户端 Bean 对象。给配置类添加 @ConfigurationProperties(prefix = "wvapi.client") 注解，用于自动从 Spring Boot 配置文件中读取配置。

3）注册配置类。在 resources/META-INF/spring.factories 文件中填写自动加载的配置类包路径。

4）开发 SDK。像开发 Spring Boot 业务系统一样编写 SDK 功能代码。

5）使用 SDK。在本地用 mvn install 命令打包 SDK，其他本地项目引入 SDK 即可使用。

6）发布 SDK。在 Maven 中央仓库发布 SDK 包，其他开发者可通过 Maven 包索引在自己的项目中引入 SDK 并使用。

