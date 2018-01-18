package page2;

public class BubbleSort {
    void sort(Comparable[]a){
        int N=a.length;
        for(int i=N-1;i>0;i--){
            for(int j=0;j<i;j++){
                if(a[j].compareTo(a[j+1])>0){
                    exch(a,j,j+1);
                }
            }
        }
    }


    public static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
