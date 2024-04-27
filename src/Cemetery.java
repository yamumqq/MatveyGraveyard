import java.util.Scanner;

public class Cemetery extends Graveyard {

    public Cemetery(String watchman) {
        super(watchman);
    }


    public void buryPerson(String name, String location) {
        if (freeGraves.contains(location)) {
            System.out.println("Захоронение человека " + name + " в месте " + location);
            graves.add(location);
            freeGraves.remove(location);
        } else {
            System.out.println("Извините, выбранное место уже занято. Пожалуйста, выберите другое место для захоронения.");
        }
    }


    public void addGrave(String location) {
        if (!graves.contains(location) && !freeGraves.contains(location)) {
            freeGraves.add(location);
            System.out.println("Могила добавлена в пустые места.");
        } else {
            System.out.println("Извините, могила уже существует или занята.");
        }
    }


    public void excavationBody(String name, String location) {
        if (graves.contains(location)) {
            System.out.println("Выкапывание тела человека " + name + " с места " + location + " и освобождение места.");
            freeGraves.add(location);
            graves.remove(location);
        } else {
            System.out.println("Извините, выбранное место не занято.");
        }
    }

    public static void main(String[] args) {
        Cemetery cemetery = new Cemetery("Святослав");

        Scanner scanner = new Scanner(System.in);
        int operation;

        while (true) {
            System.out.println("Введите номер операции:");
            System.out.println("1. Захоронение человека");
            System.out.println("2. Добавление могилы");
            System.out.println("3. Выкапывание тела");
            System.out.println("4. Просмотр текущего охранника");
            System.out.println("5. Посадка цветов на могиле");
            System.out.println("6. Просмотр статуса могил");
            System.out.println("7. Уборка могилы");
            System.out.println("8. Смена охранника");
            System.out.println("9. Приветствие охранника");
            System.out.println("10. Выход");

            operation = scanner.nextInt();

            switch (operation) {
                case 1:
                    System.out.println("Введите имя и место для захоронения:");
                    String name = scanner.next();
                    String location = scanner.next();
                    cemetery.buryPerson(name, location);
                    break;
                case 2:
                    System.out.println("Введите место для добавления:");
                    location = scanner.next();
                    cemetery.addGrave(location);
                    break;
                case 3:
                    System.out.println("Введите имя и место для выкапывания:");
                    name = scanner.next();
                    location = scanner.next();
                    cemetery.excavationBody(name, location);
                    break;
                case 4:
                    cemetery.printWatchman();
                    break;
                case 5:
                    System.out.println("Введите место для посадки цветов:");
                    location = scanner.next();
                    cemetery.plantFlowers(location);
                    break;
                case 6:
                    cemetery.printGraveStatus();
                    break;
                case 7:
                    System.out.println("Введите место для уборки:");
                    location = scanner.next();
                    cemetery.cleanGrave(location);
                    break;
                case 8:
                    System.out.println("Введите нового охранника:");
                    String newWatchman = scanner.next();
                    cemetery.switchWatchman(newWatchman);
                    break;
                case 9:
                    System.out.println(cemetery.greetTheWatchman());
                    break;
                case 10:
                    System.out.println("Выход из программы.");
                    return;
                default:
                    System.out.println("Неверная операция.");
            }
        }
    }
}