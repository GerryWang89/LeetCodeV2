public class Solution {
    private ArrayList<ArrayList<Integer>> ret;
    
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        ret = new ArrayList<ArrayList<Integer>>();
        if(numRows == 0)
            return ret;
        ArrayList<Integer> last = new ArrayList<Integer>();
        ArrayList<Integer> cur = new ArrayList<Integer>();
        cur.add(1);
        ret.add(cur);
        last = cur;
        for(int i = 1; i < numRows; i++){
            cur = new ArrayList<Integer>();
            for(int j = 0; j < last.size()+1; j++){
                if(j == 0 || j == last.size()){
                    cur.add(1);
                }else{
                    cur.add(last.get(j-1)+last.get(j));
                }
            }
            ret.add(cur);
            last = cur;
        }
        return ret;
    }
}