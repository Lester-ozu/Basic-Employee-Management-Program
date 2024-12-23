public class ArrayList_Capote {

    final int ARRAY_SIZE = 100;
    Employee employeeList[];
    int size;

    public ArrayList_Capote() {

        employeeList = new Employee[ARRAY_SIZE];
        size = 0;
    }

    public boolean addItem (Employee E) { 

        if (employeeList[employeeList.length-1] != null)
            expandList();

        employeeList[size] = E;
        size++;
        return true;
    }

    public boolean addItem (int num, Employee E) { // adding a new employee to the list with a specific index

        if (employeeList[employeeList.length-1] != null) {

            expandList();
        }

        if (employeeList[num] != null) {
            
            for (int j = size ; j > num ; j--)
                employeeList[j] = employeeList[j-1];

            employeeList[num] = E;
            size++;
            return true;
        }

        return false;
    }

    public Employee searchByIndex(int num) { // search an employee to a list through index number

        if (employeeList[num] != null) {

            return employeeList[num];
        }

        return null;
    }

    public Employee searchByID(String id) { // traverse the list to find an employee based on employee ID

        for (Employee E : employeeList) {

            if(E!=null && E.getID().equals(id)) {

                return E;
            }
        }

        return null;
    }

    public void remove() { // remove the latest employee in the list

        employeeList[size-1] = null;
        size--;
    }

    public boolean removeByIndex(int index) { // remove a specified employee in the list based on index number

        if (employeeList[index] != null) {

            employeeList[index] = null;
            listArrange();
            size--;
            return true;
        }
        
        return false;
    }

    public boolean removeByID(String id) { //traverse the list to find and remove an employee from the list based on employee ID

        for (int i = 0 ; i < size ; i++) {

            if (employeeList[i] != null && employeeList[i].getID().equals(id)) {

                employeeList[i] = null;
                listArrange();
                size--;
                return true;
            }
        }

        return false;
    }

    public Employee next(Employee employee) { // returns the next employee in the list of a specified employee

        for (int i = 0 ; i < size ; i++) {

            if (employeeList[i].equals(employee)) {

                if (i == size-1) {

                    return null;
                }

                else {

                    return employeeList[i+1];
                }
            }
        }

        return null;
    }

    public Employee previous(Employee employee) { // returns the previous employee in the list of a specified employee

        for (int i = 0 ; i < size ; i++) {

            if (employeeList[i].equals(employee)) {

                if (i == 0) {

                    return null;
                }

                else {

                    return employeeList[i-1];
                }
            }
        }

        return null;
    }

    public String toString() { // returns information of the list

        String str = "";

        for (Employee E : employeeList) {

            if (E != null)
                str += E.toString() + "\n\n";
        }

        return str;
    }

    public boolean update(Employee employee, String name, String position, byte age, String ID) { // update the information of a specified employee

        for (int i = 0 ; i < employeeList.length ; i++) {

            if (employeeList[i] != null && employeeList[i] == employee) {

                employeeList[i].setName(name);
                employeeList[i].setID(ID);
                employeeList[i].setAge(age);
                employeeList[i].setPosition(position);
                return true;
            }
        }

        return false;
    }

    public void listArrange() { // use to re arrange the list whenever an employee object is remove

        for (int i = 0 ; i < size ; i++) {

            if (employeeList[i] == null) {

                for (int j = i ; j < size ; j++) {

                    employeeList[j] = employeeList[j+1];
                }
            }
        }
    }

    public void expandList() { // use to expand the list whenever it gets full

        Employee [] tempList = new Employee[employeeList.length + 50];

        for (int i = 0 ; i < employeeList.length ; i++) {

            tempList[i] = employeeList[i];
        }

        employeeList = tempList.clone();
    }

    public boolean isEmpty() {

        if (employeeList[0] == null) return true;

        return false;
    }

    public int getSize() {return this.size;}
    public Employee [] getList () {return employeeList;}
}
