package it.unibo.nestedenum;

public class NoSuchMonthException extends IllegalArgumentException {
    private final String argument;

    public NoSuchMonthException(final String s, final String arg) {
        super(s);
        this.argument = arg;
    }

    private String getArg() {
        return this.argument;
    }

    public String toString() {
        return "No month with name '" + this.getArg() + "' exists!";
    }
}
