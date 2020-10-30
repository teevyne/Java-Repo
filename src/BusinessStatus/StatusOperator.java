package BusinessStatus;

import BusinessStatus.StatusChecker;

public class StatusOperator {

    private StatusChecker statusChecker;

    public StatusOperator(StatusChecker statusChecker){
        this.statusChecker = statusChecker;
    }

    public void getStatus(boolean status){
        if (statusChecker.isAlwaysOpen()){
            statusChecker.setAlwaysOpen();
        }

        else if (statusChecker.isOpen()){
            statusChecker.setOpen();
        }
        else if (statusChecker.isClosed()){
            statusChecker.setClosed();
        }
    }
}
