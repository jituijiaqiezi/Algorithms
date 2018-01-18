package ArrayListTest;

public class HashTest {
    public static void main(String[] args) {
        String lcp="lcp";
        int hashcode=StringHashCode(lcp.toCharArray());
        int mapHashCode=HashMapHashCode(hashcode);
        System.out.println(mapHashCode);
    }

    public static int StringHashCode(char[] value) {
        int h = 0;
        if (value.length > 0) {
            for (char aValue : value) {
                h = 31 * h + aValue;
                System.out.println(h);
            }
        }
        return h;
    }

    static int HashMapHashCode(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
}
