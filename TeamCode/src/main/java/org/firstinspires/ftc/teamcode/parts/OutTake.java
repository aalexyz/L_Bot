package org.firstinspires.ftc.teamcode.parts;

import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.drivee.HardwareMapA;

public class OutTake {
    
    private final HardwareMapA hm;

    enum StateOT { //StateOT nextState?
        DOWN, UP
    }

    StateOT state = StateOT.DOWN;
    public Elevator elevator;
    public BratAngle bratAngle;
    public OutTake(HardwareMapA hm)
    {
        this.hm = hm;

        elevator = new Elevator(hm);
        bratAngle = new BratAngle(hm);
    }
    public static int down = 0, up = 1000;

    public static double CLAW1_CLOSED = 0.3;
    public static double CLAW2_CLOSED = 0.3;
    public static double CLAW1_OPEN = 0.8;
    public static double CLAW2_OPEN = 0.8;
    private boolean last_x = false;
    private boolean claw_open = true;

    public void update(Gamepad gamepad)
    {

        if(last_x != gamepad.x) claw_open = !claw_open;
        last_x = gamepad.x;

        if(claw_open) {
            hm.miniC1.setPosition(CLAW1_OPEN);
            hm.miniC2.setPosition(CLAW2_OPEN);
        } else {
            hm.miniC1.setPosition(CLAW1_CLOSED);
            hm.miniC2.setPosition(CLAW2_CLOSED);
        }
        if(gamepad.dpad_up && state == StateOT.DOWN) {
            bratAngle.setPosition(up);
            state = StateOT.UP;
        }
        else {
            bratAngle.setPosition(down);
            state = StateOT.DOWN;
        }
        if (gamepad.y)
        {
            elevator.liftState = Elevator.LiftState.EXTENDED;
        }
        else if (gamepad.b)
        {
            elevator.liftState = Elevator.LiftState.RETRACTED;
        }
        elevator.update(gamepad);
        bratAngle.update();
    }

}


