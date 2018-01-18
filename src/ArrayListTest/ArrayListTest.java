package ArrayListTest;

import java.util.ArrayList;
import java.util.ListIterator;

public class ArrayListTest {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>() {{
            add(1);
            add(2);
            add(3);
        }};
        Integer[] integers1 = new Integer[3];
        Integer[] integers2 = list.toArray(integers1);
        for (Integer integer : integers1)
            System.out.println(integer);
        System.out.println("-------------");
        for (Integer integer : integers2)
            System.out.println(integer);
        System.out.printf("%b,%b\n", integers1 == integers2, integers1.equals(integers2));

        /*ListIterator<Integer> iterator = list.listIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
            iterator.remove();
        }*/
        //list.add(10);
        System.out.println(list.size());
        int first=3;
        int second=-3>>>1;
        System.out.println(first+","+second);
        ArrayList<Integer>list1=new ArrayList<>(list);
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i)+","+list1.get(i));
        }
        System.out.println((list1==list)+","+list1.equals(list));
        list1.set(2,10);
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i)+","+list1.get(i));
        }
        System.out.println((list1==list)+","+list1.equals(list));
        System.out.println("------------");
        System.out.println(list.toArray().getClass());

        System.out.println((-2>>1)+","+(-2>>>1));



    }
}
