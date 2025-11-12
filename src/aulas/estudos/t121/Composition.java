package aulas.estudos.t121;

import java.util.function.Predicate;

public interface Composition extends Iterable<Transaction>{
    abstract boolean find(Predicate<String> predicate);
    Composition append(Transaction transaction) throws TransactionException;
}
