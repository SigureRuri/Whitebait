package com.github.shur.whitebait.event

import org.bukkit.event.inventory.InventoryOpenEvent

data class OpenEvent(val event: InventoryOpenEvent) {
    val inventory = event.inventory
}