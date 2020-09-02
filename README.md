
### 核心概念：
    - 所有的线程中，都是通过队列 AbstractQueuedSynchronizer 来排序
    - 线程之间不可见
    - notify 不释放锁
    - wait 会释放锁，并进入阻塞状态
### 并发编程题
1. 题目一：子线程循环2次，主线程循环2次，然后子线程循环2次，主线程循环2次，这样循环10次；
    - [内置锁实现方式](src/main/java/com/javaniuniu/juc/loop/output/subject1/T1.java)
    - [显示锁实现方式](src/main/java/com/javaniuniu/juc/loop/output/subject1/T2.java)
2. 题目二：写两个线程，一个线程打印1～52，另一个线程打印A～Z，打印顺序是12A34B...5152Z；
    - [显示锁实现方式](src/main/java/com/javaniuniu/juc/loop/output/subject2/D1.java)
    - [内置锁实现方式](src/main/java/com/javaniuniu/juc/loop/output/subject2/Demo1.java)
    
3. 问题描述 
   启动3个线程打印递增的数字, 线程1先打印1,2,3,4,5, 然后是线程2打印6,7,8,9,10, 然后是线程3打印11,12,13,14,15. 接着再由线程1打印16,17,18,19,20….以此类推, 直到打印到75. 程序的输出结果应该为:
   
   线程1: 1 
   线程1: 2 
   线程1: 3 
   线程1: 4 
   线程1: 5
   
   线程2: 6 
   线程2: 7 
   线程2: 8 
   线程2: 9 
   线程2: 10 
   …
   
   线程3: 71 
   线程3: 72 
   线程3: 73 
   线程3: 74 
   线程3: 75
   - [给class上锁](src/main/java/com/javaniuniu/juc/loop/output/subject3/T1.java)
   - [内置锁+object实现方式](src/main/java/com/javaniuniu/juc/loop/output/subject3/T2.java)
4. 现在有T1、T2、T3三个线程，你怎样保证T2在T1执行完后执行，T3在T2执行完后执行？
    - [join实现方式](src/main/java/com/javaniuniu/juc/loop/output/subject4/T1_join.java)
5. 两个线程轮流打印数字，一直到100
    - [join实现方式](src/main/java/com/javaniuniu/juc/loop/output/subject5/T1.java)
6. 编写一个程序，启动三个线程，三个线程的ID分别是A，B，C；，每个线程将自己的ID值在屏幕上打印5遍，打印顺序是ABCABC..
    - [内置锁实现方式](src/main/java/com/javaniuniu/juc/loop/output/subject6/T2.java)
7. 单例模式 ：懒汉式 饿汉式 双重检测锁
   - 所有的单例模式 构造函数必须私有
   - [额汉实现方式](src/main/java/com/javaniuniu/juc/loop/output/subject7/HungerMan.java)
   - [懒汉实现方式](src/main/java/com/javaniuniu/juc/loop/output/subject7/LazyMan.java)
   - [双重检测实现方式](src/main/java/com/javaniuniu/juc/loop/output/subject7/DoubleCheck.java)
   
8. 读写锁 , CyclicBarrier ,  CountDownLatch Phaser , Semaphore
   - 读写锁
    - 有共享锁和排他锁 两个概念
    - [读写锁实现方式](src/main/java/com/javaniuniu/juc/loop/output/subject8/Test_ReadWriteLock.java)
   - CyclicBarrier
    - 使用场景：当需要某些条件同时满足时，可使用
    - [实现方式](src/main/java/com/javaniuniu/juc/loop/output/subject8/Test_CyclicBarrier.java)
   - Phaser
    - 使用场景：某个流程有多个阶段，多个线程同时参与，在不同阶段，线程相应的解释
    - 比如办酒席：人齐，吃饭，人走，洞房
   - Semaphore 信号灯
    - 使用场景： 可用于限流
    - [实现方式](src/main/java/com/javaniuniu/juc/loop/output/subject8/Test_Semaphore.java)
   - Exchanger
    - 两个程序之间通信
    - 执行 exchanger() 是阻塞的
   - LockSupport 
    - 可以指定线程结束阻塞状态
    - [实现方式](src/main/java/com/javaniuniu/juc/loop/output/subject8/Test_LockSupport.java)
   
9. 实现一个容器，提供两个方法，add，size ,写两个线程，线程1 添加10个元素到容器，线程2 实现监控元素的个数，当线程个数到5个时，线程2给出提示并结束
   - [同步容器实现方式](src/main/java/com/javaniuniu/juc/loop/output/subject9/T1_NotifyHoldingLock.java)
   - [CountDownLatch实现方式](src/main/java/com/javaniuniu/juc/loop/output/subject9/T1_NotifyHoldingLock.java)
   - [LockSupport实现方式](src/main/java/com/javaniuniu/juc/loop/output/subject9/T1_LockSupport.java)
10. 写一个固定容量的容器，拥有put和get方法，以及getCount 方法，能够支持2个生产者线程以及10个消费者线程的阻塞调用
   - [内置锁实现方式](src/main/java/com/javaniuniu/juc/loop/output/subject10/T1_Container.java)
   - [显示锁实现方式](src/main/java/com/javaniuniu/juc/loop/output/subject10/T2_Container.java)
11. 强软弱虚 引用
    - 强：当对于引用为空，开始回收内存
    - [强](src/main/java/com/javaniuniu/juc/loop/output/subject11/Test_NormalReference.java)
    - 软：当堆内存满了，开始回收内存  （可用于缓存）
    - [软](src/main/java/com/javaniuniu/juc/loop/output/subject11/Test_SoftReference.java)
    - 弱：只要触发gc，就会被回收    （一般用于容器） 在ThreadLocal 中应用到
    - [弱](src/main/java/com/javaniuniu/juc/loop/output/subject11/Test_WeakReference.java)
    - 虚：管理堆外内存  
   
12. 对比 hashtable SynchronizedHashMap  ConcurrentHashMap 的效率
    - [hashtable](src/main/java/com/javaniuniu/juc/loop/output/subject12/Test_Hashtable.java)
    - [SynchronizedHashMap](src/main/java/com/javaniuniu/juc/loop/output/subject12/Test_SynchronizedHashMap.java)
    - [ConcurrentHashMap](src/main/java/com/javaniuniu/juc/loop/output/subject12/Test_ConcurrentHashMap.java)
    - 数据插入时间 SynchronizedHashMap < hashtable < ConcurrentHashMap
    - 数据读取时间 SynchronizedHashMap > hashtable > ConcurrentHashMap
  
13. 有10000张火车票，每个票都有一个编号，同时有10个窗口对外售票
    - [Vector实现](src/main/java/com/javaniuniu/juc/loop/output/subject13/Test_TicketSell_vector2.java)
    - [ConcurrentLinkedQueue实现](src/main/java/com/javaniuniu/juc/loop/output/subject13/Test_TicketSell_ConcurrentLinkedQueue.java)
   
14. Queue 想过实现和说明
    - [ArrayBlockingQueue实现](src/main/java/com/javaniuniu/juc/loop/output/subject14/Test_ArrayBlockingQueue.java)
    - [ConcurrentHashMape实现](src/main/java/com/javaniuniu/juc/loop/output/subject14/Test_ConcurrentHashMap.java)
    - [ConcurrentLinkedQueue实现](src/main/java/com/javaniuniu/juc/loop/output/subject14/Test_ConcurrentLinkedQueue.java)
    - [CopyOnWriteArrayList实现](src/main/java/com/javaniuniu/juc/loop/output/subject14/Test_CopyOnWriteArrayList.java)
    - [DelayQueue实现](src/main/java/com/javaniuniu/juc/loop/output/subject14/Test_DelayQueue.java)
    - [LinkedBlockingQueue实现](src/main/java/com/javaniuniu/juc/loop/output/subject14/Test_LinkedBlockingQueue.java)
    - [PriorityQueue实现](src/main/java/com/javaniuniu/juc/loop/output/subject14/Test_PriorityQueue.java)
    - [synchronizedList实现](src/main/java/com/javaniuniu/juc/loop/output/subject14/Test_SynchronizedList.java)
    - [SynchronousQueue实现](src/main/java/com/javaniuniu/juc/loop/output/subject14/Test_SynchronousQueue.java)
    - [TransferQueue实现](src/main/java/com/javaniuniu/juc/loop/output/subject14/Test_TransferQueue.java)
   
15. 写两个线程，一个线程打印1～26，另一个线程打印A～Z，打印顺序是1A2B...26Z
    - 这个考的是线程执行顺序，可以通过wait 和阻塞队列实现
    - [TransferQueue实现方式](src/main/java/com/javaniuniu/juc/loop/output/subject15/Test_TransferQueue.java)
    - [AtomicInteger实现方式](src/main/java/com/javaniuniu/juc/loop/output/subject15/Test_AtomicInteger.java)
    - [BlockingQueue实现方式](src/main/java/com/javaniuniu/juc/loop/output/subject15/Test_BlockingQueue.java)
    - [CAS](src/main/java/com/javaniuniu/juc/loop/output/subject15/Test_CAS.java)
    
16. 线程池想过类示例
    - [Executor](src/main/java/com/javaniuniu/juc/loop/output/subject16/Test_Executor.java)
    - [ExecutorService](src/main/java/com/javaniuniu/juc/loop/output/subject16/Test_ExecutorService.java)
    - [Callable](src/main/java/com/javaniuniu/juc/loop/output/subject16/Test_Callable.java)
    - [ThreadPool](src/main/java/com/javaniuniu/juc/loop/output/subject16/Test_ThreadPool.java)
    - [Future](src/main/java/com/javaniuniu/juc/loop/output/subject16/Test_Future.java)
    - [MyRejectedHandler](src/main/java/com/javaniuniu/juc/loop/output/subject16/Test_MyRejectedHandler.java)
    - [SingleThreadPool](src/main/java/com/javaniuniu/juc/loop/output/subject16/Test_SingleThreadPool.java)
    - [CachedPool](src/main/java/com/javaniuniu/juc/loop/output/subject16/Test_CachedPool.java)
    - [FixedThreadPool](src/main/java/com/javaniuniu/juc/loop/output/subject16/Test_FixedThreadPool.java)
    - [ScheduledPool](src/main/java/com/javaniuniu/juc/loop/output/subject16/Test_ScheduledPool.java)
    - [ForkJoinPool](src/main/java/com/javaniuniu/juc/loop/output/subject16/Test_ForkJoinPool.java)
    - [WorkStealingPool](src/main/java/com/javaniuniu/juc/loop/output/subject16/Test_WorkStealingPool.java)
    - [ParallelStreamAPI](src/main/java/com/javaniuniu/juc/loop/output/subject16/Test_ParallelStreamAPI.java)
    
    


### [八个经典的java多线程编程题目](https://blog.csdn.net/shinecjj/article/details/103792151)

1. 要求线程a执行完才开始线程b, 线程b执行完才开始线程
2. 两个线程轮流打印数字，一直到100
3. 写两个线程，一个线程打印1~ 52，另一个线程打印A~Z，打印顺序是12A34B...5152Z
4. 编写一个程序，启动三个线程，三个线程的ID分别是A，B，C；，每个线程将自己的ID值在屏幕上打印5遍，打印顺序是ABCABC...
5. 编写10个线程，第一个线程从1加到10，第二个线程从11加20…第十个线程从91加到100，最后再把10个线程结果相加。
6. 三个窗口同时卖票
7.  生产者消费者
    7.1 synchronized方式
    7.2 ReentrantLock方式 (可以保证顺序)
    7.3 BlockingQueue方式
8. 交替打印两个数组

   
### 思考题
8. 1：A线程正在执行一个对象中的同步方法，B线程是否可以同时执行同一个对象中的非同步方法？
   2：同上，B线程是否可以同时执行同一个对象中的另一个同步方法？
   3：线程抛出异常会释放锁吗？
   4：volatile和synchronized区别？
   5：写一个程序，证明AtomXXX类比synchronized更高效
   6：AtomXXX类可以保证可见性吗？请写一个程序来证明
   7：写一个程序证明AtomXXX类的多个方法并不构成原子性
   8：写一个程序模拟死锁
   9：写一个程序，在main线程中启动100个线程，100个线程完成后，主线程打印“完成”，使用join()和countdownlatch都可以完成，请比较异同。
   10：一个高效的游戏服务器应该如何设计架构？