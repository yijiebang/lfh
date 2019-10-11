package com.reinfo.ipoly.module.utils;

import com.aspose.words.IMailMergeDataSource;
import com.aspose.words.IMailMergeDataSourceRoot;
import org.w3c.dom.Document;

public class XmlMailMergeDataSet implements IMailMergeDataSourceRoot {
	private Document xmlDoc;

	public XmlMailMergeDataSet(Document xmlDoc) {
		this.xmlDoc = xmlDoc;
	}

	public IMailMergeDataSource getDataSource(String tableName) throws Exception {
		return new XmlMailMergeDataTable(this.xmlDoc, tableName);
	}
}
