package com.github.shur.whitebait

import com.github.shur.whitebait.dsl.InventoryUIDSL
import com.github.shur.whitebait.inventory.InventoryUI
import com.github.shur.whitebait.inventory.SizedWindowOption
import com.github.shur.whitebait.inventory.Window
import org.bukkit.entity.Player

object Test : InventoryUI, InventoryUIDSL {

    override val window by window(SizedWindowOption(9)) {

        defaultSlot {

            icon {
                name = ""
            }

        }

    }

}