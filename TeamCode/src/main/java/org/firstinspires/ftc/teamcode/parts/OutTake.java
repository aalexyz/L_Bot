package org.firstinspires.ftc.teamcode.parts;

import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.drivee.HardwareMapA;

public class OutTake {

    private final HardwareMapA mappingA;
    private Claw gheara;
    private ArmOT armOT;

    enum StateOT { //StateOT nextState?
        WAIT_FOR_ELEVATOR,
        WAIT_FOR_OUTTAKE, // power = 1 se invarte outtakeul idk
        READY_TO_PLACE_PIXELS, // pixeli
        RESET,
        STARTING_POINT // power = 0

    }
    StateOT stateOT = StateOT.STARTING_POINT;
    public OutTake(HardwareMapA mappingA, Telemetry telemetry)
    {
        this.mappingA = mappingA;
    }

    public void update(Gamepad gamepad)
    {

    }

}


