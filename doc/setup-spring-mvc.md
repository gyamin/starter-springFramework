# setup spring mvc

## Gradle確認
```
$ gradle -v
------------------------------------------------------------
Gradle 2.12
------------------------------------------------------------
```

## 初期ディレクトリ構造の作成
```
$ mkdir testapp
$ cd testapp/
$ mkdir -p src/main/java/hello
$ mkdir -p src/main/resources/templates
```

## Gradle buildファイルの作成

```
$ cat build.gradle 
buildscript {
    repositories {
        mavenCentral()
    }
    dependencies {
        classpath("org.springframework.boot:spring-boot-gradle-plugin:1.3.3.RELEASE")
    }
}

apply plugin: 'java'
apply plugin: 'idea'
apply plugin: 'spring-boot'

jar {
    baseName = 'gs-serving-web-content'
    version =  '0.1.0'
}

repositories {
    mavenCentral()
}

sourceCompatibility = 1.8
targetCompatibility = 1.8

dependencies {
    compile("org.springframework.boot:spring-boot-starter-thymeleaf")
    compile("org.springframework.boot:spring-boot-devtools")
    testCompile("junit:junit")
}

task wrapper(type: Wrapper) {
    gradleVersion = '2.3'
}
```

## build
```
$ gradle build
:compileJava UP-TO-DATE
:processResources UP-TO-DATE
:classes UP-TO-DATE
...
```

## Spring Boot ToolでWebサーバを起動する

```
$ gradle bootRun
:compileJava UP-TO-DATE
:processResources UP-TO-DATE
:classes UP-TO-DATE
:findMainClass
:bootRun
...
beans for JMX exposure on startup
2016-04-05 12:31:54.567  INFO 20414 --- [  restartedMain] s.b.c.e.t.TomcatEmbeddedServletContainer : Tomcat started on port(s): 8080 (http)
2016-04-05 12:31:54.574  INFO 20414 --- [  restartedMain] hello.Application                        : Started Application in 5.383 seconds (JVM running for 6.194)
> Building 80% > :bootRun
2016-04-05 13:33:04.669  INFO 20414 --- [nio-8080-exec-1] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring FrameworkServlet 'dispatcherServlet'
2016-04-05 13:33:04.671  INFO 20414 --- [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : FrameworkServlet 'dispatcherServlet': initialization started
2016-04-05 13:33:04.711  INFO 20414 --- [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : FrameworkServlet 'dispatcherServlet': initialization completed in 40 ms
> Building 80% > :bootRun
```
ブラウザからhttp://localhost:8080/greetingで"Hello World"が表示される。

