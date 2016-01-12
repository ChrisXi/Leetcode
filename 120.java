public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
 		int size = triangle.size();

 		for(int l = 0; l<size-1; l++) {

 			int n1 = triangle.get(l).get(0);
 			int n2 = triangle.get(l+1).get(0);

 			triangle.get(l+1).set(0, n1+n2);

 			for(int i=0; i<triangle.get(l).size()-1; i++) {

 				int pre = triangle.get(l).get(i);
 				int next = triangle.get(l).get(i+1)
 				n1 = pre<next ? pre:next;
 				n2 = triangle.get(l+1).get(i+1);

 				triangle.get(l+1).set(i+1, n1+n2);

 			}

 			int l1 = triangle.get(l).size();
 			int l2 = triangle.get(l+1).size();

 			n1 = triangle.get(l).get(l1-1);
 			n2 = triangle.get(l+1).get(l2-1);

 			triangle.get(l+1).set(l2-1, n1+n2);

 		}    

 		int min = triangle.get(size-1).get(0);
 		for(int i=1; i<triangle.get(size-1).size(); i++) {
 			min = min<triangle.get(size-1).get(i) ? min:triangle.get(size-1).get(i);
 		} 

 		return min;  
    }
}