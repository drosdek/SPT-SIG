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
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import view.View_Main;

/**
 *
 * @author gruber
 */
public class Button_Submenu {

    private String title, style;
    private Parent pane;
    private Pane container;
    private Button button;
    private double width;
    private EventHandler<ActionEvent> event;

    public Button_Submenu() {
    }

    public Button_Submenu(String title, String style, Parent pane, double width, double height) {
        this.title = title;
        this.style = style;
        this.pane = pane;
        this.event = (ActionEvent event) -> {
            View_Main.getPane_main().getChildren().remove(0);
            View_Main.getPane_main().getChildren().add( 0,pane);
        };
        this.button = new Button(title);
        this.button.setStyle(style);
        this.button.setPrefSize(width, height);
        this.button.setOnAction(event);
    }

    public Pane getComponent() {
        container = new Pane();
        button.setOnMouseEntered(e -> button.setStyle(Cache.style_submenu_hover));
        button.setOnMouseExited(e -> button.setStyle(Cache.style_submenu));
        container.getChildren().add(button);
        return container;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public Parent getPane() {
        return pane;
    }

    public void setPane(Pane pane) {
        this.pane = pane;
    }

    public Button getButton() {
        return button;
    }

    public void setButton(Button button) {
        this.button = button;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

}
