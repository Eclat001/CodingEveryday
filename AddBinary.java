package facebook;

public class AddBinary {
	//时间复杂度是O(max(m,n))，m和n分别是两个字符串的长度，空间复杂度是结果的长度O(max(m,n))
    //String存储形式是数组的，所以插入第一个元素每次复杂度都是线性的，也就是1+2+3+...+n=O(n^2)。如果每次append最后则是O(1)的操作，最后reverse一次是O(n)的，所以总体是O(n)的，比第一种方案好
    public String addBinary(String a, String b) {
        if (a == null || a.length() == 0) {
            return b;
        }
        if (b == null || b.length() == 0) {
            return a;
        }
        int i = a.length() - 1, j = b.length() - 1, carry = 0;
        StringBuilder sb = new StringBuilder();
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (i >= 0) {
                sum += a.charAt(i--) - '0';
            }
            if (j >= 0) {
                sum += b.charAt(j--) - '0';
            }
            sb.append(sum % 2);
            carry = sum / 2;
        }
        if (carry != 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
    public static void main(String[] args) {
    	String a = "11";
    	String b = "1";
    	AddBinary ab = new AddBinary();
    	System.out.println(ab.addBinary(a, b));
    }
}
