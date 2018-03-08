package synchroniz;

public class ZhuTest {
    public static void main(String[] args) {
        ThreadDomain18 td = new ThreadDomain18();
        MyThread18 mt0 = new MyThread18(td);
        MyThread18 mt1 = new MyThread18(td);
        mt0.start();
        mt1.start();
    }

}
