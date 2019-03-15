/**
 *
 */
public class Knights2 {

    public static void main(String[] args) {
        Kn kn6 = new Kn(6);
        Kn kn5 = new Kn(5);
        Kn kn4 = new Kn(4);
        Kn kn3 = new Kn(3);
        Kn kn2 = new Kn(2);
        Kn kn1 = new Kn(1);
        kn1.next = kn2;
        kn2.next = kn3;
        kn3.next = kn4;
        kn4.next = kn5;
        kn5.next = kn6;
        kn6.next = kn1;

        Kn result = process(kn1);
        System.out.println("Win: number = "+result.number+", hp = "+result.hp);
    }

    private static Kn process(Kn knight) {
        int h = hit();
        knight.next.hp -= h;
        System.out.println("Knight "+knight.next.number+" has been hit"+" on "+h+" hp");
        if (knight.next.hp <= 0) {
                knight.next = knight.next.next;

        }
        if (knight.next.number == knight.number) return knight;

        return process(knight.next);
    }

    private static int hit() {
        return (int) (Math.random() * 6) + 1;
    }


}

class Kn {
    Kn next;
    int hp = 100;
    int number;

    Kn(int number) {
        this.number = number;
    }
}
