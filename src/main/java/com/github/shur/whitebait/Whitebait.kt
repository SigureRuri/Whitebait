package com.github.shur.whitebait

import com.github.shur.whitebait.listener.InventoryListener
import org.bukkit.plugin.java.JavaPlugin

class Whitebait : JavaPlugin() {

    override fun onEnable() {
        server.pluginManager.registerEvents(InventoryListener(), this)
    }

}