import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.concurrent.Callable;

public class AsyncJob implements Callable<ArrayList<Integer>> {

    public AsyncJob() {
    }

    @Override
    public ArrayList<Integer> call() {
        ArrayList<Integer> returnList = AsyncJob.generateList(10000);
        AsyncJob.sortList(returnList);
        return returnList;
    }

    private static ArrayList<Integer> generateList(int length) {
        ArrayList<Integer> list = new ArrayList<>();

        Random generator = new Random();

        for (int i = 0; i < length; i++) {
            list.add(generator.nextInt(Integer.MAX_VALUE));
        }

        return list;
    }

    private static void sortList(ArrayList<Integer> list) {
        Collections.sort(list);
    }
}
