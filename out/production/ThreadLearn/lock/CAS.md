CAS（atomicInteger.compareAndSet）
compareAndSwape(当前对象内存偏移量的值与当前值是否相同)
本质unsafe
底层思想是通过旧值和档期值进行比较，如果相同则更新为新值，在高并发环境下保证数据唯一性

缺点
  循环，耗费cpu
  只能对单个变量保证原子性
  ABA问题
        不影响结果的情况下无需处理
        影响结果的时候可用采用AtomicStampedReference进行处理，通过版本号进行控制
                int k = 0;
                AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference<Integer>(k,1);
                Boolean boo = atomicStampedReference.compareAndSet(0,2,1,2);
                System.out.println(boo+":"+k);

 

# 线程锁： 
    独占模式

    共享模式