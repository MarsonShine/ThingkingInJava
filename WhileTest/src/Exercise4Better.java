import static java.lang.StrictMath.floor;
import static java.lang.StrictMath.sqrt;

/**
 * 埃拉托斯特尼筛法
 */
public class Exercise4Better {
    public static void main(String[] args) {
        int max = 100;
        if (args.length != 0)
            max = Integer.parseInt(args[0]);
        boolean[] sieve = new boolean[max + 1];
        int limit = (int) floor(sqrt(max));
        System.out.println(1 + " ");
        if (max > 1)
            System.out.println(2 + " ");
        //检测指数 detect prime numbers
        for (int i = 3; i <= limit; i += 2) {
            if (!sieve[i])
                for (int j = 2 * i; j <= max; j += i) {
                    sieve[j] = true;
                }
        }
        //打印质数
        for (int i = 3; i <= max; i += 2) {
            if (!sieve[i])
                System.out.println(i + " ");
        }
    }
}
