import java.util.ArrayList;
import java.util.Iterator;

public class Knights {
    private static ArrayList<Knight> knights = new ArrayList<>();
    private static boolean firstRun = true;

    static {
        for (int i = 1; i <= 6; i++) {
            Knight knight = new Knight();
            knight.number = i;
            knights.add(knight);
        }
    }

    public static void main(String[] args) {
        while (knights.size() > 1) {
            Iterator<Knight> iter = knights.iterator();
            if (firstRun) {
                iter.next();
                firstRun=false;
            }
            while (iter.hasNext()) {
                Knight knight = iter.next();
                if (knight.hp <= 0) {
                    iter.remove();
                    System.out.println("Knight " + knight.number + " died");
                }
                knight.hp = knight.hp - hit();
                System.out.println("Knight " + knight.number + " has been hit ");
                if (knights.size() ==1)break;
            }
        }
        System.out.println("Knight " + knights.get(0).number + " win");

    }

    private static int hit() {
        return (int) (Math.random() * 6) + 1;
    }

}

class Knight {
    int number;
    int hp = 100;

}

