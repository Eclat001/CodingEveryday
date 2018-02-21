package facebook;

/* Given two strings S and T, determine if they are both one edit distance apart.
 * */

public class OneEditDistance {
	public boolean isOneEditDistance(String s, String t) {
		for (int i = 0; i < Math.min(s.length(), t.length()); i++) {
			if (s.charAt(i) != t.charAt(i)) {
				return s.substring(i + (s.length() >= t.length() ? 1 : 0)).equals
						(t.substring(i + (s.length() <= t.length() ? 1 : 0)));
			}
		}
		return Math.abs(s.length() - t.length()) == 1;
	}
	
	public static void main(String[] args) {
		String s = "adbc";
		String t1 = "aebc";
		String t2 = "abc";
		String t3 = "addbc";
		String t4 = "adbc";
		OneEditDistance oe = new OneEditDistance();
		System.out.println(oe.isOneEditDistance(s, t1));
		System.out.println(oe.isOneEditDistance(s, t2));
		System.out.println(oe.isOneEditDistance(s, t3));
		System.out.println(oe.isOneEditDistance(s, t4));
	}
}
