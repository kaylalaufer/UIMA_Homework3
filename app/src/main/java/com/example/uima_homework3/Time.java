package com.example.uima_homework3;

import java.text.DecimalFormat;

/** Class to represent a time of day.
 */
public class Time {

    // These are class-wide (shared) data members.
    // Checkstyle requires us to declare them before the instance data.

    /** Format integer with 4 digits of precision. */
    private static DecimalFormat four0s = new DecimalFormat("0000");
    /** Format integer with 2 digits of precision. */
    private static DecimalFormat two0s = new DecimalFormat("00");

    // These are handy constants.

    /** Number of hours in half day. */
    private static final int HALFDAY = 12;
    /** Divisor for miliarty time computations. */
    private static final int DIVISOR = 100;
    /** Number of minutes in a day. */
    private static final int DAYMINS = 60;


    // These are the instance data members.
    // Checkstyle requires us to document each one.

    /** Hour in the day, in military format: 0-23 valid. */
    private int hours;
    /** Minutes in the day, 0-59 valid. */
    private int mins;

    /** Create a time object from a string, such as "2:04pm".
     @param tstr the time string, such as "12:14am"
     */
    public Time(String tstr) {
        int i = tstr.indexOf(':');
        String hrs = tstr.substring(0, i);
        tstr = tstr.substring(i + 1);
        String mns = tstr.substring(0, 2);
        char when = tstr.toLowerCase().charAt(2);  // 'a' or 'p'
        this.setHours(Integer.parseInt(hrs));
        this.setMins(Integer.parseInt(mns));
        if (when == 'a' && this.hours == HALFDAY) {
            this.hours = 0;  // midnight
        }
        if (when == 'p' && this.hours < HALFDAY) {
            this.hours = this.hours + HALFDAY;
        }
    }

    /** Create a time object from an integer, military style.
     @param mil the military time integer, such as 1445
     */
    public Time(int mil) {
        this.setHours(mil / DIVISOR);
        this.setMins(mil % DIVISOR);
    }

    /** Set the hours to a new value.
     @param hr the hours to use, must be 0 <= hr <= 23
     */
    public void setHours(int hr) {
        if (hr < 0 || hr >= 2 * HALFDAY) {
            hr = 0;
        }
        this.hours = hr;
    }

    /** Set the minutes to a new value.
     @param mns the minutes to use, must be 0 <= mins <= 59
     */
    public void setMins(int mns) {
        if (mns < 0 || mns >= DAYMINS) {
            this.mins = 0;
        }
        this.mins = mns;
    }

    public int getHour () {
        return hours;
    }

    public int getMins () {
        return mins;
    }

    /** Get a string representation, in standard format.
     @return the string, such as "2:45pm"
     */
    public String toString() {
        String tstr = "";
        char when = 'a';
        if (this.hours >= HALFDAY) {
            when = 'p';
        }
        if (this.hours == 0) {
            tstr += HALFDAY;
        }
        else if (this.hours > HALFDAY) {
            tstr += this.hours - HALFDAY;
        }
        else {
            tstr += this.hours;
        }
        tstr += ":" + two0s.format(this.mins) + when + 'm';
        return tstr;
    }

    /** Get a military string representation.
     @return the string, such as "0405"
     */
    public String military() {
        String time = four0s.format(this.hours * DIVISOR + this.mins);
        String hr = time.substring(0, 2);
        String min = time.substring(2);
        return hr + ":" + min;
    }
}