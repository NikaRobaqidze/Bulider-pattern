package ge.tsu.DQL;

import ge.tsu.sqlutils.SQLCommand;
import ge.tsu.sqlutils.OrderDirection;
import ge.tsu.sqlutils.Where;

import java.util.ArrayList;
import java.util.List;

public class Select implements SQLCommand {

    private List<String> columns = new ArrayList<>();
    private String from;
    private String orderByColumn;
    private OrderDirection orderDirection;
    private Where where;

    public List<String> getColumns() {
        return columns;
    }

    public void setColumns(List<String> columns) {
        this.columns = columns;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getOrderByColumn() {
        return orderByColumn;
    }

    public void setOrderByColumn(String orderByColumn) {
        this.orderByColumn = orderByColumn;
    }

    public OrderDirection getOrderDirection() {
        return orderDirection;
    }

    public void setOrderDirection(OrderDirection orderDirection) {
        this.orderDirection = orderDirection;
    }

    public Where getWhere() {
        return where;
    }

    public void setWhere(Where where) {
        this.where = where;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder("SELECT ");

        // columns
        sb.append(columns.isEmpty() ? "*" : String.join(", ", columns));

        // table name
        sb.append(" FROM ").append(from);

        // order by
        if (orderByColumn != null && !orderByColumn.isBlank()) {
            sb.append(" ORDER BY ").append(orderByColumn).append(" ").append(orderDirection.name());
        }

        //where
        if(where != null) sb.append(where);

        sb.append(";");
        return sb.toString();
    }

    @Override
    public void execute() {

        // validate table
        if(from == null){

            throw new IllegalArgumentException("Table name required.");
        }

        System.out.println("exec \"" + this + "\"");
    }
}
