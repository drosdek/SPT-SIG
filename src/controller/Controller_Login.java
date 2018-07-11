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
package controller;

import cache.Cache;
import javafx.event.ActionEvent;
import view.View_Login;

/**
 * FXML Controller class
 *
 * @author gruber
 */
public class Controller_Login {

    public Controller_Login() {
    }
    
    public static void main(String[] args) {
        View_Login view_login = new View_Login();
        Cache.getScene().setRoot(view_login.getComponent());
        
        view_login.getButton_login().setOnAction((ActionEvent e) -> {
            Controller_Main.main(args);
        });
    }
    
}
