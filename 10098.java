import java.util.*;

public class Main {

    SortedMap<String, Integer> nonRepeatingPermutations = new TreeMap<>();

    public static void main(String[] args) {
        new Main().solveProblem();
    }

    public void solveProblem() {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        while(n-- > 0) {

            String s = scan.nextLine();

            permutation(sort(s), 0, s.length()-1);

            print(nonRepeatingPermutations);
            nonRepeatingPermutations.clear();
            System.out.println();
        }
    }

    private void print(Map<String, Integer> nonRepeatingPermutations) {
        for (String s : nonRepeatingPermutations.keySet()) {
            System.out.println(s);
        }
    }

    private void permutation(String s, int start, int end) {

        if(start == end) {
            nonRepeatingPermutations.put(s, 0);
        }
        else {

            for (int i = start; i <= end; i++) {

                s = swap(s, start, i);

                permutation(s, start+1, end);

                s = swap(s, i, start);

            }
        }
    }

    private String sort(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);

        return new String(chars);
    }

    private String swap(String s, int i, int j) {
        char temp;
        char[] charArray = s.toCharArray();

        temp = charArray[i] ;
        charArray[i] = charArray[j];
        charArray[j] = temp;

        return String.valueOf(charArray);
    }

}
