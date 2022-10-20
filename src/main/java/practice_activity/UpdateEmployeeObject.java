package practice_activity;

import org.hibernate.Session;

public class UpdateEmployeeObject {
    public static int updateEmployeeObject(Session session){
        return session.createQuery("update Employee set company='Microsoft'").executeUpdate();
    }
}
