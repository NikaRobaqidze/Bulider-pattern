package ge.nick.DML;

import ge.nick.sqlutils.SQLCommand;
import ge.nick.sqlutils.Where;

/**
 * Class Delete created to manage and render SQL DELETE command.
 * It implements SQLCommand to override required functions
 * to work with SQL queries.
 */

public class Delete implements SQLCommand {

    private String from; // Table name to delete data.
    private Where where; // Delete logic. Object to filter data

    // To get table name.
    public String getFrom() {
        return from;
    }

    // To get condition.
    public Where getWhere() {
        return where;
    }

    // To set table name.
    public void setFrom(String from) {
        this.from = from;
    }

    // To set condition.
    public void setWhere(Where where) {
        this.where = where;
    }

    @Override
    public String toString() {

        // Render SQL command.

        StringBuilder sb = new StringBuilder("DELETE");

        sb.append(" FROM ").append(from);

        // where
        if(where != null){

            sb.append(where);
        }

        sb.append(";");
        return sb.toString();
    }

    @Override
    public void execute() {

        // Validate that table name entered.
        if(from == null){

            throw new IllegalArgumentException("Table name required.");
        }

        // Imitate command executing.
        System.out.println("exec \"" + this + "\"");
    }
}
