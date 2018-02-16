package facebook;

public class Decode {
	//Time O(n) Space O(1) -- 空间上每次只需要前两位的历史信息，所以只需要维护三个变量然后迭代赋值就可以了
    //(1)00,30,40...:res[i]=0(2)10, 20：res[i]=res[i-2](3)01-09, 27-99：res[i]=res[i-1](4)11-19, 21-26：res[i]=res[i-1]+res[i-2]
    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }
        int num1 = 1, num2 = 1, num3 = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                if (s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2') {
                    num3 = num1;
                } else {
                    return 0;
                }
            } else {
                if (s.charAt(i - 1) == '0' || s.charAt(i - 1) >= '3'|| (s.charAt(i - 1) == '2' && s.charAt(i) >= '7')) {
                    num3 = num2;
                } else {
                    num3 = num2 + num1;
                }
            }
            num1 = num2;
            num2 = num3;
        }
        return num3;
    }
    
    public static void main(String[] args) {
    	String c = "12";
    	Decode d = new Decode();
    	System.out.println(d.numDecodings(c));
    }
}
