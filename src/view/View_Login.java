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
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.Parent;

/**
 *
 * @author gruber
 */
public class View_Login {

    private GridPane grid;
    private Text text_sceneTitle;
    private Label label_userName, label_password;
    private TextField tField_userName;
    private PasswordField pField_password;
    private Button button_login;
    private HBox hBox_button;
    private Text text_alert;

    public View_Login() {
    }

    public Parent getComponent() {

        grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        text_sceneTitle = new Text("Bem Vindo");
        text_sceneTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(text_sceneTitle, 0, 0, 2, 1);

        label_userName = new Label("Usuário:");
        grid.add(label_userName, 0, 1);

        tField_userName = new TextField();
        grid.add(tField_userName, 1, 1);

        label_password = new Label("Senha:");
        grid.add(label_password, 0, 2);

        pField_password = new PasswordField();
        grid.add(pField_password, 1, 2);

        button_login = Cache.getMap_buttons().get("button_confirm_small").clone("Logar");
        hBox_button = new HBox(10);
        hBox_button.setAlignment(Pos.BOTTOM_RIGHT);
        hBox_button.getChildren().add(button_login);
        grid.add(hBox_button, 1, 4);

        text_alert = new Text();
        grid.add(text_alert, 1, 6);

        return grid;
    }

    public GridPane getGrid() {
        return grid;
    }

    public void setGrid(GridPane grid) {
        this.grid = grid;
    }

    public Text getText_sceneTitle() {
        return text_sceneTitle;
    }

    public void setText_sceneTitle(Text text_sceneTitle) {
        this.text_sceneTitle = text_sceneTitle;
    }

    public Label getLabel_userName() {
        return label_userName;
    }

    public void setLabel_userName(Label label_userName) {
        this.label_userName = label_userName;
    }

    public Label getLabel_password() {
        return label_password;
    }

    public void setLabel_password(Label label_password) {
        this.label_password = label_password;
    }

    public TextField gettField_userName() {
        return tField_userName;
    }

    public void settField_userName(TextField tField_userName) {
        this.tField_userName = tField_userName;
    }

    public PasswordField getpField_password() {
        return pField_password;
    }

    public void setpField_password(PasswordField pField_password) {
        this.pField_password = pField_password;
    }

    public Button getButton_login() {
        return button_login;
    }

    public void setButton_login(Button button_login) {
        this.button_login = button_login;
    }

    public HBox gethBox_button() {
        return hBox_button;
    }

    public void sethBox_button(HBox hBox_button) {
        this.hBox_button = hBox_button;
    }

    public Text getText_alert() {
        return text_alert;
    }

    public void setText_alert(Text text_alert) {
        this.text_alert = text_alert;
    }

}
