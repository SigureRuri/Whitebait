package com.github.shur.whitebait.dsl

import com.github.shur.whitebait.event.ClickEvent
import com.github.shur.whitebait.inventory.Slot
import org.bukkit.inventory.ItemStack

class SlotDSL {

    val slot = Slot()


    var icon: ItemStack
        get() = slot.icon
        set(value) { slot.icon = value }

    fun onClick(block: ClickEvent.() -> Unit) {
        slot.onClick = { clickEvent ->
            clickEvent.apply(block)
        }
    }

}