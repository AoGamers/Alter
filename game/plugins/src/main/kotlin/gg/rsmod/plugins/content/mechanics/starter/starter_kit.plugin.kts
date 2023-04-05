package gg.rsmod.plugins.content.mechanics.starter

import gg.rsmod.game.model.attr.NEW_ACCOUNT_ATTR

on_login {
    if (player.attr[NEW_ACCOUNT_ATTR] ?: return@on_login) {
        with (player.inventory) {
            add(gg.rsmod.plugins.api.cfg.Items.LOGS, 5)
            add(gg.rsmod.plugins.api.cfg.Items.TINDERBOX)
            add(gg.rsmod.plugins.api.cfg.Items.BREAD, 5)
            add(gg.rsmod.plugins.api.cfg.Items.BRONZE_PICKAXE)
            add(gg.rsmod.plugins.api.cfg.Items.BRONZE_DAGGER)
            add(gg.rsmod.plugins.api.cfg.Items.KNIFE)
        }
    }
}
