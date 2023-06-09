package ge.tsu;

import ge.tsu.DML.Delete;
import ge.tsu.DML.Insert;
import ge.tsu.DQL.Select;
import ge.tsu.sqlutils.LogicOperators;
import ge.tsu.sqlutils.Where;
import ge.tsu.utils.DeleteBuilder;
import ge.tsu.utils.InsertBuilder;
import ge.tsu.utils.SelectBuilder;

import java.util.Arrays;

public class Launcher {

    public static void main(String[] args) {

        Insert insert = new InsertBuilder()
                .into("Person")
                .columns("Name", "LastName", "Age")
                .values("'Joe'", "'Doe'", "33")
                .build();

        insert.execute();

        Select select = new SelectBuilder()
                .columns("Name", "LastName", "Age")
                .from("Person")
                .build();

        select.execute();

        String[] conditions = {"Name = 'Joe'", "LastName = 'Doe'", "Age = 33"};
        LogicOperators[] logicOperators = {LogicOperators.AND, LogicOperators.AND};

        Where where = new Where();

        where.setConditions(Arrays.stream(conditions).toList());
        where.setLogics(Arrays.stream(logicOperators).toList());

        Delete delete = new DeleteBuilder()
                .from("Person")
                .where(where)
                .build();

        delete.execute();
    }
}