package za.ac.cput.dbcrud;

import java.sql.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import za.ac.cput.entities.User;

/**
 *
 * @author    Chadrack B. Boudzoumou
 * @email     219383847@mycput.ac.za
 * @student   219383847
 * @uni       Cape Peninsula University Of Technology
 * @since     31 Jul 2021 | 03:15:51
 */
public class DBCrud<T> {

  private static String persistUnit = "User_Unit";
  private static EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistUnit);
  
  public static void main(String[] args) {     
     DBCrud<User> crud = new DBCrud<>();
     User u = new User();
     u.setUserName("Jame");
     u.setUserPassword("123@abc");
     System.out.println(crud.validate(u));
  }
  
  /**
   * Method insertToDB
   * 
   */
  public void insertToDB(T obj) {
    
    EntityManager em = emf.createEntityManager();
    try {
      em.getTransaction().begin();
      em.persist(obj);
      em.getTransaction().commit();
    }
    catch(Exception ex) {
      ex.getStackTrace();
    }
    finally {
      System.out.println("Row inserted");
      em.close();
    }
  }
  
  public List<T> selectAllFromDB(String sql) {
    
    EntityManager em = emf.createEntityManager();
    em.getTransaction().begin();
    
    Query query = em.createQuery(sql);
    
    List<T> list = query.getResultList();
    
    if(list == null) {
      System.out.println("The List is empty");
      return null;
    }
    else {
      return list;
    }
  }
  
  public T selectFromDB(String sql) {
      EntityManager em = emf.createEntityManager();
      em.getTransaction().begin();
      Query query = em.createQuery(sql);
      T t = (T) query.getSingleResult();

      if(t == null){
          return null;
      }
      else {
          return t;
      }
  }
  
  public boolean validate(User u) {
    
    EntityTransaction et = null;
    User user = null;
    EntityManager em = emf.createEntityManager();
    try { 
        et = em.getTransaction();
        et.begin();
        
        Query query = em.createQuery("SELECT u FROM User u WHERE u.userName = :uname")
                .setParameter("uname", u.getUserName());

        user = (User) query.getSingleResult();

        if(user != null && user.getUserName().equals(u.getUserName()) && user.getUserPassword().equals(u.getUserPassword())) {
          return true;
        }
        et.commit();
    }
    catch(Exception ex) {
      if(et != null) {
        et.rollback();
      }
    }
    
    return false;
  }
  
  private static void truncateTable(String sql) {
    EntityManager em = emf.createEntityManager();
    
    try {
      em.getTransaction().begin();
      
      Query query = em.createNativeQuery(sql);
      int result = query.executeUpdate();
      
      if (result >= 0) {
        System.out.println("Table Cleared");
      }
      else {
        System.out.println("Could not clear the table");
      }
      em.getTransaction().commit();
    }
    catch(Exception ex) {
      System.out.println(ex.getMessage());
    } finally {
      em.close();
    }
  }
}