/**
 * @author yemingjie.
 * @date 2022/3/10.
 * @time 15:09.
 */
public class Test7 {

    public static void main(String[] args) {
        try {
            test1();
        } catch (Exception ex) {
            System.out.println("1");
        }
    }


    public static void test1() {
        try {
            System.out.println(1/0);

        } catch (Exception ex) {
            System.out.println("-----");
        }
    }
}
