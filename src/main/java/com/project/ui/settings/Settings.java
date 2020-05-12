package com.project.ui.settings;


import com.google.gson.Gson;
import com.project.alert.makeAlert;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Settings {
    public static final String SETTINGS_FILE = "settings.txt";
    private float finePerDay;

    public Settings() {
        finePerDay = 1;
    }

    public void setFinePerDay(float finePerDay) {
        this.finePerDay = finePerDay;
    }

    public float getFinePerDay() {
        return finePerDay;
    }

    public static void initConfig() {
        Writer writer = null;
        try {
            Settings settings = new Settings();
            Gson gson = new Gson();
            writer = new FileWriter(SETTINGS_FILE);
            gson.toJson(settings, writer);
        } catch (IOException ex) {
            Logger.getLogger(Settings.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                writer.close();
            } catch (IOException ex) {
                Logger.getLogger(Settings.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }


    public static Settings getSettings(){
        Gson gson = new Gson();
        Settings settings = new Settings();
        try {
            settings = gson.fromJson(new FileReader(SETTINGS_FILE), Settings.class);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Settings.class.getName()).info("Config file is missing. Creating new one with default config");
            initConfig();
        }
        return settings;
    }

    public static void writeSettingsToFile(Settings settings) {
        Writer writer = null;
        try {
            Gson gson = new Gson();
            writer = new FileWriter(SETTINGS_FILE);
            gson.toJson(settings, writer);

            makeAlert.showMessageAlert("Settings updated succesfully");
        } catch (IOException ex) {
            Logger.getLogger(Settings.class.getName()).log(Level.SEVERE, null, ex);
            makeAlert.showMessageAlert ("Cant save configuration file");
        } finally {
            try {
                writer.close();
            } catch (IOException ex) {
                Logger.getLogger(Settings.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
