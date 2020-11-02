package BusinessStatus;

public class Pizza {

    private PizzaStatus status;

    public PizzaStatus getStatus() {
        return status;
    }

    public void setStatus(PizzaStatus status) {
        this.status = status;
    }

    public enum PizzaStatus {
        ORDERED (5){
            @Override
            public boolean isOrdered() {
                return true;
            }
        },
        READY (2){
            @Override
            public boolean isReady() {
                return true;
            }
        },
        DELIVERED (0){
            @Override
            public boolean isDelivered() {
                return true;
            }
        };


        public boolean isOrdered() {return false;}

        public boolean isReady() {return false;}

        public boolean isDelivered(){return false;}

        private int timeToDelivery;

        public int getTimeToDelivery() {
            return timeToDelivery;
        }

        PizzaStatus (int timeToDelivery) {
            this.timeToDelivery = timeToDelivery;
        }
    }

    public boolean isDeliverable() {
        return this.status.isReady();
    }

    public boolean isOrdered(){
        return this.status.isReady();
    }

    public void printTimeToDeliver() {
        System.out.println("Time to delivery is " +
                this.getStatus().getTimeToDelivery());
    }

    // Methods that set and get the status variable.

    public static void main(String[] args) {
        Pizza testPz = new Pizza();
        testPz.setStatus(Pizza.PizzaStatus.READY);
        System.out.println(testPz.isDeliverable());
        System.out.println(testPz.isOrdered());
    }
}

    //The test snippet below demonstrates how this works:




//public class StatusChecker{
//
//    private boolean open;
//    private boolean alwaysOpen;
//
//    public StatusChecker(){
//        this.open = false;
//        this.alwaysOpen = false;
//    }
//
//    public void alwaysOpenShop(){
//        System.out.println("We are alwsys here for you; open for business");
//        alwaysOpen = true;
//        open = false;
//    }
//
//    public void openShop(){
//        System.out.println("We are now open for business");
//        open = true;
//        alwaysOpen = false;
//    }
//
//    public void closeShop(){
//        System.out.println("Now we are closed for business");
//        open = false;
////        alwaysOp/en = false;
//    }
//
//    public boolean isOpen(){
//        return open;
//    }
//
////    public boolean isAlwaysOpen(){
////        return alwaysOpen;
////    }
//}