public class Solution {
	public String convert(String s, int nRows) {
		if(nRows == 1 || nRows == s.length()){
			return s;
		}
		String ret = "";
		for(int i = 0; i < nRows; i++){
			for(int j = 0; ; j++){
				if(i == 0 || i == nRows-1){
					if(i+2*j*(nRows-1) >= s.length())
						break;
					ret += s.charAt(i+2*j*(nRows-1));
				}else{
					if(i+2*((j+1)/2)*(nRows-1-i)+2*(j/2)*i >= s.length())
						break;
					ret += s.charAt(i+2*((j+1)/2)*(nRows-1-i)+2*(j/2)*i);
				}
			}
		}
		return ret;
	}
}