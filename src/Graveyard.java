import java.util.ArrayList;
import java.util.List;

abstract class Graveyard {
    protected List<String> graves = new ArrayList<>();
    protected List<String> freeGraves = new ArrayList<>();
    protected List<String> floweredGraves = new ArrayList<>();
    protected String watchman;

    public Graveyard(String watchman) {
        this.watchman = watchman;
    }

    public abstract void buryPerson(String name, String location);

    public abstract void addGrave(String location);

    public abstract void excavationBody(String name, String location);

    public void printWatchman() {
        System.out.println("Текущий охранник: " + watchman);
    }

    public boolean isGraveOccupied(String location) {
        return graves.contains(location);
    }

    public void plantFlowers(String location) {
        if (isGraveOccupied(location)) {
            System.out.println("Высаживание цветов на могиле в месте " + location);
            floweredGraves.add(location);
        } else {
            System.out.println("Извините, выбранное место не занято или не существует.");
        }
    }

    public void printGraveStatus() {
        System.out.println("Свободные места: " + freeGraves);
        System.out.println("Занятые места: " + graves);
        System.out.println("Места с цветами: " + floweredGraves);
    }

    public void cleanGrave(String location) {
        if (graves.contains(location)) {
            System.out.println("Уборка могилы в месте " + location);
            graves.remove(location);
            freeGraves.add(location);
        } else {
            System.out.println("Извините, выбранное место не занято или не существует.");
        }
    }

    public void switchWatchman(String newWatchman) {
        if (!watchman.equals(newWatchman)) {
            watchman = newWatchman;
            System.out.println("Успех! Прошлый охранник был устранен!!!");
        } else {
            System.out.println("Вы не можете заменить охранника на него самого");
        }
    }

    public String greetTheWatchman() {
        return "Сторож улыбнулся и поприветсвовал Вас в ответ";
    }
}