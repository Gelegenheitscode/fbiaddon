package de.gelegenheitscode.fbiaddon;

import net.minecraft.client.Minecraft;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;

import java.util.function.Consumer;

public class PlayerMessages {
    public static void sendMessage(final String message) {
        if(FBIAddon.MINECRAFT.player == null) return;
        FBIAddon.MINECRAFT.player.sendMessage(new TextComponentString(FBIAddon.getPrefix() + message.replace("§","\u00a7")));
    }
    public static void sendUnformattedMessage(final String message, final Consumer<ITextComponent> modifyComponent) {
        ITextComponent textComponent = new TextComponentString(
                message.replace("§", "\u00a7")
        );
        if(modifyComponent != null) {
            modifyComponent.accept(textComponent);
        }
        Minecraft.getMinecraft().player.sendMessage(textComponent);
    }
    public static void sendErrorMessage(final String message) {
        if(FBIAddon.MINECRAFT.player == null) return;
        FBIAddon.MINECRAFT.player.sendMessage(new TextComponentString(TextFormatting.BLUE + "FBI " + TextFormatting.DARK_GRAY + "- " + TextFormatting.RED + message.replace("§","\u00a7")));
    }
}
