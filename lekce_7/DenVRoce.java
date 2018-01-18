package lekce_7;

public class DenVRoce {
    public static boolean IsLeapYear(int year) {
      if (((year % 100) == 0) && ((year % 400) == 0)) {
        return true;
      } else if ((year % 4) == 0) {
        return true;
      } else {
        return false;
      }
    }
    public static int DaysInMonth(int month, int year) {
      if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
        return 31;
      } else if (month == 2) {
        if (IsLeapYear(year)) {
          return 29;
        } else {
          return 28;
        }
      } else {
        return 30;
      }
    }
    public static boolean DatumExists(int day, int month, int year){
      int DaysInCurrentMonth = DaysInMonth(month, year);
      if (month <= 12) {
        if (day <= DaysInCurrentMonth) {
          return true;
        } else{
          return false;
        }
      } else {
        return false;
      }  
    }
    public static void main(String[] args) {
      int year = Integer.parseInt(args[0]);
      int month = Integer.parseInt(args[1]);
      int day = Integer.parseInt(args[2]);
      if (DatumExists(day, month, year)){
        int DayNumber = 0;
        for (int i = 1; i < month; i += 1) {
          DayNumber += DaysInMonth(i, year); 
        }
        DayNumber += day;
        System.out.printf("%d\n", DayNumber);
      } else {
        System.out.println("Datum neni platne");
      }
    }
}