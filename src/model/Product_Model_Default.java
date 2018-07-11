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

/**
 *
 * @author gruber
 */
public class Product_Model_Default extends Product_Model {

    private int id_default;

    private double height;

    public Product_Model_Default() {
    }

    public Product_Model_Default(int id_default, double height) {
        this.id_default = id_default;
        this.height = height;
    }

    public Product_Model_Default(int id_default, double height, int id_model,
            String name, String description) {
        super(id_model, name, description);
        this.id_default = id_default;
        this.height = height;
    }

    public int getId_default() {
        return id_default;
    }

    public void setId_default(int id_default) {
        this.id_default = id_default;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

}
