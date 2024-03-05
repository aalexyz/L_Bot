package org.firstinspires.ftc.teamcode.parts;

import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class OutTake {


    public Servo pivot, claw1, claw2;

    enum StateOT { //StateOT nextState?
        DOWN, UP
    }

    StateOT state = StateOT.DOWN;
    public Elevator elevator;
    public BratAngle bratAngle;
    public OutTake(HardwareMap hm, Telemetry telemetry)
    {
        elevator = new Elevator(hm);
        bratAngle = new BratAngle(hm);

        pivot = hm.get(Servo.class, "pivot");
        claw1 = hm.get(Servo.class, "claw1");
        claw2 = hm.get(Servo.class, "claw2");
    }
    public static int down = 0, up = 1000;

    public static double CLAW1_CLOSED = 0;
    public static double CLAW2_CLOSED = 0;
    public static double CLAW1_OPEN = 0;
    public static double CLAW2_OPEN = 0;
    private boolean last_x = false;
    private boolean claw_open = true;

    public void update(Gamepad gamepad)
    {

        if(last_x != gamepad.x) claw_open = !claw_open;
        last_x = gamepad.x;

        if(claw_open) {
            claw1.setPosition(CLAW1_OPEN);
            claw2.setPosition(CLAW2_OPEN);
        } else {
            claw1.setPosition(CLAW1_CLOSED);
            claw2.setPosition(CLAW2_CLOSED);
        }
        if(gamepad.dpad_up && state == StateOT.DOWN) {
            bratAngle.setPosition(up);
            state = StateOT.UP;
        }
        else {
            bratAngle.setPosition(down);
            state = StateOT.DOWN;
        }

        elevator.update(gamepad);
        bratAngle.update();
    }

}


