package facebook;

public class RegularExp {
	//If p.charAt(j) != '*':  If p.charAt(j) == s.charAt(i) || p.charAt(j) == '.':  dp[i+1][j+1] = dp[i][j];
    /*If p.charAt(j) == '*': 
        if p.charAt(j-1) = '.', ".*" matches every string, if dp[i+1][j-1] or dp[i+1][j] is true, dp[i+1][j+1],dp[i+2][j+1],
        dp[i+3][j+1]...dp[s.length()][j+1] are true;
        if p.charAt(j-1) != '.':
                dp[i+1][j+1] = dp[i+1][j]    // a* counts as a single a
                dp[i+1][j+1] = dp[i][j-1]      // a* counts as empty
                dp[i+1][j+1] = dp[i][j+1] && s[i-1]==s[i] && s[i-1]==p[j-1] (这种情况是相当于i从0到s.length()扫过来，如果p[j+1]对应的字符是‘*’那就意味着接下来的串就可以依次匹配下来，如果下面的字符一直重复，并且就是‘*’前面的那个字符）a* counts as multiple a
    */
    //Time O(n^2) Space O(n^2)
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) return false;      
        if (s.length() == 0 && p.length() == 0) return true;
        if (p.length() == 0) return false;
        
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        
        for (int j = 0; j < p.length(); j++) {
            if (p.charAt(j) == '*') {
                if (j == 0) continue;
                if (j > 0 && dp[0][j - 1]) dp[0][j + 1] = true;
                if (p. charAt(j - 1) != '.') {
                    for (int i = 0; i < s.length(); i++) {
                        if (dp[i + 1][j] || (j > 0 && dp[i + 1][j - 1])
                             || (i > 0 && j > 0 && dp[i][ j + 1] && s.charAt(i - 1) == s.charAt(i) 
                                 && s.charAt(i - 1) == p.charAt(j - 1))) {
                            dp[i + 1][j + 1] = true;
                        }
                    }
                } else {
                    int i = 0;
                    while (j > 0 && i < s.length() && !dp[i + 1][j - 1] && !dp[i + 1][j]) i++;
                    for (; i < s.length(); i++) dp[i + 1][j + 1] = true;
                }
            } else {
                for (int i = 0; i < s.length(); i++) {
                    if ((s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') && dp[i][j]) dp[i + 1][j + 1] = true;
                }
            }
        }
        
        return dp[s.length()][p.length()];
    }
    
    public static void main(String[] args) {
    	String s = "aab";
    	String p = "c*a*b";
    	RegularExp re = new RegularExp();
    	System.out.println(re.isMatch(s, p));
    }
}
