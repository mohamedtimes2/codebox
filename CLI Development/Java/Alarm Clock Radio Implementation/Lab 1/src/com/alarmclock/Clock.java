package com.alarmclock;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Clock {
   protected int clockhour;//SIMPIFY THIS AS CALENDER OBJECT. We will need another calender object (for the alarm parameters) and might need a simpledate formatt
   protected int clockmin;
   protected int clocksec;
   protected String clocknotation;
//   protected Calendar ClockTime = Calendar.getInstance();
   static SimpleDateFormat sdf = new SimpleDateFormat("hh:mm aa");

   public Clock(int clockhour, int clockmin, int clocksec, String clocknotation) {
       this.clockhour = clockhour;
       this.clockmin = clockmin;
       this.clocksec = clocksec;
       this.clocknotation = clocknotation; //validate notation, check if it really is AM or PM.
   }

   public String addZero(int mytime) {

       if (String.valueOf(mytime).length() == 1) {
           return "0" + String.valueOf(mytime);
       }
       else if (String.valueOf(mytime).length() == 0) {
           return "00";
       }

       return String.valueOf(mytime);
   }

   public String getClock() {
       return String.valueOf(this.clockhour) + ":" + addZero(this.clockmin) + ":" + addZero(this.clocksec) + " " + String.valueOf(this.clocknotation);
   }

   public void setClock(int clockhour, int clockmin, int clocksec, String clocknotation) {
       this.clockhour = clockhour;
       this.clockmin = clockmin;
       this.clocksec = clocksec;
       this.clocknotation = clocknotation;
   }

   public void showTime() {
       System.out.println(String.valueOf(this.clockhour) + ":" + addZero(this.clockmin) + ":" + addZero(this.clocksec) + " " + String.valueOf(this.clocknotation));
   }

   public void tick() {
       // add a second to the clock.
       // check do I have 60 seconds?
       // If you do, set seconds to 0
       // Add 1 to minutes.
       // Check do I have 60 minutes
       // If you do, set minutes to 0
       // Add 1 to hours.
       // Check if it is AM
       // if it is AM, and hours is 12, then switch to PM
       // If it is PM, and hours is 12 then switch to AM
       // one more check for 13.
       this.clocksec += 1;
       if (this.clocksec == 60) {
           this.clocksec = 0;
           this.clockmin += 1;
           if (this.clockmin == 60) {
               this.clockmin = 0;
               this.clockhour += 1;
               if (this.clocknotation == "AM" && this.clockhour == 12) {
                   this.clocknotation = "PM";
               } else if (this.clocknotation == "PM" && this.clockhour == 12) {
                   this.clocknotation = "AM";
               } else if (this.clockhour == 13) {
                   this.clockhour = 1;
               }
           }
       }
   }

}