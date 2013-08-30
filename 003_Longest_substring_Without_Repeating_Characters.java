public class Solution {
    public int lengthOfLongestSubstring(String s) {
        char[] v = new char[30];
        int q = 0;
        int max = 0;
        for(int i = 0; i < s.length(); i++){
            if(v[s.charAt(i) - 'a'] >= 1){
                while(s.charAt(i) != s.charAt(q)){
                    v[s.charAt(q) -'a']--;
                    q++;
                }
                q++;
            }else{
                v[s.charAt(i) - 'a']++;
            }
            if(max < i - q + 1){
                max = i - q + 1;
            }
        }
        return max;
    }
}