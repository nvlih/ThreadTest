package synchroniz;

/**
 * Created by qi on 2018/3/8.
 */
public class Mtest {
    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            Thread thread = new MyThread();
            thread.start();
        }
    }
}
