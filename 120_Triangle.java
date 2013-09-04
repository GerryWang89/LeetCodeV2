public class Solution {
    private ArrayList<ArrayList<Integer>> triangle;
    private int[][] v;
    
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        this.triangle = triangle;
        v = new int[triangle.size()][triangle.size()];
        return getMin(0,0);
    }
    
    public int getMin(int level, int index){
        if(level == triangle.size()-1){
            return triangle.get(level).get(index);
        }
        if(v[level+1][index] == 0)
            v[level+1][index] = getMin(level+1,index);
        if(v[level+1][index+1] == 0)
            v[level+1][index+1] = getMin(level+1,index+1);
        return triangle.get(level).get(index)+Math.min(v[level+1][index],v[level+1][index+1]);
    }
}