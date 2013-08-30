public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0){
            return "";
        }
        String ret = "";
        for(int i = 0; i < strs[0].length(); i++){
            int j = 1;
            for(j = 1; j < strs.length; j++){
                if(i >= strs[j].length() || strs[j].charAt(i) != strs[0].charAt(i)){
                    break;
                }
            }
            if(j != strs.length){
                break; 
            }else{
                ret += strs[0].charAt(i);
            }
        }
        return ret;
    }
}