package io.chazza.itembuilder;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Chazmondo
 */
public class TestBuilder extends JavaPlugin {

    public void onEnable(){

        getLogger().info("Building a Custom Stone Sword.");

        ItemBuilder ib = new ItemBuilder(Material.STONE_SWORD, 1)
            .withName("&6God Sword")
            .withLore(Arrays.asList("&7A powerful Sword!", "&7Level: &c5"))
            .withEnchant(Enchantment.KNOCKBACK, 1);

        ThreadLocalRandom rand = ThreadLocalRandom.current();

        new BukkitRunnable(){

            @Override
            public void run() {

                for(Player p : Bukkit.getOnlinePlayers()){
                    if(rand.nextInt(100)+1 <= 10){
                        p.getInventory().addItem(ib.getItem());
                        p.sendMessage("§7You received an §bItem Builder §7Sword.");
                    }
                }
            }
        }.runTaskTimerAsynchronously(this, 20*(60*5), 20*(60*5));
    }
}
