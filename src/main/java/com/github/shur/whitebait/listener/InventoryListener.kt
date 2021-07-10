package com.github.shur.whitebait.listener

import com.github.shur.whitebait.event.ClickEvent
import com.github.shur.whitebait.event.CloseEvent
import com.github.shur.whitebait.event.OpenEvent
import com.github.shur.whitebait.inventory.InventoryUIHolder
import org.bukkit.event.EventHandler
import org.bukkit.event.EventPriority
import org.bukkit.event.Listener
import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.event.inventory.InventoryCloseEvent
import org.bukkit.event.inventory.InventoryOpenEvent
import org.bukkit.event.inventory.InventoryType

class InventoryListener : Listener {

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    fun onOpen(event: InventoryOpenEvent) {
        val openedInventory = event.inventory
        val ui = openedInventory.holder as? InventoryUIHolder ?: return

        val openEvent = OpenEvent(event)
        ui.window.onOpen(openEvent)
    }

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    fun onClose(event: InventoryCloseEvent) {
        val closedInventory = event.inventory
        val ui = closedInventory.holder as? InventoryUIHolder ?: return

        val closeEvent = CloseEvent(event)
        ui.window.onClose(closeEvent)
    }

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    fun onClick(event: InventoryClickEvent) {
        val ui = event.inventory.holder as? InventoryUIHolder ?: return

        event.isCancelled = true

        val clickEvent = ClickEvent(event)
        ui.window.onClick(clickEvent)

        val clickedInventory = event.clickedInventory
        if (clickedInventory != null && clickedInventory.type != InventoryType.PLAYER) {
            val clickedSlotIndex = event.slot
            val clickedSlot = ui.window.slots.getOrDefault(clickedSlotIndex, ui.window.defaultSlot)

            clickedSlot.onClick(clickEvent)
        }
    }

}