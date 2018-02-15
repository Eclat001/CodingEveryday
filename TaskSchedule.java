package facebook;

import java.util.Arrays;

public class TaskSchedule {
	//(c[25] - 1) * (n + 1) + 25 - i is frame size
    //Time O(n) Space O(26) -- O(1)
    public int leastInterval(char[] tasks, int n) {
        int[] c = new int[26];
        for (char t : tasks) {
            c[t - 'A']++;
        }
        Arrays.sort(c);
        int i = 25;
        while (i >= 0 && c[25] == c[i]) {
            i--;
        }
        return Math.max(tasks.length, (c[25] - 1) * (n + 1) + 25 - i);
    }
    
    public static void main(String[] args) {
    	char[] tasks = {'A', 'A', 'C', 'C', 'C', 'B', 'E', 'E', 'E'};
    	int n = 2;
    	TaskSchedule ts = new TaskSchedule();
    	System.out.println(ts.leastInterval(tasks, n));
    }
}
