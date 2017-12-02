package com.zombieKillerPlugin;

import org.bukkit.plugin.java.JavaPlugin;
import com.zombieKillerPlugin.PlayerListener;


/**
 * Created by lester on 11/5/15.
 */
public class ZombieKiller extends JavaPlugin {

    @Override
    public void onEnable() {
        new PlayerListener(this);
    }

    @Override
    public void onDisable(){

    }
}
