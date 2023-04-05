package gg.rsmod.plugins.api.commandExtensions

import gg.rsmod.game.model.entity.Player
import gg.rsmod.plugins.api.ext.message

object Command {
    fun tryWithUsage(player: Player, args: Array<String>, failMessage: String, tryUnit: Function1<Array<String>, Unit>) {
        try {
            tryUnit.invoke(args)
        } catch (e: Exception) {
            player.message(failMessage)
            e.printStackTrace()
        }
    }
}
