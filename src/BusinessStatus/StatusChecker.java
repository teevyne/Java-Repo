package BusinessStatus;

public class StatusChecker {

    private boolean alwaysOpen;
    private boolean open;
    private boolean closed;

    public StatusChecker(){
        this.open = false;
        this.alwaysOpen = false;
        this.closed = false;
    }

//    public String setAlwaysOpen(){
//        alwaysOpen = true;
//        return String.format("Always open");
//    }
//
//    public String setClosed() {
//        closed = true;
//        return String.format("Closed");
//    }
//
//    public String setOpen() {
//        open = true;
//        return String.format("Open");
//    }

    public void setAlwaysOpen(){
        System.out.println("Always open");
        alwaysOpen = true;
    }

    public void setOpen(){
        System.out.println("Open");
        open = true;
    }

    public void setClosed() {
        System.out.println("Closed");
        closed = true;
    }

    public boolean isOpen(){
        return open;
    }

    public boolean isAlwaysOpen(){
        return alwaysOpen;
    }

    public boolean isClosed(){
        return closed;
    }
}
