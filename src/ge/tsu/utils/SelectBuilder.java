package ge.tsu.utils;

import ge.tsu.DQL.Select;
import ge.tsu.sqlutils.*;

import java.util.Arrays;

public class SelectBuilder implements Buildable {

    private Select select = new Select();

    public SelectBuilder columns(String... columns) {
        select.setColumns(Arrays.stream(columns).toList());
        return this;
    }

    public SelectBuilder from(String tableName) {
        select.setFrom(tableName);
        return this;
    }

    public SelectBuilder orderBy(String orderByColumn, OrderDirection orderDirection) {
        select.setOrderByColumn(orderByColumn);
        select.setOrderDirection(orderDirection);
        return this;
    }

    public SelectBuilder where(String... conditions) {

        Where where = new Where();
        where.setConditions(Arrays.stream(conditions).toList());

        select.setWhere(where);
        return this;
    }

    public SelectBuilder where(Where where) {

        select.setWhere(where);
        return this;
    }

    @Override
    public Select build() {
        return select;
    }
}
