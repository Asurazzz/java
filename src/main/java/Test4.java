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


        List<String> oidList = new ArrayList<>();
        HashMap<Long, String> distributeStatusMap = new HashMap(16);
        boolean isDistributor = false;
        isDistributor = paserTest(isDistributor);
        System.out.println(isDistributor);
//        parseTradeOrderToCjdf(orders, oidList, isDistributor, distributeStatusMap);
//        System.out.println(oidList);
//        System.out.println(distributeStatusMap);
//        System.out.println(isDistributor);




        // boolean isDistributor = orders.stream().anyMatch(item -> item.getName().equals("3"));


    }

    private static boolean paserTest(boolean isDistributor) {
        isDistributor = true;
        return isDistributor;
    }

    private static void parseTradeOrderToCjdf(List<Order> orders,
                                       List<String> oidList,
                                       boolean isDistributor,
                                       HashMap<Long, String> distributeStatusMap) {
        oidList = orders.stream().map(Order::getOid).map(String::valueOf).distinct().collect(Collectors.toList());
        orders.forEach((item) -> distributeStatusMap.put(item.getOid(), item.getName()));
        isDistributor = orders.stream().anyMatch(item -> item.getName().equals("1"));
    }
}
