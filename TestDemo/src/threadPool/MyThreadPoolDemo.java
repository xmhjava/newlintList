package threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyThreadPoolDemo {
public static void main(String[] args) {
	//oom
//	ExecutorService pool = Executors.newFixedThreadPool(5);
	ExecutorService pool = Executors.newSingleThreadExecutor();
	//ExecutorService pool=Executors.newCachedThreadPool();
	try {
		for (int i = 0; i < 10; i++) {
			pool.execute(() -> {
				System.out.println(Thread.currentThread().getName()+"\t办理业务");
			});
		}
		pool.shutdown();
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	
	
	
}
}
