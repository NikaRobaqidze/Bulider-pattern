package ge.tsu.utils;

import ge.tsu.DML.Insert;

import java.util.Arrays;

public class InsertBuilder implements Buildable{

    private Insert insert = new Insert();

    public InsertBuilder into(String tablename){

        insert.setInto(tablename);
        return this;
    }

    public InsertBuilder columns(String... columns){

        insert.setColumns(Arrays.stream(columns).toList());
        return this;
    }

    public InsertBuilder values(String... values){

        insert.setValues(Arrays.stream(values).toList());
        return this;
    }

    @Override
    public Insert build() {
        return insert;
    }
}
