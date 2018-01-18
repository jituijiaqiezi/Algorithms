package page2;

public class ShellSort {
    void sort(Comparable[] a) {
        int N = a.length;
        int h = 1;
        //步长可自定义大小
        int step=2;
        while (h < N / step)
            h = 2 * h + 1;
        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && a[j].compareTo(a[j - h]) < 0; j -= h)
                    exch(a, j, j - h);
            }
            h /= step;
        }
    }
    public static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
