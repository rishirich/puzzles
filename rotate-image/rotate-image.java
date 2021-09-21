class Solution {
    public void rotate(int[][] matrix) {
        //transpose and then flip
        this.transpose(matrix);
        this.flip(matrix);
    }
    
    private void transpose(int[][] matrix) {
        for(int i=0; i<matrix.length ; i++) {
            for(int j=i; j<matrix.length; j++) {
                if(i!=j) {
                    matrix[i][j] = matrix[i][j] + matrix[j][i];
                    matrix[j][i] = matrix[i][j] - matrix[j][i];
                    matrix[i][j] = matrix[i][j] - matrix[j][i];
                }
            }
        }
    }
    
    private void flip(int[][] matrix) {
        int length = matrix.length;
        for(int i=0; i<length;i++) {
            for(int j=0; j<length/2;j++) {
                matrix[i][j] = matrix[i][j] + matrix[i][length-j-1];
                matrix[i][length-j-1] = matrix[i][j] - matrix[i][length-j-1];
                matrix[i][j] = matrix[i][j] - matrix[i][length-j-1];
            }
        }
    }
}