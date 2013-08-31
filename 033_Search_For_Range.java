public class Solution {
    public int[] searchRange(int[] A, int target) {
		return solve(A, target, 0, A.length - 1);
    }
	
	public int[] solve(int[] A, int target, int left, int right){
		int[] ret = new int[2];
		if (left > right)	
			return new int[]{-1, -1};
		int mid = (left + right) / 2;
		if (A[mid] > target) {
			return solve(A,target,left,mid - 1);
		} else if (A[mid] < target) {
			return solve(A,target,mid + 1,right);
		} else {
			if (left == right) 
				return new int[]{left, right};
			int[] ans1 = solve(A,target,left,mid - 1);
			int[] ans2 = solve(A,target,mid + 1,right);
			ret[0] = ans1[0] == -1 ? mid : ans1[0];
			ret[1] = ans2[0] == -1 ? mid : ans2[1];
		}
		return ret;
	}
}