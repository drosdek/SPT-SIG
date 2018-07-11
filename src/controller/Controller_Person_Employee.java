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

import java.sql.Date;
import model.Person_Employee;
import view.Container_Person_Employee;

/**
 *
 * @author gruber
 */
public class Controller_Person_Employee {

    public void control(Container_Person_Employee container_Person_Employee) {
        
        container_Person_Employee.getButton_register().setOnAction((event) -> {
            container_Person_Employee.getGridPane_list().setVisible(false);
            container_Person_Employee.getGridPane_register().setVisible(true);
        });
        
        container_Person_Employee.getButton_cancel().setOnAction((event) -> {
            container_Person_Employee.getGridPane_list().setVisible(true);
            container_Person_Employee.getGridPane_register().setVisible(false);
        });
        
        container_Person_Employee.getButton_confirm().setOnAction((event) -> {
            container_Person_Employee.getEmployees().add( new Person_Employee(0, "Unknow", 0.0, 0,"Testenildo", "Bugado", "46541651", 0, new Date(2018, 07, 07)));
            container_Person_Employee.updateTable();
        });
        
    }
    
}
