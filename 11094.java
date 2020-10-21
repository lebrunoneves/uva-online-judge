import java.util.*;

public class Main {

    public static void main(String[] args) {
        new Main().solveProblem();
    }

    public void solveProblem() {
        Scanner scan = new Scanner(System.in);

        while(scan.hasNextInt()) {

            int m = scan.nextInt();
            int n = scan.nextInt();
            scan.nextLine();

            char[][] map = new char[m][n];

            for (int i = 0; i < m; i++) {
                String row = scan.nextLine();
                for (int j = 0; j < n; j++) {
                    map[i][j] = row.charAt(j);
                }
            }

            int x = scan.nextInt();
            int y = scan.nextInt();

            char land = map[x][y];

            int[][] continent = new int[m][n];
            int nextContinentId = 1;

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if(map[i][j] == land) {
                        if(i==0 && j==0){
                            continent[i][j] = nextContinentId;
                            nextContinentId++;
                        }
                        else if(i==0){
                           if(continent[i][j-1]!=0) {
                               continent[i][j] = continent[i][j-1];
                           }
                           else{
                               continent[i][j] = nextContinentId;
                               nextContinentId++;
                           }

                            checkAcrossTheWorldBoundary(m, n, continent, i, j);
                        }
                        else if(j==0){
                            if(continent[i-1][j]!=0) {
                                continent[i][j] = continent[i-1][j];
                            }
                            else{
                                continent[i][j] = nextContinentId;
                                nextContinentId++;
                            }
                        }
                        else{ // i>0 && j>0
                            if(continent[i][j-1]==0 && continent[i-1][j]==0){
                                continent[i][j] = nextContinentId;
                                nextContinentId++;
                            }
                            else if(continent[i][j-1]==0){
                                continent[i][j] = continent[i-1][j];
                            }
                            else if(continent[i-1][j]==0){
                                continent[i][j] = continent[i][j-1];
                            }
                            else{ // continent[i][j-1]!=0 && continent[i-1][j]!=0
                                continent[i][j] = continent[i-1][j];

                                if(continent[i][j-1] != continent[i-1][j]) {
                                    int mergeContinent = continent[i][j-1];
                                    for (int k = 0; k < m; k++) {
                                        for (int l = 0; l < n; l++) {
                                            if(continent[k][l]==mergeContinent)
                                                continent[k][l]= continent[i][j];
                                        }
                                    }
                                }
                            }

                            checkAcrossTheWorldBoundary(m, n, continent, i, j);
                        }
                    }
                }
            }

            Map<Integer, Integer> continentsSize = new HashMap<>();

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if(continent[i][j] > 0){
                        continentsSize.putIfAbsent(continent[i][j], 0);
                        int valueIncr = continentsSize.get(continent[i][j])+1;
                        continentsSize.put(continent[i][j], valueIncr);
                    }
                }
            }

            continentsSize.remove(continent[x][y]);

            System.out.println(continentsSize.size() > 0 ? Collections.max(continentsSize.values()) : "0");

        }
    }

    private void checkAcrossTheWorldBoundary(int m, int n, int[][] continent, int i, int j) {
        if(j==n-1) {
            if(continent[i][0] != 0) {
                int mergeContinent = continent[i][0];
                for (int k = 0; k < m; k++) {
                    for (int l = 0; l < n; l++) {
                        if(continent[k][l]==mergeContinent)
                            continent[k][l]= continent[i][j];
                    }
                }
            }
        }
    }
}
