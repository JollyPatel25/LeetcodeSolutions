class MyCircularQueue {
    int size = 0;
    int[] cqueue;
    int front = -1;
    int rear = -1;

    public MyCircularQueue(int k) {
        size = k;
        cqueue = new int[k];
    }
    
    public boolean enQueue(int value) {
        if (isFull()) return false;
        if (isEmpty()) front = 0;
        rear = (rear + 1) % size;
        cqueue[rear] = value;
        return true;
    }
    
    public boolean deQueue() {
        if (isEmpty()) return false;

        if (front == rear) 
        {
            front = -1;
            rear = -1;
        }
        else
            front = (front + 1) % size;

        return true;
    }
    
    public int Front() {
        if(isEmpty()) return -1;
        return cqueue[front];
    }
    public int Rear() {
        if(isEmpty()) return -1;
        return cqueue[rear];
    }
    
    public boolean isEmpty() {
        if(front == -1) return true;
        return false;
    }
    
    public boolean isFull() {
        return ((rear + 1) % size) == front;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
