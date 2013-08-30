public class Solution {
    private ArrayList<String> ret;
    
    public ArrayList<String> letterCombinations(String digits) {
        ret = new ArrayList<String>();
        String[] s = new String[]{" ", "", "abc", "def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        ArrayList<String> dList = new ArrayList<String>();
        for(int i = 0; i < digits.length(); i++){
            dList.add(s[digits.charAt(i) - '0']);
        }
        solve(dList,0,"");
        return ret;
    }
    
    public void solve(ArrayList<String> dList, int index, String cur){
        if (index == dList.size()){
    		ret.add(cur);
			return;
		}
        for (int i = 0; i < dList.get(index).length(); i++) {
            cur += (dList.get(index).charAt(i));
            solve(dList, index + 1, cur);
            cur = cur.substring(0,cur.length() - 1);
        }
    }
}