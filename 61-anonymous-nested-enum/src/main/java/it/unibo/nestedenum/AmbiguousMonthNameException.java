package it.unibo.nestedenum;

public class AmbiguousMonthNameException extends Exception {
    
    private final String argument;

    public AmbiguousMonthNameException(final String s, final String arg) {
        super(s);
        this.argument = arg;
    }

    private String getArg() {
        return this.argument;
    }

    public String toString() {
        return "Ambiguous argument passed: " + this.getArg();
    }
}
