package de.gelegenheitscode.fbiaddon.config;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * @author Gelegenheitscode
 */
@Config(modid = "fbiaddon", name = "FBIAddon")
@Mod.EventBusSubscriber
public class ConfigFile {
    @Config.Name("betterAllianceChat")
    @Config.Comment("Verändert den Bündnischat des Staates in ein besseres Format.")
    public static boolean allianceChat = true;
    @Config.Name("hideServerAdvertisements")
    @Config.Comment("Blendet die UnicaCity Werbungen aus (bsp. [Discord], [Forum], [ControlPanel], etc.).")
    public static boolean hideServerAdvertisements = true;
    @SubscribeEvent
    public static void onConfigChange(ConfigChangedEvent e) {
        if (e == null || e.getModID().equals("fbiaddon")) {
            ConfigManager.sync("fbiaddon", Config.Type.INSTANCE);
        }
    }
}
