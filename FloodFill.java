// Time Complexity : O(m * n)
// Space Complexity : O(m * n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        //we will perform depth first search
        int m = image.length;
        int n = image[0].length;

        int orgColor = image[sr][sc];

        //if new color is similar to old color then there is no need to change
        if(orgColor == color)
            return image;
        
        int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        //change orgColor to color
        dfs(image, sr, sc, color, orgColor, dir);
        return image;
    }

    public void dfs(int[][] image, int r, int c, int color, int orgColor, int[][] dir) {

        //check if it is inside boundary
        if(r < 0 || r >= image.length || c < 0 || c >= image[0].length || image[r][c] != orgColor)
            return;
        
        //mark it with new color, so we know it is visited. We avoid visiting twice
        image[r][c] = color;

        //recursively visit all the 4 neighbors
        for(int[] d: dir) {

            int nr = r + d[0];
            int nc = c + d[1];

            dfs(image, nr, nc, color, orgColor, dir);
        }
    }
}