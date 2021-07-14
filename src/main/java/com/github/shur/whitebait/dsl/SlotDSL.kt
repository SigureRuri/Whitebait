package com.github.shur.whitebait.dsl

import com.github.shur.whitebait.event.ClickEvent
import com.github.shur.whitebait.inventory.Slot
import org.bukkit.event.inventory.ClickType

class SlotDSL {

    val slot = Slot()

    fun icon(block: IconDSL.() -> Unit) {
        val iconDsl = IconDSL().apply(block)
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