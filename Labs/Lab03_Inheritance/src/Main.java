import Candies.Baravelli;
import Candies.ChocAmor;
import Candies.Lindt;

public class Main {

    public static void main(String[] args) {
        CandyBag candyBag = new CandyBag();
        Area area = new Area(candyBag, 7, "1 Decembrie 1918");

        Baravelli b1 = new Baravelli(2, 3, "B", "B");
        Baravelli b2 = new Baravelli(3, 9, "Ba", "Ba");

        ChocAmor c1 = new ChocAmor(4, "C", "C");
        ChocAmor c2 = new ChocAmor(69, "CA", "CA");

        Lindt l1 = new Lindt(1, 2, 3, "L", "L");
        Lindt l2 = new Lindt(3, 7, 4, "Li", "Li");

        candyBag.candies.add(b1);
        candyBag.candies.add(b2);
        candyBag.candies.add(c1);
        candyBag.candies.add(c2);
        candyBag.candies.add(l1);
        candyBag.candies.add(l2);

        area.getBirthdayCard();
    }
}