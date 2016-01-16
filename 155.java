class MinStack {

	Stack<Integer> min = new Stack<Integer>();
	Stack<Integer> num = new Stack<Integer>();

    public void push(int x) {
        
        num.push(x);

        int n = x;

        if(min.size() != 0) {
        	n = getMin()<x ? getMin():x;
        }

        min.push(n);

    }

    public void pop() {
        num.pop();
        min.pop();
    }

    public int top() {
        return num.peek();
    }

    public int getMin() {
       	return min.peek();
    }
}
