package com.project.ui.settings;


import com.google.gson.Gson;
import com.project.alert.makeAlert;

import java.io.*;
import java.util.logging.Logger;

public class Settings {
    public static final String SETTINGS_FILE = "settings.txt";
    private float finePerDay;

    private static Logger logger;

    static {
        System.setProperty("java.util.logging.config.file",
                "C:\\Users\\ylyho\\OneDrive\\Documente\\GitHub\\LibraryManager\\src\\main\\resources\\log.properties");
        //must initialize loggers after setting above property
        logger = Logger.getLogger(Settings.class.getName());
    }

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
        logger.info("initialize config");
        try {
            Settings settings = new Settings();
            Gson gson = new Gson();
            writer = new FileWriter(SETTINGS_FILE);
            gson.toJson(settings, writer);
        } catch (IOException ex) {
            logger.severe("IOException catch, initConfig() ");
        } finally {
            try {
                writer.close();
            } catch (IOException ex) {
                logger.severe("IOException, can not close writer");
            }
        }
    }


    public static Settings getSettings(){
        Gson gson = new Gson();
        Settings settings = new Settings();
        try {
            settings = gson.fromJson(new FileReader(SETTINGS_FILE), Settings.class);
        } catch (FileNotFoundException ex) {
            logger.info("Config file is missing. Creating new one with default config");
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

            makeAlert.showMessageAlert("Settings updated succesfully!");
            logger.info("Settings updates succesfully!");
        } catch (IOException ex) {
            logger.severe("IOException, cant save configuration file!");
            makeAlert.showMessageAlert ("Cant save configuration file");
        } finally {
            try {
                writer.close();
            } catch (IOException ex) {
                logger.severe("IOException, can not close writer!");
            }
        }
    }
}
