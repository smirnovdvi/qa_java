package praktikum;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.List;

import com.example.IFeline;
import com.example.Lion;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    private IFeline mockFeline;

    private Lion lionMale;
    private Lion lionFemale;

    @Before
    public void setUp() throws Exception {
        lionMale = new Lion("Самец", mockFeline);
        lionFemale = new Lion("Самка", mockFeline);
    }

    @Test
    public void testDoesHaveManeForMale() {
        assertTrue(lionMale.doesHaveMane());
    }

    @Test
    public void testDoesNotHaveManeForFemale() {
        assertFalse(lionFemale.doesHaveMane());
    }

    @Test
    public void testGetKittensDelegatesToFeline() {
        when(mockFeline.getKittens()).thenReturn(3);

        assertEquals(3, lionMale.getKittens());
        assertEquals(3, lionFemale.getKittens());
    }

    @Test
    public void testGetFoodDelegatesToFeline() throws Exception {
        when(mockFeline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));

        List<String> food = lionMale.getFood();
        assertEquals(List.of("Животные", "Птицы", "Рыба"), food);
    }

    @Test(expected = Exception.class)
    public void testConstructorThrowsExceptionForInvalidSex() throws Exception {
        new Lion("Неправильный пол", mockFeline); // Ожидается исключение
    }
}