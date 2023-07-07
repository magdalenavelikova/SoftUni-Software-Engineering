package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import org.example.entity.sales.Product;
import org.example.entity.sales.Sale;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Main {


    public static void main(String[] args) throws IOException {
        EntityManager entityManager = null;
        String persistenceUnitName = "";
        System.out.println("Enter task /1-5/: ");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int task = Integer.parseInt(bufferedReader.readLine());
        switch (task) {
            case 1 -> persistenceUnitName = "exercise";
            case 2 -> persistenceUnitName = "sales";
            case 3 -> persistenceUnitName = "university";
            case 4 -> persistenceUnitName = "hospital";
            case 5 -> persistenceUnitName = "bank";
        }
        entityManager = getEntityManagerDB(persistenceUnitName);
        entityManager.getTransaction().begin();



     /*   Product product = new Product();
        product.setName("alabala");
        product.setPrice(BigDecimal.TEN);
        Sale sale = new Sale();
        sale.setDate(LocalDateTime.now().now());
        sale.setProduct(product);
        product.getSales().add(sale);
        entityManager.persist(product);*/

       /* Task 4
        Patient patient = new Patient("Ivan", "Ivanov", "Varna, Madara 15","ivan@ivanov.bg", new Date(2000, 05, 05), true);
        Visitation visitation = new Visitation();
        visitation.setDate(LocalDateTime.now());
        visitation.setComments("Probably he has a Hypochondria");
        visitation.setPatient(patient);
        Diagnose flu = new Diagnose();
        flu.setName("flu");
        Medicament paracetamol = new Medicament();
        paracetamol.setName("Paracetamol");
        patient.getDiagnoses().add(flu);
        patient.getMedicaments().add(paracetamol);
        patient.getVisitations().add(visitation);
        entityManager.persist(patient);*/


        entityManager.getTransaction().commit();
    }

    private static EntityManager getEntityManagerDB(String persistenceUnitName) {
        return Persistence.createEntityManagerFactory(persistenceUnitName).createEntityManager();
    }
}