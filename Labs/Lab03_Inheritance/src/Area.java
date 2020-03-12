import Candies.CandyBox;

public class Area {
    CandyBag candyBag;
    int number;
    String street;

    public Area() {}

    public Area(CandyBag candyBag, int number, String street) {
        this.candyBag = candyBag;
        this.number = number;
        this.street = street;
    }

    void getBirthdayCard () {
        System.out.println(street + " " + number);
        System.out.println("La multi ani !");
        System.out.println();

        for(CandyBox candy : candyBag.candies) {
//            if (candy instanceof Candies.Baravelli) {
//                candy = (Candies.Baravelli) candy;
//                ((Candies.Baravelli) candy).printBaravelliDim();
//                System.out.println("Volume is: " + candy.getVolume());
//            }
//
//            if (candy instanceof Candies.Lindt) {
//                candy = (Candies.Lindt) candy;
//                ((Candies.Lindt) candy).printLindtDim();
//                System.out.println("Volume is: " + candy.getVolume());
//            }
//
//            if (candy instanceof Candies.ChocAmor) {
//                candy = (Candies.ChocAmor) candy;
//                ((Candies.ChocAmor) candy).printChocAmorDim();
//                System.out.println("Volume is: " + candy.getVolume());
//            }

            candy.print();
            System.out.println(candy.toString());
            System.out.println();
        }
    }
}
