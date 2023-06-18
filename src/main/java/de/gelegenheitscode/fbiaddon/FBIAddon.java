package de.gelegenheitscode.fbiaddon;

import de.gelegenheitscode.fbiaddon.commands.BurnCountCommand;
import de.gelegenheitscode.fbiaddon.commands.DrugCountCommand;
import de.gelegenheitscode.fbiaddon.commands.EinsatzmeldungCommand;
import de.gelegenheitscode.fbiaddon.events.*;
import net.minecraft.client.Minecraft;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

/**
 * @author Gelegenheitscode
 */
@Mod(modid = "fbiaddon", name = "FBIAddon", version = FBIAddon.VERSION)
public class FBIAddon
{
    public static final String VERSION = "1.0.0";
    public static final Minecraft MINECRAFT = Minecraft.getMinecraft();
    public static int DRUGCOUNT = -1;
    public static int BURNCOUNT = -1;
    public static String getPrefix() {
        return TextFormatting.BLUE + "FBI " + TextFormatting.DARK_GRAY + "- " + TextFormatting.DARK_AQUA;
    }
    private static Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        registerCommands();
        registerEvents();
    }
    public static void registerCommands() {
        ClientCommandHandler.instance.registerCommand(new EinsatzmeldungCommand());
        ClientCommandHandler.instance.registerCommand(new DrugCountCommand());
        ClientCommandHandler.instance.registerCommand(new BurnCountCommand());
    }
    public static void registerEvents() {
        MinecraftForge.EVENT_BUS.register(new DrugVaultListener());
    }
}
