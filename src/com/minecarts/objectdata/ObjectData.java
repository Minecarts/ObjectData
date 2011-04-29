package com.minecarts.objectdata;

import java.util.logging.Logger;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.PluginDescriptionFile;


public class ObjectData extends org.bukkit.plugin.java.JavaPlugin {
    private final Logger log = Logger.getLogger("Minecraft.ObjectData");
    
    public final ObjectDataMap shared = new ObjectDataMap();
    
    public void onEnable() {
        PluginManager pm = getServer().getPluginManager();
        PluginDescriptionFile pdf = getDescription();
        
        log.info("[" + pdf.getName() + "] v" + pdf.getVersion() + " enabled.");
    }
    
    public void onDisable() {
        
    }
}

