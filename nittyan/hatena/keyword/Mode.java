package nittyan.hatena.keyword;

public enum Mode {
    RSS("rss"),
    RSS2("rss2");

    private String mode;

    private Mode(String mode) {
        this.mode = mode;
    }

    public String getName() {
        return this.mode;
    }
}
