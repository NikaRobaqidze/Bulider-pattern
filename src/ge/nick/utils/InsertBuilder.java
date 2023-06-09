package ge.nick.utils;

import ge.nick.DML.Insert;

import java.util.Arrays;

/**
 * Class builder to create object that render INSERT SQL command.
 * Initialize object then by functions set required parameters.
 * At the end get object with set parameters.
 */

public class InsertBuilder implements Buildable{

    // Initialize required class.
    private Insert insert = new Insert();

    // Set table name.
    public InsertBuilder into(String tableName){

        insert.setInto(tableName);
        return this;
    }

    // Set table column name(s).
    public InsertBuilder columns(String... columns){

        insert.setColumns(Arrays.stream(columns).toList());
        return this;
    }

    // Set value(s) to insert.
    public InsertBuilder values(String... values){

        insert.setValues(Arrays.stream(values).toList());
        return this;
    }

    @Override
    public Insert build() {
        return insert;
    }
}
