package com.github.shur.whitebait.inventory

import com.github.shur.whitebait.event.ClickEvent
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class Slot {

    var icon: ItemStack = ItemStack(Material.AIR)

    var onClick: (ClickEvent) -> Unit = {}

}