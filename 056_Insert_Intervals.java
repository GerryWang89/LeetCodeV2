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
    public ArrayList<Interval> insert(ArrayList<Interval> intervals,
    		Interval newInterval) {
		if (newInterval == null) {
			return intervals;
		}
		if (intervals.size() == 0) {
			intervals.add(newInterval);
			return intervals;
		}
		int left = -1, right = -1;
		for (int i = 0; i < intervals.size(); i++) {
			if (intervals.get(i).end >= newInterval.start && left == -1) {
				left = i;
			}
			if (newInterval.end >= intervals.get(i).start) {
				right = i;
			}
		}
		if (left == -1) {
			intervals.add(newInterval);
			return intervals;
		}
		if (left > right) {
			intervals.add(left, newInterval);
			return intervals;
		}
		int newStart = Integer.MAX_VALUE, newEnd = Integer.MIN_VALUE;
		for (int i = left; i <= right; i++) {
			if (intervals.get(i).start < newStart)
				newStart = intervals.get(i).start;
			if (intervals.get(i).end > newEnd)
				newEnd = intervals.get(i).end;
		}
		newStart = Math.min(newStart, newInterval.start);
		newEnd = Math.max(newEnd, newInterval.end);
		Interval temp = new Interval(newStart, newEnd);
		for (int i = right; i >= left; i--) {
			intervals.remove(i);
		}
		intervals.add(left, temp);
		return intervals;
	}
}