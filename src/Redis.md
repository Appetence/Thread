1.5m /s  每秒10万
x000/s   关系型数据库

# memcached    
    hash存储，可以存mp4等
    value 无类型概念


# redis
    string      字符串，数值类型，bitmap
    hashes
    list
    sets
    sortedSets
    
## 区别
    memcached   获取value中某个元素
    redis       redis 对每种类型都有自己的实现方法，index等
    
## epoll 同步，非阻塞多类复用 cpu共享空间

    nio 多路复用
    
    内存态，用户态
    
 1 个线程1m 
    多线程cpu只有一个 多线程，cpu切换时间浪费
    
redis 默认16 个库 0-15 -n指定

set key 1 nx    不存在时候才创建
          xx    只能更新
          
mset k3 1 k4 2

mget k3 k4

msetnx k1 2 k3 4    原子性操作，一个失败，都失败



数据淘汰引发的延迟
当同一秒内有大量key过期时，也会引发Redis的延迟。在使用时应尽量将key的失效时间错开。
引入读写分离机制
Redis的主从复制能力可以实现一主多从的多节点架构，在这一架构下，主节点接收所有写请求，并将数据同步给多个从节点。





append k1 "value"

#正反向索引
getappend k1  1    6
#####    0-最大值
getappend k1 0  -1

#// 二进制安全：字节流，字符流；双方统一的编解码格式，防止由于不同语言数据类型不一致，导致精度缺失等问题

    获取长度 strlen key
    
    
    
### redis-cli --raw redis客户端识别utf8等编码格式 否则只能识别ascll编码，其他的编码默认转16进值

key  type           


rdb  aof

rdb  save（关机维护） gbsave（命令行触发） 自动触发（redis.conf）    具有时点性
######  save n m 
######  save 900 1  一个key
######  save 300 10  10个key
######  save 60 100 至少100key
不支持拉链 只有一个dump.rdb
aof always everysec  no
4.0 前 删除抵消命令合并重复命令，最终做一个纯命令的log
4.0 后 将老得数据rdb到aof中，将新的数据以指令形式append到aof中，aof是一个混合体，利用了rdb的快+日志的全量
                aof use rdb 需要配置开启
                
bfrewiteredis 触发重写


aof和rdb可以同时开启

always  数据放到内核的stringbuffer 可能会丢一个buffer的数据


no-appendsync-no-rewrite no   同步刷盘 是否需要开启，看数据敏感性


#redis 记录最后一次重写大小，当达到百分比增量以后在进行重写
auto-aof-rewrite-percentage:100
auto-aof-rewrite-min-size=64m

# pipelining
##### plplining可以批量执行无序命令；中间用 /r/n 分割；但是并不能保证顺序一致性

# 事物
MULTI
get key1
mset k2 1 k3 2
EXEC


rdb  frok（系统调用） 记录的是指针引用，copyonwrite(内核机制) 先拷贝，后复制，时点数据

单机 单点问题
容量有限
故障

#主从
主上可以知道有多少个从追随自己

#追随主
reolcaof -1i -p 端口

replac 方式 disk          默认no        replc-discless-sync
       同步阻塞队列大小                  replc-blocking-size  1m 
       network
       
       
       
redis sentinel

sentinel monitor mymaster 127.0.0.1 6379 2

# 三个配置文件分别配置不同的端口号
port <端口号>
# 设置为后台启动
daemonize yes
# 主节点的名称(可以自定义，与后面的配置保持一致即可)
# 主机地址
# 端口号
# 数量(2代表只有两个或两个以上的哨兵认为主服务器不可用的时候，才会进行failover操作)
sentinel monitor mymaster 127.0.0.1 6379 2
# 多长时间没有响应认为主观下线(SDOWN)
sentinel down-after-milliseconds mymaster 60000
# 表示如果15秒后,mysater仍没活过来，则启动failover，从剩下从节点序曲新的主节点
sentinel failover-timeout mymaster 15000
# 指定了在执行故障转移时， 最多可以有多少个从服务器同时对新的主服务器进行同步， 这个数字越小， 完成故障转移所需的时间就越长
sentinel parallel-syncs mymaster 1