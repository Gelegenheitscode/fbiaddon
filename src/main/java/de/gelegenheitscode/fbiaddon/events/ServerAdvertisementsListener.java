package de.gelegenheitscode.fbiaddon.events;

import de.gelegenheitscode.fbiaddon.config.ConfigFile;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * @author Gelegenheitscode
 */
public class ServerAdvertisementsListener {
    @SubscribeEvent
    public void onServerChat(ClientChatReceivedEvent e) {
        if (ConfigFile.hideServerAdvertisements) {
            String message = e.getMessage().getUnformattedText();
            if (message.startsWith("\u005bForum\u005d Hast du schon") || message.startsWith("\u005bRegeln\u005d") || message.startsWith("\u005bControlPanel\u005d Verwalte") || message.startsWith("\u005bPasswort\u005d Ist dein Account") || message.startsWith("\u005bVoten\u005d Du kannst") || message.startsWith("\u005bTikTok\u005d") || message.startsWith("\u005bDiscord\u005d") || message.startsWith("\u005bMerchandise\u005d") || message.startsWith("\u005bTeamspeak\u005d Besuch") || message.startsWith("\u005bF.A.Q\u005d") || message.startsWith("\u005bLabyMod\u005d")) {
                e.setCanceled(true);
            }
        }
    }
}
