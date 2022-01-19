import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cart cart1=new Cart(null);
        Cart cart2=new Cart(null);
        Worker worker= new Worker("itay","amos","itisitay123","12345",3,cart1);
        User user=new User("etai","amoss","itayyy","555",true,cart2);
        Store store= new Store(user,worker);
        System.out.println("1. create user" +'\n' + "2. log in" + '\n' + "3. exit");
        int n = scanner.nextInt();
        store.menu(n);
        System.out.println(store);
            ///שי זה היה דוגמה בשביל עצמי

        }
}
