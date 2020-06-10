# docker常用命令

### docker容器安装相关命令
> jps    
>
> apt-get update
>
> apt-get install vim 
>
> apt-get install yum 
>
> apt-get install openssh-server
>
> service ssh start

### 安装ps命令
- apt-get update && apt-get install procps

### mysql 8.0兼容性问题
- ALTER USER 'root'@'%' IDENTIFIED WITH mysql_native_password BY '123456';
- FLUSH PRIVILEGES;

### 修改配置导致容器无法启动问题解决
- find / -name my.cnf |grep '/etc/mysql/my.cnf'
### 设置容器自启
- docker update --restart=always <CONTAINER ID>
### 查看所有容器
- docker ps -a #
### 删除容器
- docker rm myredis
### 进入容器终端
- docker exec -it myrabbit sh  
### 拷贝容器中的文件到本机
- docker cp tomcat:/usr/local/tomcat/conf /opt/tomcat
### 拷贝本机文件到容器
  docker cp /opt/tomcat tomcat:/usr/local/tomcat/conf 

### 容器信息
- docker inspect tomcat  
### 使用当前容器生成镜像
- docker commit -m="fastdfs......." -a="lx" ca7ddbe20cc1 test/fastdfs:1.0
### 导出当前镜像到文件
- docker save -o mysql2.tar  lx/mysql
### 从文件中加载镜像
- docker load < busybox.tar.gz
### 从dockerFile文件构建镜像
- docker build -f /opt/dockerFile/es-6.8.7 .

### docker run 常用指令
> -d：后台运行，守护进程
>
> -p: 指定端口映射，格式为：主机(宿主)端口:容器端口
>
> -P: 随机端口映射，容器内部端口随机映射到主机的高端口
>
> -e username="ritchie": 设置环境变量
>
> --net="bridge": 指定容器的网络连接类型，支持 bridge/host/none/container: 四种类型
## docker中安装相关软件
### GUI
- docker volume create portainer_data
- docker run -d -p 9000:9000 -v /var/run/docker.sock:/var/run/docker.sock -v portainer_data:/data --name console portainer/portainer    

### Redis
- docker run -d -p 6379:6379 --name myredis redis

### Rabbitmq
- docker run -d -p 15672:15672 -p 5672:5672  --name myrabbitmq 6addf4b6a4ef

### Mysql
- docker run -d -p 3306:3306 -e MYSQL_ROOT_PASSWORD=123456 --name mysql --lower_case_table_names=1  mysql

### ElasticSearch
- docker run -d -p 9200:9200 -p 9300:9300 -p 2222:22  -e  ES_JAVA_OPTS="-Xms256m -Xmx256m"  --name es  elasticsearch
- docker run -d -p 9200:9200 -p 9300:9300 -e  ES_JAVA_OPTS="-Xms512m -Xmx512m" -v /opt/es-6.8.7/config:/usr/share/elasticsearch/config  -v /opt/es-6.8.7/logs:/usr/share/elasticsearch/logs -v /opt/es-6.8.7/data:/usr/share/elasticsearch/data -v /opt/es-6.8.7/plugins:/usr/share/elasticsearch/plugins  --name es-6.8.7 9cdc9986c313

### Tomcat
- docker run -d  --net=host -v /opt/tomcat/webapps:/usr/local/tomcat/webapps -v /opt/tomcat/logs:/usr/local/tomcat/logs -v /opt/tomcat/conf:/usr/local/tomcat/conf   --name tomcat tomcat
### FastDfs
- docker run -d --restart=always --privileged=true --net=host --name=fastdfs -e IP=192.168.171.128 -e WEB_PORT=88 -v /opt/fastdfs:/var/local/fdfs registry.cn-beijing.aliyuncs.com/tianzuo/fastdfs
### Nginx
- docker run --name mynginx -d --net=host  -v /opt/nginx/conf/nginx.conf:/etc/nginx/nginx.conf  -v /opt/nginx/logs:/var/log/nginx -v /opt/nginx/html:/etc/nginx/html nginx





