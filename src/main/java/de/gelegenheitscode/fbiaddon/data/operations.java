package de.gelegenheitscode.fbiaddon.data;

/**
 * @author Gelegenheitscode
 */
public enum operations {
    GEISELNAHME("eine Geiselnahme"),
    FLUGZEUGENTFUEHRUNG("eine Flugzeugentf\u00fchrung"),
    LABOREINBRUCH("ein Einbruch in das Labor"),
    FBIEINBRUCH("ein Einbruch in das FBI-HQ"),
    STAATSBANK("ein Bank\u00fcberfall bei der Staatsbank"),
    UBOOTENTFUEHRUNG("eine U-Boot Entf\u00fchrung"),
    ROLEPLAYEVENT("ein Roleplayevent"),
    GEBIETSEINNAHME("eine Gebietseinnahme");
    private String displayName;
    operations(final String displayName) {
        this.displayName = displayName;
    }
    public String getDisplayName() {
        return displayName;
    }
}