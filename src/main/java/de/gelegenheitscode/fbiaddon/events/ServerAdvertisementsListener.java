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
            if (message.startsWith("[Forum] Hast du schon") || message.startsWith("[Regeln]") || message.startsWith("[ControlPanel] Verwalte") || message.startsWith("[Passwort] Ist dein Account") || message.startsWith("[Voten] Du kannst") || message.startsWith("[TikTok]") || message.startsWith("[Discord]") || message.startsWith("[Merchandise]") || message.startsWith("[Teamspeak]")) {
                e.setCanceled(true);
            }
        }
    }
}
