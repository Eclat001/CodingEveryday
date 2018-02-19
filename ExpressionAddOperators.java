package facebook;

import java.util.ArrayList;
import java.util.List;

public class ExpressionAddOperators {
	//overflow: we use a long type once it is larger than Integer.MAX_VALUE or minimum, we get over it.
    //0 sequence: because we can’t have numbers with multiple digits started with zero, we have to deal with it too.
    //a little trick is that we should save the value that is to be multiplied in the next recursion.
    public List<String> addOperators(String num, int target) {
        List<String> rst = new ArrayList<>();
        if (num == null || num.length() == 0) return rst;
        help(num, target, rst, "", 0, 0, 0);
        return rst;
    }
    
    private void help(String num, int target, List<String> rst, String path, int pos, long sum, long pre) {
        if (pos == num.length()) {
            if (sum == target) {
                rst.add(path);
            }
            return;
        }
        for (int i = pos; i < num.length(); i++) {
            if (i != pos && num.charAt(pos) == '0') break;
            long cur = Long.parseLong(num.substring(pos, i + 1));
            if (pos == 0) {
                help(num, target, rst, path + cur, i + 1, cur, cur);
            } else {
                help(num, target, rst, path + "+" + cur, i + 1, sum + cur, cur);
                help(num, target, rst, path + "-" + cur, i + 1, sum - cur, -cur);
                help(num, target, rst, path + "*" + cur, i + 1, sum - pre + pre * cur, pre * cur);
            }
        }
    }
    
    public static void main(String[] args) {
    	String num = "232";
    	int target = 8;
    	ExpressionAddOperators ea = new ExpressionAddOperators();
    	System.out.println(ea.addOperators(num, target));
    }
}
