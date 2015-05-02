/*
 * Name: Willis, Alexandra
 * Project: PA-1a (Multithreading)
 * File: WorkerThread.java
 * Instructor: Feng Chen
 * Class: cs4103-au14
 * LogonID: cs410334
 */

package matrixthread;

public class WorkerThread implements Runnable{
	
	private int row;
	private int col;
	private int[][] A;
	private int[][] B;
	private int[][] C;
	
	public WorkerThread(int row, int col, int[][] A, int[][] B, int[][] C) {
		this.row = row;
		this.col = col;
		this.A = A;
		this.B = B;
		this.C = C;
	}
	
	public void run() {
		// calculate the matrix product and output in C [row] [col]
		int sum = 0;
		for(int i=0; i<A[0].length; i++){
			sum += A[row][i] * B[i][col];
		}
		
		C[row][col] = sum;
		
	}

}
