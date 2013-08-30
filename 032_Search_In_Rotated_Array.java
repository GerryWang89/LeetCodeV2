public class Solution {
    public int search(int[] A, int target) {
        int left = 0, right = A.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (A[mid] == target)
                return mid;
            if (A[mid] < target) {
                if (A[mid] < A[left] && A[right] > target) {
                    left = mid + 1;
                } else if (A[mid] < A[left] && A[right] < target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (A[mid] < A[left]) {
                    right = mid - 1;
                } else if (A[mid] > A[left] && A[left] < target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }
}