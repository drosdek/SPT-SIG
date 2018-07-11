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
import java.util.ArrayList;
import java.util.Collections;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.scene.chart.XYChart;
import model.Person;
import view.Container_Chart_Person;

/**
 *
 * @author gruber
 */
public class Controller_Chart_Person {

    public void control(Container_Chart_Person container_Chart_Person) {

        ArrayList<String> persons = new ArrayList();
        persons.add("client");
        persons.add("employee");
        persons.add("provider");

        container_Chart_Person.setList_persons(FXCollections.observableArrayList(persons));
        container_Chart_Person.getCombo_person().setItems(container_Chart_Person.getList_persons());

        container_Chart_Person.getCombo_person().getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                setDataByDate(container_Chart_Person);
            }
        });

    }

    public ArrayList list_Persons(String person) {
        switch (person) {
            case "client":
                GQBD.list_Person_clients();
                return Cache.getPersons_client();
            case "provider":
                GQBD.list_Person_providers();
                return Cache.getPersons_provider();
            case "employee":
                GQBD.list_Person_employees();
                return Cache.getPersons_employee();
            default:
                return new ArrayList();
        }

    }

    public void setDataByDate(Container_Chart_Person container_Chart_Person) {
        ArrayList<Person> persons = list_Persons(
                container_Chart_Person.getCombo_person().
                        getSelectionModel().getSelectedItem().toString());

        Collections.sort(persons);

        Person temp = new Person();
        
        XYChart.Series dataSeries = (XYChart.Series) container_Chart_Person.getAreaChart().getData().get(0);
        
        dataSeries.getData().clear();
        
        int count = 1;
        for (int x = 0; x < persons.size(); x++) {
            if (x != 0) {
                if (persons.get(x).getBirth().toString().equalsIgnoreCase(persons.get(x - 1).getBirth().toString())) {
                    count++;
                } else {
                    dataSeries.getData().add(
                            new XYChart.Data(
                                    persons.get(x - 1).getBirth().toString(),
                                    count));
                    count = 1;
                }
            }
            
            if (x + 1 >= persons.size()) {
                dataSeries.getData().add(
                        new XYChart.Data(
                                persons.get(x).getBirth().toString(),
                                count));
            }
        }
        //container_Chart_Person.getAreaChart().getData().clear();
        //container_Chart_Person.getAreaChart().getData().add(container_Chart_Person.getDataSeries());
        
    }

}
