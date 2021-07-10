package com.github.shur.whitebait.event

import org.bukkit.event.inventory.InventoryClickEvent

data class ClickEvent(val event: InventoryClickEvent) {
    val inventory = event.inventory
    val slotType = event.slotType
    val cursor = event.cursor
    val current = event.currentItem
    val isRightClick = event.isRightClick
    val isLeftClick = event.isLeftClick
    val isShiftClick = event.isShiftClick
    val slot = event.slot
    val rawSlot = event.rawSlot
    val hotbarButton = event.hotbarButton
    val action = event.action
    val clickType = event.click
}