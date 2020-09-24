import java.math.BigDecimal;
import java.util.*;

class Main {

    public static void main(String[] args) {
        new Main().solveProblem();
    }

    public void solveProblem() {

        final Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        while(n-- > 0) {
            String line = scanner.nextLine();

            BigDecimal firstBig = new BigDecimal(line.split(" ")[0]);
            BigDecimal secondBig = new BigDecimal(line.split(" ")[1]);

            String ans = firstBig.add(secondBig)
                    .toPlainString()
                    .replaceAll("0+$","")
                    .replaceAll("\\.$",".0");

            System.out.println(ans);
        }

        scanner.close();
    }

}
