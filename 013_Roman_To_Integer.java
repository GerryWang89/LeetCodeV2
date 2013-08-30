public class Solution {
    public int romanToInt(String s) {
        if(s.length() == 0)
            return 0;
        if(s.length() == 1){
            return getRomanValue(s.charAt(0));
        }
        int cur = getRomanValue(s.charAt(0)), pre = 0;
        int ret = 0;
        for(int i = 1; i < s.length(); i++){
            pre = cur;
            cur = getRomanValue(s.charAt(i));
            if(cur > pre){
                ret += (cur - pre);
                i++;
                if(i < s.length())
                    cur = getRomanValue(s.charAt(i));
            }else{
                ret += pre;
            }
        }
        if(getRomanValue(s.charAt(s.length() - 1)) <= getRomanValue(s.charAt(s.length() - 2))){
            ret += cur;
        }
        return ret;
    }
    
    public int getRomanValue(char c) {  
        switch(c) {  
            case 'I': return 1;   
            case 'V': return 5;  
            case 'X': return 10;  
            case 'L': return 50;  
            case 'C': return 100;  
            case 'D': return 500;  
            case 'M': return 1000;  
            default: return 0;  
        }  
    }  
}