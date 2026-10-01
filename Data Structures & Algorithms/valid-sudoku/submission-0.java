class Solution {

    static String calcGridQuadrants(int i, int j) {
        StringBuilder quads = new StringBuilder();
        
        int iQuad = i/3;
        int jQuad = j/3;

        quads.append(iQuad);
        quads.append(jQuad);

        return quads.toString();
    }

static boolean isValidSudoku(char[][] board) {

        HashMap<String, Boolean> rowSeen = new HashMap<>();
        HashMap<String, Boolean> columnSeen = new HashMap<>();
        HashMap<String, Boolean> gridSeen = new HashMap<>();

        // Row and Column duplication
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                
                if (rowSeen.get(String.valueOf(board[i][j])) != null) {
                    System.out.println("here");
                    return false;
                }
                if(board[i][j] != '.') 
                    rowSeen.put(String.valueOf(board[i][j]), true);

                if (columnSeen.get(String.valueOf(board[j][i])) != null) {
                    System.out.println(j + " " + i);
                    return false;
                }
                if(board[j][i] != '.') 
                    columnSeen.put(String.valueOf(board[j][i]), true);

                String quads = Solution.calcGridQuadrants(i,j);

                if (gridSeen.get(quads + String.valueOf(board[i][j])) != null) {

                    return false;
                }
                if(board[i][j] != '.') 
                    gridSeen.put(quads + String.valueOf(board[i][j]), true);
            }
            rowSeen.clear();
            columnSeen.clear();
        }

        return true;


    }
}


// ["1","2",".",".","3",".",".",".","."]
// ["4",".",".","5",".",".",".",".","."]
// [".","9","8",".",".",".",".",".","3"]
// ["5",".",".",".","6",".",".",".","4"]
// [".",".",".","8",".","3",".",".","5"]
// ["7",".",".",".","2",".",".",".","6"]
// [".",".",".",".",".",".","2",".","."]
// [".",".",".","4","1","9",".",".","8"]
// [".",".",".",".","8",".",".","7","9"]
