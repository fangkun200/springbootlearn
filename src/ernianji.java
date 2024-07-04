import java.util.Random;

public class ernianji {
    public static void main(String[] args) {
        for (int i = 0; i < 40; i++) {
            System.out.println(getFunction(20));
        }
        for (int i = 0; i < 60; i++) {
            System.out.println(getFunction(100));
        }
    }

    private static String getFunction(int num) {
        int a = new Random().nextInt(num) + 1;
        int d = new Random().nextInt(2);
        StringBuilder sb = new StringBuilder();
        if (d == 1) {
            int b = new Random().nextInt(num - a + 1) + 1;
            sb.append(a);
            sb.append(" + ");
            sb.append(b);
        } else {
            int b = new Random().nextInt(a);
            sb.append(a);
            sb.append(" - ");
            sb.append(b);
        }
        sb.append(" = ");
        return sb.toString();
    }
}
