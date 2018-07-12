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
import controller.Controller_Product_Sell;
import java.util.ArrayList;
import java.util.List;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.util.Callback;
import model.Person_Client;
import model.Person_Employee;
import model.Person_Provider;
import model.Product_Exchange;

/**
 *
 * @author gruber
 */
public class Container_Product_Sell {

    private Pane pane;
    private GridPane gridPane;
    private TableView<Product_Exchange> tableView;
    private final ArrayList<TableColumn<Product_Exchange, ?>> columns = new ArrayList();
    private final List<Product_Exchange> products = new ArrayList();
    private List<Person_Client> clients = new ArrayList();
    private final List<Person_Provider> providers = new ArrayList();
    private List<Person_Employee> employees = new ArrayList();
    private ObservableList<Product_Exchange> list_products;
    private ObservableList<Person_Client> list_clients;
    private ObservableList<Person_Employee> list_employees;
    private ComboBox comboBox_client, comboBox_employee;
    private Label label_table, label_combo_client, label_combo_employee;
    private Button button_confirm, button_cancel;

    public Parent getComponent() {

        pane = new Pane();

        gridPane = new GridPane();

        label_table = new Label("Produtos e sua quantia: ");
        label_combo_client = new Label("Cliente: ");
        label_combo_employee = new Label("Funcionário: ");

        comboBox_client = new ComboBox(list_clients);
        comboBox_employee = new ComboBox(list_employees);

        button_cancel = Cache.getMap_buttons().get("button_cancel_small").clone("Cancelar");
        button_confirm = Cache.getMap_buttons().get("button_confirm_small").clone("Confirmar");

        tableView = new TableView();
        tableView.setPrefSize(Cache.width * 0.60, Cache.height * 0.87);

        TableColumn tableColumn = new TableColumn("Add");
        tableColumn.setCellValueFactory(new PropertyValueFactory("added"));
        tableColumn.setCellFactory(tc -> new CheckBoxTableCell());

        columns.add(tableColumn);

        tableColumn = new TableColumn("Nome");
        tableColumn.setCellValueFactory(
                new PropertyValueFactory<>("name"));

        columns.add(tableColumn);

        tableColumn = new TableColumn("Descrição");
        tableColumn.setCellValueFactory(
                new PropertyValueFactory<>("description"));

        columns.add(tableColumn);

        tableColumn = new TableColumn("Modelo");
        tableColumn.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<Product_Exchange, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(
                    TableColumn.CellDataFeatures<Product_Exchange, String> product) {
                return new SimpleStringProperty(product.getValue().getModel().getName());
            }
        });

        columns.add(tableColumn);

        tableColumn = new TableColumn("Preço");
        tableColumn.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<Product_Exchange, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(
                    TableColumn.CellDataFeatures<Product_Exchange, String> product) {
                return new SimpleStringProperty(product.getValue().getPrice().getBuy_price() + "");
            }
        });

        columns.add(tableColumn);

        tableColumn = new TableColumn("Quantia");
        tableColumn.setCellValueFactory(
                new PropertyValueFactory<>("amount"));

        columns.add(tableColumn);

        columns.forEach((object) -> {
            tableView.getColumns().add(object);
        });

        tableView.setItems(list_products);

        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(Cache.width * 0.0146);
        gridPane.setVgap(Cache.height * 0.0296);
        gridPane.add(nothing(), 0, 0);
        gridPane.add(label_table, 1, 1);
        gridPane.add(tableView, 1, 2, 1, 8);
        gridPane.add(label_combo_client, 2, 1);
        gridPane.add(comboBox_client, 2, 2, 2, 1);
        gridPane.add(label_combo_employee, 2, 3);
        gridPane.add(comboBox_employee, 2, 4, 2, 1);
        gridPane.add(button_cancel, 2, 5);
        gridPane.add(button_confirm, 3, 5);
        gridPane.add(nothing(), 2, 8);

        pane.getChildren().add(gridPane);
        pane.setVisible(true);

        Thread thread = new Thread(() -> {
            new Controller_Product_Sell().control(this);
        });
        thread.start();

        return pane;
    }

    public void updateTable() {
        list_products = FXCollections.observableArrayList(products);
        tableView.setItems(list_products);
    }

    public void updateComboClient() {
        list_clients = FXCollections.observableArrayList(clients);
        comboBox_client.setItems(list_clients);
    }

    public void updateComboEmployee() {
        list_employees = FXCollections.observableArrayList(employees);
        comboBox_employee.setItems(list_employees);
    }

    private Text nothing() {
        return new Text("   ");
    }

    public Pane getPane() {
        return pane;
    }

    public void setPane(Pane pane) {
        this.pane = pane;
    }

    public GridPane getGridPane() {
        return gridPane;
    }

    public void setGridPane(GridPane gridPane) {
        this.gridPane = gridPane;
    }

    public TableView<Product_Exchange> getTableView() {
        return tableView;
    }

    public void setTableView(TableView<Product_Exchange> tableView) {
        this.tableView = tableView;
    }

    public ObservableList<Product_Exchange> getList_products() {
        return list_products;
    }

    public void setList_products(ObservableList<Product_Exchange> list_products) {
        this.list_products = list_products;
    }

    public ObservableList<Person_Client> getList_clients() {
        return list_clients;
    }

    public void setList_clients(ObservableList<Person_Client> list_clients) {
        this.list_clients = list_clients;
    }

    public ObservableList<Person_Employee> getList_employees() {
        return list_employees;
    }

    public void setList_employees(ObservableList<Person_Employee> list_employees) {
        this.list_employees = list_employees;
    }

    public ComboBox getComboBox_client() {
        return comboBox_client;
    }

    public void setComboBox_client(ComboBox comboBox_client) {
        this.comboBox_client = comboBox_client;
    }

    public ComboBox getComboBox_employee() {
        return comboBox_employee;
    }

    public void setComboBox_employee(ComboBox comboBox_employee) {
        this.comboBox_employee = comboBox_employee;
    }

    public Label getLabel_table() {
        return label_table;
    }

    public void setLabel_table(Label label_table) {
        this.label_table = label_table;
    }

    public Label getLabel_combo_client() {
        return label_combo_client;
    }

    public void setLabel_combo_client(Label label_combo_client) {
        this.label_combo_client = label_combo_client;
    }

    public Label getLabel_combo_employee() {
        return label_combo_employee;
    }

    public void setLabel_combo_employee(Label label_combo_employee) {
        this.label_combo_employee = label_combo_employee;
    }

    public Button getButton_confirm() {
        return button_confirm;
    }

    public void setButton_confirm(Button button_confirm) {
        this.button_confirm = button_confirm;
    }

    public Button getButton_cancel() {
        return button_cancel;
    }

    public void setButton_cancel(Button button_cancel) {
        this.button_cancel = button_cancel;
    }

    public ArrayList<TableColumn<Product_Exchange, ?>> getColumns() {
        return columns;
    }

    public List<Product_Exchange> getProducts() {
        return products;
    }

    public List<Person_Client> getClients() {
        return clients;
    }

    public List<Person_Provider> getProviders() {
        return providers;
    }

    public List<Person_Employee> getEmployees() {
        return employees;
    }

    public void setClients(List<Person_Client> clients) {
        this.clients = clients;
    }

    public void setEmployees(List<Person_Employee> employees) {
        this.employees = employees;
    }
    
    
    
}
