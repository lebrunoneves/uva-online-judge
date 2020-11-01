
import java.util.*;

class Main {

	static class Graph {

		private final Map<String, List<String>> edges;

		public Graph() {
			edges = new HashMap<>();
		}

		public void addEdge(String u, String v) {
			edges.putIfAbsent(u, new ArrayList<>());
			if(!edges.get(u).contains(v))
				edges.get(u).add(v);

		}

		public Map<String, String> bellmanFord(String src, int n, Map<String, Integer> weights) {

			if(n == 0)
				return new HashMap<>();

			int[] dist = new int [n+1];

			for (int i = 1; i <= n; i++) {
				dist[i] = Integer.MAX_VALUE;
			}
			dist[Integer.parseInt(src)] = 0;

			for (int i = 1; i <= n; i++) {
				for (String u : edges.keySet()) {
					for (String v: edges.get(u)) {
						Integer weight = weights.get(u+v);

						final int newDist = dist[Integer.parseInt(u)] + weight;

						if(dist[Integer.parseInt(u)] != Integer.MAX_VALUE && newDist < dist[Integer.parseInt(v)]) {
							dist[Integer.parseInt(v)] = newDist;
						}
					}
				}
			}

			for (int i = 1; i <= n; i++) {
				for (String u : edges.keySet()) {
					for (String v: edges.get(u)) {
						Integer weight = weights.get(u+v);

						if(dist[Integer.parseInt(u)] != Integer.MAX_VALUE
								&& dist[Integer.parseInt(u)] + weight < dist[Integer.parseInt(v)])
						{
							dist[Integer.parseInt(v)] = -1;
						}
					}
				}
			}

			Map<String, String> ret = new HashMap<>();

			for (int i = 1; i <= n; i++) {
				if(dist[i] < 3 || dist[i] == Integer.MAX_VALUE) {
					ret.put(String.valueOf(i), "?");
				}
				else {
					ret.put(String.valueOf(i), String.valueOf(dist[i]));
				}
			}

			return ret;
		}
	}

	public static void main(String[] args) {
		new Main().solveProblem();
    }

    public void solveProblem() {
        Scanner scan = new Scanner(System.in);
		int set = 1;

        while(scan.hasNextInt()) {

        	Graph g = new Graph();
        	Map<String, Integer> weights = new HashMap<>();

			int n = scan.nextInt();

			int[] busyness = new int[n+1];

			for (int i = 1; i <= n; i++) {
				busyness[i] = scan.nextInt();
			}

			int r = scan.nextInt();

			for (int i = 0; i < r; i++) {
				int from = scan.nextInt();
				int to = scan.nextInt();

				g.addEdge(Integer.toString(from), Integer.toString(to));

				double amount = (Math.pow(busyness[to] - busyness[from], 3));

				weights.put(Integer.toString(from) + to, (int) amount);
			}

			int q = scan.nextInt();

			System.out.println("Set #" + set++);
			Map<String, String> dist = g.bellmanFord("1", n, weights);
			for (int i = 0; i < q; i++) {
				int dest = scan.nextInt();
				System.out.println(dist.get(Integer.toString(dest)));
			}

        }


	}
}












