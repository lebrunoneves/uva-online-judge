import java.util.*;

public class Main {

    public static void main(String[] args) {
        new Main().solveProblem();
    }

    public void solveProblem() {
        Scanner scan = new Scanner(System.in);
        boolean isFirst = true;

        int tests = scan.nextInt();
        while(tests-- > 0 ) {

            int m = scan.nextInt();
            int n = scan.nextInt();

            scan.nextLine();

            int[][] maze = new int[m][n];

            for (int i = 0; i < m; i++) {
                String row = scan.nextLine();
                for (int j = 0; j < n; j++) {
                    maze[i][j] = row.charAt(j) == ' ' ? 0 : 1;
                }
            }

            int x = scan.nextInt() - 1;
            int y = scan.nextInt() - 1;
            int orientation = 0; // 0=N, 1=E, 2=S, 3=W

            String commands;

            do {
                commands = scan.nextLine();

                for (char cmd : commands.toCharArray()) {
                    if (cmd == 'R')
                        orientation = (orientation + 1) % 4;
                    else if (cmd == 'L')
                        orientation = (orientation + 3) % 4;
                    else if (cmd == 'F') {
                        if (orientation == 0) {
                            if (maze[x - 1][y] == 0)
                                x -= 1;
                        } else if (orientation == 1) {
                            if (maze[x][y + 1] == 0)
                                y += 1;
                        } else if (orientation == 2) {
                            if (maze[x + 1][y] == 0)
                                x += 1;
                        } else if (orientation == 3) {
                            if (maze[x][y - 1] == 0)
                                y -= 1;
                        }
                    }
                }

            } while (!commands.endsWith("Q"));

            if(isFirst)
                isFirst= false;
            else
                System.out.println();
            System.out.println((x+1) + " " + (y+1) + " " + (orientation==0? 'N' : orientation==1? 'E' : orientation==2? 'S' : 'W'));

        }
    }
}
