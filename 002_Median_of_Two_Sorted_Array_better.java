public class Solution {
    public double findMedianSortedArrays(int A[], int B[]) {
		int mid = (A.length + B.length) / 2;
		if ((A.length + B.length) % 2 == 1)
			return solve(A, 0, A.length - 1, B, 0, B.length - 1, mid + 1);
		else{
			double num1 = solve(A, 0, A.length - 1, B, 0, B.length - 1, mid);
			double num2 = solve(A, 0, A.length - 1, B, 0, B.length - 1, mid + 1);
			return 0.5 * (num1 + num2);
		}
	}

	private double solve(int[] A, int leftA, int rightA, int[] B, int leftB,
			int rightB, int k) {
		if (rightA - leftA > rightB - leftB)
			return solve(B, leftB, rightB, A, leftA, rightA, k);
		if (leftA > rightA)
			return B[leftB + k - 1];
		if (k == 1)
			return Math.min(A[leftA], B[leftB]);
		int pa = Math.min(k / 2, A.length - leftA), pb = k - pa;
		if (A[leftA + pa - 1] < B[leftB + pb - 1])
			return solve(A, leftA + pa, rightA, B, leftB, leftB + pb - 1, k - pa);
		else if (A[leftA + pa - 1] > B[leftB + pb - 1])
			return solve(A, leftA, leftA + pa - 1, B, leftB + pb, rightB, k - pb);
		else
			return A[leftA + pa - 1];
	}
}