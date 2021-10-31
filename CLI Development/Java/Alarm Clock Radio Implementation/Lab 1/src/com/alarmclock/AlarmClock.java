package com.alarmclock;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class AlarmClock extends Clock {
    protected int alarmhour;
    protected int alarmmin;
    protected int alarmsec;
    protected String alarmnotation;
    protected int snoozehour;
    protected int snoozemin;
    protected int snoozesec;
    protected String snoozenotation;
    protected boolean isAlarmOn = true;

    public AlarmClock(int clockhour, int clockmin, int clocksec, String clocknotation, int alarmhour, int alarmmin, int alarmsec, String alarmnotation) {
        super(clockhour, clockmin, clocksec, clocknotation);
        this.alarmhour = alarmhour;
        this.alarmmin = alarmmin;
        this.alarmsec = alarmsec;
        this.alarmnotation = alarmnotation;
        this.snoozehour = this.alarmhour;
        this.snoozemin = this.alarmmin;
        this.snoozesec = this.alarmsec;
        this.snoozenotation = this.alarmnotation;
    }

    public String getAlarm() {
        if (this.isAlarmOn == true) {
            return String.valueOf(this.alarmhour) + ":" + addZero(this.alarmmin) + ":" + addZero(this.alarmsec) + " " + String.valueOf(this.alarmnotation);
        } else {
            return "Alarm has been turned off";
        }
    }

    public void showSnoozeTime() {
        System.out.println(String.valueOf(this.snoozehour) + ":" + addZero(this.snoozemin) + ":" + addZero(this.snoozesec) + " " + String.valueOf(this.snoozenotation));
    }

    public void setAlarm(int alarmhour, int alarmmin, int alarmsec, String alarmnotation) {
        this.isAlarmOn = true;
        this.alarmhour = alarmhour;
        this.alarmmin = alarmmin;
        this.alarmsec = alarmsec;
        this.clocknotation = alarmnotation;
    }

    public void turnAlarmOn() {
        this.isAlarmOn = true;
        System.out.println("Alarm was been turned on.");
    }

    public void turnAlarmOff() {
        this.isAlarmOn = false;
        System.out.println("Alarm was been turned off.");
    }

    public boolean isAlarmOn() {
        return this.isAlarmOn;
    }

    public void checkAlarm() {
        if (this.isAlarmOn == true) {
            if ((this.alarmhour == this.clockhour && this.alarmmin == this.clockmin && this.alarmsec == this.clocksec && this.alarmnotation == this.clocknotation) || (this.snoozehour == this.clockhour && this.snoozemin == this.clockmin && this.snoozesec == this.clocksec && this.snoozenotation == this.clocknotation)) {
                System.out.println("Buzz! Buzz! Buzz!");
            }
        }
    }

    public int checkClockEqualAlarm() {
        if ((this.alarmhour == this.clockhour && this.alarmmin == this.clockmin && this.alarmsec == this.clocksec && this.alarmnotation == this.clocknotation)) {
            return 0;
        } else if ((this.snoozehour == this.clockhour && this.snoozemin == this.clockmin && this.snoozesec == this.clocksec && this.snoozenotation == this.clocknotation)){
            return 1;
        }
            return -1;
    }

    public void snooze() { //Might wanna add a condition here! Track if separate variables for snooze and in CheckAlarm (or statement)
        for (int sec = 0; sec < 540; sec++) {
            this.snoozesec += 1;
            if (this.snoozesec == 60) {
                this.snoozesec = 0;
                this.snoozemin += 1;
                if (this.snoozemin == 60) {
                    this.snoozemin = 0;
                    this.snoozehour += 1;
                    if (this.snoozenotation == "AM" && this.snoozehour == 12) {
                        this.snoozenotation = "PM";
                    } else if (this.snoozenotation == "PM" && this.snoozehour == 12) {
                        this.snoozenotation = "AM";
                    } else if (this.snoozehour == 13) {
                        this.snoozehour = 1;
                    } else {
                        continue;
                    }
                }
            }
        }
        System.out.println("Snooze was pressed!");
    }
}
