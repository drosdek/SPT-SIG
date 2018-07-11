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

import javafx.scene.control.Button;

/**
 *
 * @author gruber
 */
public class Prototype_Button extends Button {

    public String style, style_hover;
    
    private Prototype_Button(Prototype_Button target, String title) {
        if (target != null) {
            super.setPrefSize(target.getPrefWidth(), target.getPrefHeight());
            super.setStyle(target.getStyle());
            super.setOnMouseEntered(target.getOnMouseEntered());
            super.setOnMouseExited(target.getOnMouseExited());
            super.setText(title);
            super.setOnMouseEntered((event) -> {
                super.setStyle(target.style_hover);
            });
            super.setOnMouseExited((event) -> {
                super.setStyle(target.style);
            });
        }
    }

    public Prototype_Button(String style, String style_hover, double width, double height) {
        super.setStyle(style);
        super.setPrefSize(width, height);
        this.style_hover = style_hover;
        this.style = style;
    }

    public Button clone(String title) {
        return new Prototype_Button(this, title);
    }

}
