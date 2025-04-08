class MyQueue {
    int input[], output[], top1 = -1, top2 = -1;
    public MyQueue() {
        input = new int[100];
        output = new int[100];
    }
    public void push(int x) {
        input[++top1] = x;
    }
    public int pop() {
        if(top2 == -1)
            for(int i = top1; i >= 0; i--)
                output[++top2] = input[top1--];
        return output[top2--];
    }
    public int peek() {
        if(top2 == -1)
            for(int i = top1; i >= 0; i--)
                output[++top2] = input[top1--];
        return output[top2];
    }
    public boolean empty() {
        if(top1 == -1 && top2 == -1)
            return true;
        return false;
    }
}