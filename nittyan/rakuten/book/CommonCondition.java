package nittyan.rakuten.book;

import nittyan.search.Condition;

public class CommonCondition implements Condition{
    public String affiliateId;
    public String applicationId;
    public String callback;
    public Format format = Format.JSON;
}
