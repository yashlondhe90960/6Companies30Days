class Solution {

    void matrixRes(int[][] mat,int[][] res,int row, int col,int n,int m, int k){
 int startRow = row - k, startCol = col - k, endRow = row + k, endCol = col + k;
        if (startRow < 0) {
            startRow = 0;
        }
        if (startCol < 0) {
            startCol = 0;
        }
        if (endRow >= n) {
            endRow = n-1;
        }
        if (endCol >= m) {
            endCol = m-1;
        }

        for (int i = startRow; i <= endRow; i++) {
            for (int j = startCol; j <= endCol; j++) {
                res[row][col]+=mat[i][j];
            }
        }
    }
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int[][] res=new int[mat.length][mat[0].length];

        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                matrixRes(mat,res,i,j,mat.length,mat[0].length,k);
            }
        }
        return res;
    }
}