import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.taskmanager.*;

import java.util.Arrays;

public class TaskTest {

    SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

    String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
    Epic epic = new Epic(55, subtasks);

    Meeting meeting = new Meeting(
            555,
            "Выкатка 3й версии приложения",
            "Приложение НетоБанка",
            "Во вторник после обеда"
    );

    @Test
    public void shouldFindMatchesInEpic() {
        boolean expected = true;
        boolean actual = epic.matches("Молоко");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotFindMatchesInEpic() {
        boolean expected = false;
        boolean actual = epic.matches("Каша");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindMatchesInMeetingProject() {
        boolean expected = true;
        boolean actual = meeting.matches("Приложение");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindMatchesInMeetingTopic() {
        boolean expected = true;
        boolean actual = meeting.matches("3й");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotFindMatchesInMeeting() {
        boolean expected = false;
        boolean actual = meeting.matches("В четверг");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindMatchesInSimpleTasks() {
        boolean expected = true;
        boolean actual = simpleTask.matches("Позвонить");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotFindMatchesInSimpleTasks() {
        boolean expected = false;
        boolean actual = simpleTask.matches("Набрать");

        Assertions.assertEquals(expected, actual);
    }
}
