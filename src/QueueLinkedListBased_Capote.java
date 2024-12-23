public class QueueLinkedListBased_Capote {
    
    private Employee head, tail;
    private int size;

    public QueueLinkedListBased_Capote() {

        clear();
    }

    public void offer(Employee emp) {

        if(head == null) {
            
            head = emp;
            tail = emp;
        }

        else {

            tail.setNext(emp);
            emp.setPrevious(tail);
            tail = emp;
        }

        size++;
    }


    public Employee poll() {

        Employee emp;

        if(size == 1) {

            emp = head;
            clear();
            return emp;
        }

        else {

            emp = head;
            head.getNext().setPrevious(null);
            head = head.getNext();
            head.setPrevious(null);
            size--;
            return emp;
        }
    }

    public boolean isEmpty() {

        if(head == null) return true;
        else return false;
    }

    public Employee peek() {

        return head;
    }

    public boolean contains(Employee emp) {

        Employee nav1 = head;
        Employee nav2 = tail;

        while (nav1 != nav2) {

            if(nav1.equals(emp)) return true;
            if(nav2.equals(emp)) return true;
            nav1 = nav1.getNext();
            nav2 = nav2.getPrevious();
        }

        if(nav1.equals(emp)) return true;

        return false;
    }

    public void clear() {

        head = null;
        tail = null;
        size = 0;
    }

    @Override
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
    public Employee getHead() {return head;}
}