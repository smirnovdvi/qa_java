import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import java.util.Arrays;
import java.util.List;

public class LionTest {

    @Mock
    private Predator predator;

    private Lion lion;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        lion = new Lion(predator, "Самец");
    }

    @Test
    public void testDoesHaveManeWhenMale() {
        assertEquals(true, lion.doesHaveMane());
    }

    @Test
    public void testDoesNotHaveManeWhenFemale() throws Exception {
        lion = new Lion(predator, "Самка");
        assertEquals(false, lion.doesHaveMane());
    }

    @Test
    public void testGetKittens() {
        when(predator.getKittens()).thenReturn(3);
        assertEquals(3, lion.getKittens());
    }

    @Test
    public void testGetFood() throws Exception {
        when(predator.getFood("Хищник")).thenReturn(Arrays.asList("Животные", "Птицы", "Рыба"));
        List<String> expected = Arrays.asList("Животные", "Птицы", "Рыба");
        assertEquals(expected, lion.getFood());
    }

    @Test(expected = Exception.class)
    public void testInvalidSexThrowsException() throws Exception {
        new Lion(predator, "НекорректныйПол");
    }
}