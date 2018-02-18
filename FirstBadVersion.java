package facebook;

/* The isBadVersion API is defined in the parent class VersionControl.
boolean isBadVersion(int version); */

/*
public class Solution extends VersionControl {
	//Time O(logn)
	public int firstBadVersion(int n) {
	  int l = 1;
	  int r = n;
	  while (l + 1 < r) {
	      int m = l + (r - l) / 2;
	      if (isBadVersion(m)) {
	          r = m;
	      } else {
	          l = m;
	      }
	  }
	  if (isBadVersion(l)) return l;
	  if (isBadVersion(r)) return r;
	  return -1;
	}
}
**/
public class FirstBadVersion {

}
