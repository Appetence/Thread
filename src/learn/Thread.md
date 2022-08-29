volatile 修饰变量，确保变量线程间可见性 禁止指令重排序 不保证原子性 原子性借助atomic来保证

# interrupt 设置中断标识

        如果 线程处于waiting状态 wait  sleep 则抛出interruptException异常
            线程处于blocking状态， interrupt方法不会产生任何印象
        如果 线程处于运行状态，结果可能有三种，
                        1 isinterrupted为false 线程继续执行 （最多）
                        2 isInterrupted为 true 程序继续执行
                        3 isInterrupted为 true 程序退出（极少数）

# synchronize 监视器锁

        监视器锁内置于Object对象的底层
        
        Class也内置了类监视器锁

# 主存 RAM        
    cpu 内部有缓存，寄存器

# 队列 有序队列
    PriorityBlockingQueue

# 锁  
### 偏向锁：
            一个线程获取锁后，锁进入偏向模式，当同一个线程再次请求获取锁时，直接获取锁，无需在做同步操作
            适用于锁竞争不激烈情况
            -XX:+UseBiasedLocking  开启偏向锁
### 轻量级锁：
            偏向锁获取失败，虚拟机不会挂起线程；
            轻量级锁的操作，简单的将对象的头部作为指针，指向持有锁的线程堆栈的内部，
            轻量级锁获取失败，会膨胀为重量级锁
### 自旋锁:
            锁膨胀后，虚拟机为了避免线程真实在操作系统层面挂起，会做最后的尝试-------自旋锁
            经过若干次循环后，如果可以得到锁，就顺利进入临界区；如果还不能获取到锁，则真实的线程会在操作系统层面挂起
            优点： 适用于执行步骤少且快的操作
            注意，cpu个数增加，优点会退化为自旋锁缺点
            适用场景，争用较少及代码量较小的情况  临界区（线程少，并发低）

            阻塞： 自旋锁所消耗的cpu时间大于阻塞线程上下文切换的时间时候，选用阻塞
### 锁消除：
            jit编译时，会对运行上下文进行扫描，去除不可能存在共享资源竞争的锁；节省无意义的请求锁时间
            -XX:DoEscapeAnalysis        开启逃逸分析
            -XX:EliminateLocks          开启锁消除



# 锁

    CAS: 实现cpu级别对于单个变量的原子性操作，线程安全操作
    lock cmpxchg
    ### 公平锁 非公平锁
        非公平锁性能高于公平锁，减少线上下问切换 + 调度等待
### 重入锁
        boolean status ; 
            false 无锁      true  有锁
            0               1 表示重入一次，多次相加
### AQS
        Abstract
        Queue
        Synchronizer