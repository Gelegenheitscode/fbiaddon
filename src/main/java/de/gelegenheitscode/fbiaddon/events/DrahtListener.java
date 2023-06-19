package de.gelegenheitscode.fbiaddon.events;

import de.gelegenheitscode.fbiaddon.PlayerMessages;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

public class DrahtListener {
    @SubscribeEvent
    public void onItemPickup(PlayerEvent.ItemPickupEvent e) {
        String itemName = e.getStack().getDisplayName();
        PlayerMessages.sendMessage(itemName);
        if(itemName.contains("Draht")) {
            PlayerMessages.sendMessage("Du hast einen Draht aufgehoben. es ist " + itemName);
        }
    }
}
