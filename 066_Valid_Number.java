public class Solution {
    public boolean isNumber(String s) {
        s = s.trim();
        if (s.length() == 0)
            return false;
        if (s.charAt(s.length() - 1) < 'z' && s.charAt(s.length() - 1) > 'A')
            return false;
        try{
            Double.parseDouble(s);
            return true;
        }catch(Exception e){
            return false;
        }
    }
}