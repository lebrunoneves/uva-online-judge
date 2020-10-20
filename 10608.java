import java.util.*;

public class Main {

    public static void main(String[] args) {
        new Main().solveProblem();
    }

    public void solveProblem() {
        Scanner scan = new Scanner(System.in);

        int cases = Integer.parseInt(scan.nextLine());

        while(cases-- > 0) {

            String[] dataset = scan.nextLine().split(" ");

            int n = Integer.parseInt(dataset[0]);
            int m = Integer.parseInt(dataset[1]);

            if(m == 0){
                System.out.println(1);
                continue;
            }

            int[] group = new int[n+1];

            int nextGroupId = 1;

            while(m-- > 0) {
                String[] friends = scan.nextLine().split(" ");

                int a = Integer.parseInt(friends[0]);
                int b = Integer.parseInt(friends[1]);

                if(group[a] == 0 && group[b] == 0) {
                    group[a] = nextGroupId;
                    group[b] = nextGroupId;
                    nextGroupId++;
                }
                else if(group[a] == 0) {
                    group[a] = group[b];
                }
                else if(group[b] == 0) {
                    group[b] = group[a];
                }
                else if(group[a] != group[b]){ // merge groups
                    int mergeTo = group[a];
                    int mergeFrom = group[b];

                    for (int i = 1; i <= n; i++) {
                        if(group[i] == mergeFrom)
                            group[i] = mergeTo;
                    }
                }
            }

            Map<Integer, Integer> occurrences = new HashMap<>();

            for (int i = 1; i <= n; i++) {
                occurrences.putIfAbsent(group[i], 0);
                occurrences.put(group[i], occurrences.get(group[i]) + 1);
            }

            occurrences.remove(0);
            System.out.println(Collections.max(occurrences.values()));
        }
    }

}
