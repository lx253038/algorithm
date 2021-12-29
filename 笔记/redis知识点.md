# Redis相关知识点

### 常用命令
### 发布（pub）/订阅（sub）模式

* subscribe cctv ... (订阅一个或多个频道)
* psubscribe cctv*  edu* ....(订阅一个或者多个模式)
* publish  cctv   message (发布消息到哪个频道，消息内容为message)

### master/slave 主从复制

> #### 一主多仆
> * info replication  ：查看主从复制信息  master/slave 以及连接信息等
> * slaveof  host port :设置主从关系，使当前为从机，host指定的主机
> * slave从机会复制master主机中的所有数据到从机中
> * 读写分离：master能读能写，slave只能读不能写
> * master宕机 slave不会进行其他操作，一直等待master恢复
> * slave宕机再恢复，如何主从关系写在了配置文件中无影响，否则需要重新设置slave的主从关系
> #### 薪火相传
> * master下的（中间的)slave节点是 下一个slave的master节点
> * 3台redis节点  6379、6380 、6381
> * 6380：slaveof 127.0.0.1 6379
> * 6381：slaveof 127.0.0.1 6380
> #### 反客为主
> * slaveof no one   master宕机后可使用此命令将slave设置成master
> * 使用此命令可以使当前的数据库停止与其他数据库的同步，转成为主数据库

### 复制原理

> * Slave启动成功连接到master会发送一个Sync命令
> * Master接到命令启动后台的存盘进程，同时收集所有接收到的用于修改数据集命令，
>   在后台进程执行完毕之后，master将传送整个数据文件到slave,以完成一次完全同步
> * 全量复制：而slave服务在接收到数据库文件数据后，将其存盘并加载到内存中
> * 增量复制：Master继续将新的所有收集到的修改命令依次传给slave,完成同步
> * 但是只要是重新连接master,-.次完全同步(全量复制)将被自动执行

### 哨兵模式

> * 添加sentinel.conf监控配置文件
> * sentinel monitor [master-group-name] [ip] [port] [quorum]
> * sentinel monitor servername  127.0.0.1 6379  1
> * 启动哨兵监控 windows: redis-server.exe sentinel.conf --sentinel  linux: redis-sentinel  sentinel.conf

### Cluster集群模式
> * cluster-enabled  yes   开启cluster集群节点模式
> * cluster-node-timeout 15000  故障转移时间
> * cluster-config-file  nodes.conf  集群节点相关的配置信息
> * cluster-require-full-coverage  yes  集群中所有节点正常才提供服务，否则不提供服务
> * cluster meet ip port   设置节点间的相互通信
> * cluster addslots  0 1 2 3 4 5 6 7  为每个几点分配槽
> * cluster replicate node-id   设置主从关系
> * cluster nodes / cluster info  查看节点信息
> * cluster slots  查看槽分配信息

