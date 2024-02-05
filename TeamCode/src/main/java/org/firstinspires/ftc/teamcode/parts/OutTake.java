package org.firstinspires.ftc.teamcode.parts;

import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class OutTake {


    Servo miniservo1, miniservo2, virutal1, virutal2, angle, pivot;

    enum StateOT { //StateOT nextState?
        WAIT_FOR_ELEVATOR, // asteapta sa urce liftul
        WAIT_FOR_OUTTAKE, // power = 1 se invarte outtakeul idk
        READY_TO_PLACE_PIXELS, // pixeli
        RESETTING,
        PIXELS_READY,
        STARTING_POINT // power = -1


    }
    StateOT stateOT = StateOT.STARTING_POINT;
    public OutTake(HardwareMap hardwareMap, Telemetry telemetry)
    {


    }

    public void update(Gamepad gamepad)
    {



    }

}


