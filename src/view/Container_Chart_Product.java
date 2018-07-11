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
import java.util.ArrayList;
import java.util.List;
import javafx.collections.ObservableList;
import javafx.scene.Parent;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import model.Product;

/**
 *
 * @author gruber
 */
public class Container_Chart_Product {

    private ScrollPane scrollPane;
    private GridPane gridPane;
    private AreaChart areaChart_records, areaChart_stock, areaChart_price;
    private BarChart barChart_stock, barChart_price;
    private CategoryAxis categoryAxis_areaChart_records, categoryAxis_areaChart_stock, categoryAxis_areaChart_price,
            categoryAxis_barChart_stock, categoryAxis_barChart_price;
    private NumberAxis numberAxis_areaChart_records, numberAxis_areaChart_stock, numberAxis_areaChart_price,
            numberAxis_barChart_stock, numberAxis_barChart_price;
    private XYChart.Series dataSeries_areaChart_records, dataSeries_areaChart_stock, dataSeries_areaChart_price,
            dataSeries_barChart_stock, dataSeries_barChart_price;
    private ComboBox combo_areaChart_records, combo_areaChart_stock, combo_areaChart_price,
            combo_barChart_stock, combo_barChart_price;
    private Label label_areaChart_records, label_areaChart_stock, label_areaChart_price,
            label_barChart_stock, label_barChart_price;
    private final List<Product> products = new ArrayList();
    private ObservableList<Product> list_products;

    public Parent getComponent() {

        scrollPane = new ScrollPane();

        gridPane = new GridPane();

        label_areaChart_price = new Label("Produto");
        label_areaChart_records = new Label("Produto");
        label_areaChart_stock = new Label("Produto");
        label_barChart_price = new Label("Data");
        label_barChart_stock = new Label("Data");

        combo_areaChart_price = new ComboBox(list_products);
        combo_areaChart_records = new ComboBox(list_products);
        combo_areaChart_stock = new ComboBox(list_products);
        combo_barChart_price = new ComboBox(list_products);
        combo_barChart_stock = new ComboBox(list_products);

        categoryAxis_areaChart_price = new CategoryAxis();
        categoryAxis_areaChart_price.setLabel("Tempo");
        categoryAxis_areaChart_records = new CategoryAxis();
        categoryAxis_areaChart_records.setLabel("Tempo");
        categoryAxis_areaChart_stock = new CategoryAxis();
        categoryAxis_areaChart_stock.setLabel("Tempo");
        categoryAxis_barChart_price = new CategoryAxis();
        categoryAxis_barChart_price.setLabel("Produto");
        categoryAxis_barChart_stock = new CategoryAxis();
        categoryAxis_barChart_stock.setLabel("Produto");

        numberAxis_areaChart_price = new NumberAxis();
        numberAxis_areaChart_price.setLabel("Quantia");
        numberAxis_areaChart_records = new NumberAxis();
        numberAxis_areaChart_records.setLabel("Quantia");
        numberAxis_areaChart_stock = new NumberAxis();
        numberAxis_areaChart_stock.setLabel("Quantia");
        numberAxis_barChart_price = new NumberAxis();
        numberAxis_barChart_price.setLabel("Valor");
        numberAxis_barChart_stock = new NumberAxis();
        numberAxis_barChart_stock.setLabel("Quantia");

        dataSeries_areaChart_price = new XYChart.Series();
        dataSeries_areaChart_records = new XYChart.Series();
        dataSeries_areaChart_stock = new XYChart.Series();
        dataSeries_barChart_price = new XYChart.Series();
        dataSeries_barChart_stock = new XYChart.Series();

        areaChart_price = new AreaChart(categoryAxis_areaChart_price, numberAxis_areaChart_price);
        areaChart_price.setTitle("Preços");
        areaChart_price.getData().add(dataSeries_areaChart_price);
        areaChart_price.setLegendVisible(false);
        areaChart_price.setPrefSize(Cache.width * 0.60, Cache.height * 0.87);

        areaChart_records = new AreaChart(categoryAxis_areaChart_records, numberAxis_areaChart_records);
        areaChart_records.setTitle("Cadastros");
        areaChart_records.getData().add(dataSeries_areaChart_records);
        areaChart_records.setLegendVisible(false);
        areaChart_records.setPrefSize(Cache.width * 0.60, Cache.height * 0.87);

        areaChart_stock = new AreaChart(categoryAxis_areaChart_stock, numberAxis_areaChart_stock);
        areaChart_stock.setTitle("Estoque");
        areaChart_stock.getData().add(dataSeries_areaChart_stock);
        areaChart_stock.setLegendVisible(false);
        areaChart_stock.setPrefSize(Cache.width * 0.60, Cache.height * 0.87);

        barChart_price = new BarChart(categoryAxis_barChart_price, numberAxis_barChart_price);
        barChart_price.setTitle("Preços");
        barChart_price.getData().add(dataSeries_barChart_price);
        barChart_price.setLegendVisible(false);
        barChart_price.setPrefSize(Cache.width * 0.60, Cache.height * 0.87);

        barChart_stock = new BarChart(categoryAxis_barChart_stock, numberAxis_barChart_stock);
        barChart_stock.setTitle("Estoque");
        barChart_stock.getData().add(dataSeries_barChart_stock);
        barChart_stock.setLegendVisible(false);
        barChart_stock.setPrefSize(Cache.width * 0.60, Cache.height * 0.87);

        gridPane.add(nothing(), 0, 0);
        gridPane.add(nothing(), 4, 0);
        gridPane.add(areaChart_records, 1, 1, 1, 3);
        gridPane.add(label_areaChart_records, 2, 1);
        gridPane.add(combo_areaChart_records, 2, 2, 2, 1);
        gridPane.add(nothing(), 2, 3);
        gridPane.add(nothing(), 0, 4);
        gridPane.add(areaChart_price, 1, 5, 1, 3);
        gridPane.add(label_areaChart_price, 2, 5);
        gridPane.add(combo_areaChart_price, 2, 6, 2, 1);
        gridPane.add(nothing(), 2, 7);
        gridPane.add(nothing(), 0, 8);
        gridPane.add(areaChart_stock, 1, 8, 1, 3);
        gridPane.add(label_areaChart_stock, 2, 8);
        gridPane.add(combo_areaChart_stock, 2, 9, 2, 1);
        gridPane.add(nothing(), 2, 10);
        gridPane.add(nothing(), 0, 11);
        gridPane.add(barChart_price, 1, 12, 1, 3);
        gridPane.add(label_barChart_price, 2, 12);
        gridPane.add(combo_barChart_price, 2, 13, 2, 1);
        gridPane.add(nothing(), 2, 14);
        gridPane.add(nothing(), 0, 15);
        gridPane.add(barChart_stock, 1, 16, 1, 3);
        gridPane.add(label_barChart_stock, 2, 16);
        gridPane.add(combo_barChart_stock, 2, 17, 2, 1);

        scrollPane.setContent(gridPane);
        scrollPane.setPrefSize(Cache.width * 0.80, Cache.height);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scrollPane.setVisible(true);

        return scrollPane;
    }

    private Text nothing() {
        return new Text("   ");
    }

}
