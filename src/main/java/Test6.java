import java.util.ArrayList;
import java.util.List;

/**
 * @author yemingjie.
 * @date 2022/3/9.
 * @time 10:50.
 */
public class Test6 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.addAll(new ArrayList<>());
        System.out.println(list);
    }
    public static void main1(String[] args) {
        int pageIndex = 1;
        int pageSize = 100;
        int total;
        do {
            total = 310;
            System.out.println(pageIndex);
            pageIndex++;
        } while ((pageIndex - 1) * pageSize < total);
    }
}
