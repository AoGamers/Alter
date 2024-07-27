package org.alter.plugins.content.interfaces.tournament_supplies

import dev.openrune.cache.CacheManager.getItem
import org.alter.game.model.attr.INTERACTING_ITEM_ID
import org.alter.game.model.attr.INTERACTING_SLOT_ATTR
import org.alter.game.model.priv.Privilege

on_command("tournament", Privilege.ADMIN_POWER) {
    Tournament_Supplies.open(player)
}

on_button(interfaceId = Tournament_Supplies.TOURNAMENT_SUPPLIES_INTERFACE, component = 4) {
    val itemid = player.attr[INTERACTING_ITEM_ID]!!
    val option = player.getInteractingOption()
    if (option == 9) {
        world.sendExamine(player, itemid, type = ExamineEntityType.ITEM)
        return@on_button
    }
    var amount =
        when (option) {
            1 -> 1
            2 -> 5
            3 -> 10
            4 -> -1
            else -> return@on_button
        }
    if (amount == -1) {
        player.queue(TaskPriority.WEAK) {
            amount = inputInt("How many would you like to withdraw?")
            if (amount > 0) {
                if (player.inventory.freeSlotCount < amount && !getItem(itemid).stackable
                ) {
                    amount = player.inventory.freeSlotCount
                }
                player.inventory.add(itemid, amount)
            }
        }
    } else {
        if (getItem(itemid).stackable) {
            amount = 10000
        }
        player.inventory.add(itemid, amount)
    }
}

on_button(interfaceId = Tournament_Supplies.TOURNAMENT_SUPPLIES_INVENTORY_INTERFACE, component = 0) {
    try {
        val opt = player.getInteractingOption()
        val slot = player.attr[INTERACTING_SLOT_ATTR]!!
        if (opt == 9) {
            world.sendExamine(player, player.inventory[slot]!!.id, type = ExamineEntityType.ITEM)
            return@on_button
        }
        var amount =
            when (opt) {
                1 -> player.inventory.getItemCount(player.inventory[slot]!!.id)
                else -> 1
            }
        if (getItem(player.inventory[slot]!!.id).stackable) {
            amount = player.inventory.getItemCount(player.inventory[slot]!!.id)
        }
        player.inventory.remove(item = player.inventory[slot]!!.id, amount = amount, beginSlot = slot)
    } catch (e: NullPointerException) {
        e.printStackTrace()
    }
}
