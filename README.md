小雪鸮项目 Project Little Snowy Owl
----------------------------------

![Snowy Owl](./snowyowl.jpeg)


本项目为[新牛雪鸮(snowyowl)项目](https://coding.net/u/dewafer/p/snowyowl)的简化版，
演示了如何使用 Gradle，Spring Boot 和 Angular 搭建一个前后台分离的一体整合项目。


本项目在使用 Gradle 构建Spring Boot可运行胖Jar的同时会一并编译并打包内嵌的 Angular 项目。

使用方法
=======

```bash
> ./gradlew clean build
```

```bash
> java -jar ./build/libs/little-snowyowl-0.0.1-SNAPSHOT.jar
```

浏览器访问[http://localhost:8080](http://localhost:8080)
