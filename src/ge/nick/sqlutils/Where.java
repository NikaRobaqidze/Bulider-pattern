package ge.nick.sqlutils;

import java.util.ArrayList;
import java.util.List;

/**
 * Class where to set logic condition at SQL command.
 * Logic mean filter data for work.
 * Filter data with some logic.
 * And unite logic by operators.
 */

public class Where {

    // Filter condition.
    private List<String> conditions = new ArrayList<>();

    // Logic operators.
    private List<LogicOperators> logics = new ArrayList<>();

    // To get filter conditions.
    public List<String> getConditions() {
        return conditions;
    }

    // To get logic operators.
    public List<LogicOperators> getLogics() {
        return logics;
    }

    // To set filter conditions.
    public void setConditions(List<String> conditions) {
        this.conditions = conditions;
    }

    // To set logic operators.
    public void setLogics(List<LogicOperators> logics) {
        this.logics = logics;
    }

    @Override
    public String toString() {

        // Render SQL command.

        final int size = conditions.size();

        StringBuilder sb = new StringBuilder(size > 0 ? " WHERE" : "");

        for (int i = 0; i < conditions.size(); i++){

            sb.append(" ").append(conditions.get(i));

            if(i != conditions.size() - 1 && i < logics.size()) {

                sb.append(" ").append(logics.get(i));

            } else if(i != conditions.size() - 1){

                sb.append(" OR");
            }
        }

        return sb.toString();
    }
}
