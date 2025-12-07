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
        Iterator<E> i = seq.iterator();
        if (!i.hasNext()) return;
        E biggest = i.next();
        action.accept(biggest);
        while (i.hasNext()) {
            E e = i.next();
            if(cmp.compare(e, biggest) > 0){
                biggest = e;
                action.accept(e);
            }
        }
    }

    public static List<String> collectIncreasingStrings (List<String> seq){
        List<String> newSeq = new ArrayList<>();
        processRisingElements(seq, String::compareToIgnoreCase, newSeq::add);
        return newSeq;
    }

    private static int absolutDiff(int n1, int n2){
        return Math.abs(Math.abs(n1) - Math.abs(n2));
    }

    public static <S extends Collection<Integer>> List<S> groupConsecutive(Iterable<Integer> it, Supplier<S> supplier){
        Iterator<Integer> iter = it.iterator();
        List<S> ret = new ArrayList<>();
        if(!iter.hasNext()) return ret;
        S s = supplier.get();
        int prev = iter.next();
        s.add(prev);
        while (iter.hasNext()) {
            Integer i = iter.next();
            if(absolutDiff(i, prev) != 1){
               ret.add(s);
               s = supplier.get();
            }
            s.add(i);
            prev = i;
        }
        ret.add(s);
        return ret;
    }

    private static double findMedian(ArrayList<Integer> arr) {
        int n = arr.size();
        if (n % 2 != 0)
            return arr.get(n / 2);
        return (arr.get((n - 1) / 2) + arr.get(n / 2)) / 2.0;
    }

    public static double[] mediansOfGroups(Iterable<Integer> sequence){
        if(sequence == null || !sequence.iterator().hasNext())
            return null;
        List<ArrayList<Integer>> list = groupConsecutive(sequence, ArrayList::new);
        double[] medians = new double[list.size()];
        for (int i = 0; i < medians.length; i++) {
            medians[i] = findMedian(list.get(i));
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