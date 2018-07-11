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
package model;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 *
 * @author gruber
 */
@Entity(name = "tb_product_exchange")
@Table(name = "tb_product_exchange")
@PrimaryKeyJoinColumn(name = "id_product")
public class Product_Exchange extends Product {

    private BooleanProperty added = new SimpleBooleanProperty(false);
    private IntegerProperty amount = new SimpleIntegerProperty(0);

    @ManyToOne
    @JoinColumn(name = "id_price")
    private Product_Price price;

    public Product_Exchange() {
    }

    public Product_Exchange(Product_Price price, int id_product, Product_Model model, String name, String description, String url_image) {
        super(id_product, model, name, description, url_image);
        this.price = price;
    }

    public BooleanProperty isAdded() {
        return added;
    }

    public void setAdded(BooleanProperty added) {
        this.added = added;
    }

    public IntegerProperty getAmount() {
        return amount;
    }

    public void setAmount(IntegerProperty amount) {
        this.amount = amount;
    }

    public Product_Price getPrice() {
        return price;
    }

    public void setPrice(Product_Price price) {
        this.price = price;
    }

}
