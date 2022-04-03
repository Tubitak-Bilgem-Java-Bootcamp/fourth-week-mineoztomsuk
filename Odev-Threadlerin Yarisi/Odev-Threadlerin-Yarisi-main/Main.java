import java.util.ArrayList;

public class Main {
    public static ArrayList<Integer> numsOdd = new ArrayList<>();
    public static ArrayList<Integer> numsEven = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        ArrayList<Integer> list = new ArrayList<>();

        int n = 10000;
        int numInterval = 4;
        int rangeInterval = n / numInterval;

        for (int i=1; i<=10000; i++) {
            list.add(i);
        }

        ArrayList<ArrayList<Integer>> subListList = new ArrayList<>();

        for (int i=0; i<numInterval; i++) {
            ArrayList<Integer> subList = new ArrayList<>();
            for (int j = i*rangeInterval; j < (i+1)*rangeInterval; j++) {
                subList.add(list.get(j));
            }
            subListList.add(subList);
        }


        OddEven oe1 = new OddEven(subListList.get(0));
        Thread t1 = new Thread(oe1);
        t1.start();

        OddEven oe2 = new OddEven(subListList.get(1));
        Thread t2 = new Thread(oe2);
        t2.start();

        OddEven oe3 = new OddEven(subListList.get(2));
        Thread t3 = new Thread(oe3);
        t3.start();

        OddEven oe4 = new OddEven(subListList.get(3));
        Thread t4 = new Thread(oe4);
        t4.start();

        do {
            try{
                t1.join();
                t2.join();
                t3.join();
                t4.join();
            } catch (Exception e) {
                System.out.println();
            }

        } while (t1.isAlive() || t2.isAlive() || t3.isAlive() || t4.isAlive());

        System.out.println(numsOdd);
        System.out.println(numsEven);
    }
}
