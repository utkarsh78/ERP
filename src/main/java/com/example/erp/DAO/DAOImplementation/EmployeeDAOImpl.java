package com.example.erp.DAO.DAOImplementation;

import com.example.erp.Bean.Employee;
import com.example.erp.DAO.EmployeeDAO;
import com.example.erp.Util.HibernateSessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {

    @Override
    public Employee login(Employee emp) {
        try (Session session = HibernateSessionUtil.getSession();){
            String Employee_email = emp.getEmployee_email();
            String Employee_Password = emp.getEmployee_pass();

            List<Object> result = new ArrayList<Object>(session.createQuery("FROM Employee WHERE employee_email =:Employee_email and employee_pass =:Employee_Password")
                            .setParameter("Employee_email", Employee_email)
                            .setParameter("Employee_Password", Employee_Password)
                            .list()
            );

            // If no valid Employee found, return null so that login failure is understood
            if (result.size() == 0)
                return null;
            else
                return (Employee) result.get(0);
        }
        catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
        }

        return null;
    }

    @Override
    public boolean createEmployee(Employee emp) {
        try (Session session = HibernateSessionUtil.getSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(emp);
            transaction.commit();
            return true;
        }
        catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
            return false;
        }
    }

}
