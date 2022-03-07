import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author yemingjie.
 * @date 2022/3/7.
 * @time 16:22.
 */
public class Test4 {
    public static void main(String[] args) {
        List<Order> orders = new ArrayList<>();
        Order order = new Order();
        order.setOid(1L);
        order.setName("1");
        orders.add(order);
        order = new Order();
        order.setOid(2L);
        order.setName("2");
        orders.add(order);


        List<String> oidList = orders.stream().map(Order::getOid).map(String::valueOf).distinct().collect(Collectors.toList());

        System.out.println(oidList);


        HashMap<Long, String> distributeStatusMap = new HashMap(16);
        orders.forEach((item) -> distributeStatusMap.put(item.getOid(), item.getName()));

        boolean isDistributor = orders.stream().anyMatch(item -> item.getName().equals("3"));
        System.out.println(isDistributor);


    }
}
