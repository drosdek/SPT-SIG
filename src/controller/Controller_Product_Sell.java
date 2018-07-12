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
package controller;

import cache.Cache;
import gqbd.GQBD;
import java.util.ArrayList;
import model.Order_Model_Purchase;
import model.Person_Employee;
import model.Person_Provider;
import model.Product_Exchange;
import model.Product_Price;
import view.Container_Product_Sell;

/**
 *
 * @author gruber
 */
public class Controller_Product_Sell {

    public void control(Container_Product_Sell container_Product_Sell) {

        GQBD.list_Person_clients();
        GQBD.list_Person_employees();
        GQBD.list_Products();
        GQBD.list_Product_prices();

        container_Product_Sell.setClients(Cache.getPersons_client());
        container_Product_Sell.setEmployees(Cache.getPersons_employee());

        Cache.getProducts().forEach((product) -> {
            Product_Price product_Price = new Product_Price();
            Product_Exchange product_Exchange = new Product_Exchange();
            Cache.getProduct_Prices().forEach((price) -> {
                if (product.getId_product() == price.getProduct().getId_product()) {
                    product_Exchange.setPrice(price);
                }
            });
            product_Exchange.setDescription(product.getDescription());
            product_Exchange.setId_product(product.getId_product());
            product_Exchange.setModel(product.getModel());
            product_Exchange.setName(product.getName());
            product_Exchange.setUrl_image(product.getUrl_image());
            container_Product_Sell.getProducts().add(product_Exchange);
        });
        
        container_Product_Sell.updateComboClient();
        container_Product_Sell.updateComboEmployee();
        container_Product_Sell.updateTable();

        container_Product_Sell.getButton_cancel().setOnAction((event) -> {
            container_Product_Sell.getTableView().getItems().clear();
            container_Product_Sell.updateTable();

        });
        
        container_Product_Sell.getButton_confirm().setOnAction((event) -> {
            ArrayList<Product_Exchange> products = new ArrayList();
            for (Product_Exchange product_Exchange : container_Product_Sell.getTableView().getItems()) {
                if (product_Exchange.isAdded().get()
                        || product_Exchange.getAmount().get() > 0) {
                    products.add(product_Exchange);
                }
            }
            
        GQBD.insert_Order_Model_purchase(new Order_Model_Purchase(
                    0,
                    (Person_Provider) container_Product_Sell.getComboBox_client().getSelectionModel().getSelectedItem(),
                    (Person_Employee) container_Product_Sell.getComboBox_employee().getSelectionModel().getSelectedItem(),
                    products,
                    0,
                    0,
                    "Venda",
                    "Venda de produto Default"));
            container_Product_Sell.getTableView().getItems().clear();
            container_Product_Sell.updateTable();
        });

    }

}
