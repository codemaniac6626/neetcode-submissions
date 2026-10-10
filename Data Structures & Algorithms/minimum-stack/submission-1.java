class MinStack {

    private ArrayList<Integer> stack;
    private HashMap<Integer, Integer> stackFreq;
    private ArrayList<Integer> minList;
    private int min;

    public MinStack() {
        stack = new ArrayList();
        minList = new ArrayList<Integer>();
        stackFreq = new HashMap<Integer, Integer>();
        min = 0;
    }
    
    public void push(int val) {

        if(this.stack.size() == 0) 
            this.min = val;
        else if(val < this.min) {
            minList.add(this.min);
            this.min = val;
        }

        this.stack.add(val);
        
        this.stackFreq.putIfAbsent(val, 0);

        this.stackFreq.computeIfPresent(val, (k, v) -> v + 1);
    }
    
    public void pop() {

        if(this.stack.size() == 0) return;

        int popVal = this.stack.getLast();

        if(popVal == this.min && this.stackFreq.get(popVal) == 1 && this.stack.size() > 1) {
            this.min = this.minList.getLast();
            this.minList.removeLast();
        }

        this.stack.removeLast();

        this.stackFreq.computeIfPresent(popVal, (k, v) -> v - 1);
    }
    
    public int top() {
        return this.stack.getLast();
    }
    
    public int getMin() {
        return this.min;
    }
}
