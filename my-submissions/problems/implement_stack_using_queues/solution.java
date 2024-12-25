class MyStack {
    int rear = -1, front1 = -1, temp1 = -1, temp2 = -1, front2 = -1;
    int queue[] = new int[101];
    public MyStack() {
        
    }
    public void push(int x) {
        queue[++rear] = x;
        if(front1 == -1)
        {
            front1 = rear;
            front2 = 0;
        }
        else
        {
            front1++;
        }
    }
    
    public int pop() {
        if(front1 == -1 || front2 == -1)
        {
            return 0;
        }
        if(front1 == front2)
        {
            front2--;
        }
        front1--;
        rear--;
        return queue[front1 + 1];
    }
    
    public int top() {
        return queue[rear];
    }
    
    public boolean empty() {
        if(front1 == -1 || front2 == -1)
        {
            return true;
        }
        return false;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */