package synchroniz;

/**
 * Created by qi on 2018/3/8.
 */
public class MyThread18  extends Thread {
    private ThreadDomain18 td;

    public MyThread18(ThreadDomain18 td)
    {
        this.td = td;
    }

    public void run()
    {
        try
        {
            td.doLongTimeTask();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
