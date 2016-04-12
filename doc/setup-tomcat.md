# Tomcat

## CentOSにTomcatを導入する

### JDKのインストール
```
$ sudo yum install java-1.8.0-openjdk.x86_64
```

### Tomcatインストール
TomcatのホームページよりBinaryをダウンロードする。
http://tomcat.apache.org/download-80.cgi
```
$ wget http://ftp.tsukuba.wide.ad.jp/software/apache/tomcat/tomcat-8/v8.0.33/bin/apache-tomcat-8.0.33.tar.gz
```

Tomcatのインストール
```
$ tar xfz apache-tomcat-8.0.33.tar.gz
$ sudo mv apache-tomcat-8.0.33 /opt/
$ cd /opt/apache-tomcat-8.0.33/
```

### Tomcatの起動/停止

#### 起動

```
$ ./bin/
catalina.sh      daemon.sh        setclasspath.sh  startup.sh       version.sh       
configtest.sh    digest.sh        shutdown.sh      tool-wrapper.sh  
[f_nogami@localhost apache-tomcat-8.0.33]$ ./bin/startup.sh 
Using CATALINA_BASE:   /opt/apache-tomcat-8.0.33
Using CATALINA_HOME:   /opt/apache-tomcat-8.0.33
Using CATALINA_TMPDIR: /opt/apache-tomcat-8.0.33/temp
Using JRE_HOME:        /usr
Using CLASSPATH:       /opt/apache-tomcat-8.0.33/bin/bootstrap.jar:/opt/apache-tomcat-8.0.33/bin/tomcat-juli.jar
Tomcat started.
```

```
$ curl http://localhost:8080

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <title>Apache Tomcat/8.0.33</title>
        <link href="favicon.ico" rel="icon" type="image/x-icon" />
        <link href="favicon.ico" rel="shortcut icon" type="image/x-icon" />
        <link href="tomcat.css" rel="stylesheet" type="text/css" />
    </head>
...
```

#### 停止

```
$ ./bin/shutdown.sh 
Using CATALINA_BASE:   /opt/apache-tomcat-8.0.33
Using CATALINA_HOME:   /opt/apache-tomcat-8.0.33
Using CATALINA_TMPDIR: /opt/apache-tomcat-8.0.33/temp
Using JRE_HOME:        /usr
Using CLASSPATH:       /opt/apache-tomcat-8.0.33/bin/bootstrap.jar:/opt/apache-tomcat-8.0.33/bin/tomcat-juli.jar
```

## Webアプリケーションマネージャの利用

WebGUIを使ったTomcatのアプリケーションマネージャを利用するには、xmlに設定を行う必要がある。

```
$ vim ./conf/tomcat-users.xml
...
<tomcat-users xmlns="http://tomcat.apache.org/xml"
  ...
  <user username="tomcat" password="tomcatPwd" roles="manager-gui"/>
</tomcat-users>
```

http://loc_dev1:8080/manager/html にアクセス。認証で上記で設定したユーザ、パスワードでログインできる。

