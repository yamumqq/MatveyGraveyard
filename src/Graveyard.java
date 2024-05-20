import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

abstract class Graveyard {
    protected List<String> graves = new ArrayList<>();
    protected List<String> freeGraves = new ArrayList<>();
    protected List<String> floweredGraves = new ArrayList<>();
    protected String watchman;

    static Log GraveyardLog;

    static {
        try {
            GraveyardLog = new Log("Graveyard.log", Level.ALL);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

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
            GraveyardLog.Logger.info("Высаживание цветов на могиле в месте " + location);
            floweredGraves.add(location);
        } else {
            GraveyardLog.Logger.info("Извините, выбранное место не занято или не существует.");
        }
    }

    public void printGraveStatus() {
        GraveyardLog.Logger.info("Свободные места: " + freeGraves);
        GraveyardLog.Logger.info("Занятые места: " + graves);
        GraveyardLog.Logger.info("Места с цветами: " + floweredGraves);
    }

    public void cleanGrave(String location) {
        if (graves.contains(location)) {
            GraveyardLog.Logger.info("Уборка могилы в месте " + location);
            graves.remove(location);
            freeGraves.add(location);
        } else {
            GraveyardLog.Logger.info("Извините, выбранное место не занято или не существует.");
        }
    }

    public void switchWatchman(String newWatchman) {
        if (!watchman.equals(newWatchman)) {
            watchman = newWatchman;
            GraveyardLog.Logger.info("Успех! Прошлый охранник был устранен!!!");
        } else {
            GraveyardLog.Logger.info("Вы не можете заменить охранника на него самого");
        }
    }

    public String greetTheWatchman() {
        return "Сторож улыбнулся и поприветсвовал Вас в ответ";
    }
}