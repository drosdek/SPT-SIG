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
package view;

import cache.Cache;
import javafx.collections.ObservableList;
import javafx.scene.Parent;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import model.Person;
import model.Person_Client;
import model.Person_Employee;
import model.Person_Provider;

/**
 *
 * @author gruber
 */
public class Container_Chart_Person {
    
    private Pane pane;
    private GridPane gridPane;
    private CategoryAxis categoryAxis;
    private NumberAxis numberAxis;
    private AreaChart areaChart;
    private XYChart.Series dataSeries;
    private Label label_person;
    private ComboBox combo_person;
    private ObservableList<Person> list_persons;
    private ObservableList<Person_Client> list_clients;
    private ObservableList<Person_Employee> list_employees;
    private ObservableList<Person_Provider> list_providers;
    
    public Parent getComponent() {
        
        pane = new Pane();
        
        gridPane = new GridPane();
        
        label_person = new Label("Classe pessoa: ");
        
        combo_person = new ComboBox(list_persons);
        
        categoryAxis = new CategoryAxis();
        categoryAxis.setLabel("Tempo");
        
        numberAxis = new NumberAxis();
        numberAxis.setLabel("Quantia");
        
        dataSeries = new XYChart.Series();
        
        areaChart = new AreaChart(numberAxis, categoryAxis);
        areaChart.setTitle("Cadastros");
        areaChart.getData().add(dataSeries);
        areaChart.setLegendVisible(false);
        areaChart.setPrefSize(Cache.width * 0.60, Cache.height * 0.87);
        
        gridPane.add(nothing(), 0, 0);
        gridPane.add(areaChart, 1, 1, 1, 3);
        gridPane.add(label_person, 2, 1);
        gridPane.add(combo_person, 2, 2, 2, 1);
        gridPane.add(nothing(), 2, 3);
        gridPane.setVisible(true);
        
        pane.getChildren().add(gridPane);
        pane.setVisible(true);
        
        return pane;
    }
    
    private Text nothing() {
        return new Text("   ");
    }
}
