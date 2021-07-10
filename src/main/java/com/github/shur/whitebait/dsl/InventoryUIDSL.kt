package com.github.shur.whitebait.dsl

import com.github.shur.whitebait.inventory.InventoryUI
import com.github.shur.whitebait.inventory.Window
import com.github.shur.whitebait.inventory.WindowOption
import org.bukkit.entity.Player
import kotlin.properties.ReadOnlyProperty

interface InventoryUIDSL {

    fun InventoryUI.window(option: WindowOption, block: WindowDSL.() -> Unit): ReadOnlyProperty<Any, (Player) -> Window> =
        ReadOnlyProperty { _, _ ->
            { player ->
                val windowDsl = WindowDSL(player, option).apply(block)
                windowDsl.window
            }
        }

}