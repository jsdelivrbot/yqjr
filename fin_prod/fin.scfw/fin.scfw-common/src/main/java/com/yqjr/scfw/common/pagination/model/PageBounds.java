package com.yqjr.scfw.common.pagination.model;

import org.apache.ibatis.session.RowBounds;

import java.io.Serializable;

/**
 * @author quangz
 */
public class PageBounds extends RowBounds implements Serializable {
    private static final long serialVersionUID = -6414350656252331011L;
    public final static int NO_PAGE = 1;
    /**
     * 页号
     */
    protected int pageNum = NO_PAGE;
    /**
     * 分页大小
     */
    protected int pageSize = NO_ROW_LIMIT;
    /**
     * 结果集是否包含TotalCount
     */
    protected boolean containsTotalCount;

    public PageBounds() {
        containsTotalCount = false;
    }

    public PageBounds(RowBounds rowBounds) {

        if (null == rowBounds) {
            return;
        }

        if (rowBounds instanceof PageBounds) {
            PageBounds pageBounds = (PageBounds) rowBounds;
            this.pageNum = pageBounds.pageNum;
            this.pageSize = pageBounds.pageSize;
            this.containsTotalCount = pageBounds.containsTotalCount;
        } else {
            this.pageNum = (rowBounds.getOffset() / rowBounds.getLimit()) + 1;
            this.pageSize = rowBounds.getLimit();
        }

    }

    /**
     * Query TOP N, default containsTotalCount = false
     *
     * @param pageSize
     */
    public PageBounds(int pageSize) {
        this.pageSize = pageSize;
        this.containsTotalCount = false;
    }

    public PageBounds(int pageNum, int pageSize) {
        this(pageNum, pageSize, true);
    }

    public PageBounds(int pageNum, int pageSize, boolean containsTotalCount) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.containsTotalCount = containsTotalCount;
    }

    public static PageBounds of(int pageSize) {
        return new PageBounds(pageSize);
    }

    public static PageBounds of(int pageNum, int pageSize) {
        return new PageBounds(pageNum, pageSize);
    }

    public static PageBounds of(int pageNum, int pageSize, boolean containsTotalCount) {
        return new PageBounds(pageNum, pageSize, containsTotalCount);
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    @Override
    public int getLimit() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public boolean isContainsTotalCount() {
        return containsTotalCount;
    }

    public void setContainsTotalCount(boolean containsTotalCount) {
        this.containsTotalCount = containsTotalCount;
    }

    @Override
    public int getOffset() {
        if (pageNum >= 1) {
            return (pageNum - 1) * pageSize;
        }
        return 0;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PageBounds{");
        sb.append("pageNum=").append(pageNum);
        sb.append(", pageSize=").append(pageSize);
        sb.append(", containsTotalCount=").append(containsTotalCount);
        sb.append('}');
        return sb.toString();
    }
}
