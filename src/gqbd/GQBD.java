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

    public static void list_orders() {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Cache.setOrders((ArrayList) session.createQuery("from tb_order AS Order ").list());
        session.close();
        factory.close();
    }

    public static void insert_order(Order order) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(order);
        transaction.commit();
        session.close();
        factory.close();
    }

    public static void alter_order(Order order) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(order);
        transaction.commit();
        session.close();
        factory.close();
    }

    public static void remove_order(Order order) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(order);
        transaction.commit();
        session.close();
        factory.close();
    }

    public static void list_Order_Model_purchases() {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Cache.setOrders_purchase((ArrayList) session.createQuery("from tb_order_model_purchase AS Order_Model_Purchase ").list());
        session.close();
        factory.close();
    }

    public static void insert_Order_Model_purchase(Order_Model_Purchase Order_Model_purchase) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(Order_Model_purchase);
        transaction.commit();
        session.close();
        factory.close();
    }

    public static void alter_Order_Model_purchase(Order_Model_Purchase Order_Model_purchase) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(Order_Model_purchase);
        transaction.commit();
        session.close();
        factory.close();
    }

    public static void remove_Order_Model_purchase(Order_Model_Purchase Order_Model_purchase) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(Order_Model_purchase);
        transaction.commit();
        session.close();
        factory.close();
    }

    public static void list_Order_Model_sales() {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Cache.setOrders_sale((ArrayList) session.createQuery("from tb_order_model_sale AS Order_Model_Sale ").list());
        session.close();
        factory.close();
    }

    public static void insert_Order_Model_sale(Order_Model_Sale Order_Model_sale) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(Order_Model_sale);
        transaction.commit();
        session.close();
        factory.close();
    }

    public static void alter_Order_Model_sale(Order_Model_Sale Order_Model_sale) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(Order_Model_sale);
        transaction.commit();
        session.close();
        factory.close();
    }

    public static void remove_Order_Model_sale(Order_Model_Sale Order_Model_sale) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(Order_Model_sale);
        transaction.commit();
        session.close();
        factory.close();
    }

    public static void list_Person_clients() {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Cache.setPersons_client((ArrayList) session.createQuery("from tb_person_client AS Person_Client ").list());
        session.close();
        factory.close();
    }

    public static void insert_Person_client(Person_Client Person_client) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(Person_client);
        transaction.commit();
        session.close();
        factory.close();
    }

    public static void alter_Person_client(Person_Client Person_client) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(Person_client);
        transaction.commit();
        session.close();
        factory.close();
    }

    public static void remove_Person_client(Person_Client Person_client) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(Person_client);
        transaction.commit();
        session.close();
        factory.close();
    }

    public static void list_Person_employees() {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Cache.setPersons_employee((ArrayList) session.createQuery("from tb_person_employee AS Person_Employee ").list());
        session.close();
        factory.close();
    }

    public static void insert_Person_employee(Person_Employee Person_employee) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(Person_employee);
        transaction.commit();
        session.close();
        factory.close();
    }

    public static void alter_Person_employee(Person_Employee Person_employee) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(Person_employee);
        transaction.commit();
        session.close();
        factory.close();
    }

    public static void remove_Person_employee(Person_Employee Person_employee) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(Person_employee);
        transaction.commit();
        session.close();
        factory.close();
    }

    public static void list_Person_providers() {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Cache.setPersons_provider((ArrayList) session.createQuery("from tb_person_provider AS Person_Provider ").list());
        session.close();
        factory.close();
    }

    public static void insert_Person_provider(Person_Provider Person_provider) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(Person_provider);
        transaction.commit();
        session.close();
        factory.close();
    }

    public static void alter_Person_provider(Person_Provider Person_provider) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(Person_provider);
        transaction.commit();
        session.close();
        factory.close();
    }

    public static void remove_Person_provider(Person_Provider Person_provider) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(Person_provider);
        transaction.commit();
        session.close();
        factory.close();
    }

    public static void list_Products() {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Cache.setProducts((ArrayList) session.createQuery("from tb_product AS Product  ").list());
        session.close();
        factory.close();
    }

    public static void insert_Product(Product Product) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(Product);
        transaction.commit();
        session.close();
        factory.close();
    }

    public static void alter_Product(Product Product) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(Product);
        transaction.commit();
        session.close();
        factory.close();
    }

    public static void remove_Product(Product Product) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(Product);
        transaction.commit();
        session.close();
        factory.close();
    }

    public static void list_Product_Model_Defaults() {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Cache.setProducts_default((ArrayList) session.createQuery("from tb_product_model_default AS Product_Model_Default  ").list());
        session.close();
        factory.close();
    }

    public static void insert_Product_Model_Default(Product_Model_Default Product_Model_Default) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(Product_Model_Default);
        transaction.commit();
        session.close();
        factory.close();
    }

    public static void alter_Product_Model_Default(Product_Model_Default Product_Model_Default) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(Product_Model_Default);
        transaction.commit();
        session.close();
        factory.close();
    }

    public static void remove_Product_Model_Default(Product_Model_Default Product_Model_Default) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(Product_Model_Default);
        transaction.commit();
        session.close();
        factory.close();
    }

    public static void list_Product_prices() {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Cache.setProduct_Prices((ArrayList) session.createQuery("from tb_product_price AS Product_Price ").list());
        session.close();
        factory.close();
    }

    public static void insert_Product_price(Product_Price Product_price) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(Product_price);
        transaction.commit();
        session.close();
        factory.close();
    }

    public static void alter_Product_price(Product_Price Product_price) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(Product_price);
        transaction.commit();
        session.close();
        factory.close();
    }

    public static void remove_Product_price(Product_Price Product_price) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(Product_price);
        transaction.commit();
        session.close();
        factory.close();
    }

    public static void list_Product_stocks() {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Cache.setProduct_Stocks((ArrayList) session.createQuery("from tb_product_stock AS Product_Stock ").list());
        session.close();
        factory.close();
    }

    public static void insert_Product_stock(Product_Stock Product_stock) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(Product_stock);
        transaction.commit();
        session.close();
        factory.close();
    }

    public static void alter_Product_stock(Product_Stock Product_stock) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(Product_stock);
        transaction.commit();
        session.close();
        factory.close();
    }

    public static void remove_Product_stock(Product_Stock Product_stock) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(Product_stock);
        transaction.commit();
        session.close();
        factory.close();
    }

}
