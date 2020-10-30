package BusinessStatus;

public class StatusDriver {

    public static void main(String[] args) {

        StatusChecker statusChecker = new StatusChecker();
        StatusOperator statusOperator = new StatusOperator(statusChecker);

        System.out.println("Let's check if we are open... Yes! ");
        statusOperator.getStatus(statusChecker.isAlwaysOpen());

    }
}
