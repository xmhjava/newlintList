import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThredDemo {
public static void main(String[] args) {
	
	LinkedBlockingQueue<Runnable> queue = new LinkedBlockingQueue<Runnable>();
	ThreadPoolExecutor th = new ThreadPoolExecutor(5, 10,0L, TimeUnit.MILLISECONDS,queue);
//	for (int i = 0; i < 10; i++) {
//		queue.add(new aa());
//	}
	th.execute(new aa2());
	
	
}

}

class aa2 implements Runnable{

	@Override
	public void run() {
	System.out.println("添加一个对象");
		
	}
	
}