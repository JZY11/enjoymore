package com.ipubu.boot.skills.enjoymore.es.util;

import java.util.List;
import java.util.Map;
/**
 * @ClassName EsPage
 * @Description
 * @Author jzy
 */
public class EsPage {

    /**
     * 当前页
     */
    private int currentPage;
    /**
     * 每页显示多少条
     */
    private int pageSize;

    /**
     * 总记录数
     */
    private int recordCount;
    /**
     * 本页的数据列表
     */
    private List<Map<String, Object>> recordList;

    /**
     * 总页数
     */
    private int pageCount;
    /**
     * 页码列表的开始索引（包含）
     */
    private int beginPageIndex;
    /**
     * 页码列表的结束索引（包含）
     */
    private int endPageIndex;


    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getRecordCount() {
        return recordCount;
    }

    public void setRecordCount(int recordCount) {
        this.recordCount = recordCount;
    }

    public List<Map<String, Object>> getRecordList() {
        return recordList;
    }

    public void setRecordList(List<Map<String, Object>> recordList) {
        this.recordList = recordList;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getBeginPageIndex() {
        return beginPageIndex;
    }

    public void setBeginPageIndex(int beginPageIndex) {
        this.beginPageIndex = beginPageIndex;
    }

    public int getEndPageIndex() {
        return endPageIndex;
    }

    public void setEndPageIndex(int endPageIndex) {
        this.endPageIndex = endPageIndex;
    }
}
