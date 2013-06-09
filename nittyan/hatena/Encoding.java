package nittyan.hatena;

public enum Encoding {
    EUC_JP("euc-jp"),
    UTF8("utf8"),
    SHIFTJIS("shiftjis");

    private String encoding;

    private Encoding(String encoding) {
        this.encoding = encoding;
    }

    public String getName() {
        return this.encoding;
    }
}
