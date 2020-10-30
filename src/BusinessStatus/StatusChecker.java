package BusinessStatus;

public class StatusChecker{

    private boolean open;
    private boolean alwaysOpen;

    public StatusChecker(){
        this.open = false;
        this.alwaysOpen = false;
    }

    public void alwaysOpenShop(){
        System.out.println("We are alwsys here for you; open for business");
        alwaysOpen = true;
        open = false;
    }

    public void openShop(){
        System.out.println("We are now open for business");
        open = true;
        alwaysOpen = false;
    }

    public void closeShop(){
        System.out.println("Now we are closed for business");
        open = false;
//        alwaysOp/en = false;
    }

    public boolean isOpen(){
        return open;
    }

//    public boolean isAlwaysOpen(){
//        return alwaysOpen;
//    }
}