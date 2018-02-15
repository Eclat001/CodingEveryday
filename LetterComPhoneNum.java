package facebook;

import java.util.LinkedList;
import java.util.List;

public class LetterComPhoneNum {
	//假设总共有n个digit，每个digit可以代表k个字符，那么时间复杂度是O(k^n)，就是结果的数量，空间复杂度也是一样
    public List<String> letterCombinations(String digits) {
        LinkedList<String> rst = new LinkedList<>();
        if (digits.isEmpty()) {
            return rst;
        }
        rst.add("");
        String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        
        for (int i = 0; i < digits.length(); i++) {
            int c = Character.getNumericValue(digits.charAt(i));
            while (rst.peek().length() == i) {
                String t = rst.remove();
                for (char s : mapping[c].toCharArray()) {
                    rst.add(t + s);
                }
            }
        }
        return rst;
    }
    public static void main(String[] args) {
    	String digits = "23";
    	LetterComPhoneNum lc = new LetterComPhoneNum();
    	System.out.println(lc.letterCombinations(digits));
    }
}
