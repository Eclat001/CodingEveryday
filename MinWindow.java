package facebook;

import java.util.HashMap;

public class MinWindow {
	//Time O(n) Space O(n)
    public String minWindow(String s, String t) {
        if (s == null || s.length() == 0) return "";
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) map.put(c, map.getOrDefault(c, 0) + 1);
        
        int count = 0;
        int minstart = 0;
        int minlen = s.length() + 1;
        int l = 0;
        for (int r = 0; r < s.length(); r++) {
            if (map.containsKey(s.charAt(r))) {
                map.put(s.charAt(r), map.get(s.charAt(r)) - 1);
                if (map.get(s.charAt(r)) >= 0) count++;
                while (count == t.length()) {
                    if (r - l + 1 < minlen) {
                        minlen = r - l + 1;
                        minstart = l;
                    }
                    if (map.containsKey(s.charAt(l))) {
                        map.put(s.charAt(l), map.get(s.charAt(l)) + 1);
                        if (map.get(s.charAt(l)) > 0) count--;
                    }
                    l++;
                }
            }
        }
        if (minlen > s.length()) return "";
        return s.substring(minstart, minstart + minlen);
    }
    
    public static void main(String[] args) {
    	String S = "ADOBECODEBANC";
    	String T = "ABC";
    	MinWindow mw = new MinWindow();
    	System.out.println(mw.minWindow(S, T));
    }
}
