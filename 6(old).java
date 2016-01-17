public class Solution {
    public String convert(String s, int numRows) {
        int numCols = 0;
        int len = s.length();
        if (len == 0) 
            return s;
            
        if (numRows == 1)
            return s;
        else {
            int num = len/(numRows+numRows-2);
            numCols = num*(1+numRows-2);
            int additionCols = len%(numRows+numRows-2)-numRows;
            additionCols = additionCols<=0 ? 1:additionCols+1;
            numCols += additionCols;
        }
        
        char board[] = new char[numRows*numCols];
        
        int row = 0;
        int col = 0;
        for (row=0; row<numRows; row++) {
            for(col=0; col<numCols; col++) {
                board[row*numCols+col] = ' ';
            }
        }
        
        int move = -1; // -1:down 1:up
        row = 0;
        col = 0;
        for (int i=0; i<len; i++) {
            board[row*numCols+col] = s.charAt(i);
            
            if (row == 0 || row == numRows-1) {
                move = -move;
            }
            
            if (move == 1) { //down
                row ++;        
            } else { //up
                row --;
                col ++;
            }
        }
        String str="";
        for (row=0; row<numRows; row++) {
            for(col=0; col<numCols; col++) {
                if (board[row*numCols+col] != ' ')
                    str += board[row*numCols+col];
            }
        }
        return str;
    }
}