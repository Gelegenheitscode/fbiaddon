package de.gelegenheitscode.fbiaddon.data;

/**
 * @author kybuxd
 * @author Gelegenheitscode
 */
public enum operations {
    GEISELNAHME("eine Geiselnahme"),
    FLUGZEUGENTFUEHRUNG("eine Flugzeugentführung"),
    LABOREINBRUCH("ein Einbruch in das Labor"),
    FBIEINBRUCH("ein Einbruch in das FBI-HQ"),
    STAATSBANK("ein Banküberfall bei der Staatsbank"),
    UBOOTENTFUEHRUNG("eine U-Boot Entführung"),
    GEBIETSEINNAHME("eine Gebietseinnahme");
    private String displayName;
    operations(final String displayName) {
        this.displayName = displayName;
    }
    public String getDisplayName() {
        return displayName;
    }
}