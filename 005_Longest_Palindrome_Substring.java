//manacher
public class Solution {
    public String longestPalindrome(String s){
    	for(int i = 0; i < s.length(); i+=2){
			s = s.substring(0,i) + "#" + s.substring(i);
		}
		s = s+"#";
		int id = 0;
		int max = 0;
		int[] p = new int[s.length()];
		p[0] = 1;
		for(int i = 1; i < s.length(); i++){
			if(max > i){
				p[i] = Math.min(p[id*2-i],max-i);
			}else{
				p[i] = 1;
			}
			while( i-p[i] >= 0 && i+p[i] < s.length() && s.charAt(i+p[i]) == s.charAt(i-p[i])){
				p[i]++;
			}
			if(p[i] + i - 1 > max){
				max =p[i] + i - 1;
				id = i;
			}
		}
		id = 0; 
		max = 0;
		for(int i = 0; i < p.length; i++){
			if(p[i] > max){
				max = p[i];
				id = i;
			}
		}
		return s.substring(id-p[id]+1,id+p[id]).replace("#","");		
	}
}