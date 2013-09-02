public class Solution {
    public int largestRectangleArea(int[] height) {
        Stack<HeightHolder> stack = new Stack<HeightHolder>();
        int max = 0;
        stack.push(new HeightHolder(-1, -1));
        for (int i = 0; i < height.length; i++) {
            while (height[i] < stack.peek().height) {
                max = Math.max(max, stack.pop().height * (i - stack.peek().index - 1));
            }
            stack.push(new HeightHolder(height[i], i));
        }
        while (stack.size() > 1) {
            max = Math.max(max, stack.pop().height * (height.length - stack.peek().index - 1));
        }
        return max;
    }
    
    class HeightHolder{
        public int height;
        public int index;
        
        public HeightHolder(int height, int index){
            this.height = height;
            this.index = index;
        }
    }
}