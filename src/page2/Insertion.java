package page2;

public class Insertion {
    void sort(Comparable[]a){
        int N=a.length;
        for(int i=1;i<N;i++){
            for(int j=i;j>0&&a[j].compareTo(a[j-1])<0;j++)
            {
                Comparable t = a[i];
                a[i] = a[j];
                a[j] = t;
            }
        }
    }
}
