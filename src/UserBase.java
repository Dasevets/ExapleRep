import java.util.Scanner;

public class UserBase {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        User[] userBase = new User[10];

        for (int i = 0; i < userBase.length; i++) {
            System.out.println("Введите данные:");
            String fN = scanner.nextLine();
            String lN = scanner.nextLine();
            String tN = scanner.nextLine();


            if (fN.equals("s") || lN.equals("s") || tN.equals("s")) {
                break;
            }

            if (lN.equals("") && tN.equals("")) {
                userBase[i] = new User(fN);
            } else if (tN.equals("")) {
                userBase[i] = new User(fN, lN);
            } else {
                if (tN.length() < 7) {
                    System.out.println("Неверный формат номера.");
                }
                userBase[i] = new User(fN, lN, tN);
            }

            if (fN.equals("p") || lN.equals("p") || tN.equals("p")) {
                System.out.println("Введие индекс:");
                int n = scanner.nextInt();
                User.userPrint(userBase[n - 1]);
            }
        }
    }


}

class User {
    private String firstName;
    private String lastName;
    private String telephoneNumber;


    public User(String firstName) {
        this.firstName = firstName;
    }

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public User(String firstName, String lastName, String telephoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.telephoneNumber = telForm(telephoneNumber);

    }

    public String telForm(String telNumb) {
        int eInd = telNumb.length() - 3;
        String t1 = telNumb.substring(0, eInd);

        StringBuilder sb = new StringBuilder(eInd); //создаем строку из звездчек
        for (int i = 0; i < eInd; i++) {
            sb.append('*');
        }
        String t2 = sb.toString();

        String telNumbForm = telNumb.replaceAll(t1, t2); //заменяем часть номера телефона звездами
        return telNumbForm;
    }

    public static void userPrint(User user) {
        StringBuilder stringBuilder = new StringBuilder(user.firstName);
        if (user.lastName == null && user.telephoneNumber == null) {
            System.out.println(stringBuilder);
        } else if (user.lastName != null && user.telephoneNumber == null) {
            stringBuilder.append(" ");
            stringBuilder.append(user.lastName);
            System.out.println(stringBuilder);
        } else {
            stringBuilder.append(" ");
            stringBuilder.append(user.lastName);
            stringBuilder.append(" ");
            stringBuilder.append(user.telephoneNumber);
            System.out.println(stringBuilder);
        }


    }


}

