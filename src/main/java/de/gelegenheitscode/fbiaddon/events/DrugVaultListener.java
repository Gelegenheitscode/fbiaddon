package de.gelegenheitscode.fbiaddon.events;

import de.gelegenheitscode.fbiaddon.FBIAddon;
import de.gelegenheitscode.fbiaddon.PlayerMessages;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.event.world.NoteBlockEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DrugVaultListener {
    public static final Pattern DRUG_VAULT_DROP_PATTERN = Pattern.compile("^HQ: (.+) (?:\\[UC])*(\\w+) hat (\\d+)g (Pulver|Kr\u00e4uter|Kristalle|Wundert\u00fcte) \\((H\u00f6chste Reinheit|Gute Reinheit|Mittlere Reinheit|Schlechte Reinheit)\\) in der Asservatenkammer verstaut\\.$");
    public static final Pattern DRUG_VAULT_BURN_PATTERN = Pattern.compile("^\\[Asservatenkammer] Der Stromkonzern gibt dem FBI (\\d+)\\$ f\u00fcr die erzeugte W\u00e4rmeenergie zur\u00fcck\\.$");
    public static final Pattern NEW_DRUG_VAULT_DROP_PATTERN = Pattern.compile("^Asservatenkammer \\| \\+(\\d+)g (Pulver|Kr\u00e4uter|Kristalle|Wundert\u00fcte) \\((H\u00f6chste Reinheit|Gute Reinheit|Mittlere Reinheit|Schlechte Reinheit)\\) \\| (\\w+)$");

    @SubscribeEvent
    public void onClientChatReceived(ClientChatReceivedEvent e) {
        if(FBIAddon.DRUGCOUNT > -1) {
            String msg = e.getMessage().getUnformattedText();
            Matcher drugVaultDropMatcher = DRUG_VAULT_DROP_PATTERN.matcher(msg);
            if(drugVaultDropMatcher.find()) {
                FBIAddon.DRUGCOUNT = FBIAddon.DRUGCOUNT + Integer.parseInt(drugVaultDropMatcher.group(3));
                PlayerMessages.sendMessage("\u00A7bBisherige Einlagerungen\u00A78: \u00A7a" + FBIAddon.DRUGCOUNT + "g");
            }
            Matcher newDrugVaultDropMatcher = NEW_DRUG_VAULT_DROP_PATTERN.matcher(msg);
            if(newDrugVaultDropMatcher.find()) {
                FBIAddon.DRUGCOUNT = FBIAddon.DRUGCOUNT + Integer.parseInt(newDrugVaultDropMatcher.group(1));
                PlayerMessages.sendMessage("\u00A7bBisherige Einlagerungen\u00A78: \u00A7a" + FBIAddon.DRUGCOUNT + "g");
            }
        }
        if(FBIAddon.BURNCOUNT > -1) {
            String msg = e.getMessage().getUnformattedText();
            Matcher drugVaultBurnMatcher = DRUG_VAULT_BURN_PATTERN.matcher(msg);
            if(drugVaultBurnMatcher.find()) {
                FBIAddon.BURNCOUNT = FBIAddon.BURNCOUNT + Integer.parseInt(drugVaultBurnMatcher.group(1));
                e.setCanceled(true);
                PlayerMessages.sendMessage("\u00A7bBisherige Einnahmen\u00A78: \u00A7a" + FBIAddon.BURNCOUNT + "$");
            }
        } else {
            String msg = e.getMessage().getUnformattedText();
            Matcher drugVaultBurnMatcher = DRUG_VAULT_BURN_PATTERN.matcher(msg);
            if (drugVaultBurnMatcher.find()) {
                e.setCanceled(true);
                PlayerMessages.sendMessage("\u00A7bEinkommen durch diese Verbrennung\u00A78: \u00A7a" + drugVaultBurnMatcher.group(1) + "$");
            }
        }
    }
}
