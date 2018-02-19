package facebook;

import java.util.HashMap;

/*order of task cannot change* */
public class TaskScheduleII {
	public int leastInterval2(char[] tasks, int n) {
        if (tasks.length == 0) {
            return 0;
        }
        int time = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < tasks.length; i++) {
            if (map.containsKey(tasks[i])) {
                int pre = map.get(tasks[i]);
                time = Math.max(pre + n + 1, time + 1);
            } else {
                time++;
            }
            map.put(tasks[i], time);
        }
        return time;
    }
}
