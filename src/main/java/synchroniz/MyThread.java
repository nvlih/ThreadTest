package synchroniz;

/**
 * Created by qi on 2018/3/8.
 */
public class MyThread extends Thread {

    public void run() {
        Sync sync = new Sync();
        sync.test();
    }
}
