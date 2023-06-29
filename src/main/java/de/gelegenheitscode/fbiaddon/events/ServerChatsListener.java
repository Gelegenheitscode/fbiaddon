package de.gelegenheitscode.fbiaddon.events;

import de.gelegenheitscode.fbiaddon.FBIAddon;
import de.gelegenheitscode.fbiaddon.config.ConfigFile;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * @author Gelegenheitscode
 */
public class ServerChatsListener {
    @SubscribeEvent
    public void onServerChat(ClientChatReceivedEvent e) {
        String message = e.getMessage().getUnformattedText();

        if (message.startsWith("FBI") || message.startsWith("Polizei") || message.startsWith("Rettungsdienst")) {
            if (ConfigFile.allianceChat) {
                if (!FBIAddon.STREAMMODE) {
                    String[] parts = message.split(":");
                    String factionandname = parts[0];
                    String chatmessage = parts[1];
                    if (message.startsWith("Polizei")) {
                        e.setCanceled(true);
                        FBIAddon.MINECRAFT.player.sendMessage(new TextComponentString("\u00a78\u25b6 \u00a7c\u00a7lD \u00a78\u25c0 \u00a73" + factionandname + "\u00a78\u003a" + "\u00a7e" + chatmessage));
                    }
                    if (message.startsWith("FBI")) {
                        e.setCanceled(true);
                        FBIAddon.MINECRAFT.player.sendMessage(new TextComponentString("\u00a78\u25b6 \u00a7c\u00a7lD \u00a78\u25c0 \u00a79" + factionandname + "\u00a78\u003a" + "\u00a7e" + chatmessage));
                    }
                    if (message.startsWith("Rettungsdienst")) {
                        e.setCanceled(true);
                        FBIAddon.MINECRAFT.player.sendMessage(new TextComponentString("\u00a78\u25b6 \u00a7c\u00a7lD \u00a78\u25c0 \u00a74" + factionandname + "\u00a78\u003a" + "\u00a7e" + chatmessage));
                    }
                } else {
                    e.setCanceled(true);
                }
            }
        }
        if (message.startsWith("Agent in Education") || message.startsWith("Special Agent") || message.startsWith("Senior Special Agent") || message.startsWith("Supervisory Special Agent") || message.startsWith("Chief of Staff") || message.startsWith("Deputy Director") || message.startsWith("Director")) {
            if (FBIAddon.STREAMMODE) {
                e.setCanceled(true);
            }
        }
        if (message.startsWith("\u005bSocial-Media\u005d") || message.startsWith("\u005bEvent-Team\u005d") || message.startsWith("\u005bBau-Team\u005d") || message.startsWith("\u005bEntwicklung\u005d")) {
            if (FBIAddon.STREAMMODE) {
                e.setCanceled(true);
            }
        }
        if (message.startsWith("\u005bNeulingsChat\u005d")) {
            if (FBIAddon.STREAMMODE) {
                e.setCanceled(true);
            }
        }
        if (message.contains("\u00bb Volunteer") || message.contains("\u00bb Supporter") || message.contains("\u00bb Moderator") || message.contains("\u00bb Fraktionsmanagement") || message.contains("\u00bb Administrator")) {
            if (FBIAddon.STREAMMODE) {
                e.setCanceled(true);
            }
        }
        if(message.startsWith("Get\u00f6tet") || message.startsWith("Gel\u00f6scht") || message.startsWith("\u27A5") || message.startsWith("Eingesperrt") || message.startsWith("Entlassung") || message.startsWith("Gesucht") || message.startsWith("Ticket") || message.startsWith("F\u00fchrerscheinabnahme") || message.startsWith("Waffenscheinabnahme") || message.startsWith("F\u00fchrerscheinr\u00fcckgabe") || message.startsWith("Waffenscheinr\u00fcckgabe") || message.startsWith("Drogenabnahme") || message.startsWith("Waffenabnahme") || message.startsWith("Peilsender") || message.startsWith("HQ:") || message.contains("m)")){
            if(FBIAddon.STREAMMODE){
                e.setCanceled(true);
            }
        }
    }
}
