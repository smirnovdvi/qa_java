import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import java.util.Arrays;
import java.util.List;

public class FelineTest {

    @Mock
    private Animal animal;

    private Feline feline;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        feline = new Feline();
    }

    @Test
    public void testEatMeat() throws Exception {
        when(animal.getFood("Хищник")).thenReturn(Arrays.asList("Животные", "Птицы", "Рыба"));
        List<String> expected = Arrays.asList("Животные", "Птицы", "Рыба");
        assertEquals(expected, feline.eatMeat());
    }

    @Test
    public void testGetFamily() {
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void testGetKittensDefault() {
        assertEquals(1, feline.getKittens());
    }

    @Test
    public void testGetKittensWithCount() {
        assertEquals(3, feline.getKittens(3));
    }
}