1. 题目一：子线程循环2次，主线程循环2次，然后子线程循环2次，主线程循环2次，这样循环10次；
- [内置锁实现方式](src/main/java/com/javaniuniu/juc/loop/output/subject1/T1.java)
- [显示锁实现方式](src/main/java/com/javaniuniu/juc/loop/output/subject1/T2.java)
2. 题目二：写两个线程，一个线程打印1～52，另一个线程打印A～Z，打印顺序是12A34B...5152Z；
- [显示锁实现方式](src/main/java/com/javaniuniu/juc/loop/output/subject2/D1.java)
- [内置锁实现方式](src/main/java/com/javaniuniu/juc/loop/output/subject2/Demo1.java)