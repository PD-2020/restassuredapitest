package commons;

import org.testng.annotations.Test;

public class FluentTest {

    @Test
    public void practice_fluent(){
      new Printer()
                .printGreeting()
                 .printFavoriteNum()
                 .printColor()
                 .printColor()
                 .printColor()
                 .printColor()
                    .printFavoriteNum()
                    .printGreeting();
    }



}
