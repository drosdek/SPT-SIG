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
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

/**
 *
 * @author gruber
 */
public class Button_Menu {
    
    private String title, style;
    private ArrayList<Button_Submenu> submenus;
    private Button button;
    private double width, height;
    private GridPane container;
    private boolean active = false;
    
    public Button_Menu() {
    }
    
    public Button_Menu(String title, String style, double width, double height) {
        this.title = title;
        this.style = style;
        this.width = width;
        this.height = height;
        this.button = new Button(title);
        this.button.setStyle(style);
        this.button.setPrefSize(width, height);
        this.submenus = new ArrayList();
    }
    
    public Pane getComponent() {
        container = new GridPane();
        
        container.getChildren().add(button);
        button.setOnAction((event) -> {
            active = !active;
            if (active) {
                button.setStyle(Cache.style_menu_hover);
                for (int y = 0; y < submenus.size(); y++) {
                    submenus.get(y).getComponent().setVisible(true);
                    container.add(submenus.get(y).getComponent(), 0, y + 1);
                }
            } else {
                button.setStyle(Cache.style_menu);
                for (int y = 0; y < submenus.size(); y++) {
                    submenus.get(y).getComponent().setVisible(false);
                }
            }
        });
        
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
    
    public ArrayList<Button_Submenu> getSubmenus() {
        return submenus;
    }
    
    public void setSubmenus(ArrayList<Button_Submenu> submenus) {
        this.submenus = submenus;
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
    
    public double getHeight() {
        return height;
    }
    
    public void setHeight(double height) {
        this.height = height;
    }
    
    public Pane getPane() {
        return container;
    }
    
    public void setPane(GridPane pane) {
        this.container = pane;
    }
    
    public boolean isActive() {
        return active;
    }
    
    public void setActive(boolean active) {
        this.active = active;
    }
    
}
