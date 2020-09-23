import java.util.*;

class Main {

    public static void main(String[] args) {
        new Main().solveProblem();
    }

    public void solveProblem() {
        final Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();

        while(!"0 0".equals(line)) {

            String[] numbers = line.split(" ");

            equalNumOfDigits(numbers);

            int i = numbers[0].length() -1;
            int j = numbers[1].length() -1;

            int carry = 0;
            int carrysCount = 0;
            while(i >= 0 && j >= 0) {
                int soma = carry +
                        Integer.parseInt(String.valueOf(numbers[0].charAt(i))) +
                        Integer.parseInt(String.valueOf(numbers[1].charAt(j)));

                if(soma >= 10) {
                    carrysCount++;
                    carry = 1;
                }
                else {
                    carry = 0;
                }

                i--;
                j--;
            }

            if(carrysCount == 0) {
                System.out.println("No carry operation.");
            }
            else {
                System.out.println(carrysCount + " carry operation" + (carrysCount > 1 ? "s." : "."));
            }

            line = scanner.nextLine();
        }

        scanner.close();
    }

    private void equalNumOfDigits(String[] numbers) {

        String first = numbers[0];
        String second = numbers[1];

        int lengthDiff = second.length() - first.length();

        if(lengthDiff < 0) {
            String zeros = repeatString("0", Math.abs(lengthDiff));
            numbers[1] = zeros + numbers[1];
        }
        else if(lengthDiff > 0){
            String zeros = repeatString("0", lengthDiff);
            numbers[0] = zeros + numbers[0];
        }
    }

    private String repeatString(String s, int times) {
        if(times <= 1)
            return s;

        StringBuilder repeated = new StringBuilder();
        while(times > 0) {
            repeated.append(s);
            times--;
        }

        return repeated.toString();
    }
}
