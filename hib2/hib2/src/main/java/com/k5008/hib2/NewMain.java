/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.k5008.hib2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 *
 * @author Ossama
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

        SessionFactory factory = meta.getSessionFactoryBuilder().build();
        Session session = factory.openSession();
        Transaction t = session.beginTransaction();

        Module m1 = new Module("M1", "module 1");
        Module m2 = new Module("M2", "module 2");
        Student s1 = new Student("Student 1");
        Student s2 = new Student("Student 2");

        m1.addStudent(s1);
        s1.addModule(m1);
        m2.addStudent(s2);
        s2.addModule(m2);
        session.save(s1);
        session.save(s2);
        session.save(m1);
        session.save(m2);
        
        t.commit();
        System.out.println("successfully saved");
        factory.close();
        session.close();
    }

}
