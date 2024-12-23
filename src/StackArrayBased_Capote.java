public class StackArrayBased_Capote {

    private Employee employeeList[];
    private int size;

    public StackArrayBased_Capote() {

        empty();
    }

    public void push(Employee emp) {

        if(employeeList[employeeList.length-1] != null) {

            expandList();
        }

        employeeList[size] = emp;
        size++;
    }

    public Employee pop() {

        Employee emp = employeeList[size-1];
        employeeList[size-1] = null;
        size--;
        return emp;
    }

    public void empty() {

        employeeList = new Employee[100];
        size = 0;
    }

    public boolean isEmpty() {

        if(employeeList[0] == null) return true;
        else return false;
    }

    public Employee peek() {

        return employeeList[size-1];
    }

    public int search(Employee emp) {

        for (int i = 0 ; i < employeeList.length ; i++) {

            if(employeeList[i].equals(emp)) {

                return i;
            }
        }

        return -1;
    }

    public void expandList() { // use to expand the list whenever it gets full

        Employee [] tempList = new Employee[employeeList.length + 50];

        for (int i = 0 ; i < employeeList.length ; i++) {

            tempList[i] = employeeList[i];
        }

        employeeList = tempList.clone();
    }

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

    public int getSize() {return size;}
    public Employee[] getList() {return employeeList;}
}
