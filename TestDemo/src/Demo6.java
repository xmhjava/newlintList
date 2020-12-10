import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Demo6 {
public static void main(String[] args) throws InterruptedException, ExecutionException {
	
	ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);

	scheduledExecutorService.scheduleAtFixedRate(() -> { System.out.println(Thread.currentThread()); }, 2, 5, TimeUnit.SECONDS);
}

}
