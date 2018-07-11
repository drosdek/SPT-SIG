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
public class Person_Employee extends Person {

    private int id_employee;

    private String function;

    private Double salary;

    public Person_Employee() {
    }

    public Person_Employee(int id_employee, String function, Double salary) {
        this.id_employee = id_employee;
        this.function = function;
        this.salary = salary;
    }

    public Person_Employee(int id_employee, String function, Double salary,
            int id_person, String name, String lastname, String phone,
            int cpf_cnpj, Date birth) {
        super(id_person, name, lastname, phone, cpf_cnpj, birth);
        this.id_employee = id_employee;
        this.function = function;
        this.salary = salary;
    }

    public int getId_employee() {
        return id_employee;
    }

    public void setId_employee(int id_employee) {
        this.id_employee = id_employee;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

}
