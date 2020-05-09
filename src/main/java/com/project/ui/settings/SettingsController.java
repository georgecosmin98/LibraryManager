package com.project.ui.settings;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class SettingsController implements Initializable {

    @FXML
    private AnchorPane rootPane;

    @FXML
    private TextField finePerDay;

    @FXML
    private Button saveButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initDefaultValues();
    }
    private void initDefaultValues() {
        Settings settings = Settings.getSettings();
        finePerDay.setText(String.valueOf(settings.getFinePerDay()));
    }

    public void saveSettings(ActionEvent actionEvent) {
        float fine = Float.parseFloat(finePerDay.getText());

        Settings settings = Settings.getSettings();
        settings.setFinePerDay(fine);

        Settings.writeSettingsToFile(settings);
    }
}
