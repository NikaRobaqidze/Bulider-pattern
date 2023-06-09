package ge.nick.utils;

import ge.nick.DML.Delete;
import ge.nick.sqlutils.Where;

import java.util.Arrays;

/**
 * Class builder to create object that render DELETE SQL command.
 * Initialize object then by functions set required parameters.
 * At the end get object with set parameters.
 */

public class DeleteBuilder implements Buildable{

    // Initialize required class.
    private final Delete delete = new Delete();

    // Set table name.
    public DeleteBuilder from (String tableName){

        delete.setFrom(tableName);
        return this;
    }

    // Set data filter condition stringified part of SQL command.
    public DeleteBuilder where (String... conditions){

        Where where = new Where();
        where.setConditions(Arrays.stream(conditions).toList());

        delete.setWhere(where);
        return this;
    }

    // Set data filter condition.
    public DeleteBuilder where (Where where){

        delete.setWhere(where);
        return this;
    }

    @Override
    public Delete build() {
        return delete;
    }
}
