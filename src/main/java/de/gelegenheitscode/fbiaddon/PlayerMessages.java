package de.gelegenheitscode.fbiaddon;

import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;

public class PlayerMessages {
    public static void sendMessage(final String message) {
        if(FBIAddon.MINECRAFT.player == null) return;
        FBIAddon.MINECRAFT.player.sendMessage(new TextComponentString(FBIAddon.getPrefix() + message));
    }
    public static void sendUnformattedMessage(final String message) {
        if(FBIAddon.MINECRAFT.player == null) return;
        FBIAddon.MINECRAFT.player.sendMessage(new TextComponentString(message));
    }
    public static void sendErrorMessage(final String message) {
        if(FBIAddon.MINECRAFT.player == null) return;
        FBIAddon.MINECRAFT.player.sendMessage(new TextComponentString(TextFormatting.BLUE + "FBI " + TextFormatting.DARK_GRAY + "- " + TextFormatting.RED + message));
    }
}
