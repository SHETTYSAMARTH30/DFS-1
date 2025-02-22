// Time Complexity : O(m * n)
// Space Complexity : O(m * n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
class Solution {
    public int[][] updateMatrix(int[][] mat) {

        //we need to find distance of nearest 0, so instead of starting from 1 we can start breath first search from 0 and keep traversing level wise where each level == distance
        int m = mat.length;
        int n = mat[0].length;

        Queue<int[]> q = new LinkedList<>();

        //find all the 0's , if there is 1 mark it as -1 because we can later mark them as dist=1 when visited
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {

                if(mat[i][j] == 0) {
                    q.add(new int[]{i, j});
                }
                else {
                    mat[i][j] = -1;
                }
            }
        }

        //we will check all 4 directions
        int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        
        //now we will perform BFS on the queue
        int dist = 1;
        while(!q.isEmpty()) {

            int len = q.size();

            //we will perform bfs level by level
            for(int i = 0; i < len; i++) {

                int curr[] = q.poll();
                int r = curr[0];
                int c = curr[1];
                
                for(int[] d: dirs) {

                    int nr = r + d[0];
                    int nc = c + d[1];

                    //if a cell is -1 mark it with its level
                    if(nr >= 0 && nr < m && nc >= 0 && nc < n && mat[nr][nc] == -1) {

                        mat[nr][nc] = dist;
                        q.add(new int[]{nr, nc});
                }
            }

        }
        
        dist++;
    }

    return mat;
}
}