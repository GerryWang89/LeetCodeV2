public class Solution {
    public int threeSumClosest(int[] num, int target) {
        Arrays.sort(num);
        if(num.length < 3)
            return 0;
        int left,right;
        int gap = Math.abs(num[0] + num[1] + num[2] - target);
        int ret = num[0] + num[1] + num[2];
        for(int i = 1; i < num.length - 1; i++){
            left = i - 1;
            right = i + 1;
            while(left >= 0 && right < num.length){
                int sum = num[left] + num[i] + num[right];
                if(sum < target){
                    right++;
                    if(target - sum < gap){
                        gap = target - sum;
                        ret = sum;
                    }
                }else if(sum > target){
                    left--;
                    if(sum - target < gap){
                        gap = sum - target;
                        ret = sum;
                    }
                }else{
                    return target;
                }
            }
        }
        return ret;
    }
}