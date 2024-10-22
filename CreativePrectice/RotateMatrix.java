public class RotateMatrix {
    public static void main(String[] args) {
        int[][] arr = {{1,2,3}, {5,0,7}, {9,10,11},{13, 14, 0}};
        RotateMatrix rm = new RotateMatrix();
        rm.zeroMatrix(arr);
        // rm.rotateMatrix(arr);
        for (int row = 0; row < arr.length; row++){
            for (int col =0; col < arr[row].length; col++){
                System.out.print(arr[row][col] + " ");
            }
            System.out.println();
        }
    }
    int[][]rotateMatrix(int[][] arr){
        int count = 0;
        for (int row = 0; row < arr.length; row ++){
            for (int col = arr[row].length-1; col >= 0; col--){
                int temp = arr[col][row];
                arr[row][count] = temp;
                count ++;
            }
            count = 0;
        }
        return arr;
    }

    int[][] zeroMatrix(int[][] arr){
        boolean[] row = new boolean[arr.length];
        boolean[] col = new boolean[arr[0].length];

        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr[i].length; j++){
                if (arr[i][j] == 0){
                    row[i] = true;
                    col[j] = true;
                }
            }
        }

        for (int i = 0; i < row.length; i++){
            for (int j = 0; j < arr[i].length; j++){
                if (row[i]){
                    arr[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < col.length; i++){
            for (int j = 0; j < arr[i].length; j++){
                if (col[i]){
                    arr[j][i] = 0;
                }
            }
        }
        return arr;
    }

}
