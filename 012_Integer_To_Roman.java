public class Solution {  
    public String intToRoman(int number) {  
        int[] v = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };  
        String[] s = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };  
        String result = "";  
        for (int i = 0; i < v.length; i++) {  
            while (number >= v[i]) {  
                number -= v[i];  
                result += s[i];  
            }  
        }  
        return result;  
    }  
}  