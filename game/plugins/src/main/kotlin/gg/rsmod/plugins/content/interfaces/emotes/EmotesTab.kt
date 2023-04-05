package gg.rsmod.plugins.content.interfaces.emotes

import gg.rsmod.plugins.api.cfg.Varbits
import gg.rsmod.game.model.entity.Player
import gg.rsmod.game.model.queue.TaskPriority
import gg.rsmod.plugins.api.EquipmentType
import gg.rsmod.plugins.api.ext.*


/**
 * @author Tom <rspsmods@gmail.com>
 */
object EmotesTab {

    const val COMPONENT_ID = 216



    fun unlockAll(p: Player) {
        p.setVarbit(Varbits.GOBLIN_EMOTES_VARBIT, 7)
        p.setVarbit(Varbits.GLASS_BOX_EMOTE_VARBIT, 1)
        p.setVarbit(Varbits.CLIMB_ROPE_EMOTE_VARBIT, 1)
        p.setVarbit(Varbits.LEAN_EMOTE_VARBIT, 1)
        p.setVarbit(Varbits.GLASS_WALL_EMOTE_VARBIT, 1)
        p.setVarbit(Varbits.IDEA_EMOTE_VARBIT, 1)
        p.setVarbit(Varbits.STAMP_EMOTE_VARBIT, 1)
        p.setVarbit(Varbits.FLAP_EMOTE_VARBIT, 1)
        p.setVarbit(Varbits.SLAP_HEAD_EMOTE_VARBIT, 1)
        p.setVarbit(Varbits.ZOMBIE_WALK_EMOTE_VARBIT, 1)
        p.setVarbit(Varbits.ZOMBIE_DANCE_EMOTE_VARBIT, 1)
        p.setVarbit(Varbits.SCARED_EMOTE_VARBIT, 1)
        p.setVarbit(Varbits.RABBIT_HOP_EMOTE_VARBIT, 1)
        p.setVarbit(Varbits.EXERCISE_EMOTES, 1)
        p.setVarbit(Varbits.ZOMBIE_HAND_EMOTE_VARBIT, 1)
        p.setVarbit(Varbits.HYPERMOBILE_DRINKER_EMOTE_VARBIT, 1)
        p.setVarbit(Varbits.SKILLCAPE_EMOTE_VARBIT, 1)
        p.setVarbit(Varbits.AIR_GUITAR_EMOTE_VARBIT, 1)
        p.setVarbit(Varbits.URI_TRANSFORM_EMOTE_VARBIT, 1)
        p.setVarbit(Varbits.SMOOTH_DANCE_EMOTE_VARBIT, 1)
        p.setVarbit(Varbits.CRAZY_DANCE_EMOTE_VARBIT, 1)
        p.setVarbit(Varbits.PREMIER_SHIELD_EMOTE_VARBIT, 1)
        p.setVarbit(Varbits.EXPLORE_VARBIT, 1)
        p.setVarbit(Varbits.FLEX_EMOTE_VARBIT, 1)
        p.setVarbit(Varbits.RELIC_UNLOCKED_EMOTE_VARBIT, 9)
        p.setVarbit(Varbits.PARTY_EMOTE_VARBIT, 1)
    }

    fun performEmote(p: Player, emote: Emote) {
        if (emote.varbit != -1 && p.getVarbit(emote.varbit) != emote.requiredVarbitValue) {
            val description = emote.unlockDescription ?: "You have not unlocked this emote yet."
            p.queue { messageBox(description) }
            return
        }

        /**
         * @author Jarafi
         * If you move you get locked into uris form
         */
        if (emote == Emote.URI_TRANSFORM) {
            p.queue {
                p.lock()
                p.graphic(86)
                p.setTransmogId(7311)
                wait(1)
                p.setTransmogId(7313)
                p.graphic(1306)
                p.animate(7278)
                wait(10)
                p.animate(4069)
                wait(1)
                p.graphic(678)
                p.animate(4071)
                wait(2)
                p.graphic(86)
                p.setTransmogId(-1)
                p.unlock()
            }
        }
        /**
         * Thanks to @ClaroJack for the skill animation/gfx id's
         */
        if (emote == Emote.SKILLCAPE) {
            when(p.equipment[EquipmentType.CAPE.id]?.id) {
                gg.rsmod.plugins.api.cfg.Items.MAX_CAPE_13342 -> {
                    p.animate(7121, 4)
                    p.graphic(1286, delay = 4)
                }
                gg.rsmod.plugins.api.cfg.Items.ATTACK_CAPE, gg.rsmod.plugins.api.cfg.Items.ATTACK_CAPET -> {
                    p.animate(4959)
                    p.graphic(823)
                }
                gg.rsmod.plugins.api.cfg.Items.STRENGTH_CAPE, gg.rsmod.plugins.api.cfg.Items.STRENGTH_CAPET -> {
                    p.animate(4981)
                    p.graphic(828)
                }
                gg.rsmod.plugins.api.cfg.Items.DEFENCE_CAPE, gg.rsmod.plugins.api.cfg.Items.DEFENCE_CAPET -> {
                    p.animate(4961)
                    p.graphic(824)
                }
                gg.rsmod.plugins.api.cfg.Items.RANGING_CAPE, gg.rsmod.plugins.api.cfg.Items.RANGING_CAPET -> {
                    p.animate(4973)
                    p.graphic(832)
                }
                gg.rsmod.plugins.api.cfg.Items.PRAYER_CAPE, gg.rsmod.plugins.api.cfg.Items.PRAYER_CAPET -> {
                    p.animate(4979)
                    p.graphic(829)
                }
                gg.rsmod.plugins.api.cfg.Items.MAGIC_CAPE, gg.rsmod.plugins.api.cfg.Items.MAGIC_CAPET -> {
                    p.animate(4939)
                    p.graphic(813)
                }
                gg.rsmod.plugins.api.cfg.Items.RUNECRAFT_CAPE, gg.rsmod.plugins.api.cfg.Items.RUNECRAFT_CAPET -> {
                    p.animate(4947)
                    p.graphic(817)
                }
                gg.rsmod.plugins.api.cfg.Items.HITPOINTS_CAPE, gg.rsmod.plugins.api.cfg.Items.HITPOINTS_CAPET -> {
                    p.animate(4971)
                    p.graphic(833)
                }
                gg.rsmod.plugins.api.cfg.Items.AGILITY_CAPE, gg.rsmod.plugins.api.cfg.Items.AGILITY_CAPET -> {
                    p.animate(4977)
                    p.graphic(830)
                }
                gg.rsmod.plugins.api.cfg.Items.HERBLORE_CAPE, gg.rsmod.plugins.api.cfg.Items.HERBLORE_CAPET -> {
                    p.animate(4969)
                    p.graphic(835)
                }
                gg.rsmod.plugins.api.cfg.Items.THIEVING_CAPE, gg.rsmod.plugins.api.cfg.Items.THIEVING_CAPET -> {
                    p.animate(4965)
                    p.graphic(826)
                }
                gg.rsmod.plugins.api.cfg.Items.CRAFTING_CAPE, gg.rsmod.plugins.api.cfg.Items.CRAFTING_CAPET -> {
                    p.animate(4949)
                    p.graphic(818)
                }
                gg.rsmod.plugins.api.cfg.Items.FLETCHING_CAPE, gg.rsmod.plugins.api.cfg.Items.FLETCHING_CAPET -> {
                    p.animate(4937)
                    p.graphic(812)
                }
                gg.rsmod.plugins.api.cfg.Items.SLAYER_CAPE, gg.rsmod.plugins.api.cfg.Items.SLAYER_CAPET -> {
                    p.animate(4967)
                    p.graphic(827)
                }
                gg.rsmod.plugins.api.cfg.Items.CONSTRUCT_CAPE, gg.rsmod.plugins.api.cfg.Items.CONSTRUCT_CAPET -> {
                    p.animate(4953)
                    p.graphic(820)
                }
                gg.rsmod.plugins.api.cfg.Items.MINING_CAPE, gg.rsmod.plugins.api.cfg.Items.MINING_CAPET -> {
                    p.animate(4941)
                    p.graphic(814)
                }
                gg.rsmod.plugins.api.cfg.Items.SMITHING_CAPE, gg.rsmod.plugins.api.cfg.Items.SMITHING_CAPET -> {
                    p.animate(4943)
                    p.graphic(815)
                }
                gg.rsmod.plugins.api.cfg.Items.FISHING_CAPE, gg.rsmod.plugins.api.cfg.Items.FISHING_CAPET -> {
                    p.animate(4951)
                    p.graphic(819)
                }
                gg.rsmod.plugins.api.cfg.Items.COOKING_CAPE, gg.rsmod.plugins.api.cfg.Items.COOKING_CAPET -> {
                    p.animate(4955)
                    p.graphic(821)
                }
                gg.rsmod.plugins.api.cfg.Items.FIREMAKING_CAPE, gg.rsmod.plugins.api.cfg.Items.FIREMAKING_CAPET -> {
                    p.animate(4975)
                    p.graphic(831)
                }
                gg.rsmod.plugins.api.cfg.Items.WOODCUTTING_CAPE, gg.rsmod.plugins.api.cfg.Items.WOODCUT_CAPET -> {
                    p.animate(4957)
                    p.graphic(822)
                }
                gg.rsmod.plugins.api.cfg.Items.FARMING_CAPE, gg.rsmod.plugins.api.cfg.Items.FARMING_CAPET -> {
                    p.animate(4963)
                    p.graphic(825)
                }
                gg.rsmod.plugins.api.cfg.Items.HUNTER_CAPE, gg.rsmod.plugins.api.cfg.Items.HUNTER_CAPET -> {
                    p.animate(5158)
                    p.graphic(907)
                }
                gg.rsmod.plugins.api.cfg.Items.CABBAGE_CAPE -> {
                    p.animate(7209)
                }
                gg.rsmod.plugins.api.cfg.Items.QUEST_POINT_CAPE, gg.rsmod.plugins.api.cfg.Items.QUEST_POINT_CAPE_T -> {
                    p.animate(4945)
                    p.graphic(816)
                }
                gg.rsmod.plugins.api.cfg.Items.ACHIEVEMENT_DIARY_CAPE, gg.rsmod.plugins.api.cfg.Items.ACHIEVEMENT_DIARY_CAPE_T -> {
                    p.animate(2709)
                    p.graphic(323)
                }
                gg.rsmod.plugins.api.cfg.Items.MUSIC_CAPE, gg.rsmod.plugins.api.cfg.Items.MUSIC_CAPET -> {
                    p.animate(4751)
                    p.graphic(1239)
                }
            }
        }


        if (emote == Emote.RELIC_UNLOCKED) {
            p.queue(TaskPriority.STANDARD) {
                p.graphic(-1)
                p.graphic(emote.gfx, 100)
                p.unlock()
            }
        }
        if (emote.anim != -1) {
            p.queue(TaskPriority.STANDARD) {
                p.animate(-1)
                p.animate(emote.anim, 1)
                p.unlock()
            }
        }
        if (emote.gfx != -1 && emote != Emote.RELIC_UNLOCKED) {
            p.queue(TaskPriority.STANDARD) {
                p.graphic(-1)
                p.graphic(emote.gfx)
                p.unlock()
            }
        }
    }
}