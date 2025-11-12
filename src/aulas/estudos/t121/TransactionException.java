package aulas.estudos.t121;

public class TransactionException extends Exception{
    private final Transaction transaction;

    public TransactionException(String message, Transaction transaction){
        super(message);
        this.transaction = transaction;
    }

    public TransactionException(){
        super("Invalid transaction");
        this.transaction = null;
    }

    public Transaction getTransaction() {
        return transaction;
    }
}
