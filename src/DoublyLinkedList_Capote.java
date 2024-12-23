public class DoublyLinkedList_Capote {
    
    private Employee head, tail;
    private int size;

    public DoublyLinkedList_Capote() {

        makeEmpty();
    }

    public int getSize() {

        return size;
    }
    
    public Employee getHead() {

        return head;
    }

    public boolean isEmpty() {

        if(head == null &&  tail == null)
            return true;
            
        return false;
    }

    public void makeEmpty() {

        head = null;
        tail = null;
        this.size = 0;
    }

    public void insertAtTail(Employee E) {

        if(tail == null) {

            tail = E;
            head = E;
        }

        else {
            E.setPrevious(tail);
            tail.setNext(E);
            tail = E;
        }

        size++;
    }

    public void insertAtHead(Employee E) {

        if(head == null) {

            head = E;
            tail = E;
        }

        else {

            E.setNext(head);
            head.setPrevious(E);
            head = E;
        }
        
        size++;
    }

    public Employee findByIndex(int location) {

        if (size > 0 && location < size) {

            int x = 0, y = size-1;
            Employee nav1 = head;
            Employee nav2 = tail;

            while (nav1 != nav2) {

                if(x == location) return nav1;
                if(y == location) return nav2;
                nav1 = nav1.getNext();
                nav2 = nav2.getPrevious();
                x++;
                y--;
            }

            if (x == location) { return nav1;}
            else return null;
        }

        return null;
    }

    public int findByValue(Employee employee) {

        int x = 0, y = size-1;
        Employee nav1 = head, nav2 = tail;
        
        while (y != size/2-1 && x != size/2+1) {

            if (nav1.equals(employee)) return x;
            if (nav2.equals(employee)) return y;

            nav1 = nav1.getNext();
            nav2 = nav2.getPrevious();
            x++;
            y--;
        }

        return -1;
    }

    public boolean insert(Employee employee, int location) {

        if (location < 0 || location > size) return false;

        Employee nav = findByIndex(location);

        if(location == 0) {

            insertAtHead(employee);
            return true;
        }

        else if(size == 1) {

            insertAtTail(employee);
            return true;
        }

        else if (nav != null) {

            employee.setNext(nav);
            employee.setPrevious(nav.getPrevious());
            nav.getPrevious().setNext(employee);
            nav.setPrevious(employee);
            size++;
            return true;
        }

        else if (location == size) {

            employee.setNext(tail);
            employee.setPrevious(tail.getPrevious());
            tail.getPrevious().setNext(employee);
            tail.setPrevious(employee);
            size++;
            return true;
        }

        return false;
    }

    public void insert(Employee employee) {

        insert(employee, size);
    }

    public void delete(int index) {

        if (index < 0 || index > size) return;

        else if (index == 0) {

            deleteFirstRecord();
        }

        else if (index == size-1) {

            deleteLastRecord();
        }

        else {

        Employee temp = findByIndex(index);

        temp.getNext().setPrevious(temp.getPrevious());
        temp.getPrevious().setNext(temp.getNext());
        temp.setNext(null);
        temp.setPrevious(null);
        size--;
        }
    }

    public void delete(Employee employee) {

        int temp = findByValue(employee);

        if (temp != -1) {
            delete(temp);
        }
    }

    public void deleteFirstRecord() {

        if (head != null) {

            if (head == tail) {

                head = null;
                tail = null;
            }

            else {

                head = head.getNext();
                head.setPrevious(null);
            }

            size--;
        }
    }

    public void deleteLastRecord() {

        if (head != null) {

            if (head == tail) {

                head = null;
                tail = null;
            }

            else {

                tail = tail.getPrevious();
                tail.setNext(null);
            }

            size--;
        }
    }

    public boolean update(Employee emp, String name, String position, byte age, String ID) {

        int x = 0, y = size-1;
        Employee nav1 = head, nav2 = tail;
        
        while (y != size/2-1 && x != size/2+1) {

            if (nav1.equals(emp)) {

                nav1.setName(name);
                nav1.setPosition(position);
                nav1.setAge(age);
                nav1.setID(ID);
                return true;
            }

            else if (nav2.equals(emp)) {

                nav2.setName(name);
                nav2.setPosition(position);
                nav2.setAge(age);
                nav2.setID(ID);
                return true;
            }

            nav1 = nav1.getNext();
            nav2 = nav2.getPrevious();
            x++;
            y--;
        }

        return false;
    }

    public Employee searchEmployeeID(String ID) {

        int x = 0, y = size-1;
        Employee nav1 = head, nav2 = tail;

        while (y != size/2-1 && x != size/2+1) {

            if (nav1.getID().equals(ID)) return nav1;
            if (nav2.getID().equals(ID)) return nav2;

            nav1 = nav1.getNext();
            nav2 = nav2.getPrevious();
            x++;
            y--;
        }

        return null;
    }

    public Employee next (Employee employee) {

       return findByIndex(findByValue(employee)).getNext();
    }

    public Employee previous (Employee employee) {

        return findByIndex(findByValue(employee)).getPrevious();
    }

    public String toString() {

        if (size > 0) {

            Employee temp = head;
            String str = "";
            System.out.println();

            while(temp != null) {

                str += "\n" + temp.toString() + "\n";
                temp = temp.getNext();
            }

            return str;
        }

        return "List is Empty";
    }
}
