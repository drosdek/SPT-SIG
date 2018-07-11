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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

/**
 *
 * @author gruber
 */

@MappedSuperclass
public class Order {
    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_order;
    
    @ManyToOne
    @JoinColumn(name = "id_model")
    private Order_Model model;
    
    private Date the_date;
    
    private double the_value;

    public Order() {
    }

    public Order(int id_order, Order_Model model, Date date, double value) {
        this.id_order = id_order;
        this.model = model;
        this.the_date = date;
        this.the_value = value;
    }

    public int getId_order() {
        return id_order;
    }

    public void setId_order(int id_order) {
        this.id_order = id_order;
    }

    public Order_Model getModel() {
        return model;
    }

    public void setModel(Order_Model model) {
        this.model = model;
    }

    public Date getDate() {
        return the_date;
    }

    public void setDate(Date date) {
        this.the_date = date;
    }

    public double getValue() {
        return the_value;
    }

    public void setValue(double value) {
        this.the_value = value;
    }
        
}
