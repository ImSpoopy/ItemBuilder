package io.chazza.itembuilder;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chazmondo
 */
public class ItemBuilder {

    private String translate(String message){
        return ChatColor.translateAlternateColorCodes('&', message);
    }

    private List<String> translate(List<String> message){
        ArrayList<String> newLore = new ArrayList<>();

        for(String msg : message)
            translate(msg);

        return newLore;
    }

    ItemStack is;
    ItemMeta im;

    public ItemBuilder(Material item, int amount){
        this.is = new ItemStack(item, amount);
        this.im = is.getItemMeta();
    }

    public ItemBuilder withName(String name){
        im.setDisplayName(translate(name));
        return this;
    }
    public ItemBuilder withLore(List<String> lore){
        im.setLore(translate(lore));
        return this;
    }
    public ItemBuilder addLore(String lore){
        im.getLore().add(translate(lore));
        return this;
    }
    public ItemBuilder removeLore(String lore){
        im.getLore().remove(translate(lore));
        return this;
    }
    public ItemBuilder withData(int data) {
        is.setDurability((short) data);
        return this;
    }
    public ItemBuilder withEnchant(Enchantment enchant, int level) {
        is.addEnchantment(enchant, level);
        return this;
    }

    /**
     * Get ItemStack from ItemBuilder
     * @return is
     */
    public ItemStack getItem() {
        is.setItemMeta(im);
        return is;
    }
}
