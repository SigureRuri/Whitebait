package com.github.shur.whitebait.dsl

import com.github.shur.whitebait.event.ClickEvent
import com.github.shur.whitebait.inventory.Slot

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

}