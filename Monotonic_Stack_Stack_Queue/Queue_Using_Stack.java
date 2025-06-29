class MyQueue {
    Stack<Integer> stack1 = new Stack<>();
     Stack<Integer> stack2 = new Stack<>();
    public MyQueue(){
        this.stack1 = stack1;
        this.stack2 = stack2;
    }    
    // Constructor
    public void push(int x){
     while(!stack1.isEmpty()){
         stack2.push(stack1.pop());
     }   
     stack1.push(x);
     while(!stack2.isEmpty()){
         stack1.push(stack2.pop());
     }   
    }  // Push element to back of queue
    public int pop(){
     return stack1.pop();   
    }         // Remove the element from front
    public int peek(){
        return stack1.peek();
    }        // Get the front element
    public boolean empty(){
        return stack1.isEmpty();
    }     // Returns true if queue is empty
}