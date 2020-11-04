public class TimeConversion {

    static String timeConversion(String s) {
        /*
         * Write your code here.
         */

        String hour = s.substring(0, 2);
        String otherPart = s.substring(2, 8);
        int intHour = Integer.parseInt(hour);

        if (intHour >= 0 && intHour <= 24) {
            if (s.endsWith("PM")) {

                intHour = intHour + 12;
            } else if (s.endsWith("AM")) {
                if (s.startsWith("12")) {
                    intHour = 00;
                }
            }
        }

        String newHour = String.valueOf(intHour);

        return newHour + otherPart;
    }

    public static void main(String[] args) {
        System.out.println(timeConversion("15:05:45PM"));
    }
}
