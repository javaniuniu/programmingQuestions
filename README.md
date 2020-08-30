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