package constantVariables;

public enum LanguageList {

    EN("EN", "English"),
    DE("DE", "Deutsch"),
    NE("NE", "Nederlands");

    public String label;
    public String languageName;

    LanguageList(String label, String languageName) {
        this.label = label;
        this.languageName = languageName;
    }
}
