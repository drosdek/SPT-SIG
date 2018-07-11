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
import model.Person_Employee;
import view.Container_Person_Employee;

/**
 *
 * @author gruber
 */
public class Controller_Person_Employee {

    public void control(Container_Person_Employee container_Person_Employee) {
        
        GQBD.list_Person_employees();
        container_Person_Employee.setEmployees(Cache.getPersons_employee());
        container_Person_Employee.updateTable();
        
        container_Person_Employee.getButton_register().setOnAction((event) -> {
            container_Person_Employee.getGridPane_list().setVisible(false);
            container_Person_Employee.getGridPane_register().setVisible(true);
        });
        
        container_Person_Employee.getButton_cancel().setOnAction((event) -> {
            container_Person_Employee.getGridPane_list().setVisible(true);
            container_Person_Employee.getGridPane_register().setVisible(false);
            container_Person_Employee.getField_name().clear();
            container_Person_Employee.getField_lastname().clear();
            container_Person_Employee.getField_cpf().clear();
            container_Person_Employee.getField_phone().clear();
            container_Person_Employee.getField_birth().clear();
            container_Person_Employee.getField_function().clear();
            container_Person_Employee.getField_salary().clear();
        });
        
        container_Person_Employee.getButton_confirm().setOnAction((event) -> {
            GQBD.insert_Person_employee(new Person_Employee(
                    0,
                    container_Person_Employee.getField_function().getText(),                    
                    Double.parseDouble(container_Person_Employee.getField_salary().getText()),
                    0,
                    container_Person_Employee.getField_name().getText(),
                    container_Person_Employee.getField_lastname().getText(),
                    container_Person_Employee.getField_phone().getText(),  
                    Integer.parseInt(container_Person_Employee.getField_cpf().getText()),
                    Date.valueOf(container_Person_Employee.getField_birth().getText())                                        
            ));
            
        GQBD.list_Person_employees();
            container_Person_Employee.setEmployees(Cache.getPersons_employee());
            container_Person_Employee.updateTable();
            container_Person_Employee.getGridPane_list().setVisible(true);
            container_Person_Employee.getGridPane_register().setVisible(false);            
            container_Person_Employee.getField_birth().clear();
            container_Person_Employee.getField_cpf().clear();
            container_Person_Employee.getField_lastname().clear();
            container_Person_Employee.getField_name().clear();
            container_Person_Employee.getField_phone().clear();
            container_Person_Employee.getField_salary().clear();
            container_Person_Employee.getField_function().clear();
        });
        
    }
    
}