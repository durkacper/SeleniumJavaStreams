import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class Match {

    @Test
    public void streamMatch(){

        //check if "Adam" is present in List - return True or False
        List<String> names = Arrays.asList("Adam", "Dona", "Alex", "Anastasia", "Tom");
        boolean flag = names.stream().anyMatch(s -> s.equalsIgnoreCase("Adam"));

        Assert.assertTrue(flag);



    }
}
