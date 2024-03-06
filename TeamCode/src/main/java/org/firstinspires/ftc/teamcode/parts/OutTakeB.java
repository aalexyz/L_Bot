package org.firstinspires.ftc.teamcode.parts;

import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.drivee.HardwareMapA;

public class OutTakeB {

    private final HardwareMapA hm;

    enum StateOT { //StateOT nextState?
        DOWN, UP
    }

    StateOT state = StateOT.DOWN;
    public Elevator elevator;
    public BratAngle bratAngle;
    public Claw claw;
    public OutTakeB(HardwareMapA hm)
    {
        this.hm = hm;

        elevator = new Elevator(hm);
        bratAngle = new BratAngle(hm);
    }
    public static int down = 0, up = 1000;
    Gamepad currentgm, prevgm;
    public void update(Gamepad gamepad)
    {
        prevgm = currentgm;
        currentgm = gamepad;

        if (gamepad.y && !prevgm.y)
        {
            hm.servoC1.setPosition(Claw.backdropPos);
            Claw.isRotated = true;
        }
        else if (gamepad.a && !prevgm.a)
        {
            hm.servoC1.setPosition(Claw.intakePos);
            Claw.isRotated = false;
        }

        if(Claw.c1isOpened && (gamepad.b && !prevgm.b)) {
            claw.clawState = Claw.ClawState.OPENED_LEFT;
        } else {
            claw.clawState = Claw.ClawState.CLOSED_LEFT;
        }

        if(Claw.c2isOpened && (gamepad.x && !prevgm.x)) {
            claw.clawState = Claw.ClawState.OPENED_RIGHT;
        } else {
            claw.clawState = Claw.ClawState.CLOSED_RIGHT;
        }

        if(gamepad.dpad_left && state == StateOT.DOWN) {
            bratAngle.setPosition(up);
            state = StateOT.UP;
        }
        else {
            bratAngle.setPosition(down);
            state = StateOT.DOWN;
        }
        if (gamepad.dpad_up)
        {
            elevator.liftState = Elevator.LiftState.EXTENDED;
        }
        else if (gamepad.dpad_down)
        {
            elevator.liftState = Elevator.LiftState.RETRACTED;
        }
        elevator.update(gamepad);
        bratAngle.update();
        claw.update();
    }

}


