package studio2;

import java.util.Scanner;

public class Pi {
	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		
		long pi = 0;
		long darts = 0;
		
		while(true) {
			double x = Math.random();
			double y = Math.random();
			darts++;
			
			double distance = Math.sqrt(x*x + y*y);
			if (distance <= 1.0) {
				pi++;
			}
			if (darts % 20000000 == 0) {
				System.out.println(
						String.format("%.15f", 4.0 * pi / darts));
			}

		}

	}
}
