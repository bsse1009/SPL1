package com.viterbi;

public class Viterbi_Algorithm {
	 public static int[] compute(int obs[], int states[], double start_p[], double trans_p[][], double emission_p[][]) {
	        double[][] viterbi = new double[obs.length][states.length];
	        int[][] path = new int[states.length][obs.length];

	        System.out.println("\nPrinting the observation list:-");
	        for (int i = 0; i < obs.length; i++)
	            System.out.print(obs[i] + " ");
	        System.out.println();
	        
	        //int k = obs [0] - 1;
	        //System.out.println(k);
	        //initializing the viterbi matrix and the path matrix
	        
	        for (int state = 0; state < states.length; state++) {
	            viterbi[0][state] = start_p[state] * emission_p[state][obs[0] - 1];
	            path[state][0] = state;
	        }

	        for (int i = 1; i < obs.length; i++) {
	            int[][] newpath = new int[states.length][obs.length];

	            for (int curr_state = 0; curr_state < states.length; curr_state++) {
	                double prob = -1.0;
	                int state;
	                for (int from_state = 0; from_state < states.length; from_state++) {
	                    double nprob = viterbi[i - 1][from_state] * trans_p[from_state][curr_state] * emission_p[curr_state][obs[i] - 1];
	                    if (nprob > prob) { //reassign only if greater
	                        prob = nprob;
	                        state = from_state;
	                        viterbi[i][curr_state] = prob;
	                        System.arraycopy(path[state], 0, newpath[curr_state], 0, i);
	                        newpath[curr_state][i] = curr_state;
	                    }
	                }
	            }

	            path = newpath;
	        }

	        //Uncomment below code part to see the status of the viterbi matrix
	        /*
	        for (int i = 0; i < obs.length; i++) {
	            for (int j = 0; j < states.length; j++)
	                System.out.print(viterbi[i][j] + " ");
	            System.out.println();
	        }
	        */

	        double prob = -1;
	        int state = 0;
	        //computing the final path
	        for (int state1 = 0; state1 < states.length; state1++) {
	            if (viterbi[obs.length - 1][state1] > prob) {
	                prob = viterbi[obs.length - 1][state1];
	                state = state1;
	            }
	        }

	        return path[state];
	    }

	    public static void main(String[] args) {
	        int obs[] = {3, 3, 1, 1, 2, 2, 3, 1, 3};
	        int states[] = {0, 1, 2, 3}; //0 - start; 1 - hot; 2 - cold; 3 - end;
	        double start_p[] = {1, 1, 1, 1};
	        double trans_p[][] = {
	                {0, 0.8, 0.2, 0},
	                {0, 0.6, 0.3, 0.1},
	                {0, 0.4, 0.5, 0.1},
	                {0, 0, 0, 0}
	        };
	        double emit_p[][] = {
	                {0, 0, 0},
	                {0.2, 0.4, 0.4},
	                {0.5, 0.4, 0.1},
	                {0, 0, 0}
	        };

	        int path_result[] = compute(obs, states, start_p, trans_p, emit_p);
	        System.out.println("Resultant path of first observation:-");
	        for (int path = 0; path < path_result.length; path++) {
	            if (path == 1) System.out.print("hot ");
	            else System.out.print("cold ");
	        }
	        System.out.println();

	        int obs2[] = {3, 3, 1, 1, 2, 3, 3, 1, 2};
	        path_result = compute(obs2, states, start_p, trans_p, emit_p);
	        System.out.println("Resultant path of second observation:-");
	        for (int path = 0; path < path_result.length; path++) {
	            if (path == 1) System.out.print("hot ");
	            else System.out.print("cold ");
	        }
	     
	}
}
