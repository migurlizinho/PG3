package aulas.estudos.t121;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Predicate;

public class TLong extends Transaction implements Composition{
    private ArrayList<Transaction> subTransactions;

    protected TLong(String name) {
        super(name);
    }

    @Override
    public boolean isCompensable() {
        return false;
    }

    @Override
    public String compesationToString() {
        return "";
    }

    @Override
    public boolean find(Predicate<String> predicate) {
        for (Transaction subTransaction : subTransactions) {
            if(predicate.test(subTransaction.getName()))
                return true;
        }
        return false;
    }

    @Override
    public Composition append(Transaction transaction) throws TransactionException {
        if(!transaction.isCompensable() || this.find(s -> {return s.equals(transaction.getName());}))
            throw new TransactionException();
        else
            subTransactions.add(transaction);
        return this;
    }

    @Override
    public Iterator<Transaction> iterator() {
        return subTransactions.iterator();
    }

    @Override
    public String getDescription(String prefix) {
        StringBuilder sb = new StringBuilder();
        sb.append(prefix).append(getName());
        for (Transaction subTransaction : subTransactions) {
            sb.append('\n').append(prefix).append(subTransaction.getDescription(prefix));
        }
        return sb.toString();
    }
}
