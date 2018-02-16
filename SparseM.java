package facebook;
/* Given two sparse matrices A and B, return the result of AB.
 * You may assume that A's column number is equal to B's row number.
 * Example:
A = [
  [ 1, 0, 0],
  [-1, 0, 3]
]
B = [
  [ 7, 0, 0 ],
  [ 0, 0, 0 ],
  [ 0, 0, 1 ]
]
     |  1 0 0 |   | 7 0 0 |   |  7 0 0 |
AB = | -1 0 3 | x | 0 0 0 | = | -7 0 3 |
                  | 0 0 1 |
 * */
public class SparseM {
	public int[][] multiply(int[][] A, int[][] B) {
        int m = A.length;
        int nm = A[0].length;
        int n = B[0].length;
        int[][] C = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int k = 0; k < nm; k++) {
                if (A[i][k] != 0) {
                    for (int j = 0; j < n; j++) {
                        if (B[k][j] != 0) {
                            C[i][j] += A[i][k] * B[k][j];
                        }
                    }
                }
            }
        }
        return C;
    }
	public static void main(String[] args) {
		int[][] A = {{1, 0, 0}, {-1, 0, 3}};
		int[][] B = {{7, 0, 0}, {0, 0, 0}, {0, 0, 1}};
		SparseM sm = new SparseM();
		System.out.println(sm.multiply(A, B));
	}
}
