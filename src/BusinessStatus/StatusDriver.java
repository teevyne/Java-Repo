package BusinessStatus;

public class StatusDriver{

    public static void main(String[] args) {

        StatusChecker statusChecker = new StatusChecker();
        StatusOperator statusOperator = new StatusOperator(statusChecker);

//        System.out.println("Dog barks to go outside");
        statusOperator.pressButton();
        statusOperator.pressButton();
        statusOperator.pressButton();

    }
}