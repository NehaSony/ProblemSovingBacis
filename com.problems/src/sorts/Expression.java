package sorts;

public class Expression implements Comparable<Expression> {

    private final String definition;
    private final int key;

    public static final Expression build(final String definition) {
        return new Expression(definition);
    }

    public Expression(final String definition) {
        this.definition = definition;
        this.key = Expression.calculateKey(this.definition);
    }

    public String getDefinition() {
        return this.definition;
    }

    public int getKey() {
        return this.key;
    }

    @Override
    public int compareTo(Expression o) {
        return this.key - Expression.calculateKey(o.getDefinition());
    }

    public static int calculateKey(String definition) {
        int key = 0;
        for (int i = 0; i < definition.length(); i++) {
            key += (int) definition.charAt(i) * (i + 1);
        }
        return key;

    }

    @Override
    public String toString() {
        return "Expression{" +
                "definition='" + definition + '\'' +
                "key='" + key + '\'' +
                '}';
    }
}
