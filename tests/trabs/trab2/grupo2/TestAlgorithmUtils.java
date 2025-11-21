package trabs.trab2.grupo2;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestAlgorithmUtils {
    @Test
    public void testCollectIncreasingStrings() {
        List<String> list = List.of("teste", "teste3", "teste2","teste4");
        List<String> result = List.of("teste", "teste3", "teste4");
        assertEquals(result, AlgorithmUtils.collectIncreasingStrings(list));
    }

    @Test
    public void testMediansOfGroups(){
        List<Integer> list = List.of(1, 2, 3, 5 , 6, 8, 9, 10);
        double[] result = AlgorithmUtils.mediansOfGroups(list);
        double[] expected = {2, 5.5, 9};
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], result[i]);
        }
    }
}
