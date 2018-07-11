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

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author gruber
 */
@Entity(name = "tb_person_client")
@Table(name = "tb_person_client")
public class Person_Client extends Person implements Serializable {

    private int id_client;

    public Person_Client() {
    }

    public Person_Client(int id_client) {
        this.id_client = id_client;
    }

    public Person_Client(int id_client, int id_person, String name,
            String lastname, String phone, int cpf_cnpj, Date birth) {
        super(id_person, name, lastname, phone, cpf_cnpj, birth);
        this.id_client = id_client;
    }

    public int getId_client() {
        return id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

}
