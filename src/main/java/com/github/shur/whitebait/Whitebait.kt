package com.github.shur.whitebait

import com.github.shur.whitebait.listener.InventoryListener
import org.bukkit.plugin.java.JavaPlugin

class Whitebait : JavaPlugin() {

    override fun onEnable() {
        INSTANCE = this

        server.pluginManager.registerEvents(InventoryListener(), this)
    }

    companion object {

        @JvmStatic
        lateinit var INSTANCE: JavaPlugin
            private set

    }

}