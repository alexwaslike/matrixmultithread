/*
 * Name: Willis, Alexandra
 * Project: PA-1a (Multithreading)
 * File: MainThread.java
 * Instructor: Feng Chen
 * Class: cs4103-au14
 * LogonID: cs410334
 */

package matrixthread;

public class MainThread {

	public static void main(String[] args) {
		
		// initialize A(mxk), B(kxn), & product C(mxn)
		int[][] A = new int[2][3];
		A[0][0] = 1;
		A[0][1] = 2;
		A[0][2] = 3;
		A[1][0] = 4;
		A[1][1] = 5;
		A[1][2] = 6;
		System.out.println("A: ");
		for(int i=0; i<A.length; i++){
			for(int j=0; j<A[0].length; j++){
				System.out.print(A[i][j] + ", ");
			}
			System.out.print("\n");
		}
		
		int[][] B = new int[3][2];
		B[0][0] = 8;
		B[0][1] = 5;
		B[1][0] = 7;
		B[1][1] = 4;
		B[2][0] = 6;
		B[2][1] = 3;
		System.out.println("\nB: ");
		for(int i=0; i<B.length; i++){
			for(int j=0; j<B[0].length; j++){
				System.out.print(B[i][j] + ", ");
			}
			System.out.print("\n");
		}
		
		int[][] C = new int[A.length][B[0].length];
		
		// create m*n worker threads
		Thread[][] workers = new Thread[A.length][B[0].length];
		
		for(int i=0; i<workers[0].length; i++){
			// create and start new WorkerThreads for each ith row and jth column
			for(int j=0; j<workers.length; j++){
				workers[i][j] =   new Thread( new WorkerThread(i,j,A,B,C) );
				workers[i][j].start();
			}
		}
		
		// wait for all worker threads to complete
		for (int i=0; i<workers.length; i++) {
			
			for(int j=0; j<workers[i].length; j++){
				try {
					workers[i][j].join();
				} catch (InterruptedException ie) { }
			}
		}
		
		System.out.println("\nA*B = C :");
		// output C
		for (int i=0; i<C.length; i++) {
			
			for(int j=0; j<C[i].length; j++){
				System.out.print(C[i][j] + ", ");
			}
			System.out.print("\n");
		}

	}

}
