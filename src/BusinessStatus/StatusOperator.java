package BusinessStatus;

public class StatusOperator{

    private StatusChecker statusChecker;

    public StatusOperator(StatusChecker aChecker){
        this.statusChecker = aChecker;
    }

    public void pressButton() {
        System.out.println("Setting business status");
        if(statusChecker.isAlwaysOpen()){
            statusChecker.alwaysOpenShop();
        }
        if (statusChecker.isOpen()) {
            statusChecker.openShop();
        } else {
            statusChecker.closeShop();
        }
    }
}