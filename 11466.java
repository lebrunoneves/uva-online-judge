import java.util.*;

public class Main {

    public static void main(String[] args) {
        new Main().solveProblem();
    }

    public void solveProblem() {
        Scanner scan = new Scanner(System.in);

        long n = Long.parseLong(scan.nextLine());

        while(n != 0) {

            long lpd = getLargestPrimeDivisor(Math.abs(n));

            System.out.println(lpd);

            n = Long.parseLong(scan.nextLine());
        }
    }

    private long getLargestPrimeDivisor(long n) {
        int divisors = 0;
        long original = n;
        long maxPrime = -1;

        if(n % 2 == 0) divisors++;
        while (n % 2 == 0) {
            maxPrime = 2;
            n /= 2;
        }

        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if(n % i == 0) divisors++;
            while (n % i == 0) {
                maxPrime = i;
                n = n / i;
            }
        }

        if (n > 2) {
            maxPrime = n;
            divisors++;
        }

        if(maxPrime == original || divisors<2)
            return -1;

        return maxPrime;
    }

}
