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
package cache;

import component.Prototype_Button;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import model.*;

/**
 *
 * @author gruber
 */
public class Cache {

    private static ArrayList<Order> orders = new ArrayList();
    private static ArrayList<Person_Client> persons_client = new ArrayList();
    private static ArrayList<Person_Employee> persons_employee = new ArrayList();
    private static ArrayList<Person_Provider> persons_provider = new ArrayList();
    private static ArrayList<Product> products = new ArrayList();
    private static ArrayList<Product_Model_Default> products_default = new ArrayList();
    private static ArrayList<Product_Price> product_Prices = new ArrayList();
    private static ArrayList<Product_Stock> product_Stocks = new ArrayList();
    private static ArrayList<Order_Model_Sale> orders_sale = new ArrayList();
    private static ArrayList<Order_Model_Purchase> orders_purchase = new ArrayList();
    private static Scene scene;
    private static Pane pane_main, pane_sidebar;
    private static Map<String, Prototype_Button> map_buttons = new HashMap();
    public static double width, height;
    public static String style_menu
            = "-fx-background-color: #212121;"
            + "-fx-border-color: #E1E1E1 ;"
            + "-fx-border-width: 0.5 0 0 0;"
            + "-fx-cursor: hand;"
            + "-fx-font-size: 16;"
            + "-fx-font-style: normal;"
            + "-fx-font-family: Noto Sans;"
            + "-fx-text-fill: #F1F1F1;"
            + "-fx-alignment: CENTER-LEFT;",
            style_menu_hover
            = "-fx-background-color: #313131;"
            + "-fx-border-color: #E1E1E1 #0093ff;"
            + "-fx-border-width: 0.5 8 0 0;"
            + "-fx-cursor: hand;"
            + "-fx-font-size: 16;"
            + "-fx-font-style: normal;"
            + "-fx-font-family: Noto Sans;"
            + "-fx-text-fill: #F1F1F1;"
            + "-fx-alignment: CENTER-LEFT;",
            style_submenu
            = "-fx-background-color: #212121;"
            + "-fx-border-color: #0093ff;"
            + "-fx-border-width: 0 7 0 0;"
            + "-fx-cursor: hand;"
            + "-fx-font-size: 14;"
            + "-fx-font-style: normal;"
            + "-fx-font-family: Noto Sans;"
            + "-fx-text-fill: #F1F1F1;",
            style_submenu_hover
            = "-fx-background-color: #414141;"
            + "-fx-border-color: #0093ff;"
            + "-fx-border-width: 0 7 0 0;"
            + "-fx-cursor: hand;"
            + "-fx-font-size: 14;"
            + "-fx-font-style: normal;"
            + "-fx-font-family: Noto Sans;"
            + "-fx-text-fill: #F1F1F1;";

    public Cache() {
    }

    public static void setOrders(ArrayList<Order> orders) {
        Cache.orders = orders;
    }

    public static void setPersons_client(ArrayList<Person_Client> persons_client) {
        Cache.persons_client = persons_client;
    }

    public static void setPersons_employee(ArrayList<Person_Employee> persons_employee) {
        Cache.persons_employee = persons_employee;
    }

    public static void setPersons_provider(ArrayList<Person_Provider> persons_provider) {
        Cache.persons_provider = persons_provider;
    }

    public static void setProducts_default(ArrayList<Product_Model_Default> products_default) {
        Cache.products_default = products_default;
    }

    public static void setOrders_sale(ArrayList<Order_Model_Sale> orders_sale) {
        Cache.orders_sale = orders_sale;
    }

    public static void setOrders_purchase(ArrayList<Order_Model_Purchase> orders_purchase) {
        Cache.orders_purchase = orders_purchase;
    }

    public static ArrayList<Order> getOrders() {
        return orders;
    }

    public static ArrayList<Person_Client> getPersons_client() {
        return persons_client;
    }

    public static ArrayList<Person_Employee> getPersons_employee() {
        return persons_employee;
    }

    public static ArrayList<Person_Provider> getPersons_provider() {
        return persons_provider;
    }

    public static ArrayList<Product_Model_Default> getProducts_default() {
        return products_default;
    }

    public static ArrayList<Order_Model_Sale> getOrders_sale() {
        return orders_sale;
    }

    public static ArrayList<Order_Model_Purchase> getOrders_purchase() {
        return orders_purchase;
    }

    public static Scene getScene() {
        return scene;
    }

    public static void setScene(Scene scene) {
        Cache.scene = scene;
    }

    public static Pane getPane_main() {
        return pane_main;
    }

    public static void setPane_main(Pane pane_main) {
        Cache.pane_main = pane_main;
    }

    public static Pane getPane_sidebar() {
        return pane_sidebar;
    }

    public static void setPane_sidebar(Pane pane_sidebar) {
        Cache.pane_sidebar = pane_sidebar;
    }

    public static Map<String, Prototype_Button> getMap_buttons() {
        return map_buttons;
    }

    public static void setMap_buttons(Map<String, Prototype_Button> map_buttons) {
        Cache.map_buttons = map_buttons;
    }

    public static ArrayList<Product> getProducts() {
        return products;
    }

    public static void setProducts(ArrayList<Product> products) {
        Cache.products = products;
    }

    public static ArrayList<Product_Price> getProduct_Prices() {
        return product_Prices;
    }

    public static void setProduct_Prices(ArrayList<Product_Price> product_Prices) {
        Cache.product_Prices = product_Prices;
    }

    public static ArrayList<Product_Stock> getProduct_Stocks() {
        return product_Stocks;
    }

    public static void setProduct_Stocks(ArrayList<Product_Stock> product_Stocks) {
        Cache.product_Stocks = product_Stocks;
    }

}
