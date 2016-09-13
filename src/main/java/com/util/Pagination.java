package com.util;

import java.util.List;

/**
 * Created by wuwan on 2016/6/30.
 */
public class Pagination {
    private int pageSize =10;
    private int pageNumber =1;
    private long totalCount =10;
private List list;

    public Pagination(){

    }
    public Pagination(int pageSize, int pageNumber, long totalCount) {
        this.pageSize = pageSize;
        this.pageNumber = pageNumber;
        this.totalCount = totalCount;
    }


    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
          int totalpage=(int)Math.ceil(totalCount/pageSize);
    if (totalpage <pageNumber)
        this.pageNumber =totalpage;
    else if(pageNumber<=0)
        this.pageNumber=1;
    else
        this.pageNumber =pageNumber;
    }

    public long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }
}
