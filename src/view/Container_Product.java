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
import controller.Controller_Product;
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
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.util.Callback;
import model.Product;
import model.Product_Model_Default;
import model.Product_Price;
import model.Product_Stock;

/**
 *
 * @author gruber
 */
public class Container_Product {

    private Pane pane;
    private GridPane gridPane_register, gridPane_list, gridPane_stock, gridPane_price;
    private Label label_name, label_description, label_image, label_model,
            label_stock_amount, label_price_buy, label_price_sell;
    private TextField field_name, field_description, field_image,
            field_stock_amount, field_price_buy, field_price_sell;
    private ComboBox<Product_Model_Default> combo_model;
    private Button button_register_cancel, button_register_confirm, button_register,
            button_stock, button_stock_cancel, button_stock_confirm,
            button_price, button_price_cancel, button_price_confirm;
    private TableView<Product> tableView_product;
    private TableView<Product_Stock> tableView_stock;
    private TableView<Product_Price> tableView_price;
    private final ArrayList<TableColumn<Product, String>> columns_product = new ArrayList();
    private final ArrayList<TableColumn<Product_Stock, String>> columns_stock = new ArrayList();
    private final ArrayList<TableColumn<Product_Price, String>> columns_price = new ArrayList();
    private List<Product> products = new ArrayList();
    private List<Product_Stock> stocks = new ArrayList();
    private List<Product_Price> prices = new ArrayList();
    private List<Product_Model_Default> models = new ArrayList();
    private ObservableList<Product> list_products;
    private ObservableList<Product_Stock> list_stocks;
    private ObservableList<Product_Price> list_prices;
    private ObservableList<Product_Model_Default> list_models;

    public Container_Product() {
    }

    public Parent getComponent() {

        pane = new Pane();

        gridPane_register = new GridPane();

        label_name = new Label("Nome");
        label_description = new Label("Descrição");
        label_image = new Label("Imagem");
        label_model = new Label("Modelo");
        label_stock_amount = new Label("Quantia");
        label_price_buy = new Label("Preço de compra");
        label_price_sell = new Label("Preço de venda");

        field_name = new TextField();
        field_description = new TextField();
        field_image = new TextField();
        field_stock_amount = new TextField();
        field_price_buy = new TextField();
        field_price_sell = new TextField();

        combo_model = new ComboBox(list_models);

        button_register_cancel = Cache.getMap_buttons().get("button_cancel_small").clone("Cancelar");
        button_register_confirm = Cache.getMap_buttons().get("button_confirm_small").clone("Confirmar");
        button_register = Cache.getMap_buttons().get("button_confirm_small").clone("Registrar");
        button_price_cancel = Cache.getMap_buttons().get("button_cancel_small").clone("Cancelar");
        button_price_confirm = Cache.getMap_buttons().get("button_confirm_small").clone("Confirmar");
        button_price = Cache.getMap_buttons().get("button_confirm_small").clone("Preço");
        button_price.setVisible(false);
        button_stock_cancel = Cache.getMap_buttons().get("button_cancel_small").clone("Cancelar");
        button_stock_confirm = Cache.getMap_buttons().get("button_confirm_small").clone("Confirmar");
        button_stock = Cache.getMap_buttons().get("button_confirm_small").clone("Estoque");
        button_stock.setVisible(false);

        gridPane_register.setAlignment(Pos.CENTER);
        gridPane_register.setHgap(Cache.width * 0.0146);
        gridPane_register.setVgap(Cache.height * 0.0296);
        gridPane_register.add(nothing(), 0, 0);
        gridPane_register.add(new Text("Formulário de Produto"), 1, 1);
        gridPane_register.add(label_name, 1, 3);
        gridPane_register.add(field_name, 2, 3);
        gridPane_register.add(label_description, 4, 3);
        gridPane_register.add(field_description, 5, 3);
        gridPane_register.add(label_image, 1, 5);
        gridPane_register.add(field_image, 2, 5);
        gridPane_register.add(label_model, 4, 5);
        gridPane_register.add(combo_model, 5, 5);
        gridPane_register.add(button_register_cancel, 1, 7);
        gridPane_register.add(button_register_confirm, 2, 7);
        gridPane_register.setVisible(false);

        pane.getChildren().add(gridPane_register);

        gridPane_stock = new GridPane();

        tableView_stock = new TableView();
        tableView_stock.setPrefSize(Cache.width * 0.60, Cache.height * 0.87);

        TableColumn tableColumn = new TableColumn("Quantia");
        tableColumn.setCellValueFactory(
                new PropertyValueFactory("amount")
        );

        columns_stock.add(tableColumn);

        tableColumn = new TableColumn("Data");
        tableColumn.setCellValueFactory(
                new PropertyValueFactory("date")
        );

        columns_stock.add(tableColumn);

        columns_stock.forEach((object) -> {
            tableView_stock.getColumns().add(object);
        });

        tableView_stock.setItems(list_stocks);

        gridPane_stock.setAlignment(Pos.CENTER);
        gridPane_stock.setHgap(Cache.width * 0.0146);
        gridPane_stock.setVgap(Cache.height * 0.0296);
        gridPane_stock.add(nothing(), 0, 0);
        gridPane_stock.add(label_stock_amount, 2, 1);
        gridPane_stock.add(tableView_stock, 1, 1, 1, 4);
        gridPane_stock.add(field_stock_amount, 2, 2, 2, 1);
        gridPane_stock.add(button_stock_cancel, 2, 3);
        gridPane_stock.add(button_stock_confirm, 3, 3);
        gridPane_stock.add(nothing(), 3, 4);
        gridPane_stock.setVisible(false);

        pane.getChildren().add(gridPane_stock);

        gridPane_price = new GridPane();

        tableView_price = new TableView();
        tableView_price.setPrefSize(Cache.width * 0.60, Cache.height * 0.87);

        tableColumn = new TableColumn("Preço de compra");
        tableColumn.setCellValueFactory(
                new PropertyValueFactory<>("buy_price")
        );

        columns_price.add(tableColumn);

        tableColumn = new TableColumn("Preço de venda");
        tableColumn.setCellValueFactory(
                new PropertyValueFactory<>("sell_price")
        );

        columns_price.add(tableColumn);

        tableColumn = new TableColumn("Data");
        tableColumn.setCellValueFactory(
                new PropertyValueFactory<>("date")
        );

        columns_price.add(tableColumn);

        columns_price.forEach((object) -> {
            tableView_price.getColumns().add(object);
        });

        tableView_price.setItems(list_prices);

        gridPane_price.setAlignment(Pos.CENTER);
        gridPane_price.setHgap(Cache.width * 0.0146);
        gridPane_price.setVgap(Cache.height * 0.0296);
        gridPane_price.add(nothing(), 0, 0);
        gridPane_price.add(label_price_buy, 2, 1);
        gridPane_price.add(tableView_price, 1, 1, 1, 6);
        gridPane_price.add(field_price_buy, 2, 2, 2, 1);
        gridPane_price.add(label_price_sell, 2, 3);
        gridPane_price.add(field_price_sell, 2, 4, 2, 1);
        gridPane_price.add(button_price_cancel, 2, 5);
        gridPane_price.add(button_price_confirm, 3, 5);
        gridPane_price.add(nothing(), 3, 6);
        gridPane_price.setVisible(false);

        pane.getChildren().add(gridPane_price);

        gridPane_list = new GridPane();

        tableView_product = new TableView();
        tableView_product.setPrefSize(Cache.width * 0.65, Cache.height * 0.87);

        tableColumn = new TableColumn("Nome");
        tableColumn.setCellValueFactory(
                new PropertyValueFactory<>("name"));

        columns_product.add(tableColumn);

        tableColumn = new TableColumn("Descrição");
        tableColumn.setCellValueFactory(
                new PropertyValueFactory<>("description"));

        columns_product.add(tableColumn);

        tableColumn = new TableColumn("Modelo");
        tableColumn.setCellValueFactory(new Callback<CellDataFeatures<Product, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(CellDataFeatures<Product, String> product) {
                return new SimpleStringProperty(product.getValue().getModel().getName());
            }
        });

        columns_product.add(tableColumn);

        columns_product.forEach((object) -> {
            tableView_product.getColumns().add(object);
        });

        tableView_product.setItems(list_products);

        gridPane_list.setAlignment(Pos.CENTER);
        gridPane_list.setHgap(Cache.width * 0.0146);
        gridPane_list.setVgap(Cache.height * 0.0296);
        gridPane_list.add(nothing(), 0, 0);
        gridPane_list.add(button_register, 2, 1);
        gridPane_list.add(tableView_product, 1, 1, 1, 4);
        gridPane_list.add(button_stock, 2, 2);
        gridPane_list.add(button_price, 2, 3);
        gridPane_list.add(nothing(), 2, 4);

        pane.getChildren().add(gridPane_list);

        pane.setVisible(true);

        Thread thread = new Thread(() -> {
            new Controller_Product().control(this);
        });
        thread.start();

        return pane;
    }

    public void updateTableProduct() {
        list_products = FXCollections.observableArrayList(products);
        tableView_product.setItems(list_products);
    }

    public void updateTableStock() {
        list_stocks = FXCollections.observableArrayList(stocks);
        tableView_stock.setItems(list_stocks);
    }

    public void updateTablePrice() {
        list_prices = FXCollections.observableArrayList(prices);
        tableView_price.setItems(list_prices);
    }

    public void updateComboModel() {
        list_models = FXCollections.observableArrayList(models);
        combo_model.setItems(list_models);
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

    public GridPane getGridPane_stock() {
        return gridPane_stock;
    }

    public void setGridPane_stock(GridPane gridPane_stock) {
        this.gridPane_stock = gridPane_stock;
    }

    public GridPane getGridPane_price() {
        return gridPane_price;
    }

    public void setGridPane_price(GridPane gridPane_price) {
        this.gridPane_price = gridPane_price;
    }

    public Label getLabel_name() {
        return label_name;
    }

    public void setLabel_name(Label label_name) {
        this.label_name = label_name;
    }

    public Label getLabel_description() {
        return label_description;
    }

    public void setLabel_description(Label label_description) {
        this.label_description = label_description;
    }

    public Label getLabel_image() {
        return label_image;
    }

    public void setLabel_image(Label label_image) {
        this.label_image = label_image;
    }

    public Label getLabel_model() {
        return label_model;
    }

    public void setLabel_model(Label label_model) {
        this.label_model = label_model;
    }

    public Label getLabel_stock_amount() {
        return label_stock_amount;
    }

    public void setLabel_stock_amount(Label label_stock_amount) {
        this.label_stock_amount = label_stock_amount;
    }

    public Label getLabel_price_buy() {
        return label_price_buy;
    }

    public void setLabel_price_buy(Label label_price_buy) {
        this.label_price_buy = label_price_buy;
    }

    public Label getLabel_price_sell() {
        return label_price_sell;
    }

    public void setLabel_price_sell(Label label_price_sell) {
        this.label_price_sell = label_price_sell;
    }

    public TextField getField_name() {
        return field_name;
    }

    public void setField_name(TextField field_name) {
        this.field_name = field_name;
    }

    public TextField getField_description() {
        return field_description;
    }

    public void setField_description(TextField field_description) {
        this.field_description = field_description;
    }

    public TextField getField_image() {
        return field_image;
    }

    public void setField_image(TextField field_image) {
        this.field_image = field_image;
    }

    public TextField getField_stock_amount() {
        return field_stock_amount;
    }

    public void setField_stock_amount(TextField field_stock_amount) {
        this.field_stock_amount = field_stock_amount;
    }

    public TextField getField_price_buy() {
        return field_price_buy;
    }

    public void setField_price_buy(TextField field_price_buy) {
        this.field_price_buy = field_price_buy;
    }

    public TextField getField_price_sell() {
        return field_price_sell;
    }

    public void setField_price_sell(TextField field_price_sell) {
        this.field_price_sell = field_price_sell;
    }

    public Button getButton_register_cancel() {
        return button_register_cancel;
    }

    public void setButton_register_cancel(Button button_register_cancel) {
        this.button_register_cancel = button_register_cancel;
    }

    public Button getButton_register_confirm() {
        return button_register_confirm;
    }

    public void setButton_register_confirm(Button button_register_confirm) {
        this.button_register_confirm = button_register_confirm;
    }

    public Button getButton_register() {
        return button_register;
    }

    public void setButton_register(Button button_register) {
        this.button_register = button_register;
    }

    public Button getButton_stock() {
        return button_stock;
    }

    public void setButton_stock(Button button_stock) {
        this.button_stock = button_stock;
    }

    public Button getButton_stock_cancel() {
        return button_stock_cancel;
    }

    public void setButton_stock_cancel(Button button_stock_cancel) {
        this.button_stock_cancel = button_stock_cancel;
    }

    public Button getButton_stock_confirm() {
        return button_stock_confirm;
    }

    public void setButton_stock_confirm(Button button_stock_confirm) {
        this.button_stock_confirm = button_stock_confirm;
    }

    public Button getButton_price() {
        return button_price;
    }

    public void setButton_price(Button button_price) {
        this.button_price = button_price;
    }

    public Button getButton_price_cancel() {
        return button_price_cancel;
    }

    public void setButton_price_cancel(Button button_price_cancel) {
        this.button_price_cancel = button_price_cancel;
    }

    public Button getButton_price_confirm() {
        return button_price_confirm;
    }

    public void setButton_price_confirm(Button button_price_confirm) {
        this.button_price_confirm = button_price_confirm;
    }

    public TableView<Product> getTableView_product() {
        return tableView_product;
    }

    public void setTableView_product(TableView<Product> tableView_product) {
        this.tableView_product = tableView_product;
    }

    public TableView<Product_Stock> getTableView_stock() {
        return tableView_stock;
    }

    public void setTableView_stock(TableView<Product_Stock> tableView_stock) {
        this.tableView_stock = tableView_stock;
    }

    public TableView<Product_Price> getTableView_price() {
        return tableView_price;
    }

    public void setTableView_price(TableView<Product_Price> tableView_price) {
        this.tableView_price = tableView_price;
    }

    public ObservableList<Product> getList_products() {
        return list_products;
    }

    public void setList_products(ObservableList<Product> list_products) {
        this.list_products = list_products;
    }

    public ObservableList<Product_Stock> getList_stocks() {
        return list_stocks;
    }

    public void setList_stocks(ObservableList<Product_Stock> list_stocks) {
        this.list_stocks = list_stocks;
    }

    public ObservableList<Product_Price> getList_prices() {
        return list_prices;
    }

    public void setList_prices(ObservableList<Product_Price> list_prices) {
        this.list_prices = list_prices;
    }

    public ArrayList<TableColumn<Product, String>> getColumns_product() {
        return columns_product;
    }

    public ArrayList<TableColumn<Product_Stock, String>> getColumns_stock() {
        return columns_stock;
    }

    public ArrayList<TableColumn<Product_Price, String>> getColumns_price() {
        return columns_price;
    }

    public List<Product> getProducts() {
        return products;
    }

    public List<Product_Stock> getStocks() {
        return stocks;
    }

    public List<Product_Price> getPrices() {
        return prices;
    }

    public List<Product_Model_Default> getModels() {
        return models;
    }

    public void setModels(List<Product_Model_Default> models) {
        this.models = models;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void setStocks(List<Product_Stock> stocks) {
        this.stocks = stocks;
    }

    public void setPrices(List<Product_Price> prices) {
        this.prices = prices;
    }

    public ComboBox getCombo_model() {
        return combo_model;
    }

    public void setCombo_model(ComboBox combo_model) {
        this.combo_model = combo_model;
    }

    public ObservableList<Product_Model_Default> getList_models() {
        return list_models;
    }

    public void setList_models(ObservableList<Product_Model_Default> list_models) {
        this.list_models = list_models;
    }

}
