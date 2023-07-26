public class Employee {
    private int employeeID;
    private String firstName;
    private String lastName;
    private String position;
    private double salary;
    private String workDepartment;

    public Employee(int employeeID, String firstName, String lastName, String position, double salary, String workDepartment) {
        this.employeeID = employeeID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.salary = salary;
        this.workDepartment = workDepartment;
    }

    public int getEmployeeID() { return employeeID; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getPosition() { return position; }
    public double getSalary() { return salary; }
    public String getWorkDepartment() { return workDepartment; }


    @Override
    public String toString(){
        return "---------------------------------\n" +
                "ID: " + getEmployeeID() + "\n" +
                "First Name: " + getFirstName() + "\n" +
                "Last Name: " + getLastName() + "\n" +
                "Position: " + getPosition() + "\n" +
                "Salary: $" + getSalary() + "\n" +
                "Department: " + getWorkDepartment() + "\n" +
                "---------------------------------\n";
    }
}
