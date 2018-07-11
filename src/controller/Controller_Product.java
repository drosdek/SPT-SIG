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

import gqbd.GQBD;
import model.Product;
import model.Product_Model_Default;
import view.Container_Product;

/**
 *
 * @author gruber
 */
public class Controller_Product {

    private Product product;

    public void control(Container_Product container_Product) {

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
            container_Product.getProducts().add(new Product(
                    0,
                    new model.Product_Model(0, "sdfsdgsdf", "sdfdfdsda"),
                    "sdffgfhsdf",
                    "sdfsdfhgfs",
                    "tesatasd"
            ));
            container_Product.updateTableProduct();
        });

        container_Product.getButton_register_cancel().setOnAction((event) -> {
            container_Product.getGridPane_register().setVisible(false);
            container_Product.getGridPane_list().setVisible(true);
            container_Product.getField_name().clear();
            container_Product.getField_description().clear();
            container_Product.getField_image().clear();
            container_Product.getField_model().clear();
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
            container_Product.getGridPane_price().setVisible(true);
            container_Product.getGridPane_list().setVisible(false);
        });

        container_Product.getButton_price_cancel().setOnAction((event) -> {
            container_Product.getGridPane_list().setVisible(true);
            container_Product.getGridPane_price().setVisible(false);
            container_Product.getField_price_buy().clear();
            container_Product.getField_price_sell().clear();
        });

    }

}
