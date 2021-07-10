package com.github.shur.whitebait.inventory

import com.github.shur.whitebait.event.ClickEvent
import com.github.shur.whitebait.event.CloseEvent
import com.github.shur.whitebait.event.OpenEvent

class Window(
    val option: WindowOption
) {

    var onOpen: (OpenEvent) -> Unit = {}
    var onClose: (CloseEvent) -> Unit = {}
    var onClick: (ClickEvent) -> Unit = {}

    var defaultSlot = Slot()
    val slots: MutableMap<Int, Slot> = hashMapOf()

    var title: String? = null

}