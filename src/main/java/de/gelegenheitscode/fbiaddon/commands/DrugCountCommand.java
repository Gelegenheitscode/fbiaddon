package de.gelegenheitscode.fbiaddon.commands;

import de.gelegenheitscode.fbiaddon.FBIAddon;
import de.gelegenheitscode.fbiaddon.PlayerMessages;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;

/**
 * @author Gelegenheitscode
 */
public class DrugCountCommand extends CommandBase implements ICommand {

    @Override
    public String getName() {
        return "drugcount";
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return "/drugcount";
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        final EntityPlayerSP p = (EntityPlayerSP) sender;
        if(FBIAddon.DRUGCOUNT == -1){
            FBIAddon.DRUGCOUNT = 0;
            PlayerMessages.sendMessage("Du hast den Drogencounter aktiviert.");
        }
        else {
            PlayerMessages.sendMessage("Du hast den Drogencounter beendet. §7(§e" + FBIAddon.DRUGCOUNT + "g§7)");
            FBIAddon.DRUGCOUNT = -1;
        }
    }

    @Override
    public boolean checkPermission(MinecraftServer server, ICommandSender sender) {
        return true;
    }

}
