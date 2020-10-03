@SuppressWarnings("unchecked")
public class TestMain {
    public static void main(String[] args) {
        int b = 2;
        int c = 3;
        int a = b + c;
        System.out.println("Before changing b, a=" + a);
        b = 5;
        System.out.println("After changing b, a=" + a);
    }
}
