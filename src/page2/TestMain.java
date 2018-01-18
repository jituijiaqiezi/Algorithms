package page2;

import edu.princeton.cs.algs4.Selection;
import edu.princeton.cs.algs4.Shell;

import java.util.ArrayList;
import java.util.List;

public class TestMain {
    public static void main(String[] args) {
        /*List<Integer> list=new ArrayList<>();
        int N=100000;
        for(int i=0;i<N;i++)
            list.add(i);
        long time=System.nanoTime();
        Selection.sort(list.toArray(new Integer[N]));
        System.out.println("Shell:"+(System.nanoTime()-time));

        Selection.sort(list.toArray(new Integer[N]));
        System.out.println("Insertion:"+(System.nanoTime()-time));
        time=System.nanoTime();

        Selection.sort(list.toArray(new Integer[N]));
        System.out.println("Selection:"+(System.nanoTime()-time));
        time=System.nanoTime();*/

        Integer[]b=new Integer[]{5,4,3,2,1};
        new BubbleSort().sort(b);
        for(int i:b)
            System.out.println(i);
    }
}
