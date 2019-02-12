package com.mik;

import java.util.ArrayList;
import java.util.Scanner;

public class MainClass {
		
	public static void main(String[] args) {
		
		int n  = 0;
		int m = 0;
		ArrayList<String> states = new ArrayList <String>();	//** state list
		ArrayList<String> emotions = new ArrayList <String>();	//**  emotions list
		double start_p [] = new double [100];				//** store starting probability of state
		double  trans_p[][] = new double [100][100];		//** store transition table
		double  emit_p[][] = new double [100][100];			//** store emition probability table
		String observData;									//** store users emotion sequence
		int status [] = new int [100];				//** representing state as a integer number accordin
													//   to their list index
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Input number of State : ");
		n= sc.nextInt();
		
		System.out.print("Input number of emossion : ");
		m = sc.nextInt();
		
		//** Input State name and their starting probability 
		
		for (int i = 0; i < n; i++)
		{
			System.out.print("State "+ i + " : ");
			sc.nextLine();
			String state = sc.nextLine();
			states.add(state);
			status [i] = i;
			System.out.print("Starting probability of State "+ i + " : ");
			start_p [i] = sc.nextDouble();
		}
		sc.nextLine();
		
		//** input emoji  name
		
		for (int i = 0; i < m; i++)
		{
			System.out.print("Input emoji " + i +" : ");
			String emo = sc.nextLine();
			emotions.add(emo);
		}
		
		//** input transition probability table
		
		for (int i = 0; i < n; i++)
		{
			for (int j = 0; j < n; j++)
			{
				System.out.print("Transition probability of State "+ states.get(i) +" to State " + states.get(j) +" : ");
				trans_p [i][j] = sc.nextDouble();
				
			}
			
		}
		
		System.out.println();
		
		//** input emision probability table
		
		for (int i = 0; i < n; i++)
		{
			for (int j = 0; j < m; j++)
			{
				System.out.print("emission  probability of State "+ states.get(i) +" to emoji " +emotions.get(j)  +" : ");
				emit_p [i][j] = sc.nextDouble();
			}
			
		}
	
		sc.nextLine();
		
		System.out.print("Input your observe data : ");
		observData = sc.nextLine();
		
		System.out.println();
		
		//**split obserbdate by space separator and push them in observations array
		
		String [] observations = observData.split(" ");
		int c = 0;
		
		int obs [] = new int [observations.length];  //** obs array store the sequence of 
												   //** emoji corresponding the emotions list
		
		for (String i : observations)
		{
			//System.out.println(i);
			
			for (int j = 0; j < m; j++)
			{
				if (i.equals(emotions.get(j)) )
				{
					obs [c] = j;
					c++;
					break;
				}
			}
		}
		
		/*
		for (int k : obs )
			System.out.println(k);
		
		*/
		
		int[] result = Viterbi.compute(obs, status, start_p, trans_p, emit_p);
		
		for (int i : result)
		{
			System.out.print(states.get(i) + " ");
		}
		System.out.println();
	}

}