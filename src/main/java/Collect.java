import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;


public class Collect {

    @Test
    public void streamCollect() {

        // we have the List --> do some modification and store results in new List

        //List
        List<String> list = Arrays.asList("Dona", "Adam", "Alex", "Anastasia", "Tom");

        //do some modifications and store them in new List
        List<String> newList = list.stream().filter(s -> s.startsWith("A")).map(s -> s.toUpperCase()).collect(Collectors.toList());

        //print the new List
        System.out.println(newList);


        //EXTRA assignment
        //1. print unique numbers from array
        //2. sort the array
        //3. store it to new list
        //4. print third value

        List<Integer> numbers = Arrays.asList(4, 2, 2, 7, 5, 1, 9, 9, 7);

        List<Integer> uniqueNumbers = numbers.stream().distinct().sorted().collect(Collectors.toList());
        System.out.println(uniqueNumbers.get(2));


    }
}
