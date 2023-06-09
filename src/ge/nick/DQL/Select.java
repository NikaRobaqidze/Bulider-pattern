package ge.nick.DQL;

import ge.nick.sqlutils.SQLCommand;
import ge.nick.sqlutils.OrderDirection;
import ge.nick.sqlutils.Where;

import java.util.ArrayList;
import java.util.List;

/**
 * Class Select created to manage and render SQL SELECT command.
 * It implements SQLCommand to override required functions
 * to work with SQL queries.
 */

public class Select implements SQLCommand {

    // Table column name(s).
    private List<String> columns = new ArrayList<>();
    private String from; // Table name.
    private String orderByColumn; // Data sort logic depend on column name.
    private OrderDirection orderDirection; // // Data sort logic depend on content.
    private Where where; // Delete logic. Object to filter data

    // To get table column name(s).
    public List<String> getColumns() {
        return columns;
    }

    // To set table column name(s)..
    public void setColumns(List<String> columns) {
        this.columns = columns;
    }

    // To get table name.
    public String getFrom() {
        return from;
    }

    // To set table name.
    public void setFrom(String from) {
        this.from = from;
    }

    // To get by column name sort logic.
    public String getOrderByColumn() {
        return orderByColumn;
    }

    // To set by column name sort logic.
    public void setOrderByColumn(String orderByColumn) {
        this.orderByColumn = orderByColumn;
    }

    // To get order by content sort logic.
    public OrderDirection getOrderDirection() {
        return orderDirection;
    }

    // To set by content sort logic.
    public void setOrderDirection(OrderDirection orderDirection) {
        this.orderDirection = orderDirection;
    }

    // To get selection logic.
    public Where getWhere() {
        return where;
    }

    // To set selection logic.
    public void setWhere(Where where) {
        this.where = where;
    }

    @Override
    public String toString() {

        // Render SQL command.

        StringBuilder sb = new StringBuilder("SELECT ");

        // columns
        sb.append(columns.isEmpty() ? "*" : String.join(", ", columns));

        // table name
        sb.append(" FROM ").append(from);

        // order by
        if (orderByColumn != null && !orderByColumn.isBlank()) {
            sb.append(" ORDER BY ").append(orderByColumn).append(" ").append(orderDirection.name());
        }

        // where
        if(where != null) sb.append(where);

        sb.append(";");
        return sb.toString();
    }

    @Override
    public void execute() {

        // Check if table set.
        if(from == null){

            throw new IllegalArgumentException("Table name required.");
        }

        // Imitate command executing.
        System.out.println("exec \"" + this + "\"");
    }
}
