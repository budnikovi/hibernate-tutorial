package practice_activity;

import org.hibernate.Session;

public class DeleteEmployeeObject {
    public static int deleteEmployeeObject(Session session, int id){
        return session.createQuery("delete from Employee where id=1").executeUpdate();
    }
}
