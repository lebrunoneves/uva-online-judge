
import java.util.*;

class Main {

	public static void main(String[] args) {
		new Main().solveProblem();
    }

    public void solveProblem() {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();

        while(n != 0) {

        	int maxStreak = 0;
        	int currSequence = 0;

			for (int i = 0; i < n; i++) {
				int bet = scan.nextInt();

				currSequence += bet;

				if(currSequence < 0)
					currSequence = 0;
				else
					maxStreak = Math.max(maxStreak, currSequence);

			}

			if(maxStreak > 0)
				System.out.println("The maximum winning streak is " + maxStreak + ".");
			else
				System.out.println("Losing streak.");

        	n = scan.nextInt();
		}
	}
}
