public class Solution {
	List<String> letters;
	String digits;
    public List<String> letterCombinations(String digits) {
    	this.digits = digits;
        letters = new ArrayList<String>();

        if(this.digits.length() == 0)
        	return letters;

        combineLetters(0, "");

        return letters;  
    }

    public void combineLetters(int no, String str) {

		if(no == this.digits.length()) {
    		this.letters.add(str);
    		return;
    	} 

    	char c = this.digits.charAt(no);
    	List<Character> letters = getLetter(c);

    	for(int i=0; i<letters.size(); i++) {
    		String temp = str + letters.get(i);
    		combineLetters(no+1, temp);
    	}
    	
    } 

    public List<Character> getLetter(char digit) {

		List<Character> letters = new ArrayList<Character>();
		
		switch(digit) {
		case '2': letters.add('a');letters.add('b');letters.add('c');break;
		case '3': letters.add('d');letters.add('e');letters.add('f');break;
		case '4': letters.add('g');letters.add('h');letters.add('i');break;
		case '5': letters.add('j');letters.add('k');letters.add('l');break;
		case '6': letters.add('m');letters.add('n');letters.add('o');break;
		case '7': letters.add('p');letters.add('q');letters.add('r');letters.add('s');break;
		case '8': letters.add('t');letters.add('u');letters.add('v');break;
		case '9': letters.add('w');letters.add('x');letters.add('y');letters.add('z');break;
		}

		return letters;
	}
}


