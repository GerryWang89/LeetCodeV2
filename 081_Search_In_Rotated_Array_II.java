public class Solution {
    public boolean search(int[] A, int target) {
        int left = 0, right = A.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (A[mid] == target)
                return true;
            if (A[mid] < target) {
                if (A[mid] < A[left] && A[right] >= target) {
                    left = mid + 1;
                } else if (A[mid] < A[left] && A[right] < target) {
                    right = mid - 1;
                } else if (A[mid] > A[left]){
                    left = mid + 1;
                } else {
                    for(int i = left; i <= right; i++){
                        if(A[i] == target)
                            return true;
                    }
                    return false;
                }
            } else {
                if (A[mid] < A[left]) {
                    right = mid - 1;
                } else if (A[mid] > A[left] && A[left] <= target) {
                    right = mid - 1;
                } else if (A[mid] > A[left] && A[left] > target) {
                    left = mid + 1;
                } else {
                    for(int i = left; i <= right; i++){
                        if(A[i] == target)
                            return true;
                    }
                    return false;
                }
            }
        }
        return false;
    }
}