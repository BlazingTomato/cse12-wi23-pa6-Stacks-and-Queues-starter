public class MyDeque<E> implements DequeInterface<E>{

    Object[] data;
    int size;
    int rear;
    int front;

    public MyDeque(int initialCapacity){
        if(initialCapacity < 0)
            throw new IllegalArgumentException();
        
        size = 0;
        rear = 0;
        front = 0;
        data = new Object[initialCapacity];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void expandCapacity() {
        if(data.length == 0){
            data = new Object[10];
            return;
        }

        Object[] temp = new Object[data.length];

        for(int i = 0; i < temp.length; i++){
            temp[i] = data[i];
        }


        data = new Object[data.length * 2];

        for(int i = 0; i < temp.length; i++){
            if(front + i >= temp.length){
                data[i] = temp[(front + i) % temp.length];
            }else{
                data[i] = temp[front + i];
            }
        } 

        front = 0;
        if(size != 0){rear = size - 1;}else {rear = 0;}
        
    }

    @Override
    public void addFirst(E element) {
        if(element == null)
            throw new NullPointerException();
        
        if(size == data.length){
            expandCapacity();
        }

        if(data[front] == null){
            data[front] = element;
            size++;
            return;
        }

        int index = front - 1;

        if(index < 0){
            data[data.length + index] = element;
            front = data.length + index;
            size++;
            return;
        }

        
        data[index] = element;
        front = index;
        size++;
    }

    @Override
    public void addLast(E element) {
        if(element == null)
            throw new NullPointerException();
        
        if(size == data.length){
            expandCapacity();
        }

        if(data[rear] == null){
            data[rear] = element;
            size++;
            return;
        }

        int index = rear + 1;

        if(index >= data.length){
            data[data.length % index] = element;
            rear = data.length % index;
            size++;
            return;
        }

        
        data[index] = element;
        rear = index;
        size++;
    }

    @Override
    public E removeFirst() {
        if(data.length == 0)
            return null;

        int index = front + 1;
        E temp = (E)data[front];

        if(temp == null)
            return null;
        data[front] = null;


        if(index >= data.length){
            if(data[data.length % index] != null)
                front = data.length % index;
            size--;
            return temp;
        }

        if(data[index] != null)
            front = index;
        size--;
        return temp;
    }

    @Override
    public E removeLast() {
        if(data.length == 0)
            return null;
            
        int index = rear - 1;
        E temp = (E)data[rear];

        if(temp == null)
            return null;

        data[rear] = null;

        if(index < 0){
            if(data[data.length + index] != null)
                rear = data.length + index;
            size--;
            return temp;
        }

        if(data[index] != null)
            rear = index;
        size--;
        return temp;
    }

    @Override
    public E peekFirst() {
        return (E)data[front];
    }

    @Override
    public E peekLast() {
        return (E)data[rear];
    }
}
