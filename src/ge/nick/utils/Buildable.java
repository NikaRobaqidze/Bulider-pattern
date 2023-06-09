package ge.nick.utils;

/**
 * Interface that include required functions to build object.
 * Build opportunity is functions that set all required parameters
 * to construct correct object for SQL command rendering.
 */

public interface Buildable {

    // To complete building and get object to render command.
    Object build();
}
