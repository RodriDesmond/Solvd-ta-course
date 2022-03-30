package Collection;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;

public class HospitalEmployeesLinkedList<E> {


    private static final Logger LOGGER = LogManager.getLogger(HospitalEmployeesLinkedList.class);

    //Value and reference to the next node.
    static class Node<E>{
        Node<E> next;
        private Node <E> previous;
        private E value;

        Node(E value){
            this.value = value;
        }
        public Node <E> getNext() {
            return next;
        }

        public void setNext(Node <E> next) {
            this.next = next;
        }

        public Node <E> getPrevious() {
            return previous;
        }

        public void setPrevious(Node <E> previous) {
            this.previous = previous;
        }

        public Object getValue() {
            return value;
        }

        public void setValue(E value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value.toString();
        }
    }

    private Node<E> head ;

    private Node<E> tail;

    private int length;

    public HospitalEmployeesLinkedList() {
        length = 0;
    }

    public Marker iterate() {
        if (this.getLength() != 0) {
            Node<E> tmp = head;
            LOGGER.info(tmp.toString());
            while (tmp.getNext() != null) {
                tmp = tmp.getNext();
                LOGGER.info(tmp);
            }
        } else {
            throw new NullPointerException("Can't iterate through an empty list");
        }
        return null;
    }

    /**
     * Inserts the specified element at the beginning of this list.
     *
     * @param val the element to add
     */
    public void addAtFirst(E val){
        Node<E> temp = new Node(val);
        temp.next = head;
        head = temp;

        if(tail == null){
            tail = temp;
        }
    }

    /**
     * Inserts the specified element at the last of this list.
     *
     * @param val the element to add
     */
    public void add(E val){
        if (this.length == 0) {
            head = new Node<E>(val);
            tail = new Node<E>(val);
        } else {
            Node<E> tmp = new Node<E>(val);
            Node<E> actual = head;
            while (actual.getNext() != null) {
                actual = actual.getNext();
            }
            actual.setNext(tmp);
            tmp.setPrevious(actual);
            tail = tmp;
        }
        length++;
    }

    public Node<E> getHead() {
        return head;
    }

    public void setHead(Node<E> head) {
        this.head = head;
    }

    public Node<E> getTail() {
        return tail;
    }

    public void setTail(Node<E> tail) {
        this.tail = tail;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
