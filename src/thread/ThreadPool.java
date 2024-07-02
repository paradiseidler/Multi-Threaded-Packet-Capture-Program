package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {
    private static final ExecutorService threadPool;

    private static final Integer threadNum=3;

    static{
        threadPool= Executors.newFixedThreadPool(threadNum);
    }

    public static void execute(Runnable runnable){
        threadPool.execute(runnable);
    }
}
