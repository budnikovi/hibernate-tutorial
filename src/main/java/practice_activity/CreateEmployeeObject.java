package practice_activity;

public class CreateEmployeeObject {
    public static Employee createEmployeeObject(String firstName, String lastName, String company) {
        return new Employee(firstName,lastName,company);
    }
}
