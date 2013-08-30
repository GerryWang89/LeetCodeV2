public class Solution {
    private ArrayList<ArrayList<Integer>> ret;

    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
		Arrays.sort(num);
		ret = new ArrayList<ArrayList<Integer>>();
		if (num.length < 4) {
			return ret;
		}
		deal(num, 0, target, 4, new ArrayList<Integer>());
		return ret;
	}

	private void deal(int[] num, int index, int target, int count,
			ArrayList<Integer> cur) {
		if (count == 0) {
			if (target == 0)
				ret.add(new ArrayList<Integer>(cur));
			return;
		}
		if (target < count * num[index] || count * num[num.length - 1] < target) {
			return;
		}
		for (int i = index; i <= num.length - count && num[i] * count <= target; i++) {
			cur.add(num[i]);
			deal(num, i + 1, target - num[i], count - 1, cur);
			cur.remove(cur.size() - 1);
			while (i + 1 < num.length && num[i] == num[i + 1]) {
				i++;
			}
		}
	}
}