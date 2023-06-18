package de.gelegenheitscode.fbiaddon.commands;

import de.gelegenheitscode.fbiaddon.PlayerMessages;
import de.gelegenheitscode.fbiaddon.data.operations;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Gelegenheitscode
 * @author kybuxd
 */
public final class EinsatzmeldungCommand extends CommandBase implements ICommand {

    @Override
    public String getName() {
        return "einsatzmeldung";
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return "/einsatzmeldung [Einsatz] [Informationen]";
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        final EntityPlayerSP p = (EntityPlayerSP) sender;
        if(args.length < 2) {
            PlayerMessages.sendErrorMessage("Nutze /einsatzmeldung [Einsatz] [Informationen]!");
            return;
        }
        final operations type = getTypeByString(args[0]);
        if(type == null) {
            PlayerMessages.sendErrorMessage("Gebe einen g\u00fcltigen Einsatz an!");
            return;
        }
        final String message = String.join(" ", Arrays.copyOfRange(args, 1, args.length));
        PlayerMessages.sendMessage("Du hast \u00A7e" + type.getDisplayName() + " \u00A73im Discord gemeldet!");
        p.sendChatMessage("/sms 100564 custom \"Es wird " + type.getDisplayName() + " gemeldet!\" \"Nachricht von " + p.getName() + ": \n" + message + "\"");
    }

    @Override
    public boolean checkPermission(MinecraftServer server, ICommandSender sender) {
        return true;
    }

    @Override
    public List<String> getTabCompletions(MinecraftServer server, ICommandSender sender, String[] args, @Nullable BlockPos targetPos) {
        final List<String> list = new ArrayList<>();
        switch (args.length) {
            case 1:
                for (operations value : operations.values()) {
                    list.add(value.toString());
                }
                break;
            case 2:
                list.add("Nachricht");
                break;
        }
        return list;
    }
    private operations getTypeByString(final String typeStr) {
        for (operations value : operations.values()) {
            if(value.toString().equalsIgnoreCase(typeStr)) {
                return value;
            }
        }
        return null;
    }
}
