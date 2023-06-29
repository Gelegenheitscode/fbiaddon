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
public class StreamModeCommand extends CommandBase implements ICommand {

    @Override
    public String getName() {
        return "streammode";
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return "/streammode";
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        final EntityPlayerSP p = (EntityPlayerSP) sender;
        if(FBIAddon.STREAMMODE){
            FBIAddon.STREAMMODE = false;
            PlayerMessages.sendMessage("Du hast den Streammodus deaktiviert.");
        }
        else {
            PlayerMessages.sendMessage("Du hast den Streammodus aktiviert.");
            FBIAddon.STREAMMODE = true;
        }
    }

    @Override
    public boolean checkPermission(MinecraftServer server, ICommandSender sender) {
        return true;
    }

}
