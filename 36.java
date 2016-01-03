import java.util.Hashtable;

public class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        for(int i=0; i<3; i++) {
        	for(int j=0; j<3; j++) {

        		Hashtable<Character, Integer> nums = new Hashtable<Character, Integer>();

        		int indexr = i*3;
        		int indexc = j*3;
        		for(int r=0; r<3; r++) {
        			for(int c=0; c<3; c++) {

        				char num = board[indexr+r][indexc+c];

        				if(num == '.')
        					continue;
						
						if(nums.containsKey(num)) {
							return false;
						} else {
							nums.put(num, 1);
						}

	        		}
        		}
        	}
        }

        for(int i=0; i<9; i++) {
        	Hashtable<Character, Integer> nums = new Hashtable<Character, Integer>();

        	for(int j=0; j<9; j++) {
        		char num = board[i][j];
						
				if(num == '.')
					continue;

				if(nums.containsKey(num)) {
					return false;
				} else {
					nums.put(num, 1);
				}
        	}
        }

        for(int j=0; j<9; j++) {
			Hashtable<Character, Integer> nums = new Hashtable<Character, Integer>();

        	for(int i=0; i<9; i++) {
        		char num = board[i][j];
						
				if(num == '.')
					continue;

				if(nums.containsKey(num)) {
					return false;
				} else {
					nums.put(num, 1);
				}
        	}
        }

        return true;
    }
}