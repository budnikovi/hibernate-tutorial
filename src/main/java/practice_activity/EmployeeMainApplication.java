package practice_activity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class EmployeeMainApplication {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();
        try {
            session.beginTransaction();

            // create employee object
            Employee createEmployee = CreateEmployeeObject
                    .createEmployeeObject("John", "Smith", "Apple");
            System.out.println("create " + createEmployee.toString());
            session.save(createEmployee);

            // read employee object
            Employee readEmployee = ReadEmployeeObject
                    .readEmployeeObject(session, createEmployee.getId());
            System.out.println("read " + readEmployee.toString());

            // update employee object
            int updateEmployee = UpdateEmployeeObject
                    .updateEmployeeObject(session);
            System.out.println("update " + updateEmployee);
            System.out.println("object " + readEmployee.toString());

            // query where company = 'Microsoft'
            List<Employee> employees = QueryEmployeeObject
                    .queryEmployeeObject(session);
            employees.forEach(System.out::println);

            //delete employee object
            int deleteEmployee = DeleteEmployeeObject
                    .deleteEmployeeObject(session, readEmployee.getId());
            System.out.println("delete " + deleteEmployee);

            session.getTransaction().commit();
            System.out.println("Done!");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            factory.close();
        }
    }
}
