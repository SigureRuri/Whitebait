package com.github.shur.whitebait.event

import org.bukkit.event.inventory.InventoryCloseEvent

data class CloseEvent(val event: InventoryCloseEvent) {
    val inventory = event.inventory
}