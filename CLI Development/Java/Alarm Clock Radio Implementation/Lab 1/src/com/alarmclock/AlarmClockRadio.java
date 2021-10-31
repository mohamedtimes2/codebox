package com.alarmclock;

public class AlarmClockRadio {
    private AlarmClock alarmclock;
    private Radio radio;

    public AlarmClockRadio(AlarmClock alarmclock, Radio radio) {
        this.alarmclock = alarmclock;
        this.radio = radio;
        System.out.println("Initial Time: " + this.alarmclock.getClock() + "." +  " The radio was turned on and is playing " + this.radio.getRadioStation() + ".");
        //Edit this constructor!
    }

    public void showTime() {
        this.alarmclock.showTime();
    }

    public void showDashboard(){
        System.out.println("Time: " + this.alarmclock.getClock() + ". " + "Alarm Time: " + this.alarmclock.getAlarm() + ". " + "Radio: " + this.radio.getRadioStation());
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
        this.alarmclock.tick();
    }

    public String getClock() {
        return this.alarmclock.getClock();
    }

    public void setClock(int clockhour, int clockmin, int clocksec, String clocknotation) {this.alarmclock.setClock(clockhour, clockmin, clocksec, clocknotation);}

    public String getAlarm() {
        return this.alarmclock.getAlarm();
    }

    public void setAlarm(int alarmhour, int alarmmin, int alarmsec, String alarmnotation) {
        this.alarmclock.setAlarm(alarmhour, alarmmin, alarmsec, alarmnotation);
    }

    public void turnAlarmOn() {
        this.alarmclock.turnAlarmOn();
    }

    public void turnAlarmOff() {
        this.alarmclock.turnAlarmOff();
    }

    public boolean isAlarmOn() {return this.alarmclock.isAlarmOn();}

    public void checkAlarm() {
        this.alarmclock.checkAlarm();
    }

    public void checkAlarmAndSnooze() {
        if (this.alarmclock.checkClockEqualAlarm() == 0) {
            System.out.println("The radio is playing: " + this.radio.getRadioStation());
        } else if (this.alarmclock.checkClockEqualAlarm() == 1) {
            System.out.println("Buzz! Buzz! Buzz!");
        }
    }

    public void snooze() { //Fixed this!
        this.alarmclock.snooze();
    }


    public String getRadioStation() {
        return this.radio.getRadioStation();
    }

    public void setRadioStation(String RadioStation) {
        this.radio.setRadioStation(RadioStation);
    }

    public void turnRadioOn() {
        this.radio.turnRadioOn();
    }

    public void turnRadioOff() {
        this.radio.turnRadioOff();
    }

    public void raiseVolume() {
        this.radio.raiseVolume();
    }

    public void lowerVolume() {
        this.radio.lowerVolume();
    }

    public int getVolume() {
        return this.radio.getVolume();
    }



}
