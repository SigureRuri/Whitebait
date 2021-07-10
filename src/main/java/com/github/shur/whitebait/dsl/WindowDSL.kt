package com.github.shur.whitebait.dsl

import com.github.shur.whitebait.event.ClickEvent
import com.github.shur.whitebait.event.CloseEvent
import com.github.shur.whitebait.event.OpenEvent
import com.github.shur.whitebait.inventory.Window
import com.github.shur.whitebait.inventory.WindowOption
import org.bukkit.entity.Player
import kotlin.properties.ReadOnlyProperty

class WindowDSL(
    val player: Player,
    val option: WindowOption
) {

    val window = Window(option)


    fun onOpen(block: OpenEvent.() -> Unit) {
        window.onOpen = { openEvent ->
            openEvent.apply(block)
        }
    }

    fun onClose(block: CloseEvent.() -> Unit) {
        window.onClose = { closeEvent ->
            closeEvent.apply(block)
        }
    }

    fun onClick(block: ClickEvent.() -> Unit) {
        window.onClick = { clickEvent ->
            clickEvent.apply(block)
        }
    }

    fun defaultSlot(block: SlotDSL.() -> Unit) {
        val slotDsl = SlotDSL().apply(block)
        window.defaultSlot = slotDsl.slot
    }

    fun slot(index: Int, block: SlotDSL.() -> Unit) {
        val slotDsl = SlotDSL().apply(block)
        window.slots[index] = slotDsl.slot
    }

    var title: String?
        get() = window.title
        set(value) { window.title = value }

}