package com.zombieKillerPlugin;

import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.Random;

public class PlayerListener implements Listener{
    int counter = 0;
    public PlayerListener(ZombieKiller plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void spawnZombies(PlayerJoinEvent e) {
        int amount = 1, x, y, z;
        Random random = new Random();
        x = random.nextInt(10); y =random.nextInt(10); z = (int)e.getPlayer().getLocation().getZ();
        Location playerLoc = e.getPlayer().getLocation();
        Location location = new Location(e.getPlayer().getWorld(), (int)e.getPlayer().getLocation().getX() + x, (int)e.getPlayer().getLocation().getY() + y, z);

        for(int i = 1; i <= amount; ++i) {

            e.getPlayer().getWorld().spawnEntity(location , EntityType.ZOMBIE);
        }
    }

    @EventHandler
    public void checkWinCondition(EntityDeathEvent e) {
        ++counter;
        if(e.getEntity() instanceof Zombie) {
            if(counter == 1) {
                e.getEntity().getKiller().sendMessage("You did good Kid!");
            }
        }
    }
}
