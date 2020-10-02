package commons;

public class Printer {

    public Printer printGreeting(){
        System.out.println("printGreeting:   Hello there! ");
        return this;
    }

    public Printer printFavoriteNum(){
        System.out.println("printFavoriteNum:      My favorite number is 1");
        return this;
    }

    public Printer printColor(){
        System.out.println("printColor:     Green");
        return this;
    }
}
