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
import model.Person_Provider;
import view.Container_Person_Provider;

/**
 *
 * @author gruber
 */
public class Controller_Person_Provider {
    
    public void control(Container_Person_Provider container_Person_Provider) {        
        
        GQBD.list_Person_clients();
        container_Person_Provider.setProviders(Cache.getPersons_provider());
        container_Person_Provider.updateTable();
        
        container_Person_Provider.getButton_register().setOnAction((event) -> {
            container_Person_Provider.getGridPane_list().setVisible(false);
            container_Person_Provider.getGridPane_register().setVisible(true);
        });
        
        container_Person_Provider.getButton_cancel().setOnAction((event) -> {
            container_Person_Provider.getGridPane_list().setVisible(true);
            container_Person_Provider.getGridPane_register().setVisible(false);
            container_Person_Provider.getField_name().clear();
            container_Person_Provider.getField_lastname().clear();
            container_Person_Provider.getField_cpf().clear();
            container_Person_Provider.getField_phone().clear();
            container_Person_Provider.getField_birth().clear();
            container_Person_Provider.getField_company().clear();            
        });
        
        container_Person_Provider.getButton_confirm().setOnAction((event) -> {
            GQBD.insert_Person_provider(new Person_Provider(
                    0,
                    container_Person_Provider.getField_company().getText(),
                    0,
                    container_Person_Provider.getField_name().getText(),
                    container_Person_Provider.getField_lastname().getText(),                   
                    container_Person_Provider.getField_cpf().getText(),
                    Integer.parseInt(container_Person_Provider.getField_phone().getText()),
                    Date.valueOf(container_Person_Provider.getField_birth().getText())                    
            ));
            
            GQBD.list_Person_providers();
            container_Person_Provider.setProviders(Cache.getPersons_provider());
            container_Person_Provider.updateTable();
            container_Person_Provider.getGridPane_list().setVisible(true);
            container_Person_Provider.getGridPane_register().setVisible(false);
            container_Person_Provider.getField_birth().clear();
            container_Person_Provider.getField_cpf().clear();
            container_Person_Provider.getField_lastname().clear();
            container_Person_Provider.getField_name().clear();
            container_Person_Provider.getField_phone().clear();
        });

    }
    
}