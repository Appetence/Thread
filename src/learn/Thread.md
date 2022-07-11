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