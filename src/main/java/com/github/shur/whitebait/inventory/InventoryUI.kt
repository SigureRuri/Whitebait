package com.github.shur.whitebait.inventory

import com.github.shur.whitebait.Whitebait
import org.bukkit.Bukkit
import org.bukkit.entity.Player

interface InventoryUI {

    val window: (Player) -> Window

    fun build(player: Player) = InventoryUIHolder(window(player))

    fun open(player: Player) {
        player.openInventory(build(player).inventory)
    }

    /**
     * 次のサーバーティックでUIを開く。
     * [com.github.shur.whitebait.event.ClickEvent]からは、[open]を使用すると正常に動作しない場合がある。
     * その場合の代替としてこちらを使用する。
     */
    fun openLater(player: Player) {
        Bukkit.getScheduler().runTask(Whitebait.INSTANCE, Runnable {
            open(player)
        })
    }

}