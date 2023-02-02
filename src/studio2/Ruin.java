package studio2;

import java.util.Scanner;

public class Ruin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner in = new Scanner(System.in);
		System.out.println("enter starting amount");
		double startAmount = in.nextDouble();
		System.out.println("enter win chance");
		double winChance = in.nextDouble();
		System.out.println("enter win limit");
		double winLimit = in.nextDouble();
		System.out.println( "How many total simulations?");
		int totalSimulations = in.nextInt(); 
		double totalLosses = 0 ; 
		double a = (1 - winChance) / winChance ; 
		
		
		for (int simulations = 1 ; simulations <= totalSimulations;  simulations++) {
			double amount = startAmount;
			int round = 0 ; 
			
			while(amount > 0 && amount < winLimit)
			{
				if (Math.random() < winChance) {
					amount++ ; 
				}
				else {
					amount-- ; 
				}
				round ++;
			}
			if (amount >= winLimit) {
				System.out.println("Simulation " + simulations + ": " + round + " WIN");
			}
			else {
				System.out.println("Simulation " + simulations + ": " + round + " LOSE");
				totalLosses++;
			}
		}
		double ruinRate = 0;
		
		if (winChance == 0.5) {
			ruinRate = (1-(startAmount/winLimit));
		}
		else {
			ruinRate = ((Math.pow(a, startAmount) - Math.pow(a, winLimit)) / (1- (Math.pow(a, winLimit))));
		}
		System.out.println( "Losses: " + totalLosses + " Simulations: " + totalSimulations);
		System.out.println("Ruin Rate from Simulation: " + (totalLosses/totalSimulations) + " Expected Ruin Rate: " + ruinRate);
	}

}
