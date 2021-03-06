package com.github.shur.whitebait.inventory.window

import org.bukkit.event.inventory.InventoryType

sealed class WindowOption

class TypedWindowOption(val type: InventoryType) : WindowOption()

class SizedWindowOption(val size: Int) : WindowOption()