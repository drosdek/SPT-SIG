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

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author gruber
 */

@Entity(name = "tb_product_stock")
@Table(name = "tb_product_stock")
public class Product_Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_stock;

    @ManyToOne
    @JoinColumn(name = "id_product")
    private Product product;

    private int amount;

    private Date the_date;

    public Product_Stock() {
    }

    public Product_Stock(int id_stock, Product product, int amount, Date date) {
        this.id_stock = id_stock;
        this.product = product;
        this.amount = amount;
        this.the_date = date;
    }

    public int getId_stock() {
        return id_stock;
    }

    public void setId_stock(int id_stock) {
        this.id_stock = id_stock;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return the_date;
    }

    public void setDate(Date date) {
        this.the_date = date;
    }

}
