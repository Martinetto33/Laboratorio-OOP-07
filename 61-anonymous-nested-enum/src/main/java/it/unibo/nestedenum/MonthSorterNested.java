package it.unibo.nestedenum;

import java.util.Comparator;
import java.util.Locale;
import java.util.Objects;

/**
 * Implementation of {@link MonthSorter}.
 */
public final class MonthSorterNested implements MonthSorter {

    @Override
    public Comparator<String> sortByDays() {
        return null;
    }

    @Override
    public Comparator<String> sortByOrder() {
        return null;
    }

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
    }
}
