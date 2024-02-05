package org.firstinspires.ftc.teamcode.parts;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.drivee.HardwareMapping;
import org.firstinspires.ftc.teamcode.utils.PIDElevator;

public class Elevator {

    private final HardwareMapping mapping;


    enum State
    {
        DOWN,
        UP,
        WAITFO,
        GOINGDDOWN

    }
    State state = State.DOWN;

    public Elevator(HardwareMapping mapping)
    {
        this.mapping = mapping;
    }

    public void update(Gamepad gamepad)
    {

    }
}
