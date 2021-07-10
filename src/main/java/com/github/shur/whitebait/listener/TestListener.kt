package com.github.shur.whitebait.listener

import com.github.shur.whitebait.TestUI
import org.bukkit.Material
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerInteractEvent

// TODO: Test
class TestListener : Listener {
    @EventHandler
    fun onClickDiamond(event: PlayerInteractEvent) {
        if (event.hasItem()) {
            if (event.item!!.type == Material.DIAMOND) {
                TestUI.open(event.player)
            }
        }
    }
}