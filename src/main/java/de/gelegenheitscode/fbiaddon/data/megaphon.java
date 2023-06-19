package de.gelegenheitscode.fbiaddon.data;

public enum megaphon {
    SPERRGEBIET("Achtung, Achtung! Das FBI weist auf das aktuelle Sperrgebiet hin! Jeglicher Aufenthalt im und um das Gebiet ist nicht gestattet und wird mit Wantedpunkten geahndet!"),
    BOMBE("Achtung, Achtung! Das FBI weist auf die akute Terrorgefahr und auf das damit verbundene Sperrgebiet hin! Jeglicher Aufenthalt im und um das Gebiet wird mit Wantedpunkten geahndet!"),
    BAUSTELLE("Achtung, Achtung! Das FBI weist auf den unerlaubten Aufenthalt auf einer Baustelle und den damit verbundenen Wantedpunkten hin!"),
    FEUER("Achtung, Achtung! Aufgrund des Feuers weist das FBI alle Zivilisten darauf hin, zur Eigensicherung hinter den Absperrungen zu bleiben. Das Missachten wird mit Wantedpunkten bestraft!");
    private String displayName;
    megaphon(final String displayName) {
        this.displayName = displayName;
    }
    public String getDisplayName() {
        return displayName;
    }
}
