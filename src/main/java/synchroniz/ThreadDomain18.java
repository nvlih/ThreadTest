package synchroniz;

/**
 * Created by qi on 2018/3/8.
 */
public class ThreadDomain18 {
    public void doLongTimeTask() throws Exception
    {
        for (int i = 0; i < 100; i++)
        {
            System.out.println("nosynchronized threadName = " +
                    Thread.currentThread().getName() + ", i = " + (i + 1));
        }
        System.out.println();
        synchronized (this)
        {
            for (int i = 0; i < 100; i++)
            {
                System.out.println("synchronized threadName = " +
                        Thread.currentThread().getName() + ", i = " + (i + 1));
            }
        }
    }
}

