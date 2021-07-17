package com.github.shur.whitebait.inventory

import com.github.shur.whitebait.inventory.window.SizedWindowOption
import com.github.shur.whitebait.inventory.window.TypedWindowOption
import com.github.shur.whitebait.inventory.window.Window
import org.bukkit.Bukkit
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.InventoryHolder

class InventoryUIHolder(
    val window: Window
) : InventoryHolder {

    override fun getInventory(): Inventory {
        val inventory = createBaseInventory()

        inventory.apply {
            (0 until inventory.size).forEach { index ->
                val slot = window.slots.getOrDefault(index, window.defaultSlot)
                setItem(index, slot.icon.toItemStack())
            }
        }

        return inventory
    }

    private fun createBaseInventory(): Inventory {
        val title = window.title
        val option = window.option

        return if (title == null) {
            when (option) {
                is TypedWindowOption -> Bukkit.createInventory(this, option.type)
                is SizedWindowOption -> Bukkit.createInventory(this, option.size)
            }
        } else {
            when (option) {
                is TypedWindowOption -> Bukkit.createInventory(this, option.type, title)
                is SizedWindowOption -> Bukkit.createInventory(this, option.size, title)
            }
        }
    }

}