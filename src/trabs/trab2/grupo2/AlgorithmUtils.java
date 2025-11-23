package trabs.trab2.grupo2;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class AlgorithmUtils {

    public static <E> void processRisingElements(Collection<E> seq, Comparator<E> cmp, Consumer<E> action){
        E biggest = (E) seq.toArray()[0];
        for (E e : seq) {
            if(cmp.compare(e, biggest) >= 0){
                biggest = e;
                action.accept(e);
            }
        }
    }

    public static List<String> collectIncreasingStrings (List<String> seq){
        List<String> newSeq = new ArrayList<>();
        processRisingElements(seq, String::compareTo, newSeq::add);
        return newSeq;
    }
    public static <S extends Collection<Integer>> List<S> groupConsecutive(Iterable<Integer> it, Supplier<S> supplier){
        List<S> ret = new ArrayList<>();
        S s = supplier.get();
        int prev = it.iterator().next();
        for (Integer i : it) {
            if( i != prev + 1 && i != prev){
               ret.add(s);
               s = supplier.get();
            }
            s.add(i);
            prev = i;
        }
        ret.add(s);
        return ret;
    }

    private static double findMedian(Integer[] arr) {
        int n = arr.length;
        if (n % 2 != 0)
            return arr[n / 2];
        return (arr[(n - 1) / 2] + arr[n / 2]) / 2.0;
    }

    public static double[] mediansOfGroups(Iterable<Integer> sequence){
        List<Collection<Integer>> list = groupConsecutive(sequence, ArrayList::new);
        double[] medians = new double[list.size()];
        int result;
        for (int i = 0; i < medians.length; i++) {
            medians[i] = findMedian((Integer[]) list.get(i).toArray(new Integer[list.get(i).size()]));
        }
        return medians;
    }

    public static String getSurname(String name){
        StringTokenizer tokenizer = new StringTokenizer(name);
        String surname = null;
        while (tokenizer.hasMoreTokens())
            surname = tokenizer.nextToken();
        return surname;
    }

    public static <C extends Collection<String>> Map<String,C> families(File file, Supplier<Map<String, C>> supMap, Supplier<C> supC) throws IOException {
        Map<String, C> map = supMap.get();
        BufferedReader reader = new BufferedReader(new FileReader(file));
        C c = supC.get();
        String line, surname;
        while((line = reader.readLine()) != null){
            surname = getSurname(line);
            if(map.containsKey(surname)){
                map.get(surname).add(line);
            }else {
                c.add(line);
                map.put(surname, c);
                c = supC.get();
            }
        }
        return map;
    }
}