package com.reinfo.ipoly.common.mappers.common;

import java.util.HashMap;
import java.util.Map;

public class Criteria {
    public void setForUpdate() {
        addParameter(FORUPDATE, " FOR UPDATE ");
    }

    public static Criteria newCriteria() {
        return new Criteria();
    }

    public boolean hasAddWhere() {
        return whereBuilder.hasAddWhere();
    }

    public Criteria addWhere(String filed, Object value) {
        if (value instanceof String) {
            whereBuilder.addWhere(filed + "='%1$s'", new Object[] {value});
        } else {
            whereBuilder.addWhere(filed + "=%1$s", new Object[] {value});
        }
        return this;
    }

    public Criteria addWhere(String where, Object[] values) {
        whereBuilder.addWhere(where, values);
        return this;
    }

    public Criteria addAscOrder(String filed) {
        orderBuilder.addAscOrder(filed);
        return this;
    }

    public Criteria addDescOrder(String filed) {
        orderBuilder.addDescOrder(filed);
        return this;
    }

    public Criteria setSumField(String sumField) {
        addParameter(SUMFIELD, sumField);
        return this;
    }

    public Criteria setMaxField(String maxField) {
        addParameter(MAXFIELD, maxField);
        return this;
    }

    public Criteria setLimit(int limit) {
        addParameter(LIMIT, " rownum = " + limit + " ");
        return this;
    }

    public Criteria addParameter(String key, String value) {
        paraMap.put(key, value);
        return this;
    }

    public Map<String, String> getAnswer() {
        Map<String, String> map = new HashMap<String, String>();
        map.put(WHERE, whereBuilder.build());
        map.put(ORDER, orderBuilder.build());
        map.putAll(paraMap);
        return map;
    }

    public void reset() {
        paraMap.clear();
        whereBuilder.reset();
        orderBuilder.reset();
    }

    /* public function */
    public static WhereFieldBuilder newWhereBuilder() {
        return new WhereFieldBuilder();
    }

    public static OrderFieldBuilder newOrderBuilder() {
        return new OrderFieldBuilder();
    }
    /* END - public function */

    /* private property */
    private Map<String, String> paraMap = new HashMap<String, String>(10);
    private WhereFieldBuilder whereBuilder = newWhereBuilder();
    private OrderFieldBuilder orderBuilder = newOrderBuilder();
    /* END - private property */

    /* public final property */
    public static final String WHERE = "where";
    public static final String ORDER = "order";
    public static final String SUMFIELD = "sumField";
    public static final String MAXFIELD = "maxField";
    public static final String LIMIT = "limit";
    public static final String FORUPDATE = "for_update";

    /* END - public final property */
    public void setPageNo(int start, int limit) {
        addParameter(LIMIT, " limit " + start + "," + limit);
    }

    public static void main(String[] args) {
        Criteria criteria = Criteria.newCriteria().addWhere("aa", 1).addWhere("bb", "bb");
        System.out.println();

    }
}
