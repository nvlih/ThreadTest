package cn.itcast.heima2;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
//CountDownLatch类位于java.util.concurrent包下，利用它可以实现类似计数器的功能。比如有一个任务A，它要等待其他4个任务执行完毕之后才能执行，此时就可以利用CountDownLatch来实现这种功能了。
public class CountdownLatchTest {

	public static void main(String[] args) {
		//创建一个定长线程池，支持定时及周期性任务执行。
		ExecutorService service = Executors.newCachedThreadPool();
		final CountDownLatch cdOrder = new CountDownLatch(1);
		final CountDownLatch cdAnswer = new CountDownLatch(3);		
		for(int i=0;i<3;i++){
			Runnable runnable = new Runnable(){
					public void run(){
					try {
						System.out.println("线程" + Thread.currentThread().getName() +
								"正准备接受命令");
						//调用await()方法的线程会被挂起，它会等待直到count值为0才继续执行
						cdOrder.await();
						System.out.println("线程" + Thread.currentThread().getName() +
						"已接受命令");
						Thread.sleep((long)(Math.random()*10000));	
						System.out.println("线程" + Thread.currentThread().getName() +
								"回应命令处理结果");
						//　 void	countDown()//计数器减1
						cdAnswer.countDown();						
					} catch (Exception e) {
						e.printStackTrace();
					}				
				}
			};
			service.execute(runnable);
		}		
		try {
			Thread.sleep((long)(Math.random()*10000));
		
			System.out.println("线程" + Thread.currentThread().getName() +
					"即将发布命令");
			cdOrder.countDown();
			System.out.println("线程" + Thread.currentThread().getName() +
			"已发送命令，正在等待结果");
			cdAnswer.await();
			System.out.println("线程" + Thread.currentThread().getName() +
			"已收到所有响应结果");
		} catch (Exception e) {
			e.printStackTrace();
		}				
		service.shutdown();

	}
}
