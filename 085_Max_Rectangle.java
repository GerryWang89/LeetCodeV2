public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0)
            return 0;
        Stack<HeightHolder> stack = new Stack<HeightHolder>();
        stack.push(new HeightHolder(-1, -1));
        int[] height = new int[matrix[0].length];
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                height[j] = matrix[i][j] == '1' ? height[j] + 1 : 0;
                while (height[j] < stack.peek().height) {
                    max = Math.max(max, stack.pop().height * (j - stack.peek().index - 1));
                }
                stack.push(new HeightHolder(height[j], j));
            }
            while (stack.size() > 1) {
                max = Math.max(max, stack.pop().height * (height.length - stack.peek().index - 1));
            }
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