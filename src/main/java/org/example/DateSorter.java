package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public class DateSorter {
    /**
     * The implementation of this method should sort dates.
     * The output should be in the following order:
     * Dates with an 'r' in the month,
     * sorted ascending (first to last),
     * then dates without an 'r' in the month,
     * sorted descending (last to first).
     * For example, October dates would come before May dates,
     * because October has an 'r' in it.
     * thus: (2004-07-01, 2005-01-02, 2007-01-01, 2032-05-03)
     * would sort to
     * (2005-01-02, 2007-01-01, 2032-05-03, 2004-07-01)
     *
     * @param unsortedDates - an unsorted list of dates
     * @return the collection of dates now sorted as per the spec
     */
    public Collection<LocalDate> sortDates(List<LocalDate> unsortedDates) {
        List<LocalDate> resultList = new ArrayList<>();
        List<LocalDate> listWithoutR = new ArrayList<>();

        unsortedDates.forEach(date -> {
            if (date.getMonthValue() <= 4 || date.getMonthValue() >= 9) {
                resultList.add(date);
            } else {
                listWithoutR.add(date);
            }
        });

        resultList.sort(new DateComparator());
        listWithoutR.sort(new DateComparator());
        resultList.addAll(listWithoutR);

        return resultList;
    }

    static class DateComparator implements Comparator<LocalDate> {
        @Override
        public int compare(LocalDate date1, LocalDate date2) {
            if(date1.getMonthValue() <= 4 || date1.getMonthValue() >= 9
                && date2.getMonthValue() <= 4 || date2.getMonthValue() >= 9) {
                return date1.compareTo(date2);
            } else {
                return -1 * date1.compareTo(date2);
            }
        }
    }
}
