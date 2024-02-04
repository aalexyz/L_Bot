package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.drive.HardwareMapping;

public class OutTakeq {

    public static Servo servoGobilda, servoRev;
    // public static double =

    enum State {
        UP, DOWN;
    }
    State state=State.DOWN;
    public OutTakeq (HardwareMap hm)
    {
        servoGobilda = hm.get(Servo.class , "s1");
        servoRev = hm.get(Servo.class , "s2");

    }

    public void update(Gamepad gamepad)
    {



    }

}


