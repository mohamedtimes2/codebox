package com.alarmclock;

public class Main {

    public static void main(String[] args) {
        int seconds;
        int i;
        AlarmClockRadio myClock3 = new AlarmClockRadio(new AlarmClock(8, 00, 0, "AM", 8, 05, 0, "AM"), new Radio("1060 AM"));
        for (i = 0; i < 6; i++) {
            System.out.println(myClock3.getClock());
            for (seconds = 0; seconds < 60; seconds++) {
                myClock3.checkAlarmAndSnooze();
                myClock3.tick();
            }
        }
        myClock3.snooze();
        for (i = 0; i < 9; i++)
        {
            System.out.println(myClock3.getClock());
            for (seconds = 0; seconds < 60; seconds++)
            {
                myClock3.checkAlarmAndSnooze();
                myClock3.tick();
            }
        }
    }
}

