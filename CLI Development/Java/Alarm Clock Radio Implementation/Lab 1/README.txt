Lab 1 Documentation: Mohamed Mohamed

The following documentation and code is for Lab 1 for SE 310, and as such simulates the Alarm Clock & Radio functionality.
Please run the main method for the program's functionality.

The driver code uses an instance of the AlarmClockRadio class, which aggregates from the Clock/AlarmClock and Radio classes (see the UML Diagram in the zip file for more detail)

Overview of the methods for each class:

Clock:

addZero():  Returns the double digit format for a clock for the clockmin and clocksec attributes.

getClock(): Returns the time in clock format.

setClock(): Modifies the clock's instance.

showTime(): Prints the time in clock format.

tick(): Advances the clock by one second, accommodating for the rules of a clock.


AlarmClock:

Note: Since AlarmClock is derived from Clock, it shares all of Clock's methods.

getAlarm(): Returns the alarm in a clock format.

showSnoozeTime(): Prints the snooze time.

setAlarm(): Modifies the alarm's instance.

turnAlarmOn(): Turns the alarm on (Sets the class variable, isAlarmOn, to true).

turnAlarmOff(): Turns the alarm off (Sets the class variable, isAlarmOn, to false).

isAlarmOn(): Turns the isAlarmOn class variable's value to determine if the alarm is on.

checkAlarm(): Checks if the alarm and clock is are equal, and prints a message if so. Otherwise, it does not execute anything. (For Part A of Lab 1)

checkClockEqualAlarm(): Helper function that determines if the clocks equals the alarm or the snooze time, utilized in one of AlarmClockRadio's methods.

snooze(): Adds 9 minutes to the snooze time (which should equal the alarm clock initially)


Radio:

getRadioStation(): Returns the name of the radio station if the radio is open (isRadioOn = true), otherwise return a string indicating that the radio is off.

setRadioStation(): Modifies the radio instance, and turns the radio on (isRadioOn becomes 'true')

turnRadioOn(): Turns the radio on (isRadioOn becomes 'true').

turnRadioOff(): Turns the radio off (isRadioOn becomes 'false').

raiseVolume(): If the radio is on, add one to the "volume" class variable, until a limit is reached where a message will be displayed. Otherwise, the method does not execute anything.

lowerVolume(): If the radio is on, subtract one to the "volume" class variable, until a limit is reached where a message will be displayed. Otherwise, the method does not execute anything.

getVolume(): Return the value of the "volume" class variable.


AlarmClockRadio:

Note: All methods for this class, except for checkAlarmAndSnooze() are all aggregated from its two class variables which are instances of the previous classes.

checkAlarmAndSnooze(): Uses the AlarmClock's checkClockEqualAlarm() method to determine the message to output if the clock equals the alarm or the snooze time.