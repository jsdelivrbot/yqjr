package com.yqjr.scfw.common.pagination.model;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author quangz
 */
public class PageList<E> extends ArrayList<E> {
    private static final long serialVersionUID = 1412759446332294208L;

    private Integer pageNum;
    private Integer pageSize;
    private Integer totalCount;

    public PageList(Collection<? extends E> c, Integer pageNum, Integer pageSize, Integer totalCount) {
        super(c);
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.totalCount = totalCount;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public int getPages() {
        return (totalCount % pageSize == 0 ?
                totalCount / pageSize
                : totalCount / pageSize + 1);
    }
}
