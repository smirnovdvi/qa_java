package praktikum;

import static org.junit.Assert.assertEquals;

import java.util.List;

import com.example.Feline;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    private Feline feline;

    @Before
    public void setUp() {
        feline = new Feline();
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
    public void testGetKittensWithParameter() {
        assertEquals(5, feline.getKittens(5));
    }

    @Test
    public void testEatMeatReturnsCorrectFoodForCarnivore() throws Exception {
        List<String> actualFood = feline.eatMeat();

        assertEquals(List.of("Животные", "Птицы", "Рыба"), actualFood);
    }
}