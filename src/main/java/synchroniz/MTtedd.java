package synchroniz;

/**
 * Created by qi on 2018/3/8.
 */
public class MTtedd {
    //线程1访问了一个对象方法A的synchronized块，线程2对于同一对象同步方法B的访问应该是会被阻塞的，因为线程2访问同一对象的同步方法B的时候将会尝试去获取这个对象的对象锁，但这个锁却在线程1这里


    //为了进一步完善这个结论，把"otherMethod()"方法的synchronized去掉
    //当A线程访问对象的synchronized代码块的时候，B线程依然可以访问同一对象方法中其余非synchronized块的部分，第一部分的执行结果证明了这一点

    //所以synchronized 锁住的是对象
    public static void main(String[] args) throws Exception {
        ThreadDomain20 td = new ThreadDomain20();
        MyThread20_0 mt0 = new MyThread20_0(td);
        MyThread20_1 mt1 = new MyThread20_1(td);
        mt0.start();
        Thread.sleep(100);
        mt1.start();
    }
}
