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
public class Container_Chart_Order {
    
    private ScrollPane scrollPane;
    private GridPane gridPane;
    private AreaChart areaChart_sell, areaChart_buy;
    private CategoryAxis categoryAxis_areaChart_sell, categoryAxis_areaChart_buy;
    private NumberAxis numberAxis_areaChart_sell, numberAxis_areaChart_buy;
    private XYChart.Series dataSeries_areaChart_sell, dataSeries_areaChart_buy;
    private ComboBox combo_areaChart_buy, combo_areaChart_sell;
    private Label label_areaChart_buy, label_areaChart_sell;
    private final List<Product> products = new ArrayList();
    private ObservableList<Product> list_products;

    public Parent getComponent() {

        scrollPane = new ScrollPane();

        gridPane = new GridPane();

        label_areaChart_buy = new Label("Produto");
        label_areaChart_sell = new Label("Produto");

        combo_areaChart_buy = new ComboBox(list_products);
        combo_areaChart_sell = new ComboBox(list_products);

        categoryAxis_areaChart_sell = new CategoryAxis();
        categoryAxis_areaChart_sell.setLabel("Tempo");
        categoryAxis_areaChart_buy = new CategoryAxis();
        categoryAxis_areaChart_buy.setLabel("Tempo");

        numberAxis_areaChart_sell = new NumberAxis();
        numberAxis_areaChart_sell.setLabel("Quantia");
        numberAxis_areaChart_buy = new NumberAxis();
        numberAxis_areaChart_buy.setLabel("Quantia");

        dataSeries_areaChart_sell = new XYChart.Series();
        dataSeries_areaChart_buy = new XYChart.Series();


        areaChart_sell = new AreaChart(categoryAxis_areaChart_sell, numberAxis_areaChart_sell);
        areaChart_sell.setTitle("Cadastros");
        areaChart_sell.getData().add(dataSeries_areaChart_sell);
        areaChart_sell.setLegendVisible(false);
        areaChart_sell.setPrefSize(Cache.width * 0.60, Cache.height * 0.87);

        areaChart_buy = new AreaChart(categoryAxis_areaChart_buy, numberAxis_areaChart_buy);
        areaChart_buy.setTitle("Estoque");
        areaChart_buy.getData().add(dataSeries_areaChart_buy);
        areaChart_buy.setLegendVisible(false);
        areaChart_buy.setPrefSize(Cache.width * 0.60, Cache.height * 0.87);

        gridPane.add(nothing(), 0, 0);
        gridPane.add(nothing(), 4, 0);
        gridPane.add(areaChart_sell, 1, 1, 1, 3);
        gridPane.add(label_areaChart_buy, 2, 1);
        gridPane.add(combo_areaChart_buy, 2, 2, 2, 1);
        gridPane.add(nothing(), 2, 3);
        gridPane.add(nothing(), 0, 4);
        gridPane.add(areaChart_buy, 1, 5, 1, 3);
        gridPane.add(label_areaChart_sell, 2, 5);
        gridPane.add(combo_areaChart_sell, 2, 6, 2, 1);
        gridPane.add(nothing(), 2, 7);
        
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
