package com.github.shur.whitebait.dsl

import com.github.shur.whitebait.dsl.window.WindowDSL
import com.github.shur.whitebait.inventory.InventoryUI
import com.github.shur.whitebait.inventory.window.Window
import com.github.shur.whitebait.inventory.window.WindowOption
import org.bukkit.entity.Player
import kotlin.properties.ReadOnlyProperty

fun InventoryUI.window(option: WindowOption, block: WindowDSL.() -> Unit): ReadOnlyProperty<Any, (Player) -> Window> =
    ReadOnlyProperty { _, _ ->
        { player ->
            val windowDsl = WindowDSL(player, option).apply(block)
            windowDsl.window
        }
    }