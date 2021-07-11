package com.github.shur.whitebait.inventory

import com.github.shur.whitebait.event.ClickEvent

class Slot {

    var icon: Icon = Icon()

    var onClick: (ClickEvent) -> Unit = {}

}