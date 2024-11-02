/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project252;

import java.util.HashMap;
import java.util.Map;


public class ConfigManager {
     private static ConfigManager instance;

    private ConfigManager() {}

    public static ConfigManager getInstance() {
        if (instance == null) {
            instance = new ConfigManager();
        }
        return instance;
    }
public String getConfig(String key) {
    switch (key) {
        case "currency":
            return "SAR"; // العملة في جدة
        case "region":
            return "Jeddah"; // المنطقة
        default:
            return null;
    }
}}