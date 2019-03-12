import java.util.ArrayList;

public class Test2 {
    static ArrayList<Knight> knights = new ArrayList<>();

    static{
        for (int i = 1; i <= 6; i++) {
            Knight knight = new Knight();
            knight.number = i;
         knights.add(knight);
        }
    }

    public static void main(String[] args) {
        while (knights.size()>1){
            int size = knights.size();
            for (int i = 0; i < size; i++){
                Knight knight = knights.get(i+1);
                if (knights.get(i).hp<=0){
                    knights.remove(i);
                    size = size-1;
                    System.out.println("Knight "+knight.number+" died");
                }
                knight.hp = knight.hp-hit();
                System.out.println("Knight "+knight.number+" has been hit ");
                knights.set(i, knight);
            }

        }
        System.out.println("Knight "+knights.get(0).number +" win");

    }

    public static int hit()
    {
        return (int)(Math.random() * 6) + 1;
    }

}

