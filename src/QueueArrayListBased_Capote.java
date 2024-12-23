public class QueueArrayListBased_Capote {

    private Employee employeeList[];
    private int size;

    public QueueArrayListBased_Capote() {

        clear();
    }

    public void offer(Employee emp) {

        if(employeeList[employeeList.length-1] != null) expandList();

        employeeList[size] = emp;
        size++;
    }

    public Employee poll() {

        Employee emp = employeeList[0];
        employeeList[0] = null;
        size--;
        listArrange();
        return emp;
    }

    public void clear() {

        employeeList = new Employee[100];
        size = 0;
    }

    public boolean isEmpty() {

        if(employeeList[0] == null) return true;
        return false;
    }

    public Employee peek() {

        return employeeList[0];
    }

    public boolean contains(Employee emp) {

        for(Employee employee : employeeList) {

            if(employee != null && emp.equals(employee)) return true;
        }

        return false;
    }

    public void expandList() { // use to expand the list whenever it gets full

        Employee [] tempList = new Employee[employeeList.length + 50];

        for (int i = 0 ; i < employeeList.length ; i++) {

            tempList[i] = employeeList[i];
        }

        employeeList = tempList.clone();
    }

    public void listArrange() {

        for (int i = 0 ; i < size ; i++) {

            employeeList[i] = employeeList[i+1];
        }

        employeeList[size] = null;
    }

    public int getSize() {return size;}
    public Employee [] getList() {return employeeList;}

    @Override
    public String toString() {

        String employees = "";

        for (Employee emp : employeeList) {

            if (emp != null) {

                employees += emp.toString() + "\n\n";
            }
        }

        return employees;
    }
}