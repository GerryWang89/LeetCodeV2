public class Solution {
    private int[] x;
    private int n;
    private ArrayList<String[]> ret;
    public ArrayList<String[]> solveNQueens(int n) {
        this.n = n;
        this.x = new int[n];
        ret = new ArrayList<String[]>();
        if(n == 1){
            ret.add(new String[]{"Q"});
        	return ret;
        }
        solve(0);
        return ret;
    }
    public void solve(int num){
        if(num >= n){
        	String[] temp = new String[n];
        	for(int i = 0; i < n; i++){
        		String row = "";
        		for(int j = 0; j < temp.length; j++){
        			if( j == x[i]){
        				row += "Q";
        			}else{
        				row += ".";
        			}
        		}
        		temp[i] = row;
        	}
            ret.add(temp);
            return;
        }
        for(int i = 0; i < n; i++){
        	if(isValid(num,i)){
        		x[num] = i;
        		solve(num+1);
        	}
        }
    }
    private boolean isValid(int num,int line){
    	for(int i = 0; i < num; i++){
    		if(Math.abs(line-x[i]) == Math.abs(num-i) || x[i] == line){
    			return false;
    		}
    	}
    	return true;
    }
}