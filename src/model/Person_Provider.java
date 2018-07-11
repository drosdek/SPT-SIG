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
public class Person_Provider extends Person {

    private int id_provider;

    private String company;

    public Person_Provider() {
    }

    public Person_Provider(int id_provider, String company) {
        this.id_provider = id_provider;
        this.company = company;
    }

    public Person_Provider(int id_provider, String company, int id_person,
            String name, String lastname, String phone, int cpf_cnpj, Date birth) {
        super(id_person, name, lastname, phone, cpf_cnpj, birth);
        this.id_provider = id_provider;
        this.company = company;
    }

    public int getId_provider() {
        return id_provider;
    }

    public void setId_provider(int id_provider) {
        this.id_provider = id_provider;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

}
