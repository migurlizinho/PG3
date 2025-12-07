package trabs.trab2.grupo2;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestAlgorithmUtils {
    @Test
    public void testCollectIncreasingStrings() {
        List<String> list = List.of("teste", "teste3", "teste2","teste4");
        List<String> expected = List.of("teste", "teste3", "teste4");
        assertEquals(expected, AlgorithmUtils.collectIncreasingStrings(list));

        list = List.of("ccc", "aaa", "ddd","ppp", "bbb", "eee", "ccc", "fff");
        expected = List.of("ccc", "ddd", "ppp");
        assertEquals(expected, AlgorithmUtils.collectIncreasingStrings(list));
    }

    @Test
    public void testMediansOfGroups(){
        List<Integer> list = List.of(1, 2, 3  ,5,6,  8, 9, 10);
        double[] result = AlgorithmUtils.mediansOfGroups(list);
        double[] expected = {2, 5.5, 9};
        assertArrayEquals(expected, result);

        list = List.of(5,6,7 ,12,13,14, 21,22,23);
        result = AlgorithmUtils.mediansOfGroups(list);
        expected = new double[]{6, 13, 22};
        assertArrayEquals(expected, result);
    }
}
