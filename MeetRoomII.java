package facebook;

import java.util.Arrays;

import structure.Interval;

/* Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), 
 * find the minimum number of conference rooms required.
 * For example, Given [[0, 30],[5, 10],[15, 20]], return 2.
 * */

public class MeetRoomII {
	//always check first-end room, if one start after the end time, then can be added to the room, the check the followings
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            start[i] = intervals[i].start;
            end[i] = intervals[i].end;
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int rooms = 0;
        int endTime = 0;
        for (int i = 0; i < start.length; i++) {
            if (start[i] < end[endTime]) {
                rooms++;
            }
            else {
                endTime++;
            }
        }
        return rooms;
    }
    public static void main(String[] args) {
    	Interval i1 = new Interval(0, 30);
    	Interval i2 = new Interval(5, 10);
    	Interval i3 = new Interval(15, 20);
       	Interval[] intervals = new Interval[3];
       	intervals[0] = i1;
       	intervals[1] = i2;
       	intervals[2] = i3;
    	MeetRoomII mr = new MeetRoomII();
    	System.out.println(mr.minMeetingRooms(intervals));
    }
}
