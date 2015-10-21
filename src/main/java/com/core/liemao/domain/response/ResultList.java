package com.core.liemao.domain.response;

import java.util.List;

/**
 * 
 * @author chancore
 *
 */
public class ResultList<T> extends Result {

    private List<T> itemList;

    public ResultList() {
        super();
    }
    
    public ResultList(List<T> itemList) {
        super();
        this.itemList = itemList;
    }

    public ResultList(Integer status, String message, List<T> itemList) {
        super(status, message);
        this.itemList = itemList;
    }

    public List<T> getItemList() {
        return itemList;
    }

    public void setItemList(List<T> itemList) {
        this.itemList = itemList;
    }
}



