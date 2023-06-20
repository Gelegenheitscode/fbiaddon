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
public class BurnCountCommand extends CommandBase implements ICommand {

    @Override
    public String getName() {
        return "burncount";
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return "/burncount";
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        final EntityPlayerSP p = (EntityPlayerSP) sender;
        if(FBIAddon.BURNCOUNT == -1){
            FBIAddon.BURNCOUNT = 0;
            PlayerMessages.sendMessage("Du hast den Burncounter aktiviert.");
        }
        else {
            PlayerMessages.sendMessage("Du hast den Burncounter beendet. §7(§e" + FBIAddon.BURNCOUNT + "$§7)");
            FBIAddon.BURNCOUNT = -1;
        }
    }

    @Override
    public boolean checkPermission(MinecraftServer server, ICommandSender sender) {
        return true;
    }

}
