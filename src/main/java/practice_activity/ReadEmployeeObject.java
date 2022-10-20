package practice_activity;

import org.hibernate.Session;

public class ReadEmployeeObject {
    public static Employee readEmployeeObject(Session session, Integer id) {
        return session.get(Employee.class,id);
    }
}
