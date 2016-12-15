package com.siyou.bojun.bean;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * @author 青山
 *
 */
public class PageBean<T> implements Serializable{
 
	private static final long serialVersionUID = 1L;
	
	/**每页显示多少数据*/
	public static final int pageRecordNum = 20;
	
	/**总条数*/
	private int allRecords;
	
	/**当前的页码*/
	private int currentPageNum;
	
	/**改页数据*/
	private List<T> pageData;
	
	/**一共有多少页的数据*/
	private int pageSize;

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getAllRecords() {
		return allRecords;
	}

	public void setAllRecords(int allRecords) {
		this.allRecords = allRecords;
	}

	public int getCurrentPageNum() {
		return currentPageNum;
	}

	public void setCurrentPageNum(int currentPageNum) {
		this.currentPageNum = currentPageNum;
	}

	public List<T> getPageData() {
		return pageData;
	}

	public void setPageData(List<T> pageData) {
		this.pageData = pageData;
	}

	public static int getPagerecordnum() {
		return pageRecordNum;
	}
	
	
	/**
	 * 计算一共有多少页的数据
	 * @param totalCnt
	 * @return
	 */
	public int getPageSize(int totalCnt){
		if(totalCnt>0){
			if(totalCnt%pageRecordNum==0){
				return totalCnt/pageRecordNum;
			}else{
				return totalCnt/pageRecordNum+1;
			}
		}else{
			return 0;
		}
	}

}
