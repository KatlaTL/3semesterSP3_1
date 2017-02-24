package com.mycompany.classicmodels;

import entity.Customer;
import entity.Employee;
import entity.Office;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class entityFacade {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu", null);
    
    public static void main(String[] args) {
        entityFacade ef = new entityFacade();
        EntityManager em = ef.getManager();
        ef.createEmployee();
        
        Query q1 = em.createQuery("SELECT c FROM Customer c");
        List<Customer> customers = q1.getResultList();
        ef.updateCustomer(customers.get(0));
        
        System.out.println("Antal employees: " + ef.getEmployeCount());
        
        for (Customer customer : ef.getCustomerInCity("Nantes")) {
            System.out.println(customer.getCustomerName()+ ", city: " + customer.getCity());
        }
        
        System.out.println(ef.getEmployeeMaxCustomer());
    }
    
    public Employee createEmployee(){
        Employee empolyee = new Employee(12345, "Hansen", "Bob", "something", "bobhansen@gmail.com", "Murer");
        EntityManager em = getManager();
        
        Office office = em.find(Office.class, "1");
        empolyee.setOffice(office);
        Query q1 = em.createQuery("SELECT e FROM Employee e");
        List<Employee> employees = q1.getResultList();
        int empNr = employees.get(employees.size()-1).getEmployeeNumber() + 1;
        empolyee.setEmployeeNumber(empNr);
        try {
            em.getTransaction().begin();
            em.persist(empolyee);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.clear();
        }
        return empolyee;
    }
    
    public Customer updateCustomer(Customer cust) {
        Customer customer = cust;
        EntityManager em = getManager();
        //int custNr = em.find(Customer.class, cust.getCustomerNumber()).getCustomerNumber();
        try {
            em.getTransaction().begin();
            Query q1 = em.createQuery("UPDATE Customer c SET c.customerName = ?1 WHERE c.customerNumber = ?2");
            q1.setParameter(1, "Asger");
            q1.setParameter(2, customer.getCustomerNumber());
            q1.executeUpdate();
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.clear();
        }
        return customer;
    }
    
    public int getEmployeCount(){
        EntityManager em = getManager();
        Query q1 = em.createQuery("SELECT e FROM Employee e");
        List<Employee> employees = q1.getResultList();
        return employees.size();
    }
    
    public List<Customer> getCustomerInCity(String city) {
        EntityManager em = getManager();
        Query q1 = em.createQuery("SELECT c FROM Customer c WHERE c.city = ?1");
        q1.setParameter(1, city);
        return q1.getResultList();
    }
    //virker ikke helt
    public Employee getEmployeeMaxCustomer(){
        EntityManager em = getManager();
        Query q1 = em.createQuery("SELECT e, size(e.customerCollection) FROM Employee e order by size(e.customerCollection) desc").setMaxResults(1);
        List<Object[]> employees = q1.getResultList();
        Employee employee = new Employee();
        for (Object[] employee1 : employees) {
            for (Object employee2 : employee1) {
                employee = (Employee) employee2;
            }
        }
        return employee;
    }
    
    private EntityManager getManager() {
        return emf.createEntityManager();
    }
}
