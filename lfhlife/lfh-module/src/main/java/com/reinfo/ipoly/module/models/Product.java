package com.reinfo.ipoly.module.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.util.List;

public class Product {

	private String mainDocumentPath;
	private List<String> documentPathList;
	
	@JsonInclude(Include.NON_NULL)
	private String[] removeSectionList;
	private Data data;
	
	public String getMainDocumentPath() {
		return mainDocumentPath;
	}
	public void setMainDocumentPath(String mainDocumentPath) {
		this.mainDocumentPath = mainDocumentPath;
	}
	public List<String> getDocumentPathList() {
		return documentPathList;
	}
	public void setDocumentPathList(List<String> documentPathList) {
		this.documentPathList = documentPathList;
	}
	public String[] getRemoveSectionList() {
		return removeSectionList;
	}
	public void setRemoveSectionList(String[] removeSectionList) {
		this.removeSectionList = removeSectionList;
	}
	public Data getData() {
		return data;
	}
	public void setData(Data data) {
		this.data = data;
	}
	
	
}
