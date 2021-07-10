package com.github.shur.whitebait

import com.github.shur.whitebait.inventory.InventoryUI
import com.github.shur.whitebait.inventory.SizedWindowOption
import com.github.shur.whitebait.inventory.Slot
import com.github.shur.whitebait.inventory.Window
import org.bukkit.Material
import org.bukkit.Sound
import org.bukkit.enchantments.Enchantment
import org.bukkit.entity.Player
import org.bukkit.event.inventory.ClickType
import org.bukkit.inventory.ItemStack

// TODO: Test
object TestUI : InventoryUI {

    override val window: (Player) -> Window = { player ->
        Window(SizedWindowOption(36)).apply {
            title = "Inventory UI"

            onOpen = {
                player.sendMessage("UIを開いたよ")
            }
            onClose = {
                player.sendMessage("UIを閉じたよ")
            }
            onClick = {
                player.sendMessage("くりっく")
            }

            defaultSlot = Slot().apply defaultSlot@{
                icon = ItemStack(Material.GRAY_STAINED_GLASS).apply {
                    itemMeta = itemMeta?.apply {
                        setDisplayName(" ")
                    }
                }

                this@defaultSlot.onClick = onClick@ {
                    if (it.clickType == ClickType.DOUBLE_CLICK) return@onClick

                    player.sendMessage("デフォルトスロットをクリックしたよ")
                }
            }

            slots[5] = Slot().apply diamond@ {
                icon = ItemStack(Material.DIAMOND).apply {
                    itemMeta = itemMeta?.apply {
                        setDisplayName("すごいダイアモンド")
                        addEnchant(Enchantment.ARROW_INFINITE, 100, true)
                    }
                }

                this@diamond.onClick = onClick@ {
                    if (it.clickType == ClickType.DOUBLE_CLICK) return@onClick

                    player.playSound(player.location, Sound.BLOCK_ANVIL_PLACE, 1f, 1f)
                    player.sendMessage("ダイアモンドをクリックしたよ")
                }
            }
        }
    }

}