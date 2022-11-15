package it.unibo.nestedenum;

import java.util.Comparator;
import java.util.Locale;
import java.util.Objects;

/**
 * Implementation of {@link MonthSorter}.
 */
public final class MonthSorterNested implements MonthSorter {

    public static enum Month {
        JANUARY("January", 31, 1),
        FEBRUARY("February", 28, 2), 
        MARCH("March", 31, 3), 
        APRIL("April", 30, 4), 
        MAY("May", 31, 5), 
        JUNE("June", 30, 6),
        JULY("July", 31, 7), 
        AUGUST("August", 31, 8), 
        SEPTEMBER("September", 30, 9),
        OCTOBER("October", 31, 10),
        NOVEMBER("November", 30, 11), 
        DECEMBER("December", 31, 12);
        
        private static final int NOT_FOUND = -1;

        private final String actualName;
        private final int numberOfDays;
        private final int order;

        private Month(String actualName, int numberOfDays, int order) {
            this.actualName = actualName;
            this.numberOfDays = numberOfDays;
            this.order = order;
        }

        public String getActualName() {
            return this.actualName;
        }

        public int getNumberOfDays() {
            return this.numberOfDays;
        }

        public int getOrder() {
            return this.order;
        } 

        public Month fromString(String monthName) throws AmbiguousMonthNameException, NoSuchMonthException {
            Month result = null;
            for (Month elem : Month.values()) {
                if (elem.getActualName().toLowerCase().indexOf(monthName.toLowerCase()) != NOT_FOUND) {
                    if (result != null) {
                        throw new AmbiguousMonthNameException("This month name: " + monthName + "is ambiguous!", monthName);
                    }
                    result = elem;
                }
            }
            if (result == null) {
                throw new NoSuchMonthException("This month: " + monthName + "doesn't exist!", monthName);
            }
            return result;
        } 
        
        public Month getMonthFromArgument (Month month, String arg) {
            month = month.fromString(arg);
            return month;
        }
    }

    static class SortByMonthOrder implements Comparator<String> {

        @Override
        public int compare(String arg0, String arg1) {
            Month firstMonth = Month.JANUARY;
            Month secondMonth = Month.JANUARY;
            firstMonth = firstMonth.getMonthFromArgument(firstMonth, arg0);
            secondMonth = secondMonth.getMonthFromArgument(secondMonth, arg1);
            return firstMonth.order - secondMonth.order;
        }
    }

    
    static class SortByDaysOrder implements Comparator<String> {

        @Override
        public int compare(String arg0, String arg1) {
            Month firstMonth = Month.JANUARY;
            Month secondMonth = Month.JANUARY;
            firstMonth = firstMonth.getMonthFromArgument(firstMonth, arg0);
            secondMonth = secondMonth.getMonthFromArgument(secondMonth, arg1);
            return firstMonth.numberOfDays - secondMonth.numberOfDays;
        }
    }

    @Override
    public Comparator<String> sortByDays() {
        return new SortByDaysOrder();
    }

    @Override
    public Comparator<String> sortByOrder() {
        return new SortByMonthOrder();
    }
}
