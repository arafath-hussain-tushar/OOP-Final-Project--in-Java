package SupershopManagementSystem;

import java.util.ArrayList;

public class SuperShop {
    String name;
    ArrayList<Employee> employeeArrayList;

    public SuperShop(String name){
        this.name = name;
        employeeArrayList = new ArrayList<>();
    }
    public void AddEmployee(Employee employee){
        employeeArrayList.add(employee);
        System.out.println(employee.getName() + " added successfully!");
    }
    public void RemoveEmployee(int id){
        Employee employeeToRemove = null;
        for(Employee e: employeeArrayList){
            if(e.id == id){
                employeeToRemove = e;
                break;
            }
        }
        if(employeeToRemove != null){
            employeeArrayList.remove(employeeToRemove);
            System.out.println(employeeToRemove.getName() + " removed successfully!");
        }
    }
    public void viewEmployee(){
        System.out.println("~----Employee List----~");
        System.out.println("+-----+-----------------+--------------------------+----------------+---------------+------+-----------------+----------+");
        System.out.println("| id  | name            | email                    | address        | phone         | age  | designation     | salary   |");
        System.out.println("+-----+-----------------+--------------------------+----------------+---------------+------+-----------------+----------+");

        for(Employee e: employeeArrayList){
            System.out.printf("| %-3s | %-15s | %-24s | %-14s | %-13s | %-4s | %-15s | %-8s |\n", e.id, e.getName(), e.getEmail(), e.getAddress(), e.getPhone(), e.age, e.designation, e.salary);
            System.out.println("+-----+-----------------+--------------------------+----------------+---------------+------+-----------------+----------+");
        }
    }
}
