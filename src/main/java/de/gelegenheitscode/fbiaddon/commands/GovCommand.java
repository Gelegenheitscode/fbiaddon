package de.gelegenheitscode.fbiaddon.commands;

import de.gelegenheitscode.fbiaddon.PlayerMessages;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.event.ClickEvent;
import net.minecraft.util.text.event.HoverEvent;

import java.util.Arrays;

/**
 * @author Gelegenheitscode
 */
public final class GovCommand extends CommandBase implements ICommand {

    @Override
    public String getName() {
        return "gov";
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return "/gov [Meldung]";
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        final EntityPlayerSP p = (EntityPlayerSP) sender;
        PlayerMessages.sendUnformattedMessage("§7", iTextComponent -> {
        });
        PlayerMessages.sendMessage("Vorlagen f\u00fcr eine Staatsmeldung:");
        PlayerMessages.sendUnformattedMessage("  §7\u00bb §bSperrgebiet", iTextComponent -> {
            iTextComponent.getStyle().setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new TextComponentString("\u00a77Das Gebiet um [...] wird hiermit zum absoluten Sperrgebiet erklärt. Jeglicher Aufenthalt im und um das Gebiet ist nicht gestattet und wird mit Wantedpunkten geahndet!\n\n\u00a7bKlicke zum einsetzen!")));
            iTextComponent.getStyle().setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/Gov Das Gebiet um [...] wird hiermit zum absoluten Sperrgebiet erklärt. Jeglicher Aufenthalt im und um das Gebiet ist nicht gestattet und wird mit Wantedpunkten geahndet!"));
        });
        PlayerMessages.sendUnformattedMessage("  §7\u00bb §bVermisste Person", iTextComponent -> {
            iTextComponent.getStyle().setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new TextComponentString("\u00a77Liebe B\u00fcrger! [...] wird vermisst! Jegliche Information, welche zum Auffinden der Person f\u00fchrt, wird mit einem Finderlohn von [...] belohnt.\n\n\u00a7bKlicke zum einsetzen!")));
            iTextComponent.getStyle().setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/Gov Liebe B\u00fcrger! [...] wird vermisst! Jegliche Information, welche zum Auffinden der Person f\u00fchrt, wird mit einem Finderlohn von [...] belohnt."));
        });
        PlayerMessages.sendUnformattedMessage("  §7\u00bb §bFl\u00fcchtige Person", iTextComponent -> {
            iTextComponent.getStyle().setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new TextComponentString("\u00a77Der Straft\u00e4ter [...] ist Fl\u00fcchtig! [Kurze Beschreibung der Klamotten]. Jegliche Informationen an das FBI oder die Polizei \u00fcber den Aufenthaltsort wird mit einem Finderlohn von [...] belohnt. Jeglicher Kontakt mit [...] ist zu vermeiden!\n\n\u00a7bKlicke zum einsetzen!")));
            iTextComponent.getStyle().setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/Gov Der Straft\u00e4ter [...] ist Fl\u00fcchtig! [Kurze Beschreibung der Klamotten]. Jegliche Informationen an das FBI oder die Polizei \u00fcber den Aufenthaltsort wird mit einem Finderlohn von [...] belohnt. Jeglicher Kontakt mit [...] ist zu vermeiden!"));
        });
        PlayerMessages.sendUnformattedMessage("  §7\u00bb §bBombe", iTextComponent -> {
            iTextComponent.getStyle().setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new TextComponentString("\u00a77Das Gebiet um [...] wird aufgrund erh\u00f6hter Terrorgefahr hiermit zum absoluten Sperrgebiet erklärt. Jeglicher Aufenthalt im und um das Gebiet ist nicht gestattet und wird mit Wantedpunkten geahndet!\n\n\u00a7bKlicke zum einsetzen!")));
            iTextComponent.getStyle().setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/Gov Das Gebiet um [...] wird aufgrund erh\u00f6hter Terrorgefahr hiermit zum absoluten Sperrgebiet erklärt. Jeglicher Aufenthalt im und um das Gebiet ist nicht gestattet und wird mit Wantedpunkten geahndet!"));
        });
        PlayerMessages.sendUnformattedMessage("  §7\u00bb §bGeiselnahme", iTextComponent -> {
            iTextComponent.getStyle().setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new TextComponentString("\u00a77Das Gebiet um [...] wird aufgrund einer Geiselnahme hiermit zum absoluten Sperrgebiet erklärt. Jeglicher Aufenthalt im und um das Gebiet ist nicht gestattet und wird mit Wantedpunkten geahndet!\n\n\u00a7bKlicke zum einsetzen!")));
            iTextComponent.getStyle().setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/Gov Das Gebiet um [...] wird aufgrund einer Geiselnahme hiermit zum absoluten Sperrgebiet erklärt. Jeglicher Aufenthalt im und um das Gebiet ist nicht gestattet und wird mit Wantedpunkten geahndet!"));
        });
        PlayerMessages.sendUnformattedMessage("  §7\u00bb §bSperrgebiet aufheben", iTextComponent -> {
            iTextComponent.getStyle().setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new TextComponentString("\u00a77Das Sperrgebiet um [...] ist hiermit wieder aufgehoben! Es besteht keine Gefahr mehr und das betroffene Gebiet kann bedenkenlos betreten werden.\n\n\u00a7bKlicke zum einsetzen!")));
            iTextComponent.getStyle().setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/Gov Das Sperrgebiet um [...] ist hiermit wieder aufgehoben! Es besteht keine Gefahr mehr und das betroffene Gebiet kann bedenkenlos betreten werden."));
        });
        PlayerMessages.sendUnformattedMessage("§7", iTextComponent -> {
        });
    }

    @Override
    public boolean checkPermission(MinecraftServer server, ICommandSender sender) {
        return true;
    }

}
