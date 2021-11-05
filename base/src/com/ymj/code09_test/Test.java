package ymj.code09_test;

public class Test {
    public static int aMethod(int i)throws Exception {
        try{
            return 10 / i;
        }
        catch (Exception ex) {
            System.out.println("\nexception in a Method");
            return 1;
        } finally{
            System.out.printf("\nfinally ");
            return 2;
        }
    }

    public static void main(String [] args) {
        try {
            int i = aMethod(0);
            System.out.println(i);
        }
        catch (Exception ex) {
            System.out.printf("\nexception in main ");
        }
        System.out.printf(" \nfinished ");
    }
}




