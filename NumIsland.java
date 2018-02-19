package facebook;

public class NumIsland {
	//find land, then expand until water, mark all the lands visited.
    //Time O(mn) Space O(logmn)
    private int m;
    private int n;
    
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        m = grid.length;
        n = grid[0].length;
        int rst = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != '1') {
                    continue;
                } else {
                    rst++;
                    dfs(grid, i, j);
                }
            }
        }
        return rst;
    }
    
    private void dfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] != '1') return;
        grid[i][j] = '0';
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }
    
    public static void main(String[] args) {
    	char[][] grid = {{'1', '1', '1', '1', '0'},
    					 {'1', '1', '0', '1', '0'},
    					 {'1', '1', '0', '0', '0'},
    					 {'0', '0', '0', '0', '0'}};
    	NumIsland ni = new NumIsland();
    	System.out.println(ni.numIslands(grid));
    }
}
