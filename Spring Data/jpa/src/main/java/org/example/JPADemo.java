package org.example;

import org.example.entity.User;

import javax.persistence.*;
import java.util.Arrays;

//TODO type password in persistence.xml ->  <property name="hibernate.connection.password" value=""/>
public class JPADemo {
    private static    EntityManagerFactory emf=null;
    public static void main(String[] args) {
        try {

            emf= Persistence.createEntityManagerFactory("school");
            EntityManager entityManager = emf.createEntityManager();
            entityManager.getTransaction().begin();
//            City city=new City();
//            city.setName("Pleven");
//            User user=new User();
//            user.setName("Maggie");
//            user.setPassword("123");
//            user.setCity(city);
//
//            entityManager.persist(user);

            TypedQuery<User> query = entityManager.createQuery("SELECT u FROM User u WHERE city.id IN :cityIds", User.class);
            query.setParameter("cityIds", Arrays.asList(1,3));
            query.getResultList().forEach(System.out::println);


            entityManager.getTransaction().commit();

        }catch (Exception e){
            System.out.println(e.getMessage());

        }finally {
            if(emf !=null){
                emf.close();
            }
        }


    }
}
