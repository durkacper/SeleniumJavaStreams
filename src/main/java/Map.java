import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Stream;

public class Map {

    @Test
    public void streamMap(){

        //print names which have last letter as "a" with UPPERCASE
        Stream.of("Adam", "Dona", "Alex", "Anastasia", "Tom").filter(s -> s.endsWith("a")).map(s -> s.toUpperCase()).forEach(s -> System.out.println(s));

        //print names which have first letter as "a" with UPPERCASE and sorted
        Stream.of("Adam", "Dona", "Alex", "Anastasia", "Tom").filter(s -> s.startsWith("A")).sorted().map(s -> s.toUpperCase()).forEach(s -> System.out.println(s));

        //merge two lists
        List<String> names = Arrays.asList("Adam", "Dona", "Alex", "Anastasia", "Tom");
        List<String> surnames = Arrays.asList("Brown", "Nicholson", "Stallone", "Pitt", "Green");

        Stream<String> fullName = Stream.concat(names.stream(), surnames.stream());
        fullName.forEach(s -> System.out.println(s));




    }
}
