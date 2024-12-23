import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ErrorProof {
    
    public static boolean checkName(String text) {

        if(text.equals("")) return false;

        if(!text.trim().matches("^[a-zA-Z ]+$")) 
            return true;
        
        return false;
    }

    public static boolean checkPosition(String text) {

        if(text.equals("")) return false;

        if(!text.trim().matches("^[a-zA-Z0-9 ]+$"))
            return true;

        return false;
    }

    public static boolean checkAge(String text) {

        if(text.equals("")) return false;

        if (!text.trim().matches("\\d+"))
            return true;

        return false;
    }

    public static boolean checkID(String text) {

        if(text.equals("")) return false;

        if (!text.trim().matches("\\d+"))
            return true;

        return false;
    }

    public static boolean checkIndex(String text) {

        if(text.equals("")) return false;

        if (!text.trim().matches("\\d+"))
            return true;

        return false;
    }

    public static boolean isSameID(Employee [] list, String text) {

        if(text.equals("")) return false;

        for (Employee employee : list)
            if (employee != null && employee.getID().equals(text))
                return true;

        return false;
    }

    public static boolean isSameID(ArrayList<Employee> list, String text) {

        if(text.equals("")) return false;

        for (Employee employee : list)
            if (employee != null && employee.getID().equals(text))
                return true;

        return false;
    }

    public static boolean isSameID(LinkedList<Employee> list, String text) {

        if(text.equals("")) return false;

        for (Employee employee : list)
            if (employee != null && employee.getID().equals(text))
                return true;

        return false;
    }

    public static boolean isSameID(Stack<Employee> list, String text) {

        if(text.equals("")) return false;

        for (Employee employee : list)
            if (employee != null && employee.getID().equals(text))
                return true;

        return false;
    }

    public static boolean isSameID(Queue<Employee> list, String text) {

        if(text.equals("")) return false;

        for (Employee employee : list)
            if (employee != null && employee.getID().equals(text))
                return true;

        return false;
    }

    public static boolean isSameID(Employee emp, Employee [] list, String text) {

        if(text.equals("")) return false;

        for (Employee employee : list) {

            if (employee != null) {
                if(employee.equals(emp))
                    continue;

                else if (employee != null && employee.getID().equals(text))
                    return true;
            }
        }

        return false;
    }

    public static boolean isSameID(Employee head, String text) {

        if(text.equals("")) return false;

        while(head != null) {

            if(head.getID().equals(text)) {

                return true;
            }
            head = head.getNext();
        }

        return false;
    }

    public static boolean isSameID(Employee emp, Employee head, String text) {

        if(text.equals("")) return false;

        while(head != null) {

            if(emp.equals(head)) {

                head = head.getNext();
                continue;
            }

            if(head.getID().equals(text)) {

                return true;
            }
            head = head.getNext();
        }

        return false;
    }
}
