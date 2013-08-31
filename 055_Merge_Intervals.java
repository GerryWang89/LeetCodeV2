/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
    	if (intervals.size() < 2)
			return intervals;
		Collections.sort(intervals, new MyComparator());
		ArrayList<Interval> ret = new ArrayList<Interval>();
		ret.add(intervals.get(0));
		for (int i = 1; i < intervals.size(); i++) {
			if (isCross(ret.get(ret.size() - 1), intervals.get(i))) {
				Interval temp = add(ret.get(ret.size() - 1), intervals.get(i));
				ret.remove(ret.size() - 1);
				ret.add(temp);
			} else {
				ret.add(intervals.get(i));
			}
		}
		return ret;
	}

	public boolean isCross(Interval i1, Interval i2) {
		if ((i1.end - i2.start) * (i2.end - i1.start) >= 0) {
			return true;
		} else {
			return false;
		}
	}

	public Interval add(Interval i1, Interval i2) {
		return new Interval(Math.min(i1.start, i2.start), Math.max(i1.end,
				i2.end));
	}

	class MyComparator implements Comparator<Interval> {
		@Override
		public int compare(Interval i1, Interval i2) {
			if (i1.start < i2.start) {
				return -1;
			} else {
				return 1;
			}
		}
	}
}