package ge.nick.utils;

import ge.nick.DQL.Select;
import ge.nick.sqlutils.*;

import java.util.Arrays;

/**
 * Class builder to create object that render SELECT SQL command.
 * Initialize object then by functions set required parameters.
 * At the end get object with set parameters.
 */

public class SelectBuilder implements Buildable {

    // Initialize required class.
    private Select select = new Select();

    // Set table column name(s).
    public SelectBuilder columns(String... columns) {
        select.setColumns(Arrays.stream(columns).toList());
        return this;
    }

    // Set table name.
    public SelectBuilder from(String tableName) {
        select.setFrom(tableName);
        return this;
    }

    // To set by content sort logic.
    public SelectBuilder orderBy(String orderByColumn, OrderDirection orderDirection) {
        select.setOrderByColumn(orderByColumn);
        select.setOrderDirection(orderDirection);
        return this;
    }

    // Set data filter condition stringified part of SQL command.
    public SelectBuilder where(String... conditions) {

        Where where = new Where();
        where.setConditions(Arrays.stream(conditions).toList());

        select.setWhere(where);
        return this;
    }

    // Set data filter condition.
    public SelectBuilder where(Where where) {

        select.setWhere(where);
        return this;
    }

    @Override
    public Select build() {
        return select;
    }
}
