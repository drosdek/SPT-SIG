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
import model.Person_Client;
import gqbd.GQBD;
import java.sql.Date;
import view.Container_Person_Client;

/**
 *
 * @author gruber
 */
public class Controller_Person_Client {

    public void control(Container_Person_Client container_Person_Client) {

        GQBD.list_Person_clients();
        container_Person_Client.setClients(Cache.getPersons_client());
        container_Person_Client.updateTable();

        container_Person_Client.getButton_register().setOnAction((event) -> {
            container_Person_Client.getGridPane_list().setVisible(false);
            container_Person_Client.getGridPane_register().setVisible(true);
        });

        container_Person_Client.getButton_cancel().setOnAction((event) -> {
            container_Person_Client.getGridPane_list().setVisible(true);
            container_Person_Client.getGridPane_register().setVisible(false);
            container_Person_Client.getField_birth().clear();
            container_Person_Client.getField_cpf().clear();
            container_Person_Client.getField_lastname().clear();
            container_Person_Client.getField_name().clear();
            container_Person_Client.getField_phone().clear();
        });

        container_Person_Client.getButton_confirm().setOnAction((event) -> {
            GQBD.insert_Person_client(new Person_Client(
                    0,
                    0,
                    container_Person_Client.getField_name().getText(),
                    container_Person_Client.getField_lastname().getText(),
                    container_Person_Client.getField_phone().getText(),
                    Integer.parseInt(container_Person_Client.getField_cpf().getText()),
                    Date.valueOf(container_Person_Client.getField_birth().getText())
            ));
            GQBD.list_Person_clients();
            container_Person_Client.setClients(Cache.getPersons_client());
            container_Person_Client.updateTable();
            container_Person_Client.getGridPane_list().setVisible(true);
            container_Person_Client.getGridPane_register().setVisible(false);
            container_Person_Client.getField_birth().clear();
            container_Person_Client.getField_cpf().clear();
            container_Person_Client.getField_lastname().clear();
            container_Person_Client.getField_name().clear();
            container_Person_Client.getField_phone().clear();
        });

    }

}
