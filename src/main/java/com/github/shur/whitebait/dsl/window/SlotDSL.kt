package com.github.shur.whitebait.dsl.window

import com.github.shur.whitebait.event.ClickEvent
import com.github.shur.whitebait.inventory.window.Slot
import org.bukkit.event.inventory.ClickType
import org.bukkit.inventory.ItemStack

class SlotDSL {

    val slot = Slot()

    fun icon(basedItem: ItemStack? = null, block: IconDSL.() -> Unit) {
        val iconDsl = IconDSL(basedItem).apply(block)
        slot.icon = iconDsl.icon
    }

    fun onClick(block: ClickEvent.() -> Unit) {
        slot.onClick = { clickEvent ->
            clickEvent.apply(block)
        }
    }

    fun onClickFilterNotDoubleClick(block: ClickEvent.() -> Unit) {
        onClick {
            if (clickType == ClickType.DOUBLE_CLICK) return@onClick
            this.apply(block)
        }
    }

}