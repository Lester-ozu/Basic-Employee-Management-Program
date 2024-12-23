public class Employee {
    
    private String name, position;
    private byte age;
    private String id;
    private Employee next, previous;


    public Employee() {

        this.name = "";
        this.position = "";
        this.age = 0;
        this.id = "";
        this.next = null;
        this.previous = null;
    }

    public Employee(String name, String position, byte age, String id) {

        this.name = name;
        this.position = position;
        this.age = age;
        this.id = id;
        this.next = null;
        this.previous = null;
    }

    public Employee(String name, String position, byte age, String id, Employee N, Employee P) {

        this.name = name;
        this.position = position;
        this.age = age;
        this.id = id;
        this.next = N;
        this.previous = P;
    }

    public Employee(Employee copy, Employee N, Employee P) {

        this.name = copy.name;
        this.position = copy.position;
        this.age = copy.age;
        this.id = copy.id;
        this.next = N;
        this.previous = P;
    }

    // Setters
    public void setName(String name) {this.name = name;}
    public void setPosition(String position) {this.position = position;}
    public void setAge(byte age) {this.age = age;}
    public void setID (String id) {this.id = id;}
    public void setNext(Employee N) {this.next = N;}
    public void setPrevious (Employee P) {this.previous = P;}

    //getters
    public String getName() {return this.name;}
    public String getPosition() {return this.position;}
    public byte getAge() {return this.age;}
    public String getID() {return this.id;}
    public Employee getNext() {return this.next;}
    public Employee getPrevious() {return this.previous;}

    public boolean equals(Employee copy) { // compares two employee objects

        if (this.name.equals(copy.name) && this.position.equals(copy.position) && this.age == copy.age && this.id.equals(copy.id))
            return true;
        else
            return false;
    }

    @Override
    public String toString() { // returns all information about the employee

        return "Name: " + this.name + "\n" +
               "Position: " + this.position + "\n" +
               "Age: " + this.age + "\n" +
               "ID: " + this.id;
    }
}
