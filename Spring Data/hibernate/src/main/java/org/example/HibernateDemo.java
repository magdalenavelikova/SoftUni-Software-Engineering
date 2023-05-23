package org.example;

import jakarta.persistence.TypedQuery;
import org.example.entity.City;
import org.example.entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateDemo {
    public static void main(String[] arguments) {
      //TODO type password in hibernate.cfg.xml -> <property name = "hibernate.connection.password"> </property>

      Session session1 = new Configuration().configure().buildSessionFactory().openSession();
        Transaction transaction = session1.beginTransaction();
        User user = new User();
        user.setName("Test");
        user.setPassword("123");
        session1.persist(user);

       // EntityManager session1 = new Configuration().configure().buildSessionFactory().openSession();
        TypedQuery<User> query = session1.createQuery("SELECT u FROM User u where u.id = :id", User.class);
        query.setParameter("id", 1);

        TypedQuery<User> query1 = session1.createQuery("SELECT u FROM User u where u.city.name = :city_name", User.class);
        query1.setParameter("city_name", "Varna");
        query1.getResultList().forEach(u -> System.out.println(u));

        TypedQuery<City> query2 = session1.createQuery("SELECT c FROM City c WHERE c.name=:city_name", City.class);
        query2.setParameter("city_name", "Sofia");
        City sofiaCity = query2.getSingleResult();

        var manol=new User();
        manol.setName("Manol");
        manol.setPassword("1");
        manol.setCity(sofiaCity);
        session1.persist(manol);
        transaction.commit();
    }
}