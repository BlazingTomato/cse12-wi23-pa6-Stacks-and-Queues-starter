import org.junit.Test;

import static org.junit.Assert.*;

public class CustomTester {
    
    private static void initDeque(MyDeque<Integer> deque, Object[] data, int size,
                          int front, int rear) {
        deque.data = data;
        deque.size = size;
        deque.front = front;
        deque.rear = rear;
    }

    private static void test(MyDeque<Integer> deque, Object[] newData, int newSize, int newFront, int newRear){
        assertArrayEquals(newData, deque.data);
        assertSame(newSize, deque.size);
        assertSame(newFront, deque.front);
        assertSame(newRear, deque.rear);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testDequeConstructor(){
        MyDeque<Integer> deque = new MyDeque<>(-1);
    }

    @Test
    public void testExpandCapacity(){
        //Test 1
        MyDeque<Integer> deque = new MyDeque<>(0);
        Integer[] orig = {};
        Integer[] finalOrdering = new Integer[10];

        initDeque(deque, orig, 0, 0, 0);
        deque.expandCapacity();

        test(deque, finalOrdering, 0, 0, 0);

        //Test 2
        deque = new MyDeque<>(5);
        orig = new Integer[]{1,2,3,4,5};
        finalOrdering = new Integer[]{1,2,3,4,5,null,null,null,null,null};

        initDeque(deque, orig, 5, 0, 4);
        deque.expandCapacity();

        test(deque, finalOrdering, 5, 0, 4);

        //Test 3
        deque = new MyDeque<>(5);
        orig = new Integer[]{6,7,8,4,5};
        finalOrdering = new Integer[]{4,5,6,7,8,null,null,null,null,null};

        initDeque(deque, orig, 5, 3, 2);
        deque.expandCapacity();

        test(deque, finalOrdering, 5, 0, 4);
    }
    
    //{null,null,null,null,null,null,null,null,null,null};}
    @Test
    public void testAddFirst(){
        //Test 1
        MyDeque<Integer> deque = new MyDeque<>(0);
        Integer[] orig = {};
        Integer[] finalOrdering = {1,null,null,null,null,null,null,null,null,null};

        initDeque(deque, orig, 0, 0, 0);
        deque.addFirst(1);

        test(deque, finalOrdering, 1, 0, 0);

        //Test 2
        deque = new MyDeque<>(0);
        orig = new Integer[]{2,3,4,5,6};
        finalOrdering = new Integer[]{2,3,4,5,6,null,null,null,null,1};

        initDeque(deque, orig, 5, 0, 4);
        deque.addFirst(1);

        test(deque, finalOrdering, 6, 9, 4);

        //Test 3
        deque = new MyDeque<>(0);
        orig = new Integer[]{3,4,5,null,2};
        finalOrdering = new Integer[]{3,4,5,1,2};

        initDeque(deque, orig, 4, 4, 2);
        deque.addFirst(1);

        test(deque, finalOrdering, 5, 3, 2);

        //Test 4
        deque = new MyDeque<>(0);
        orig = new Integer[]{5,6,2,3,4};
        finalOrdering = new Integer[]{2,3,4,5,6,null,null,null,null,1};

        initDeque(deque, orig, 5, 2, 1);
        deque.addFirst(1);

        test(deque, finalOrdering, 6, 9, 4);

        //Test 5
        deque = new MyDeque<>(0);
        orig = new Integer[]{2,null,null,null,null};
        finalOrdering = new Integer[]{2,null,null,null,1};

        initDeque(deque, orig, 1, 0, 0);
        deque.addFirst(1);

        test(deque, finalOrdering, 2, 4, 0);

        //Test 6
        deque = new MyDeque<>(0);
        orig = new Integer[]{null,null,null,null,null};
        finalOrdering = new Integer[]{null,null,null,null,1};

        initDeque(deque, orig, 0, 4, 4);
        deque.addFirst(1);

        test(deque, finalOrdering, 1, 4, 4);
    }

    @Test
    public void testAddLast(){
        //Test 1
        MyDeque<Integer> deque = new MyDeque<>(0);
        Integer[] orig = {};
        Integer[] finalOrdering = {1,null,null,null,null,null,null,null,null,null};

        initDeque(deque, orig, 0, 0, 0);
        deque.addLast(1);

        test(deque, finalOrdering, 1, 0, 0);

        //Test 2
        deque = new MyDeque<>(0);
        orig = new Integer[]{1,2,3,4,5};
        finalOrdering = new Integer[]{1,2,3,4,5,6,null,null,null,null};

        initDeque(deque, orig, 5, 0, 4);
        deque.addLast(6);

        test(deque, finalOrdering, 6, 0, 5);

        //Test 3
        deque = new MyDeque<>(0);
        orig = new Integer[]{3,4,5,null,2};
        finalOrdering = new Integer[]{3,4,5,6,2};

        initDeque(deque, orig, 4, 4, 2);
        deque.addLast(6);

        test(deque, finalOrdering, 5, 4, 3);

        //Test 4
        deque = new MyDeque<>(0);
        orig = new Integer[]{4,5,1,2,3};
        finalOrdering = new Integer[]{1,2,3,4,5,6,null,null,null,null};

        initDeque(deque, orig, 5, 2, 1);
        deque.addLast(6);

        test(deque, finalOrdering, 6, 0, 5);

        //Test 5
        deque = new MyDeque<>(0);
        orig = new Integer[]{null,null,null,null,1};
        finalOrdering = new Integer[]{2,null,null,null,1};

        initDeque(deque, orig, 1, 4, 4);
        deque.addLast(2);

        test(deque, finalOrdering, 2, 4, 0);

        //Test 6
        deque = new MyDeque<>(0);
        orig = new Integer[]{null,null,null,null,null};
        finalOrdering = new Integer[]{null,null,null,null,1};

        initDeque(deque, orig, 0, 4, 4);
        deque.addLast(1);

        test(deque, finalOrdering, 1, 4, 4);
    }

    @Test
    public void testremoveFirst(){
        //Test 1
        MyDeque<Integer> deque = new MyDeque<>(0);
        Integer[] orig = {};
        Integer[] finalOrdering = {};

        initDeque(deque, orig, 0, 0, 0);
        Integer value = deque.removeFirst();

        test(deque, finalOrdering, 0, 0, 0);
        assertSame(null, value);

        //Test 2
        deque = new MyDeque<>(0);
        orig = new Integer[]{2,3,4,5,6};
        finalOrdering = new Integer[]{null,3,4,5,6};

        initDeque(deque, orig, 5, 0, 4);
        value = deque.removeFirst();
        
        assertSame(2,value);

        test(deque, finalOrdering, 4, 1, 4);

        //Test 3
        deque = new MyDeque<>(0);
        orig = new Integer[]{3,4,5,null,2};
        finalOrdering = new Integer[]{3,4,5,null,null};

        initDeque(deque, orig, 4, 4, 2);
        value = deque.removeFirst();
        
        assertSame(2,value);

        test(deque, finalOrdering, 3, 0, 2);

        //Test 4
        deque = new MyDeque<>(0);
        orig = new Integer[]{5,6,2,3,4};
        finalOrdering = new Integer[]{5,6,null,3,4};

        initDeque(deque, orig, 5, 2, 1);
        value = deque.removeFirst();
        
        assertSame(2,value);

        test(deque, finalOrdering, 4, 3, 1);

        //Test 5
        deque = new MyDeque<>(0);
        orig = new Integer[]{2,null,null,null,null};
        finalOrdering = new Integer[]{null,null,null,null,null};

        initDeque(deque, orig, 1, 0, 0);
        value = deque.removeFirst();
        
        assertSame(2,value);

        test(deque, finalOrdering, 0, 0, 0);

        //Test 6
        deque = new MyDeque<>(0);
        orig = new Integer[]{null,null,null,null,null};
        finalOrdering = new Integer[]{null,null,null,null,null};

        initDeque(deque, orig, 0, 4, 4);
        value = deque.removeFirst();
        
        assertSame(null,value);

        test(deque, finalOrdering, 0, 4, 4);
    }

    @Test (expected = NullPointerException.class)
    public void testInvalidAddFirst(){
        //Test 1
        MyDeque<Integer> deque = new MyDeque<>(0);
        Integer[] orig = {};
        Integer[] finalOrdering = {};

        initDeque(deque, orig, 0, 0, 0);
        deque.addFirst(null);

        test(deque, finalOrdering, 0, 0, 0);
    }

    @Test (expected = NullPointerException.class)
    public void testInvalidAddLast(){
        //Test 1
        MyDeque<Integer> deque = new MyDeque<>(0);
        Integer[] orig = {};
        Integer[] finalOrdering = {};

        initDeque(deque, orig, 0, 0, 0);
        deque.addLast(null);

        test(deque, finalOrdering, 0, 0, 0);
    }

    @Test
    public void testRemoveLast(){
        //Test 1
        MyDeque<Integer> deque = new MyDeque<>(0);
        Integer[] orig = {};
        Integer[] finalOrdering = {};

        initDeque(deque, orig, 0, 0, 0);
        Integer value = deque.removeLast();

        assertSame(null, value);

        test(deque, finalOrdering, 0, 0, 0);

        //Test 2
        deque = new MyDeque<>(0);
        orig = new Integer[]{1,2,3,4,5};
        finalOrdering = new Integer[]{1,2,3,4,null};

        initDeque(deque, orig, 5, 0, 4);
        value = deque.removeLast();

        assertSame(5, value);

        test(deque, finalOrdering, 4, 0, 3);

        //Test 3
        deque = new MyDeque<>(0);
        orig = new Integer[]{3,4,5,null,2};
        finalOrdering = new Integer[]{3,4,null,null,2};

        initDeque(deque, orig, 4, 4, 2);
        value = deque.removeLast();

        assertSame(5, value);

        test(deque, finalOrdering, 3, 4, 1);

        //Test 4
        deque = new MyDeque<>(0);
        orig = new Integer[]{4,5,1,2,3};
        finalOrdering = new Integer[]{4,null,1,2,3};

        initDeque(deque, orig, 5, 2, 1);
        value = deque.removeLast();

        assertSame(5, value);

        test(deque, finalOrdering, 4, 2, 0);

        //Test 5
        deque = new MyDeque<>(0);
        orig = new Integer[]{null,null,null,null,1};
        finalOrdering = new Integer[]{null,null,null,null,null};

        initDeque(deque, orig, 1, 4, 4);
        value = deque.removeLast();

        assertSame(1, value);

        test(deque, finalOrdering, 0, 4, 4);

        //Test 6
        deque = new MyDeque<>(0);
        orig = new Integer[]{null,null,null,null,null};
        finalOrdering = new Integer[]{null,null,null,null,null};

        initDeque(deque, orig, 0, 4, 4);
        value = deque.removeLast();

        assertSame(null, value);

        test(deque, finalOrdering, 0, 4, 4);
    }

    @Test
    public void testMyStack(){
        
    }

    @Test
    public void testMyQueue(){
        
    }

}
