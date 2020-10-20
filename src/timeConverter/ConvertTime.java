package timeConverter;

public class ConvertTime {

    private static String[] hour = {
            "Twelve", "One", "Two",
            "Three", "Four", "Five",
            "Six", "Seven", "Eight",
            "Nine", "Ten", "Eleven", "Twelve"
    };

    private static String[] minutesTens = {
            "", "one", "two", "three", "four",
            "five", "six", "seven", "eight", "nine",
            "ten", "eleven", "twelve", "thirteen", "fourteen",
            "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"
    };

    private static String[] minutesWhole = {
            "", "",
            "twenty", "thirty",
            "forty", "fifty"
    };

    public static void main(String[] args) {
        System.out.println(printTime(21, 59));
    }

    public static String hourOperation(int hourValue){
        String hourInWords = "";
        if (hourValue > 0 && hourValue <= 23){
            if (hourValue > 12){
                hourValue = hourValue % 12;
            }
        }
        hourInWords = hour[hourValue];
        return hourInWords;
    };

    public static String minutesOpsOne(int minuteValue){
        String minuteInWords = "";

        if (minuteValue >= 0 && minuteValue <= 59) {
            if (minuteValue == 0) {
                minuteInWords = minuteInWords + "O' clock";
            } else if (minuteValue >= 1 && minuteValue <= 9) {
                minuteInWords = minuteInWords + "zero " + minutesTens[minuteValue];
            } else if (minuteValue >= 10 && minuteValue <= 19) {
                minuteInWords = minuteInWords + minutesTens[minuteValue];
            } else {
//                if (minuteValue % 10 == 0) {
                    minuteInWords = minuteInWords + minutesWhole[minuteValue / 10] + " " +
                            minutesTens[minuteValue % 10];
//                }
            }
        }

        return minuteInWords;
    }

    public static String printTime (int hour, int minute){
        String timeInWords = "";

        timeInWords = hourOperation(hour) + " " + minutesOpsOne(minute);

        if (hour >= 12){
            timeInWords = timeInWords + " pm";
        }
        else{
            timeInWords = timeInWords + " am";
        }
        return timeInWords;
    };
}
