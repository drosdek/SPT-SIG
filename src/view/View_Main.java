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
import javafx.animation.AnimationTimer;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Screen;

/**
 *
 * @author gruber
 */
public class View_Main {

    private Button button_client, button_employee, button_provider,
            button_product, button_product_sale, button_product_buy,
            button_chart_person, button_chart_product, button_chart_financial;
    private HBox hbox_button_person, hbox_button_product, hbox_button_chart;
    private GridPane grid;
    private static AnchorPane pane;
    private static Pane pane_sidebar, pane_main;

    public View_Main() {
    }

    public static Parent getComponent() {

        String style_main = "-fx-background-color: #F7F7F7;";
        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();

//        grid = new GridPane();
        pane = new AnchorPane();
        pane_sidebar = Cache.getPane_sidebar();
        
        pane_main = Cache.getPane_main();
        pane_main.setPrefSize(screenBounds.getWidth() * 0.80, screenBounds.getHeight());
        pane_main.setLayoutX(screenBounds.getWidth() * 0.20);
        pane_main.setStyle(style_main);
        pane_main.getChildren().add(new Pane());

        pane.getChildren().add(0, pane_sidebar);
        pane.getChildren().add(1, pane_main);

        return pane;
    }

    public static Pane getPane_main() {
        return pane_main;
    }

    public static void setPane_main(Pane pane_main) {
        View_Main.pane_main = pane_main;
    }
    
}
