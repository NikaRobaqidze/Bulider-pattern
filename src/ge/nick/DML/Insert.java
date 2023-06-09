package ge.nick.DML;

import ge.nick.sqlutils.SQLCommand;

import java.util.ArrayList;
import java.util.List;

/**
 * Class Insert created to manage and render SQL INSERT command.
 * It implements SQLCommand to override required functions
 * to work with SQL queries.
 */

public class Insert implements SQLCommand {

    private String into; // Table name to insert data.
    private List<String> columns = new ArrayList<>(); // List of column names.
    private List<String> values = new ArrayList<>(); // List of values to insert.

    // To get column name(s).
    public List<String> getColumns() {
        return columns;
    }

    // To set column name(s).
    public void setColumns(List<String> columns) {
        this.columns = columns;
    }

    // To get table name.
    public String getInto() {
        return into;
    }

    // To set table name.
    public void setInto(String into) {
        this.into = into;
    }

    // To get value(s).
    public List<String> getValues() {
        return values;
    }

    // To set value(s).
    public void setValues(List<String> values) {
        this.values = values;
    }

    @Override
    public String toString() {

        // Render SQL command.

        String sb = "INSERT INTO " + into +
                " (" + String.join(", ", columns) + ")" +
                " VALUES (" + String.join(", ", values) + ")" +
                ";";
        return sb;
    }

    @Override
    public void execute() {

        // Check if table set.
        if(into == null){

            throw new IllegalArgumentException("Table name required.");
        }

        // Check if columns name(s) set.
        if (columns.isEmpty()) {

            throw new IllegalArgumentException("Columns have not set.");
        }

        // Check if value(s) set.
        if (values.isEmpty()) {

            throw new IllegalArgumentException("Values have not set.");
        }

        if (columns.size() != values.size()){

            throw new IllegalArgumentException("Error at sql parsing. Different count of columns and values.");
        }

        // Imitate command executing.
        System.out.println("exec \"" + this + "\"");
    }
}
