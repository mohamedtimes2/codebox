package com.alarmclock;


public class Radio {
    private String RadioStation;
    private int volume = 5;
    private boolean isRadioOn = true;

    public Radio(String RadioStation) {
        this.RadioStation = RadioStation;
    }

    public String getRadioStation() {
        if (this.isRadioOn == true) {
            return this.RadioStation;
        } else {
            return "Nothing is being played.";
        }
    }

    public void setRadioStation(String radioStation) {
        this.isRadioOn = true;
        this.RadioStation = radioStation;
    }

    public void turnRadioOn() {
        this.isRadioOn = true;
    }

    public void turnRadioOff() {
        this.isRadioOn = false;
    }

    public void raiseVolume() {
        if (this.isRadioOn == true) {
            if (this.volume >= 0 && this.volume < 10) {
                this.volume += 1;
                System.out.println("The volume has been increased");
            }
            else {
                System.out.println("The volume can no longer be increased.");
            }
        }
    }

    public void lowerVolume() {
        if (this.isRadioOn == true) {
            if (this.volume > 0 && this.volume <= 10) {
                this.volume -= 1;
            } else {
                System.out.println("The volume can no longer be decreased.");
            }
        }
    }

    public int getVolume() {
        return this.volume;
    }
}
