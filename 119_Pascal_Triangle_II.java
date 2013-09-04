public class Solution {
    public ArrayList<Integer> getRow(int rowIndex) {
        ArrayList<Integer> last = new ArrayList<Integer>();
        ArrayList<Integer> cur = new ArrayList<Integer>();
        cur.add(1);
        last = cur;
        for(int i = 0; i < rowIndex; i++){
            cur = new ArrayList<Integer>();
            for(int j = 0; j < last.size()+1; j++){
                if(j == 0 || j == last.size()){
                    cur.add(1);
                }else{
                    cur.add(last.get(j-1)+last.get(j));
                }
            }
            last = cur;
        }
        return cur;
    }
}