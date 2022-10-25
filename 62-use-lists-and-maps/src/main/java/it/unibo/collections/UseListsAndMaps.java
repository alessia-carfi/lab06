package it.unibo.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Example class using {@link List} and {@link Map}.
 *
 */
public final class UseListsAndMaps {

    private UseListsAndMaps() {
    }

    /**
     * @param s
     *            unused
     */
    public static void main(final String... s) {
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */
        final int start = 1000;
        final int end = 2000;

        final List<Integer> alist = new ArrayList<>();
        for(int i = start; i < end; i++) {
            alist.add(i);
        } 

        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */

        final List<Integer> llist = new LinkedList<>(alist);

        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
        
        final int size = alist.size();
        final int tmp = alist.get(size - 1);
        alist.set(size - 1, alist.get(0));
        alist.set(0, tmp);

        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */

        for(final int i : alist) {
            System.out.print(i + ", ");
        }
        System.out.println();

        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
        final int elem = 100_000;
        UseListsAndMaps.calculateTimeToInsert(elem, alist, "Time required for ArrayList");
        UseListsAndMaps.calculateTimeToInsert(elem, llist, "Time required for LinkedList");

        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example PerfTest.java.
         */

        final int reads = 1000;
        UseListsAndMaps.calculateTimeToRead(reads, alist, "Time required for ArrayList");
        UseListsAndMaps.calculateTimeToRead(reads, llist, "Time required for LinkedList");

        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         *
         * Africa -> 1,110,635,000
         *
         * Americas -> 972,005,000
         *
         * Antarctica -> 0
         *
         * Asia -> 4,298,723,000
         *
         * Europe -> 742,452,000
         *
         * Oceania -> 38,304,000
         */

        Map<String, Long> map = new HashMap<>();
        map.put("Africa", 1_110_635_000L);
        map.put("Americas", 972_005_000L);
        map.put("Antartica", 0L);
        map.put("Asia", 4_298_723_000L);
        map.put("Europe", 742_452_000L);
        map.put("Oceania", 38_304_000L);

        /*
         * 8) Compute the population of the world
         */

        long populationTot = 0;
        for(final long p : map.values()){
            populationTot += p;
        }
        System.out.println("Popolazione totale: " + populationTot);
    }

    static private void calculateTimeToInsert(int numberOfTimes, List<Integer> list, String textMessage) {

        long time = System.nanoTime();
        for(int i = 0; i < numberOfTimes; i++) {
            list.add(i);
        }
        time = System.nanoTime() - time;
        System.out.println(textMessage + ": " + time);
    }

    static private void calculateTimeToRead(int numberOfTimes, List<Integer> list, String textMessage) {

        long time = System.nanoTime();
        for(int i = 0; i < numberOfTimes; i++) {
            list.get(list.size() / 2);
        }
        time = System.nanoTime() - time;
        System.out.println(textMessage + ": " + time);
    }

}
