package com.github.shur.whitebait.dsl

import com.github.shur.whitebait.inventory.Icon
import org.bukkit.Material
import org.bukkit.enchantments.Enchantment
import org.bukkit.inventory.ItemFlag
import org.bukkit.inventory.ItemStack

class IconDSL {

    val icon = Icon()

    var basedItem: ItemStack?
        get() = icon.basedItem
        set(value) { icon.basedItem = value }

    var type: Material
        get() = icon.type
        set(value) { icon.type = value }

    var amount: Int
        get() = icon.amount
        set(value) { icon.amount = value }

    var name: String?
        get() = icon.name
        set(value) { icon.name = value }

    var lore: MutableList<String>
        get() = icon.lore
        set(value) { icon.lore = value }

    var flags: MutableSet<ItemFlag>
        get() = icon.flags
        set(value) { icon.flags = value }

    var enchantments: MutableMap<Enchantment, Int>
        get() = icon.enchantments
        set(value) { icon.enchantments = value }

    var model: Int?
        get() = icon.model
        set(value) { icon.model = value }

    fun edit(block: ItemStack.() -> Unit) {
        icon.editItem = {
            it.apply(block)
        }
    }

}