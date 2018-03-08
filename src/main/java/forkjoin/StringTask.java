package forkjoin;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
public class StringTask extends RecursiveTask<Integer>{
    //要处理的字符串
    private String dest;
    public StringTask(String dest) {
        this.dest = dest;
    }
    //父类RecursiveTask是一个抽象类，所以需要实现compute方法
    @Override
    protected Integer compute() {
        if (dest == null || "".equals(dest))
            return 0;
        //判断字符串中 * 的索引，并返回
        return dest.indexOf("*");
    }
}

class ArrayTask extends RecursiveTask<Integer>{
    //需要处理的字符串数组
    private String[] array;

    public ArrayTask(String[] array) {
        this.array = array;
    }

    @Override
    protected Integer compute() {
        if (array == null || array.length < 1)
            return 0;

        //申明一个StringTask变量，作为子任务
        StringTask stringTask;
        //定义一个子任务队列，用于任务执行完毕后，获取子任务的执行结果
        List<StringTask> list = new ArrayList<>();
        int sum = 0;
        //把字符串数组的中每一个字符串分给多个StringTask子任务去处理
        for (String s : array){
            //创建一个变量，作为子任务去处理字符串
            stringTask = new StringTask(s);
            //执行子任务
            stringTask.fork();
            //加入子任务队列
            list.add(stringTask);
            System.out.println("@@@:---------");
        }

        for (StringTask task : list){
            //等子任务执行完毕，获取子任务执行的结果，并累加
            sum += task.join();
        }

        return sum;
    }
}

class Demo{

    public static void main(String[] args){
        //初始化字符串数组
//        String[] array = new String[]{"1111111","222222","333333333333","4444444444444444!@"};
        String[] array = new String[]{"#####*####","##*########","###*#######","#*############"};
        //创建一个总任务，处理字符串数组
        ArrayTask arrayTask = new ArrayTask(array);
        //创建执行任务的线程池ForkJoinPool对象
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        //执行总任务
        ForkJoinTask<Integer> forkJoinTask = forkJoinPool.submit(arrayTask);

        //返回任务的结果
        try {
            System.out.println(forkJoinTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
