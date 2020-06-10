# docker��������

### docker������װ�������
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

### ��װps����
- apt-get update && apt-get install procps

### mysql 8.0����������
- ALTER USER 'root'@'%' IDENTIFIED WITH mysql_native_password BY '123456';
- FLUSH PRIVILEGES;

### �޸����õ��������޷�����������
- find / -name my.cnf |grep '/etc/mysql/my.cnf'
### ������������
- docker update --restart=always <CONTAINER ID>
### �鿴��������
- docker ps -a #
### ɾ������
- docker rm myredis
### ���������ն�
- docker exec -it myrabbit sh  
### ���������е��ļ�������
- docker cp tomcat:/usr/local/tomcat/conf /opt/tomcat
### ���������ļ�������
  docker cp /opt/tomcat tomcat:/usr/local/tomcat/conf 

### ������Ϣ
- docker inspect tomcat  
### ʹ�õ�ǰ�������ɾ���
- docker commit -m="fastdfs......." -a="lx" ca7ddbe20cc1 test/fastdfs:1.0
### ������ǰ�����ļ�
- docker save -o mysql2.tar  lx/mysql
### ���ļ��м��ؾ���
- docker load < busybox.tar.gz
### ��dockerFile�ļ���������
- docker build -f /opt/dockerFile/es-6.8.7 .

### docker run ����ָ��
> -d����̨���У��ػ�����
>
> -p: ָ���˿�ӳ�䣬��ʽΪ������(����)�˿�:�����˿�
>
> -P: ����˿�ӳ�䣬�����ڲ��˿����ӳ�䵽�����ĸ߶˿�
>
> -e username="ritchie": ���û�������
>
> --net="bridge": ָ�������������������ͣ�֧�� bridge/host/none/container: ��������
## docker�а�װ������
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





