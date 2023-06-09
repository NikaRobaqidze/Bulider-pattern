package ge.tsu.DML;

import ge.tsu.sqlutils.SQLCommand;
import ge.tsu.sqlutils.Where;

public class Delete implements SQLCommand {

    private String from;
    private Where where;

    public String getFrom() {
        return from;
    }

    public Where getWhere() {
        return where;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public void setWhere(Where where) {
        this.where = where;
    }

    @Override
    public String toString() {

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

        // validate table
        if(from == null){

            throw new IllegalArgumentException("Table name required.");
        }

        System.out.println("exec \"" + this + "\"");
    }
}
