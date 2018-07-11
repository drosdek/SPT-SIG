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
import controller.Controller_Person_Client;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import model.Person_Client;

/**
 *
 * @author gruber
 */
public class Container_Person_Client {

    private Pane pane;
    private GridPane gridPane_register, gridPane_list;
    private TableView<Person_Client> tableView;
    private final ArrayList<TableColumn<Person_Client, String>> columns = new ArrayList();
    private final List<Person_Client> clients = new ArrayList();
    private ObservableList<Person_Client> list_clients;
    private Label label_name, label_lastname, label_phone, label_cpf, label_birth;
    private TextField field_name, field_lastname, field_phone, field_cpf, field_birth;
    private Button button_confirm, button_cancel, button_register;

    public Container_Person_Client() {
    }

    public Parent getComponent() {

        pane = new Pane();

        gridPane_register = new GridPane();

        label_name = new Label("Nome");
        label_lastname = new Label("Sobrenome");
        label_phone = new Label("Telefone");
        label_cpf = new Label("CPF/CPNJ");
        label_birth = new Label("Nascimento");

        field_name = new TextField();
        field_lastname = new TextField();
        field_phone = new TextField();
        field_cpf = new TextField();
        field_birth = new TextField();

        button_cancel = Cache.getMap_buttons().get("button_cancel_small").clone("Cancelar");
        button_confirm = Cache.getMap_buttons().get("button_confirm_small").clone("Confirmar");

        gridPane_register.setAlignment(Pos.CENTER);
        gridPane_register.setHgap(Cache.width * 0.0146);
        gridPane_register.setVgap(Cache.height * 0.0296);
        gridPane_register.add(nothing(), 0, 0);
        gridPane_register.add(new Text("Formulário de Clientes"), 1, 1);
        gridPane_register.add(label_name, 1, 3);
        gridPane_register.add(field_name, 2, 3);
        gridPane_register.add(label_lastname, 4, 3);
        gridPane_register.add(field_lastname, 5, 3);
        gridPane_register.add(label_phone, 1, 5);
        gridPane_register.add(field_phone, 2, 5);
        gridPane_register.add(label_cpf, 4, 5);
        gridPane_register.add(field_cpf, 5, 5);
        gridPane_register.add(label_birth, 1, 7);
        gridPane_register.add(field_birth, 2, 7);
        gridPane_register.add(button_cancel, 4, 7);
        gridPane_register.add(button_confirm, 5, 7);

        gridPane_register.setVisible(false);
        pane.getChildren().add(gridPane_register);

        gridPane_list = new GridPane();

        tableView = new TableView();
        tableView.setPrefSize(Cache.width * 0.65, Cache.height * 0.87);

        TableColumn tableColumn = new TableColumn("Nome");
        tableColumn.setMinWidth(Cache.width * 0.127);
        tableColumn.setCellValueFactory(
                new PropertyValueFactory<>("name"));

        columns.add(tableColumn);

        tableColumn = new TableColumn("Sobrenome");
        tableColumn.setMinWidth(Cache.width * 0.127);
        tableColumn.setCellValueFactory(
                new PropertyValueFactory<>("lastname"));

        columns.add(tableColumn);

        tableColumn = new TableColumn("CPF/CNPJ");
        tableColumn.setMinWidth(Cache.width * 0.127);
        tableColumn.setCellValueFactory(
                new PropertyValueFactory<>("cpf_cnpj"));

        columns.add(tableColumn);

        tableColumn = new TableColumn("Telefone");
        tableColumn.setMinWidth(Cache.width * 0.127);
        tableColumn.setCellValueFactory(
                new PropertyValueFactory<>("phone"));

        columns.add(tableColumn);

        tableColumn = new TableColumn("Aniversário");
        tableColumn.setMinWidth(Cache.width * 0.127);
        tableColumn.setCellValueFactory(
                new PropertyValueFactory<>("birth"));

        columns.add(tableColumn);

        columns.forEach((column) -> {
            tableView.getColumns().add(column);
        });

        button_register = Cache.getMap_buttons().get("button_confirm_small").clone("Registrar");

        gridPane_list.setAlignment(Pos.CENTER);
        gridPane_list.setHgap(Cache.width * 0.0146);
        gridPane_list.setVgap(Cache.height * 0.0296);
        gridPane_list.add(nothing(), 0, 0);
        gridPane_list.add(tableView, 1, 1);
        gridPane_list.add(button_register, 2, 1);

        pane.getChildren().add(gridPane_list);
        
        Thread thread = new Thread(() -> {
            new Controller_Person_Client().control(this);
        });
        thread.start();

        return pane;
    }

    public void updateTable() {
        list_clients = FXCollections.observableArrayList(clients);
        tableView.setItems(list_clients);
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

    public GridPane getGridPane_register() {
        return gridPane_register;
    }

    public void setGridPane_register(GridPane gridPane_register) {
        this.gridPane_register = gridPane_register;
    }

    public GridPane getGridPane_list() {
        return gridPane_list;
    }

    public void setGridPane_list(GridPane gridPane_list) {
        this.gridPane_list = gridPane_list;
    }

    public TableView<Person_Client> getTableView() {
        return tableView;
    }

    public void setTableView(TableView<Person_Client> tableView) {
        this.tableView = tableView;
    }

    public ObservableList<Person_Client> getList_clients() {
        return list_clients;
    }

    public void setList_clients(ObservableList<Person_Client> list_clients) {
        this.list_clients = list_clients;
    }

    public Label getLabel_name() {
        return label_name;
    }

    public void setLabel_name(Label label_name) {
        this.label_name = label_name;
    }

    public Label getLabel_lastname() {
        return label_lastname;
    }

    public void setLabel_lastname(Label label_lastname) {
        this.label_lastname = label_lastname;
    }

    public Label getLabel_phone() {
        return label_phone;
    }

    public void setLabel_phone(Label label_phone) {
        this.label_phone = label_phone;
    }

    public Label getLabel_cpf() {
        return label_cpf;
    }

    public void setLabel_cpf(Label label_cpf) {
        this.label_cpf = label_cpf;
    }

    public Label getLabel_birth() {
        return label_birth;
    }

    public void setLabel_birth(Label label_birth) {
        this.label_birth = label_birth;
    }

    public TextField getField_name() {
        return field_name;
    }

    public void setField_name(TextField field_name) {
        this.field_name = field_name;
    }

    public TextField getField_lastname() {
        return field_lastname;
    }

    public void setField_lastname(TextField field_lastname) {
        this.field_lastname = field_lastname;
    }

    public TextField getField_phone() {
        return field_phone;
    }

    public void setField_phone(TextField field_phone) {
        this.field_phone = field_phone;
    }

    public TextField getField_cpf() {
        return field_cpf;
    }

    public void setField_cpf(TextField field_cpf) {
        this.field_cpf = field_cpf;
    }

    public TextField getField_birth() {
        return field_birth;
    }

    public void setField_birth(TextField field_birth) {
        this.field_birth = field_birth;
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

    public Button getButton_register() {
        return button_register;
    }

    public void setButton_register(Button button_register) {
        this.button_register = button_register;
    }

    public ArrayList<TableColumn<Person_Client, String>> getColumns() {
        return columns;
    }

    public List<Person_Client> getClients() {
        return clients;
    }

}
