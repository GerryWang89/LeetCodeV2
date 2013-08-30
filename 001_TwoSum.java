public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        if (numbers.length < 2) 
            return null;
        ArrayList<IndexHolder> numList = new ArrayList<IndexHolder>();
        for (int i = 0; i < numbers.length; i++) {
            numList.add(new IndexHolder(i,numbers[i]));
        }
        Collections.sort(numList, new MyComparator());
        int i = 0, j = numList.size() - 1;
        while (i < j) {
            if (numList.get(i).val + numList.get(j).val > target) {
                j--;
            } else if (numList.get(i).val + numList.get(j).val < target) {
                i++;
            } else {
                if (numList.get(i).index < numList.get(j).index) {
                    return new int[]{numList.get(i).index, numList.get(j).index};
                } else {
                    return new int[]{numList.get(j).index, numList.get(i).index};
                }
            }
        }
        return null;
    }
    
    class IndexHolder{
        public int index;
        public int val;
        
        public IndexHolder(int index, int val){
            this.index = index + 1;
            this.val = val;
        }
    }
    
    class MyComparator implements Comparator<IndexHolder>{
        @Override
        public int compare(IndexHolder o1, IndexHolder o2){
            if(o1.val < o2.val){
                return -1;
            } else if (o1.val > o2.val) {
                return 1;
            } else {
                return 0;
            }
        }
    }
}