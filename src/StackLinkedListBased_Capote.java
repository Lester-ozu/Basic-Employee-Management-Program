public class StackLinkedListBased_Capote {

    private Employee head, tail;
    private int size;

    public StackLinkedListBased_Capote() {

        empty();
    }

    public void push(Employee emp) {

        if (tail == null) {

            tail = emp;
            head = emp;
        }

        else {

            tail.setNext(emp);
            emp.setPrevious(tail);
            tail = emp;
        }

        size++;
    }

    public Employee pop() {

        Employee emp;

        if (size == 1) {

            emp = head;
            empty();
        }

        else {

            emp = tail;
            tail.getPrevious().setNext(null);
            tail = tail.getPrevious();
            tail.setNext(null);
            size--;
        }

        return emp;
    }

    public void empty() {

        head = null;
        tail = null;
        this.size = 0;
    }

    public boolean isEmpty() {

        if(head == null) return true;
        return false;
    }

    public Employee peek() {

        return tail;
    }

    public int search(Employee emp) {

        int x = 0, y = size-1;
        Employee nav1 = head;
        Employee nav2 = tail;

        while (nav1 != nav2) {

            if(nav1.equals(emp)) return x;
            if(nav2.equals(emp)) return y;
            nav1 = nav1.getNext();
            nav2 = nav2.getPrevious();
            x++;
            y--;
        }

        if(nav1.equals(emp)) return x;

        return -1;
    }

    public String toString() {

        String employees = "";

        Employee nav1 = head;

        while (nav1 != null) {

            employees += nav1.toString() + "\n\n";
            nav1 = nav1.getNext();
        }

        return employees;
    }

    public int getSize() {return size;}
    public Employee getTail () {return tail;}
    public Employee getHead () {return head;}
}