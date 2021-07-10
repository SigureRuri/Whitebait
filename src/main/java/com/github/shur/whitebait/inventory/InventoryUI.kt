package com.github.shur.whitebait.inventory

import org.bukkit.entity.Player

interface InventoryUI {

    val window: (Player) -> Window

    fun open(player: Player) {
        player.openInventory(build(player).inventory)
    }

    fun build(player: Player) = InventoryUIHolder(window(player))

}