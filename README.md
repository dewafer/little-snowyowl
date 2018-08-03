小雪鸮项目 Project Little Snowy Owl
----------------------------------

[![Build Status](https://travis-ci.org/dewafer/little-snowyowl.svg?branch=master)](https://travis-ci.org/dewafer/little-snowyowl)

![Snowy Owl](./snowyowl.jpeg)


本项目为[新牛雪鸮(snowyowl)项目](https://coding.net/u/dewafer/p/snowyowl)的简化版，
演示了如何使用 Gradle，Spring Boot 和 Angular 搭建一个前后台分离的一体整合项目。


本项目在使用 Gradle 构建 Spring Boot 可运行胖 Jar 的同时会一并编译并打包内嵌的 Angular 项目。

使用方法
=======

```bash
> ./gradlew clean build
```

```bash
> java -jar ./build/libs/little-snowyowl-0.0.1-SNAPSHOT.jar
```

浏览器访问[http://localhost:8080](http://localhost:8080)


相关说明
=======

1.  本项目的前端部分需要单独构建，并且构建后的产品不会被加入代码管理，
    因此如果您需要在IDE中直接运行本项目，需要另外单独构建前端部分，可以使用以下方法单独构建前端项目：
    
    1. 使用 `>./gradlew bundleFrontend` 命令或者使用IDE中的 Gradle 插件运行 `bundleFrontend` 任务。
    2. 如果您是一位有经验的前端工作者，可以直接cd到 `src/main/frontend` 目录下使用 `ng build` 进行构建。
    
2.  本项目 Gradle 的 `bundleFrontend` 被配置为增量型的构建模式，如果需要强行重新构建，请先运行 `clean` 任务，
    或者手动删除以下目录:
    
    * `node_modules/`
    * `src/main/frontend/node_modules`
    * `src/main/resources/frontend`
    
3.  由于本项目使用了H2内存数据库，可以在项目启动后访问 `http://localhost:8080/h2-console/` 来查看、修改内存数据库中的内容。
    内存数据库的相关参数为：
    
    * JDBC URL  : `jdbc:h2:mem:testdb`
    * User Name : `sa`
    * Password  : (none)

4.  本项目的前端 Demo 为 Angular 官方 [Tutorial: Tour of Heroes](https://angular.io/tutorial)，
    代码是我手动敲的不是复制黏贴的（为了学习ng），如果有错请见谅。
    
    官方 Tutorial 中的 [Simulate a data server](https://angular.io/tutorial/toh-pt6#simulate-a-data-server) 部分使用
    Spring boot 替代，其他原封不动。
    
