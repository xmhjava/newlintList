import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TestMyThreadPool {
	public static void main(String[] args) throws InterruptedException {
		MyThreadPool pool = new MyThreadPool(3,0);
        pool.execute(new MyTask("testA"));
        pool.execute(new MyTask("testB"));
        pool.execute(new MyTask("testC"));
        pool.execute(new MyTask("testD"));
        pool.execute(new MyTask("testE"));
        System.out.println(pool);
        Thread.sleep(10000);
        //所有任务执行完成才destory
        pool.destory();
        System.out.println(pool);
        //机器的cpu核心数
        System.out.println(Runtime.getRuntime().availableProcessors());

	}
	
}



class MyThreadPool{
	 /**
     * 线程池中默认线程的个数为5
     */
    private static int WORK_NUM = 5;
 
    /**
     * 队列默认任务个数为100
     */
    private static int TASK_COUNT = 100;
 
    /**
     * 工作线程
     */
    private WorkThread[] workThreads;
    /**
     * 任务队列 作为一个缓冲
     */
    private final BlockingQueue<Runnable> taskQueue;
 
    /**
     * 用户构造这个池，希望的启动的线程数
     */
    private final int worker_num;
 
    /**
     * 创建具有默认线程个数的线程池
     */
    public MyThreadPool(){
        this(WORK_NUM,TASK_COUNT);
    }
 
    /**
     * 创建线程池 ,worker_num为线程池中工作线程的个数
     * @param worker_num
     * @param taskCount
     */
    public MyThreadPool( int worker_num,int taskCount) {
        if(worker_num<=0){
            worker_num = WORK_NUM;
        }
        if(taskCount<=0){
            taskCount=TASK_COUNT;
        }
 
        this.worker_num = worker_num;
        taskQueue = new ArrayBlockingQueue<>(taskCount);
 
        workThreads = new WorkThread[worker_num];
        for (int i =0 ;i<worker_num;i++){
            workThreads[i] = new WorkThread();
            workThreads[i].start();
        }
    }
 
    /**
     * 执行任务，其实只是任务加入任务队列，什么时候执行有线程池管理器决定
     */
    public void execute(Runnable task){
        try {
            taskQueue.put(task);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
 
    /**
     * 销毁线程池，该方法保证所有任务都完成的情况下才销毁所有线程，否则等待任务完成才销毁
     */
    public void destory(){
        //工作线程停止工作，且置为null
        System.out.println("ready close pool...");
        for (int i =0 ;i<worker_num;i++){
            //help gc
            workThreads[i].stopWorker();
            workThreads[i] = null;
        }
        //清空任务队列
        taskQueue.clear();
    }
 
    @Override
    public String toString() {
        return "workThread number" + worker_num +
                "wait task number:" + taskQueue.size();
    }
 
    /**
     * 内部类，工作线程
     */
    private class WorkThread extends Thread{
        @Override
        public void run() {
            Runnable r = null;
            while (!isInterrupted()){
                try {
                    r = taskQueue.take();
                    if(r!=null){
                        System.out.println(getId()+" ready exec :"+r);
                        r.run();
                    }
                    //help gc
                    r = null;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
 
        public void stopWorker(){
            interrupt();
        }
    }

}


class MyTask implements Runnable{
	private String name;
    private Random r = new Random();
    public MyTask(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
	@Override
	public void run() {
		 try {
             Thread.sleep(r.nextInt(1000)+2000);
         } catch (InterruptedException e) {
             System.out.println(Thread.currentThread().getId()+" sleep InterruptedException:"
                     +Thread.currentThread().isInterrupted());
         }
         System.out.println(Thread.currentThread().getName()+"任务 " + name + " 完成");
		
	}
	
}