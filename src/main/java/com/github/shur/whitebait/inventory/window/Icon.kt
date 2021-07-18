package com.github.shur.whitebait.inventory.window

import org.bukkit.Material
import org.bukkit.enchantments.Enchantment
import org.bukkit.inventory.ItemFlag
import org.bukkit.inventory.ItemStack

class Icon(
    private val basedItem: ItemStack? = null
) {

    var type: Material = Material.AIR
    var amount: Int = 1
    var name: String? = null
    var lore: MutableList<String> = mutableListOf()
    var flags: MutableSet<ItemFlag> = mutableSetOf()
    var enchantments: MutableMap<Enchantment, Int> = mutableMapOf()
    var model: Int? = null

    // basedItemは元となるアイテムであり、editItemはパラーメーター適応後に処理される
    var editItem: (ItemStack) -> Unit = { }


    init {
        if (basedItem != null) {
            type = basedItem.type
            amount = basedItem.amount

            val itemMeta = basedItem.itemMeta
            if (itemMeta != null) {
                if (itemMeta.hasDisplayName()) name = itemMeta.displayName
                if (itemMeta.hasLore()) lore = itemMeta.lore!!
                if (itemMeta.itemFlags.isNotEmpty()) flags = itemMeta.itemFlags
                if (itemMeta.hasEnchants()) enchantments = itemMeta.enchants
                if (itemMeta.hasCustomModelData()) model = itemMeta.customModelData
            }
        }
    }

    fun toItemStack(): ItemStack {
        val itemStack = basedItem ?: ItemStack(type)

        itemStack.amount = amount
        itemStack.itemMeta = itemStack.itemMeta?.also { meta ->
            meta.setDisplayName(name)
            meta.lore = lore
            meta.addItemFlags(*flags.toTypedArray())
            enchantments.forEach { (enchant, level) -> meta.addEnchant(enchant, level, true) }
            meta.setCustomModelData(model)
        }

        itemStack.apply(editItem)

        return itemStack
    }

}