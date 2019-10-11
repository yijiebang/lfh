package com.reinfo.ipoly.module.base.models;

import java.util.Date;

public class Page {
    public final static Integer maxPageSize = 100;// 每页最大记录数

    private Integer currentPageNo = 1;

    private Integer pageSize = 10;// 默认每页大小

    public Integer startIndex;

    public Integer endIndex;

    private Long totalPageNum;

    private Long totalRecord;

    private Date startTime;

    private Date endTime;

    /**
     * 根据总记录数计算总页数
     * 
     * @param totalRecord
     */
    public void setTotalRecord(long totalRecord) {
        this.totalRecord = totalRecord;
        this.totalPageNum = (totalRecord + pageSize - 1) / pageSize;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getStartIndex() {
        return (currentPageNo - 1) * getPageSize();
    }

    public Integer getEndIndex() {
        return currentPageNo * getPageSize() + 1;
    }

    public void setStartIndex(Integer startIndex) {
        this.startIndex = startIndex;
    }

    public Integer getCurrentPageNo() {
        return currentPageNo;
    }

    public void setCurrentPageNo(Integer currentPageNo) {
        this.currentPageNo = currentPageNo;
    }

    public Integer getPageSize() {
        return pageSize > maxPageSize ? maxPageSize : pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Long getTotalPageNum() {
        return totalPageNum;
    }

    public void setTotalPageNum(Long totalPageNum) {
        this.totalPageNum = totalPageNum;
    }

    public Long getTotalRecord() {
        return totalRecord;
    }
}
