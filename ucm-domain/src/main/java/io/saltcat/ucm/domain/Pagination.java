package io.saltcat.ucm.domain;

import java.util.List;

/**
 * Created by huawei on 4/3/16.
 */
public class Pagination<T> {

    private Integer count;
    private List<T> results;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<T> getResults() {
        return results;
    }

    public void setResults(List<T> results) {
        this.results = results;
    }
}
