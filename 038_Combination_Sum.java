private ArrayList<ArrayList<Integer>> ret;
	private ArrayList<Integer> cur;

	public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
		if (candidates == null) {
			return null;
		}
		Arrays.sort(candidates);
		ret = new ArrayList<ArrayList<Integer>>();
		cur = new ArrayList<Integer>();
		find(0, 0, candidates, target);
		return ret;
	}

	private void find(int sum, int index, int[] candidates, int target) {
		if (index >= candidates.length) {
			return;
		}
		cur.add(candidates[index]);
		sum += candidates[index];
		if (sum == target) {
			ArrayList<Integer> ans = new ArrayList<Integer>(cur);
			ret.add(ans);
			cur.remove(cur.size() - 1);
			return;
		}
		if (sum > target) {
			cur.remove(cur.size() - 1);
			return;
		}
		find(sum, index, candidates, target);
		cur.remove(cur.size() - 1);
		sum -= candidates[index];
		find(sum, index + 1, candidates, target);
	}