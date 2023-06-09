package ge.tsu.sqlutils;

import java.util.ArrayList;
import java.util.List;

public class Where {

    private List<String> conditions = new ArrayList<>();
    private List<LogicOperators> logics = new ArrayList<>();

    public List<String> getConditions() {
        return conditions;
    }

    public List<LogicOperators> getLogics() {
        return logics;
    }

    public void setConditions(List<String> conditions) {
        this.conditions = conditions;
    }

    public void setLogics(List<LogicOperators> logics) {
        this.logics = logics;
    }

    @Override
    public String toString() {

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
