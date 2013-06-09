package nittyan.hatena.keyword;

import nittyan.hatena.Encoding;
import nittyan.search.Condition;

public class KeywordCondition implements Condition {
    public String word;
    /**
     * default is Mode.RSS
     */
    public Mode mode = Mode.RSS;
    /**
     * default is Encoding.UTF8
     */
    public Encoding encoding = Encoding.UTF8;
}
