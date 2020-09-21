import java.util.*;

class Main {

    public static void main(String[] args) {
        new Main().solveProblem();
    }

    public void solveProblem() {
        final Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        while(n-- > 0) {
            Long number = Long.parseLong(scanner.nextLine());

            Long reverse = getReverse(number);

            Long result = number + reverse;

            boolean isResultPalindrom = isPalidrom(result);

            int interations = 1;
            while(!isResultPalindrom) {
                number = result;
                reverse = getReverse(number);

                result = number + reverse;

                isResultPalindrom = isPalidrom(result);
                interations++;
            }

            System.out.println(interations + " " + result);
        }

        scanner.close();
    }

    static private boolean isPalidrom(Long number) {

        String n = number.toString();

        int i = 0;
        int j = n.length() - 1;

        while(i < j) {

            if(n.charAt(i) == n.charAt(j)) {
                i++;
                j--;
            }
            else {
                return false;
            }
        }

        return true;
    }

    static private Long getReverse(Long number) {

        String n = number.toString();

        StringBuilder reverse = new StringBuilder();

        for (int i = n.length() - 1 ; i >= 0 ; i--) {
            reverse.append(n.charAt(i));
        }

        return Long.parseLong(reverse.toString());
    }
}
