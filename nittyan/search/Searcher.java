package nittyan.search;

import java.util.List;

public interface Searcher<R extends Result, T extends Condition> {
    public R search(T condition);
}
