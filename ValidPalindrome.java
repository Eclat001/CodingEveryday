package facebook;

public class ValidPalindrome {
	public boolean isPalindrome(String s) {
        if (s == null || s.length() <= 1) return true;
        
        int l = 0;
        int r = s.length() - 1;
        while (l < r) {
            while (l < r && !isValid(s.charAt(l))) l++;
            while (l < r && !isValid(s.charAt(r))) r--;
            if (l < r && !isSame(s.charAt(l), s.charAt(r))) return false;
            l++;
            r--;
        }
        return true;
    }
    
    private boolean isValid(char c) {
        return ((c >= '0' && c <= '9') || (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'));
    }
    
    private boolean isSame(char a, char b) {
        if (a >= 'a' && a <= 'z') a = (char)(a - 'a' + 'A');
        if (b >= 'a' && b <= 'z') b = (char)(b - 'a' + 'A');
        return a == b;
    }
    
    public static void main(String[] args) {
    	String s1 = "A man, a plan, a canal: Panama";
    	String s2 = "race a car";
    	ValidPalindrome vp = new ValidPalindrome();
    	System.out.println(vp.isPalindrome(s1));
    	System.out.println(vp.isPalindrome(s2));
    }
}
