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
import java.sql.Date;
import model.Product;
import model.Product_Model;
import model.Product_Price;
import view.Container_Product;

/**
 *
 * @author gruber
 */
public class Controller_Product {

    private Product product;

    public void control(Container_Product container_Product) {

        GQBD.list_Products();
        container_Product.setProducts(Cache.getProducts());
        container_Product.updateTableProduct();
        GQBD.list_Product_Model_Defaults();
        container_Product.setModels(Cache.getProducts_default());
        container_Product.updateComboModel();
        GQBD.list_Product_prices();

        container_Product.getTableView_product().setOnMouseClicked((event) -> {
            product = container_Product.getTableView_product().
                    getSelectionModel().getSelectedItems().get(0);
            if (product != null) {
                container_Product.getButton_price().setVisible(true);
                container_Product.getButton_stock().setVisible(true);
            } else {
                container_Product.getButton_price().setVisible(false);
                container_Product.getButton_stock().setVisible(false);
            }
        });

        container_Product.getButton_register().setOnAction((event) -> {
            container_Product.getGridPane_register().setVisible(true);
            container_Product.getGridPane_list().setVisible(false);
        });

        container_Product.getButton_register_confirm().setOnAction((event) -> {
            GQBD.insert_Product(new Product(
                    0,
                    (Product_Model) container_Product.getCombo_model().getSelectionModel().getSelectedItem(),
                    container_Product.getField_name().getText(),
                    container_Product.getField_description().getText(),
                    container_Product.getField_image().getText()
            ));
            GQBD.list_Products();
            container_Product.setProducts(Cache.getProducts());
            container_Product.updateTableProduct();
            container_Product.getGridPane_register().setVisible(false);
            container_Product.getGridPane_list().setVisible(true);
            container_Product.getField_name().clear();
            container_Product.getField_description().clear();
            container_Product.getField_image().clear();
        });

        container_Product.getButton_register_cancel().setOnAction((event) -> {
            container_Product.getGridPane_register().setVisible(false);
            container_Product.getGridPane_list().setVisible(true);
            container_Product.getField_name().clear();
            container_Product.getField_description().clear();
            container_Product.getField_image().clear();
        });

        container_Product.getButton_stock().setOnAction((event) -> {
            container_Product.getGridPane_stock().setVisible(true);
            container_Product.getGridPane_list().setVisible(false);
        });

        container_Product.getButton_stock_cancel().setOnAction((event) -> {
            container_Product.getGridPane_list().setVisible(true);
            container_Product.getGridPane_stock().setVisible(false);
            container_Product.getField_stock_amount().clear();
        });

        container_Product.getButton_price().setOnAction((event) -> {
            container_Product.getPrices().clear();
            Cache.getProduct_Prices().forEach((price) -> {
                if (price.getProduct().getId_product() == product.getId_product()) {
                    container_Product.getPrices().add(price);
                }
            });
            container_Product.updateTablePrice();
            container_Product.getGridPane_price().setVisible(true);
            container_Product.getGridPane_list().setVisible(false);
        });

        container_Product.getButton_price_confirm().setOnAction((event) -> {
            GQBD.insert_Product_price(new Product_Price(
                    0,
                    product,
                    Double.parseDouble(container_Product.getField_price_buy().getText()),
                    Double.parseDouble(container_Product.getField_price_sell().getText()),
                    new Date(System.currentTimeMillis())
            ));
            GQBD.list_Product_prices();
            Cache.getProduct_Prices().forEach((price) -> {
                if (price.getProduct().equals(product)) {
                    container_Product.getPrices().add(price);
                }
            });
            container_Product.updateTablePrice();
            container_Product.getField_price_buy().clear();
            container_Product.getField_price_sell().clear();
        });

        container_Product.getButton_price_cancel().setOnAction((event) -> {
            container_Product.getGridPane_list().setVisible(true);
            container_Product.getGridPane_price().setVisible(false);
            container_Product.getField_price_buy().clear();
            container_Product.getField_price_sell().clear();
        });

    }

}
