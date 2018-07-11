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
        
        container_Person_Client.getButton_register().setOnAction((event) -> {
            container_Person_Client.getGridPane_list().setVisible(false);
            container_Person_Client.getGridPane_register().setVisible(true);
        });
        
        container_Person_Client.getButton_cancel().setOnAction((event) -> {
            container_Person_Client.getGridPane_list().setVisible(true);
            container_Person_Client.getGridPane_register().setVisible(false);
        });
        
        container_Person_Client.getButton_confirm().setOnAction((event) -> {
            container_Person_Client.getClients().add( new Person_Client(0, 0, "Testenildo", "Bugado", "46541651", 0, new Date(2018, 07, 07)));
            container_Person_Client.updateTable();
        });
        
    }

    protected void add() {
        try {
            GQBD.insert_Person_client(new Person_Client(
                    0,
                    0,
                    "name",
                    "lastname",
                    "phone",
                    0,
                    new Date(0)
            )
            );
        } catch (Exception exception) {
            System.err.println(exception);
        }
    }

    protected void remove(Person_Client client) {
        try {
            GQBD.remove_Person_client(client);
        } catch (Exception exception) {
            System.err.println(exception);
        }
    }

    protected void update(Person_Client client) {
        try {
            GQBD.remove_Person_client(client);
        } catch (Exception exception) {
            System.err.println(exception);
        }
    }

}
