/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */

import java.util.Hashtable;

public class Solution {

	Hashtable<Integer, UndirectedGraphNode> table;

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {

    	table = new Hashtable<Integer, UndirectedGraphNode>();

        return  child(node);
    }

    public UndirectedGraphNode child(UndirectedGraphNode n) {

    	if(n == null)
    		return null;

    	if(table.containsKey(n.label)) {
    		return table.get(n.label);
    	}

    	UndirectedGraphNode temp = new UndirectedGraphNode(n.label);
    	table.put(temp.label, temp);

    	for(int i=0; i<n.neighbors.size(); i++) {

    		temp.neighbors.add(child(n.neighbors.get(i)));
    	}

    	

    	return temp;
    }
}


