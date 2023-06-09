/**
 * @Author: Nika Robaqidze
 * @Email: nika42568@gmail.com

 * Scenario:
 * Initialize object to render SQL commands.
 * By functions set parameters then build object.
 * As result imitate command execution.
 * Print rendered result on the screen.
 */

package ge.nick;

import ge.nick.DML.*;
import ge.nick.DQL.*;

import ge.nick.sqlutils.LogicOperators;
import ge.nick.sqlutils.Where;

import ge.nick.utils.DeleteBuilder;
import ge.nick.utils.InsertBuilder;
import ge.nick.utils.SelectBuilder;

import java.util.Arrays;

public class Launcher {

    public static void main(String[] args) {

        // Initialize INSERT command object renderer.
        Insert insert = new InsertBuilder()
                .into("Person")
                .columns("Name", "LastName", "Age")
                .values("'Joe'", "'Doe'", "33")
                .build();

        // Execute rendered INSERT command.
        insert.execute();

        // Initialize SELECT command object renderer.
        Select select = new SelectBuilder()
                .columns("Name", "LastName", "Age")
                .from("Person")
                .build();

        // Execute rendered SELECT command.
        select.execute();

        String[] conditions = {"Name = 'Joe'", "LastName = 'Doe'", "Age = 33"};
        LogicOperators[] logicOperators = {LogicOperators.AND, LogicOperators.AND};

        // Initialize data filter object.
        Where where = new Where();

        // Set filter conditions.
        where.setConditions(Arrays.stream(conditions).toList());
        // Set filter logic operators.
        where.setLogics(Arrays.stream(logicOperators).toList());


        // Execute rendered DELETE command.
        Delete delete = new DeleteBuilder()
                .from("Person")
                .where(where)
                .build();

        // Execute rendered DELETE command.
        delete.execute();
    }
}