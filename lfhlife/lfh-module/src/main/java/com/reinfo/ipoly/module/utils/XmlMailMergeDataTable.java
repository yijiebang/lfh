package com.reinfo.ipoly.module.utils;

import com.aspose.words.IMailMergeDataSource;
import java.util.HashMap;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class XmlMailMergeDataTable implements IMailMergeDataSource {
	private Node currentNode;
	private boolean isFirstRecord = true;
	private final String tableName;
	private final HashMap<String, XPathExpression> expressionSet = new HashMap();
	private final XPath xPath = XPathFactory.newInstance().newXPath();

	public XmlMailMergeDataTable(Document xmlDoc, String tableName) throws Exception {
		this(xmlDoc.getDocumentElement(), tableName);
	}

	private XmlMailMergeDataTable(Node rootNode, String tableName) throws Exception {
		this.tableName = tableName;
		this.currentNode = (Node) this.retrieveExpression("./" + tableName).evaluate(rootNode, XPathConstants.NODE);
	}

	public String getTableName() {
		return this.tableName;
	}

	public boolean getValue(String fieldName, Object[] fieldValue) throws Exception {
		Node value = (Node) this.retrieveExpression(fieldName).evaluate(this.currentNode, XPathConstants.NODE);
		Element nodeAsElement = (Element) this.currentNode;
		if (value != null) {
			fieldValue[0] = value.getTextContent();
			return true;
		}
		if (nodeAsElement.hasAttribute(fieldName)) {
			fieldValue[0] = nodeAsElement.getAttribute(fieldName);
			return true;
		}
		return false;
	}

	public boolean moveNext() {
		if (!this.isEof()) {
			if (!this.isFirstRecord) {
				do {
					this.currentNode = this.currentNode.getNextSibling();
				} while (this.currentNode != null && (!this.currentNode.getNodeName().equals(this.tableName)
						|| this.currentNode.getNodeType() != 1));
			} else {
				this.isFirstRecord = false;
			}
		}
		return !this.isEof();
	}

	public IMailMergeDataSource getChildDataSource(String tableName) throws Exception {
		return new XmlMailMergeDataTable(this.currentNode, tableName);
	}

	private boolean isEof() {
		return this.currentNode == null;
	}

	private XPathExpression retrieveExpression(String path) throws Exception {
		XPathExpression expression;
		if (this.expressionSet.containsKey(path)) {
			expression = this.expressionSet.get(path);
		} else {
			expression = this.xPath.compile(path);
			this.expressionSet.put(path, expression);
		}
		return expression;
	}
}