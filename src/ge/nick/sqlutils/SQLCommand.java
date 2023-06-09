package ge.nick.sqlutils;

/**
 * Interface that includes required functions to work SQL queries.
 * This functions must be override in implemented classes
 * to set opportunities of working with SQL queries.
 */

public interface SQLCommand {

    // To execute rendered SQL command.
    void execute();

    // Todo send query to database.
}
