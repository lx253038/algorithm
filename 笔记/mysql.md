### MySQL相关知识点

#### 相关命令
* 通用、登录等
>
>* -D，--database=name    打开指定数据库
>* -h, --host =name 服务器名称或者ip
>* -p, --password    密码
>* -P, --port    端口号
>* -u, --user    用户名
>* -V，--version     查看版本信息
>* mysql -uroot  -p123456  /mysql -u root  -p   登录mysql
>* SELECT  VERSION();   查看版本信息
>* SELECT  NOW();    查看当前时间
>* SELECT USER();   查看当前用户
>* SELECT DATABASE();  查看当前打开的数据库
>* show warnings;   查看警告信息
>* show variables like '%autocommit%'  查询数据库相关属性

* 数据库相关命令
>* use test;  使用哪个库
>* show databases  [ like '%s%' ];    查看所有的数据库
>* create  database  [ if not exists ]  db_name  [character set  utf8];  创建数据库
>* show create database demo3;  查看建库信息
>* alter database demo2 character set utf8;  修改库字符集
>* drop database   [ if exists ]  db_name;  删除数据库
* 数据表相关命令
>* show tables  [ from db_name]  [ like '%s%' ]   ;  查看当前库(所指定库)的所有表
>* create table [ if not exists ]  table1 (
>            id int   primary key (主键)   auto_increment（自增类型） , 
>            name varchar(255)   unique  （唯一索引）,
>            age int default（为字段添加默认值） 20,
>            pid int ,
>            foreign key(pid) REFERENCES tbl2(id)
>) ;  创建数据表
>* show columns from table_name;   查询指定表的列信息
>* alter table tbl4 add column desc3 varchar(255) [ after name ];  修改表添加列
>* alter table tbl4 drop column desc6,drop column desc7; 删除列
>* alter table tbl4 add  primary key(id),add unique (name),add foreign key (pid) references tbl2(id); 添加列约束
>* alter table tbl4 drop primary key,drop (key|index) name,drop FOREIGN KEY tbl4_ibfk_1; 删除约束

#### 索引分类

> * 单值索引：一个索引只包含单个列，一张表可以有多个单列索引（复合索引优于单值索引）
>
> * 唯一索引（unique）：索引列的值必须唯一，但允许有空值
>
> * 复合索引：即一个索引包含多个列
>
> * 基本语法
>
>  ```sql
> ## 创建索引
> create [unique] index indexName ON table_name(column_name(length));
> alter table tbl4 add [unique] index  index_name(column_name(length));
> ## 删除索引
> drop index index_name on table_name;
> ## 查看索引
> show index FROM tbl4;
> ## 查看SQL执行效率 system>const>eq_ref>ref>range>index>all
> explain SQL;
>  ```
>

