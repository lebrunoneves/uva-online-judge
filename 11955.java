import java.math.BigInteger;
import java.util.*;

class Main {

    public static void main(String[] args) {
        new Main().solveProblem();
    }

    public void solveProblem() {

        BigInteger[][] C = new BigInteger[60][60];

        for (int i=0; i<60; i++)
            for (int j=0; j<=i; j++) {
                if (j == 0 || j == i)
                    C[i][j] = BigInteger.valueOf(1);
                else
                    C[i][j] = C[i - 1][j - 1].add(C[i - 1][j]);
            }

        final Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {

            String exp = scanner.nextLine();

            System.out.print("Case " + (i+1) + ": ");

            String a = exp.substring(exp.indexOf("(")+1, exp.indexOf("+"));
            String b = exp.substring(exp.indexOf("+")+1, exp.indexOf(")"));
            int k = Integer.parseInt(exp.substring(exp.indexOf("^")+1));

            for (int j = 0; j <= k ; j++) {
                if(j>0)
                    System.out.print("+");
                if(!C[k][j].equals(new BigInteger("1")))
                    System.out.print(C[k][j] + "*");
                if(k-j > 0){
                    System.out.print(a);
                    if(k-j>1)
                        System.out.print("^" + (k-j));
                }
                if((k-j)>0 && j>0) {
                    System.out.print("*");
                }
                if(j > 0){
                    System.out.print(b);
                    if(j>1)
                        System.out.print("^" + j);
                }
            }

            System.out.println();

        }

        scanner.close();
    }



}
