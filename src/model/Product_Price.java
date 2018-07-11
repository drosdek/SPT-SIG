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

import java.sql.Date;

/**
 *
 * @author gruber
 */
public class Product_Price {

    private int id_price;

    private Product product;

    private double buy_price, sell_price;

    private Date date;

    public Product_Price() {
    }

    public Product_Price(int id_price, Product product, double buy_price, double sell_price, Date date) {
        this.id_price = id_price;
        this.product = product;
        this.buy_price = buy_price;
        this.sell_price = sell_price;
        this.date = date;
    }

    public int getId_price() {
        return id_price;
    }

    public void setId_price(int id_price) {
        this.id_price = id_price;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public double getBuy_price() {
        return buy_price;
    }

    public void setBuy_price(double buy_price) {
        this.buy_price = buy_price;
    }

    public double getSell_price() {
        return sell_price;
    }

    public void setSell_price(double sell_price) {
        this.sell_price = sell_price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
