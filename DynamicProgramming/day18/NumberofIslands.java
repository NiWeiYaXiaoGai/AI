package main.java.ChinaHadoop_AI_Offer.DynamicProgramming.day18;

public class NumberofIslands {
    /**
     *dfs深度优先搜索算法：遍历网格，碰到为1到格子计数，然后dfs碰到为1到格子置为0
     * 时间复杂度O(m*n)
     * 空间复杂度O(m*n)
     */
    public int numIslands(char[][] grid) {
        int count=0;
        //判断二维数组是否为null [] [[]]
        if(grid==null || grid[0]==null || grid[0].length==0)
            return count;
        int row=grid.length;
        int col=grid[0].length;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]=='1'){
                    count++;
                    dfs(i,j,grid,row,col);
                }else{
                    continue;
                }
            }
        }
        return count;
    }

    private void dfs(int x,int y,char[][] grid,int row,int col){
        if(x<0 || x>=row || y<0 || y>=col || grid[x][y]=='0')
            return;
        if(grid[x][y]=='1'){
            grid[x][y]='0';
            dfs(x+1,y,grid,row,col);
            dfs(x-1,y,grid,row,col);
            dfs(x,y+1,grid,row,col);
            dfs(x,y-1,grid,row,col);
        }
    }
}
