public class Account {

    private static final int MAX_LENGTH = 12;
    private String ag;
    private String cc;
    private String name;

    private double balance;

    private Log logger;

    public Account(String ag, String cc, String name) {
        this.ag = ag;
        this.cc = cc;
        setName(name);
        logger = new Log();
    }

    public void setName(String name) {
        if (name.length() > MAX_LENGTH) {
            this.name = name.substring(0, MAX_LENGTH);
        } else {
            this.name = name;
        }
        System.out.println(this.name);

    }

    public void deposit(double value) {
        balance += value;
        logger.out(" DEPOSITO - R$ " + value + " Valor disponível em conta agora é de R$ " + balance);
    }

    public boolean withDraw(Double value) {
        if (balance < value) {
            logger.out(" SAQUE - R$ " + value + " Saldo atual em conta é de R$ " + balance);
            return false;
        } else {
            balance -= value;
            logger.out(" SAQUE - R$ " + value + " Valor disponível em conta agora é de R$ " + balance);
            return true;
        }

    }

    public double getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        String result = "A conta " + this.name + " " + this.ag + "/" + this.cc + " Possui: R$" + balance;
        return result;
    }
}
