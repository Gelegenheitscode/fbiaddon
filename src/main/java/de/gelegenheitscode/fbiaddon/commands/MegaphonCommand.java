package de.gelegenheitscode.fbiaddon.commands;

import de.gelegenheitscode.fbiaddon.PlayerMessages;
import de.gelegenheitscode.fbiaddon.data.megaphon;
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
import java.util.Collections;
import java.util.List;

/**
 * @author Gelegenheitscode
 */
public final class MegaphonCommand extends CommandBase implements ICommand {

    @Override
    public String getName() {
        return "megaphon";
    }

    @Override
    public List<String> getAliases() {
        return Collections.singletonList("mega");
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return "/megaphon [Meldung]";
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        final EntityPlayerSP p = (EntityPlayerSP) sender;
        if(args.length < 1) {
            PlayerMessages.sendErrorMessage("Nutze /megaphon [Meldung]!");
            return;
        }
        final megaphon type = getTypeByString(args[0]);
        if(type == null) {
            p.sendChatMessage("/megaphon " + args[0]);
            return;
        }
        final String message = String.join(" ", Arrays.copyOfRange(args, 1, args.length));
        p.sendChatMessage("/megaphon " + type.getDisplayName());
        PlayerMessages.sendMessage("Du hast erfolgreich das Auto-Megafon genutzt!");
    }

    @Override
    public boolean checkPermission(MinecraftServer server, ICommandSender sender) {
        return true;
    }

    @Override
    public List<String> getTabCompletions(MinecraftServer server, ICommandSender sender, String[] args, @Nullable BlockPos targetPos) {
        final List<String> list = new ArrayList<>();
        for (megaphon value : megaphon.values()) {
            list.add(value.toString());

        }
        return list;
    }
    private megaphon getTypeByString(final String typeStr) {
        for (megaphon value : megaphon.values()) {
            if(value.toString().equalsIgnoreCase(typeStr)) {
                return value;
            }
        }
        return null;
    }
}
