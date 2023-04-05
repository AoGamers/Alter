
/**
 * @author Fritz <frikkipafi@gmail.com>
 */

for (tabId in listOf(
    AccountTab.UPGRADE_NOW_ID,
    AccountTab.BENEFITS_ID,
    AccountTab.INBOX_ID,
    AccountTab.HISTORY_ID,
    AccountTab.NEWS_ID,
    AccountTab.ARCHIVE_ID,
    AccountTab.WEBSITE_ID,
    AccountTab.GE_ID,
    AccountTab.WIKI_ID,
    AccountTab.SUPPORT_ID,
    AccountTab.HISCORE_ID,
    AccountTab.MERCH_ID
)) {
    on_button(AccountTab.BUTTON_ID, tabId) {
        player.message("Darwin is right")
    }
}

on_button(AccountTab.BUTTON_ID, AccountTab.NAME_CHANGER_ID) {
    player.openInterface(interfaceId = 589, dest = InterfaceDestination.TAB_AREA)
    player.setComponentText(interfaceId = 589, component = 6, text = "Next free change:")
    player.setComponentText(interfaceId = 589, component = 7, text = "Now!") // Make this a method to pull last updated date from your database, return that date, or "Now!"
    player.setInterfaceEvents(interfaceId = 589, component = 18, range = 0..9, setting = 0)
    player.setVarbit(5605, 1)
}
/*