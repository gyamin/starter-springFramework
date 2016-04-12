# データベースの準備
springアプリケーションから接続するデータベースのセットアップを記載する。

## oracle編


## postgresql編

#### データベース作成
```
postgres=# CREATE DATABASE SPRING_DEV OWNER DEVELOPER;
```

#### テーブル作成

```
$ psql -h loc_dev1 -U developer spring_dev
...
spring_dev=> \i create_table.sql 
CREATE TABLE
```
