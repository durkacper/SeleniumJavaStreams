import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Filters {

    @Test
    public void regular() {

        //Count the number of names starting with alphabet "A" in list

        ArrayList<String> names = new ArrayList<String>();
        names.add("Adam");
        names.add("Don");
        names.add("Alex");
        names.add("Anastasia");
        names.add("Tom");

        int count = 0;

        for (int i = 0; i < names.size(); i++) {
            String actual = names.get(i);
            if (actual.startsWith("A")) {
                count++;
            }
        }
        System.out.println(count);
    }


    @Test
    public void streamFilter() {
        ArrayList<String> names = new ArrayList<String>();
        names.add("Adam");
        names.add("Don");
        names.add("Alexander");
        names.add("Anastasia");
        names.add("Tom");

        //TIP - we can store e.g. names in List and easily convert the List to ArrayList (we want to have Strings)
        List<String> namess = Arrays.asList("Adam", "Don", "Alex", "Anastasia", "Tom");

        //convert to stream - intermediate operation (filter) - lambda expression (s-> ...) - terminal operation (count())
        Long count = names.stream().filter(s -> s.startsWith("A")).count();
        System.out.println(count);

        // We can create stream of values and filter it in one line:
        Long count2 = Stream.of("Adam", "Don", "Alex", "Anastasia", "Tom").filter(s -> s.startsWith("A")).count();
        System.out.println(count2);


        // print all the names of ArrayList where the length of the name is greater than 4
        names.stream().filter(s -> s.length() > 4).forEach(s -> System.out.println(s));

        //print only one result of above requirement
        names.stream().filter(s -> s.length() > 4).limit(1).forEach(s -> System.out.println(s));

    }


}
