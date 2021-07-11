package com.github.shur.whitebait.inventory

import org.bukkit.Material
import org.bukkit.enchantments.Enchantment
import org.bukkit.inventory.ItemFlag
import org.bukkit.inventory.ItemStack

class Icon {

    var basedItem: ItemStack? = null

    var type: Material = Material.AIR
    var amount: Int = 1
    var name: String? = null
    var lore: MutableList<String> = mutableListOf()
    var flags: MutableSet<ItemFlag> = mutableSetOf()
    var enchantments: MutableMap<Enchantment, Int> = mutableMapOf()
    var model: Int? = null
    // basedItemは元となるアイテムであり、editItemはパラーメーター適応後に処理される
    var editItem: (ItemStack) -> Unit = {  }

    fun toItemStack(): ItemStack {
        val itemStack = basedItem ?: ItemStack(type)

        itemStack.amount = amount
        if (itemStack.hasItemMeta()) {
            itemStack.itemMeta = itemStack.itemMeta!!.also { meta ->
                meta.setDisplayName(name)
                meta.lore = lore
                meta.addItemFlags(*flags.toTypedArray())
                enchantments.forEach { (enchant, level) -> meta.addEnchant(enchant, level, true) }
                meta.setCustomModelData(model)
            }
        }
        editItem(itemStack)

        return itemStack
    }

}