package ge.tsu.utils;

import ge.tsu.DML.Delete;
import ge.tsu.sqlutils.Where;

import java.util.Arrays;

public class DeleteBuilder implements Buildable{

    private Delete delete = new Delete();

    public DeleteBuilder from (String tablename){

        delete.setFrom(tablename);
        return this;
    }

    public DeleteBuilder where (String... conditions){

        Where where = new Where();
        where.setConditions(Arrays.stream(conditions).toList());

        delete.setWhere(where);
        return this;
    }

    public DeleteBuilder where (Where where){

        delete.setWhere(where);
        return this;
    }

    @Override
    public Delete build() {
        return delete;
    }
}
