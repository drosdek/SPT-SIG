/*
 * Copyright (C) 2018 gruber
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package gqbd;

import java.util.ArrayList;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import cache.Cache;
import model.*;

/**
 *
 * @author gruber
 */
public class GQBD {

    public static void list_Person_clients() {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Cache.setPersons_client((ArrayList) session.createQuery("from tb_person_client AS Person_Client ").list());
        session.close();
    }

    public static void insert_Person_client(Person_Client Person_client) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(Person_client);
        transaction.commit();
        session.close();
    }

    public static void alter_Person_client(Person_Client Person_client) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(Person_client);
        transaction.commit();
        session.close();
    }

    public static void remove_Person_client(Person_Client Person_client) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(Person_client);
        transaction.commit();
        session.close();
    }

    public static void list_Person_employees() {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Cache.setPersons_employee((ArrayList) session.createQuery("from tb_person_employee AS Person_Employee ").list());
        session.close();
    }

    public static void insert_Person_employee(Person_Employee Person_employee) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(Person_employee);
        transaction.commit();
        session.close();
    }

    public static void alter_Person_employee(Person_Employee Person_employee) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(Person_employee);
        transaction.commit();
        session.close();
    }

    public static void remove_Person_employee(Person_Employee Person_employee) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(Person_employee);
        transaction.commit();
        session.close();
    }

    public static void list_Person_providers() {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Cache.setPersons_provider((ArrayList) session.createQuery("from tb_person_provider AS Person_Provider ").list());
        session.close();
    }

    public static void insert_Person_provider(Person_Provider Person_provider) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(Person_provider);
        transaction.commit();
        session.close();
    }

    public static void alter_Person_provider(Person_Provider Person_provider) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(Person_provider);
        transaction.commit();
        session.close();
    }

    public static void remove_Person_provider(Person_Provider Person_provider) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(Person_provider);
        transaction.commit();
        session.close();
    }

    public static void list_Products() {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Cache.setProducts((ArrayList) session.createQuery("from tb_product AS Product  ").list());
        session.close();
    }

    public static void insert_Product(Product Product) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(Product);
        transaction.commit();
        session.close();
    }

    public static void alter_Product(Product Product) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(Product);
        transaction.commit();
        session.close();
    }

    public static void remove_Product(Product Product) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(Product);
        transaction.commit();
        session.close();
    }

}
