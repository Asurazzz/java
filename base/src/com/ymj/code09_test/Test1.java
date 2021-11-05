package ymj.code09_test;

public class Test1 {
    public static Test1 t1 = new Test1();
    public static Test1 t2 = new Test1();

    {
        System.out.println("构造块");
    }

    static {
        System.out.println("静态块");
    }

    public static void main(String[] args) {
        Test1 test1 = new Test1();
    }
}
