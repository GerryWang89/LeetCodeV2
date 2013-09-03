public class Solution {
    private int[][][] v;
    String s1,s2,s3;
    
    
    public boolean isInterleave(String s1, String s2, String s3) {
        v = new int[s1.length()+1][s2.length()+1][s3.length()+1];
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
        return isInter(0,0,0) >= 0;
    }
    
    private int isInter(int i1, int i2, int i3){
        if(s1.length() == i1){
            if (s2.substring(i2).equals(s3.substring(i3)))
                return 1;
            else
                return -1;
        }
        if(s2.length() == i2){
            if (s1.substring(i1).equals(s3.substring(i3)))
                return 1;
            else
                return -1;
        }
        int match1 = -1, match2 = -1;
        if(s3.charAt(i3) == s1.charAt(i1)){
            if(v[i1+1][i2][i3+1] == 0)
                v[i1+1][i2][i3+1] = isInter(i1+1,i2,i3+1);
            match1 = v[i1+1][i2][i3+1];
        }
        if(s3.charAt(i3) == s2.charAt(i2)){
            if(v[i1][i2+1][i3+1] == 0)
                v[i1][i2+1][i3+1] = isInter(i1,i2+1,i3+1);
            match2 = v[i1][i2+1][i3+1];
        }
        if(match1 + match2 >= 0){
            return 1;
        }else{
            return -1;
        }
    }
}