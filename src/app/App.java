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
package app;

import cache.Cache;
import component.Prototype_Button;
import controller.Controller_Login;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 *
 * @author gruber
 */
public class App extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("SPT & SIG");
        stage.setScene(Cache.getScene());
        stage.sizeToScene();
        stage.centerOnScreen();
        stage.setMaximized(true);
        stage.getScene().rootProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println("Obs:" + observable + "\n oV: " + oldValue + "\n nV: " + newValue);
        });
        setUserAgentStylesheet(STYLESHEET_MODENA);
        stage.show();
    }

    public static void main(String... args) {

        Thread thread = new Thread(() -> {
            Controller_Login.main(args);
        });
        Cache.setScene(new Scene(new GridPane()));

        thread.start();

        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
        Cache.width = screenBounds.getWidth();
        Cache.height = screenBounds.getHeight();
        
        Cache.getMap_buttons().put("button_confirm_small",
                new Prototype_Button(
                        "  -fx-background-color: #0093FF;"
                        + "-fx-border-color: #0073DD;"
                        + "-fx-border-width: 0.5 0 0 0;"
                        + "-fx-cursor: hand;"
                        + "-fx-font-size: 12;"
                        + "-fx-font-style: normal;"
                        + "-fx-font-family: Noto Sans;"
                        + "-fx-text-fill: #F1F1F1;"
                        + "-fx-alignment: CENTER;",
                        " -fx-background-color: #10A3FF;"
                        + "-fx-border-color: #0073DD;"
                        + "-fx-border-width: 0.5 0 0 0;"
                        + "-fx-cursor: hand;"
                        + "-fx-font-size: 12;"
                        + "-fx-font-style: normal;"
                        + "-fx-font-family: Noto Sans;"
                        + "-fx-text-fill: #F1F1F1;"
                        + "-fx-alignment: CENTER;",
                        Cache.width * 0.0585,
                        Cache.height * 0.0269));

        Cache.getMap_buttons().put("button_confirm_medium",
                new Prototype_Button(
                        "  -fx-background-color: #0093FF;"
                        + "-fx-border-color: #0073DD;"
                        + "-fx-border-width: 0.5 0 0 0;"
                        + "-fx-cursor: hand;"
                        + "-fx-font-size: 12;"
                        + "-fx-font-style: normal;"
                        + "-fx-font-family: Noto Sans;"
                        + "-fx-text-fill: #F1F1F1;"
                        + "-fx-alignment: CENTER;",
                        "  -fx-background-color: #10A3FF;"
                        + "-fx-border-color: #0073DD;"
                        + "-fx-border-width: 0.5 0 0 0;"
                        + "-fx-cursor: hand;"
                        + "-fx-font-size: 12;"
                        + "-fx-font-style: normal;"
                        + "-fx-font-family: Noto Sans;"
                        + "-fx-text-fill: #F1F1F1;"
                        + "-fx-alignment: CENTER;",
                        Cache.width * 0.1,
                        Cache.height * 0.0269));

        Cache.getMap_buttons().put("button_confirm_large",
                new Prototype_Button(
                        "  -fx-background-color: #0093FF;"
                        + "-fx-border-color: #0073DD;"
                        + "-fx-border-width: 0.5 0 0 0;"
                        + "-fx-cursor: hand;"
                        + "-fx-font-size: 12;"
                        + "-fx-font-style: normal;"
                        + "-fx-font-family: Noto Sans;"
                        + "-fx-text-fill: #F1F1F1;"
                        + "-fx-alignment: CENTER;",
                        "  -fx-background-color: #10A3FF;"
                        + "-fx-border-color: #0073DD;"
                        + "-fx-border-width: 0.5 0 0 0;"
                        + "-fx-cursor: hand;"
                        + "-fx-font-size: 12;"
                        + "-fx-font-style: normal;"
                        + "-fx-font-family: Noto Sans;"
                        + "-fx-text-fill: #F1F1F1;"
                        + "-fx-alignment: CENTER;",
                        Cache.width * 0.15,
                        Cache.height * 0.0269));

        Cache.getMap_buttons().put("button_cancel_small",
                new Prototype_Button(
                        "  -fx-background-color: #D1D1D1;"
                        + "-fx-cursor: hand;"
                        + "-fx-font-size: 12;"
                        + "-fx-font-style: normal;"
                        + "-fx-font-family: Noto Sans;"
                        + "-fx-text-fill: #212121;"
                        + "-fx-alignment: CENTER;",
                        "  -fx-background-color: #E1E1E1;"
                        + "-fx-cursor: hand;"
                        + "-fx-font-size: 12;"
                        + "-fx-font-style: normal;"
                        + "-fx-font-family: Noto Sans;"
                        + "-fx-text-fill: #212121;"
                        + "-fx-alignment: CENTER;",
                        Cache.width * 0.0585,
                        Cache.height * 0.0269));

        launch(args);
    }

}
