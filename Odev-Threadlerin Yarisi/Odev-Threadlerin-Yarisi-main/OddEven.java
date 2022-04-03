import java.util.ArrayList;


public class OddEven implements Runnable{

    private ArrayList<Integer> subList;

    private final Object LOCK = new Object();

    public OddEven(ArrayList<Integer> subList) {
        this.subList = subList;
    }

    @Override
    public synchronized void run() {

        for (int i = 0; i < this.subList.size(); i++) {
            Integer item = this.subList.get(i);
            if (item % 2 == 0) {
                Main.numsEven.add(item);
            } else {
                Main.numsOdd.add(item);
            }
        }
    }

    public ArrayList<Integer> getSubList() {
        return subList;
    }
}
