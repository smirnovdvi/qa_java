package praktikum;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import com.example.IFeline;
import com.example.Lion;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.mockito.Mock;

@RunWith(Parameterized.class)
public class LionParameterizedTest {

    @Mock
    private IFeline mockFeline;

    private Lion lion;
    private final String sex;
    private final boolean expectedHasMane;

    public LionParameterizedTest(String sex, boolean expectedHasMane) {
        this.sex = sex;
        this.expectedHasMane = expectedHasMane;
    }

    @Parameters(name = "{index}: Test with sex={0}, expectedHasMane={1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"Самец", true},
                {"Самка", false}
        });
    }

    @Before
    public void setUp() throws Exception {
        lion = new Lion(sex, mockFeline);
    }

    @Test
    public void testDoesHaveMane() {
        assertEquals(expectedHasMane, lion.doesHaveMane());
    }

    @Test(expected = Exception.class)
    public void testConstructorThrowsExceptionForInvalidSex() throws Exception {
        new Lion("Неправильный пол", mockFeline); // Ожидается исключение
    }
}