package praktikum;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;

import com.example.Cat;
import com.example.Feline;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Mock
    private Feline mockFeline;

    private Cat cat;

    @Before
    public void setUp() {
        cat = new Cat(mockFeline);
    }

    @Test
    public void testGetSound() {
        assertEquals("Мяу", cat.getSound());
    }

    @Test
    public void testGetFoodWhenEatMeatReturnsCorrectly() throws Exception {
        when(mockFeline.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));

        List<String> food = cat.getFood();
        assertEquals(List.of("Животные", "Птицы", "Рыба"), food);
    }

    @Test(expected = Exception.class)
    public void testGetFoodThrowsExceptionWhenEatMeatFails() throws Exception {
        when(mockFeline.eatMeat()).thenThrow(new Exception("Ошибка получения пищи"));

        cat.getFood();
    }
}