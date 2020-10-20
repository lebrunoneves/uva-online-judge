import java.util.*;

public class Main {

    public static void main(String[] args) {
        new Main().solveProblem();
    }

    public void solveProblem() {
        Scanner scan = new Scanner(System.in);

        int k = 1;

        int from = scan.nextInt();
        int to = scan.nextInt();

        while(from >= 0 && to >=0 ) {

            Map<Integer, List<Integer>> edges = new HashMap<>();
            Map<Integer, Integer> groups = new HashMap<>();
            int nextGroupId = 1;

            while(from > 0 && to > 0){

                edges.putIfAbsent(to, new ArrayList<>());
                edges.putIfAbsent(from, new ArrayList<>());

                edges.get(to).add(from);

                if(!groups.containsKey(from) && !groups.containsKey(to)) {
                    groups.put(from, nextGroupId);
                    groups.put(to, nextGroupId);
                    nextGroupId++;
                }
                else if(!groups.containsKey(from)) {
                    groups.put(from, groups.get(to));
                }
                else if(!groups.containsKey(to)) {
                    groups.put(to, groups.get(from));
                }
                else {
                    int fromGroup = groups.get(from);
                    int toGroup = groups.get(to);

                    for (int node: groups.keySet())
                        if(groups.get(node) == fromGroup)
                            groups.put(node, toGroup);
                }

                from = scan.nextInt();
                to = scan.nextInt();
            }

            boolean isConnected = groups.values().stream().distinct().count() <= 1;

            int roots = 0;
            boolean multipleEdgePoints = false;

            for (int node: edges.keySet()) {
                if(edges.get(node).isEmpty()){
                   roots++;
                }
                else if(edges.get(node).size() > 1) {
                    multipleEdgePoints = true;
                }
            }

            if(edges.isEmpty() || (roots == 1 && !multipleEdgePoints && isConnected) )
                System.out.println("Case " + k++ + " is a tree.");
            else
                System.out.println("Case " + k++ + " is not a tree.");


            from = scan.nextInt();
            to = scan.nextInt();
        }
    }
}
