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
package component;

import cache.Cache;
import java.util.ArrayList;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Screen;
import view.Container_Chart_Order;
import view.Container_Chart_Person;
import view.Container_Chart_Product;
import view.Container_Person_Client;
import view.Container_Person_Employee;
import view.Container_Person_Provider;
import view.Container_Product;
import view.Container_Product_Buy;
import view.Container_Product_Sell;

/**
 *
 * @author gruber
 */
public class Sidebar {

    private GridPane pane;
    private ArrayList<Button_Menu> menus;
    private double width, height;

    public Sidebar() {
    }

    public Parent getComponent() {

        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
        String style
                = "-fx-background-color: #212121";

        pane = new GridPane();
        menus = new ArrayList();

        width = screenBounds.getWidth() * 0.20;
        height = screenBounds.getHeight();

        Button_Menu menu_person
                = new Button_Menu("Pessoas", Cache.style_menu, width, height * 0.10);

        menu_person.getSubmenus().add(
                new Button_Submenu(
                        "Clientes",
                        Cache.style_submenu,
                        new Container_Person_Client().getComponent(),
                        width, height * 0.07));
        menu_person.getSubmenus().add(
                new Button_Submenu(
                        "Funcionários",
                        Cache.style_submenu,
                        new Container_Person_Employee().getComponent(),
                        width, height * 0.07));
        menu_person.getSubmenus().add(
                new Button_Submenu(
                        "Fornecedores",
                        Cache.style_submenu,
                        new Container_Person_Provider().getComponent(),
                        width, height * 0.07));

        Button_Menu menu_product
                = new Button_Menu("Produtos", Cache.style_menu, width, height * 0.10);

        menu_product.getSubmenus().add(
                new Button_Submenu(
                        "Produtos",
                        Cache.style_submenu,
                        new Container_Product().getComponent(),
                        width, height * 0.07));
        menu_product.getSubmenus().add(
                new Button_Submenu(
                        "Venda Produtos",
                        Cache.style_submenu,
                        new Container_Product_Sell().getComponent(),
                        width, height * 0.07));
        menu_product.getSubmenus().add(
                new Button_Submenu(
                        "Compra Produtos",
                        Cache.style_submenu,
                        new Container_Product_Buy().getComponent(),
                        width, height * 0.07));

        Button_Menu menu_chart
                = new Button_Menu("Gráficos", Cache.style_menu, width, height * 0.10);

        menu_chart.getSubmenus().add(
                new Button_Submenu(
                        "Pessoas",
                        Cache.style_submenu,
                        new Container_Chart_Person().getComponent(),
                        width, height * 0.07));
        menu_chart.getSubmenus().add(
                new Button_Submenu(
                        "Produtos",
                        Cache.style_submenu,
                        new Container_Chart_Product().getComponent(),
                        width, height * 0.07));
        menu_chart.getSubmenus().add(
                new Button_Submenu(
                        "Financeiro",
                        Cache.style_submenu,
                        new Container_Chart_Order().getComponent(),
                        width, height * 0.07));

        menus.add(menu_person);
        menus.add(menu_product);
        menus.add(menu_chart);

        pane.setPrefSize(screenBounds.getWidth() * 0.20, screenBounds.getHeight());
        pane.setStyle(style);

        for (int y = 0; y < menus.size(); y++) {
            pane.add(menus.get(y).getComponent(), 0, y);
        }

        return pane;
    }
}
