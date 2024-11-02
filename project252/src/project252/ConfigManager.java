/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project252;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author reemajez
 */
public class ConfigManager {
    private static ConfigManager instance;
    private Map<String, String> config;

    private ConfigManager() {
        config = new HashMap<>();
        config.put("currency", "USD");
        config.put("region", "US");
    }

    public static ConfigManager getInstance() {
        if (instance == null) {
            instance = new ConfigManager();
        }
        return instance;
    }

    public String getConfig(String key) {
        return config.get(key);
    }
}

