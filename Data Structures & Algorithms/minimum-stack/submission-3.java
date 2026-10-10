class MinStack {

    private ArrayList<Integer> stack;
    private ArrayList<Integer> minList;

    public MinStack() {
        stack = new ArrayList();
        minList = new ArrayList<Integer>();
    }
    
    public void push(int val) {

        if(this.stack.size() == 0 || val < this.minList.getLast()) 
            this.minList.add(val);
        else 
            this.minList.add(this.minList.getLast());

        this.stack.add(val);
    }
    
    public void pop() {

        if(this.stack.size() == 0) return;

        this.minList.removeLast();
        this.stack.removeLast();
    }
    
    public int top() {
        return this.stack.getLast();
    }
    
    public int getMin() {
        return this.minList.getLast();
    }
}
