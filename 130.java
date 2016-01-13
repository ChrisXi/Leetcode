public class Solution {

	Queue<Point> q;
    public void solve(char[][] board) {
    	
    	q = new LinkedList<Point>();

    	int lenr = board.length;

    	if(lenr <= 1)
    		return;

    	int lenc = board[0].length;

    	int[][] checkBoard = new int[lenr][lenc];

    	for(int i=0; i<lenc; i++) {
    		if(board[0][i] == 'O') {
    			checkBoard[0][i] = 1;
    			Point p = new Point(0, i);
    			q.offer(p);
    		} else {
    			checkBoard[0][i] = 2;
    		}
    	}

    	for(int i=1; i<lenr; i++) {
    		if(board[i][lenc-1] == 'O') {
    			checkBoard[i][lenc-1] = 1;
    			Point p = new Point(i, lenc-1);
    			q.offer(p);
    		} else {
    			checkBoard[i][lenc-1] = 2;
    		}
    	}

    	for(int i=0; i<lenc-1; i++) {
    		if(board[lenr-1][i] == 'O') {
    			checkBoard[lenr-1][i] = 1;
    			Point p = new Point(lenr-1, i);
    			q.offer(p);
    		} else {
    			checkBoard[lenr-1][i] = 2;
    		}
    	}

    	for(int i=1; i<lenr-1; i++) {
    		if(board[i][0] == 'O') {
    			checkBoard[i][0] = 1;
    			Point p = new Point(i, 0);
    			q.offer(p);
    		} else {
    			checkBoard[i][0] = 2;
    		}
    	}

    	while(!q.isEmpty()) {
    		Point p = q.poll();
    		int r = p.x;
    		int c = p.y;

    		check(lenr, lenc, r-1, c, board, checkBoard);
    		check(lenr, lenc, r, c-1, board, checkBoard);
    		check(lenr, lenc, r, c+1, board, checkBoard);
    		check(lenr, lenc, r+1, c, board, checkBoard);
    	}

    	for(int r=0; r<lenr; r++) {
    		for(int c=0; c<lenc; c++) {
    			if(checkBoard[r][c] == 0) {
    				board[r][c] = 'X';
    			}
    		}
    	}

    }

    public void check(int lenr, int lenc, int r, int c, char[][] board, int[][] check) {
    	if(r<1 || r>=lenr || c<1 || c>=lenc) 
    		return;

    	if(check[r][c] != 0)
    		return;

    	if(board[r][c] != 'O') {
    		check[r][c] = 2;
    		return;
    	}

    	check[r][c] = 1;

    	Point p = new Point(r, c);
		q.offer(p);
    }
}



