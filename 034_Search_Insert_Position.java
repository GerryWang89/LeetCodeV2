public class solution{
	public int searchInsert(int[] A, int target) {
		if (target < A[0])
			return 0;
		if (target > A[A.length - 1])
			return A.length;
		return search(A, 0, A.length - 1, target);
	}

	public int search(int[] A, int s, int e, int target) {
		if (s == e) {
			if (target == A[s])
				return s;
			else if (target > A[s])
				return s + 1;
			else
				return s;
		}
		if (A[(s + e) / 2] == target) {
			return (s + e) / 2;
		} else if (A[(s + e) / 2] > target) {
			return search(A, s, (s + e) / 2, target);
		} else {
			return search(A, (s + e) / 2 + 1, e, target);
		}
	}
}