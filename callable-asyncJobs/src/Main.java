import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

    public static void main(String[] args) {

        final long startTime = System.currentTimeMillis();

        final int threadPoolSize = 10;
        final int numberOfJobs = 500;

        ExecutorService executorService = Executors.newFixedThreadPool(threadPoolSize);
        List<Future<ArrayList<Integer>>> jobList = new ArrayList<>();

        for (int i = 0; i < numberOfJobs; i++) {
            Callable<ArrayList<Integer>> job = new AsyncJob();
            Future<ArrayList<Integer>> pendingJob = executorService.submit(job);
            jobList.add(pendingJob);
        }

        for (Future<ArrayList<Integer>> result : jobList) {
            try {
                System.out.println(result.get());
            }
            catch (Exception e) {
                e.printStackTrace();
            }

            executorService.shutdown();
        }

        final long stopTime = System.currentTimeMillis();
        final long latency = stopTime - startTime;

        System.out.println("task completed in " + latency + "ms.");
    }
}
