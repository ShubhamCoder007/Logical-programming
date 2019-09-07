import java.util.ArrayList;
import java.util.LinkedList;

public class SparseMat {

	private int rows;
	private int cols;
	LinkedList<Integer>[] list;
	
	public SparseMat() {
		this(0,0);
	}
	
	public SparseMat(int rows, int cols) {
		this.rows = rows;
		this.cols = cols;
		//rows correspond to the number of array
		list = new LinkedList[rows];
		for(int i = 0; i < rows; i++)
			list[i] = new LinkedList<>();
	}
	
	public static SparseMat getSparseMatrix(int[][] mat) {
		SparseMat ob = new SparseMat(mat.length, mat[0].length);
		//only those index of the row are added in the linked list which has data other than 1
		for(int i = 0; i < mat.length; i++) {
			for(int j = 0; j < mat[0].length; j++) {
				if(mat[i][j] == 1)
					ob.list[i].add(j);
			}
		}
		
		return ob;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][] mat = {
				{1,0,0,0},
				{0,1,0,1},
				{0,0,1,0},
				{0,0,0,1}
				};
		
		printMatrix(mat);
		
		SparseMat m = getSparseMatrix(mat);
		
		m.printSparseMatrix();
		
	}

	private void printSparseMatrix() {
		System.out.println("\nDisplaying sparse matrix: ");
		int[][] mat = new int[rows][cols];
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++)
				mat[i][j] = 0;
		}
		
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				if(list[i].size() > 0) {
					for(Integer k : list[i])
						mat[i][k] = 1;
				}
			}
		}
		printMatrix(mat);
	}

	private static void printMatrix(int[][] mat) {
		System.out.println("\nDisplaying matrix: ");
		for(int i = 0; i < mat.length; i++) {
			for(int j = 0; j < mat[0].length; j++)
				System.out.print(mat[i][j]+" ");
			System.out.println();
		}
	}

}
