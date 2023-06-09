package ge.tsu.DML;

import ge.tsu.sqlutils.SQLCommand;

import java.util.ArrayList;
import java.util.List;

public class Insert implements SQLCommand {

    private String into;
    private List<String> columns = new ArrayList<>();
    private List<String> values = new ArrayList<>();

    public List<String> getColumns() {
        return columns;
    }

    public void setColumns(List<String> columns) {
        this.columns = columns;
    }

    public String getInto() {
        return into;
    }

    public void setInto(String into) {
        this.into = into;
    }

    public List<String> getValues() {
        return values;
    }

    public void setValues(List<String> values) {
        this.values = values;
    }

    @Override
    public String toString() {

        // table name
        String sb = "INSERT INTO " + into +
                " (" + String.join(", ", columns) + ")" +
                " VALUES (" + String.join(", ", values) + ")" +
                ";";
        return sb;
    }

    @Override
    public void execute() {

        // validate table
        if(into == null){

            throw new IllegalArgumentException("Table name required.");
        }

        // columns
        if (columns.isEmpty()) {

            throw new IllegalArgumentException("Columns have not set.");
        }

        // values
        if (values.isEmpty()) {

            throw new IllegalArgumentException("Values have not set.");
        }

        if (columns.size() != values.size()){

            throw new IllegalArgumentException("Error at sql parsing. Different count of columns and values.");
        }

        System.out.println("exec \"" + this + "\"");
    }
}
