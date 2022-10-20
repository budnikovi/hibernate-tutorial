package practice_activity;

import org.hibernate.Session;

import java.util.List;

public class QueryEmployeeObject {
    public static List<Employee> queryEmployeeObject(Session session) {
        return session.createQuery("from Employee e where e.company = 'Microsoft'").getResultList();
    }
}
