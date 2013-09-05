public class Solution {
    private int max;
    
    public int longestConsecutive(int[] num) {
        max = Integer.MIN_VALUE;
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i : num) {
            set.add(i);
        }
        for (int i = 0; i < num.length && !set.isEmpty(); i++) {
            if (set.contains(num[i])) {
                int left = num[i] - 1, right = num[i] + 1;
                while (left >= Integer.MIN_VALUE && set.contains(left)){
                    set.remove(left);
                    left--;
                }
                while (right <= Integer.MAX_VALUE && set.contains(right)){
                    set.remove(right);
                    right++;
                }
                set.remove(num[i]);
                max = Math.max(right - left - 1, max);
            }
        }
        return max;
    }
}