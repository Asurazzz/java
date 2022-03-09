/**
 * @author yemingjie.
 * @date 2022/3/8.
 * @time 17:46.
 */
public class Test5 {
    public static void main(String[] args) {
        int defaultValue = 1;
        int pageIndex = 4;
        while (defaultValue <= pageIndex) {
            defaultValue = defaultValue == 1?  2 : defaultValue;
            System.out.println(defaultValue);
            defaultValue++;
        }
    }
}
