package synchroniz;

/**
 * Created by qi on 2018/3/8.
 */
public class Sync {
    public synchronized void test() {
        System.out.println("test开始..");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("test结束..");
    }
}

