package facebook;

import java.util.ArrayList;
import java.util.List;

public class RemoveP {
	//we restrict ourself to remove the first ) in a series of concecutive )s to avoid duplicate
    //we need to keep another information: the last removal position
    //What about ‘(‘? What if s = ‘(()(()’ in which we need remove ‘(‘?      The answer is: do the same from right to left.
    //Time O(nk) -- k is how many times recursion are called
    public List<String> removeInvalidParentheses(String s) {
        List<String> rst = new ArrayList<>();
        remove(s, rst, 0, 0, new char[]{'(', ')'});
        return rst;    
    }
    public void remove(String s, List<String> rst, int last_i, int last_j, char[] par) {
        for (int stack = 0, i = last_i; i < s.length(); ++i) {
            if (s.charAt(i) == par[0]) {
                stack++;
            }
            if (s.charAt(i) == par[1]) {
                stack--;
            }
            if (stack >= 0) {
                continue;
            }
            for (int j = last_j; j <= i; ++j) {
                if (s.charAt(j) == par[1] && (j == last_j || s.charAt(j - 1) != par[1])) {
                    remove(s.substring(0, j) + s.substring(j + 1, s.length()), rst, i, j, par);
                }
            }
            return;
        }
        String reversed = new StringBuilder(s).reverse().toString();
        if (par[0] == '(')  {      //finished left to right
            remove(reversed, rst, 0, 0, new char[]{')', '('});
        }   
        else {    //finished right to left
            rst.add(reversed);
        }
            
    }
    public static void main(String[] args) {
    	String s1 = "()())()";
    	String s2 = "(a)())()";
    	String s3 = ")(";
    	RemoveP rp = new RemoveP();
    	System.out.println(rp.removeInvalidParentheses(s1));
    	System.out.println(rp.removeInvalidParentheses(s2));
    	System.out.println(rp.removeInvalidParentheses(s3));
    }
}
