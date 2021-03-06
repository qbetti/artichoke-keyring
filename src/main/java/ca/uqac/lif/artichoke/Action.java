package ca.uqac.lif.artichoke;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class Action {

    private String target;
    private String type;
    private String value;

    public Action(String target, String type, String value) {
        this.target = target;
        this.type = type;
        this.value = value;
    }

    public String encode() {
        return this.toString();
    }

    public static Action decode(String encodedAction) {
        JsonElement jAction = new JsonParser().parse(encodedAction);
        JsonArray array = jAction.getAsJsonArray();
        return new Action(array.get(0).getAsString(), array.get(1).getAsString(), array.get(2).getAsString());
    }

    public JsonArray toJsonArray() {
        JsonArray array = new JsonArray();
        array.add(target);
        array.add(type);
        array.add(value);

        return array;
    }

    /**
     * Returns the target of the action
     * @return the target of the action
     */
    public String getTarget() {
        return target;
    }

    /**
     * Returns the type of the action
     * @return the type of the action
     */
    public String getType() {
        return type;
    }

    /**
     * Returns the value of the action (might be empty or null)
     * @return the value of the action
     */
    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return toJsonArray().toString();
    }
}
