import java.util.Hashtable;

public class Solution {
    public String minWindow(String s, String t) {
     
     	Hashtable<Character, Integer> map = new Hashtable<Character, Integer>();
     	Hashtable<Character, Integer> temp = new Hashtable<Character, Integer>();

     	for(int i=0; i<t.length(); i++) {
     		map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0)+1);
     	}

     	int len = s.length();

     	String str = "";
     	for(int i=0; i<len; i++) {
     		if(map.containsKey(i)) {
     			int n1 = map.get(t.charAt(i));
     			int n2 = map.getOrDefault(t.charAt(i), 0);
     		}
     	}   
    }
}