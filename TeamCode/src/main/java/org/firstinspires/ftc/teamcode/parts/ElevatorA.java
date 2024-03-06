package org.firstinspires.ftc.teamcode.parts;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.PIDCoefficients;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.drivee.HardwareMapA;
import org.firstinspires.ftc.teamcode.utils.Motion;

public class ElevatorA {
    private HardwareMapA mapping;
    private Claw claw;
    private ArmOT armOT;
    public ElevatorA (HardwareMapA mappingA)
    {
        this.mapping = mappingA;
        mapping.motorSlider.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        mapping.motorSlider.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motion.setMotion(0, 0, 0);
    }
    enum LiftStates //nextstate thing
    {
        START,
        WAIT_FOR_ROTATE,
        GOINGUP,
        WAIT_FOR_OT,
        GOINGDOWN
        /*
        public int position;
        public final LiftStates nextState;
        LiftStates(int position){
            this.position = position;
            this.nextState = this;
        }

        LiftStates(int position, LiftStates nextState){
            this.position = position;
            this.nextState = nextState;
        }
        s a inncercat
         */
    }
    public LiftStates liftState = LiftStates.START;
    public double pos = 0, error, pow, lastpos, maxVelocity = 0, acc = 0, dec = 0;
    boolean ok, down = true;
    int nr;
    public static ElapsedTime timer=new ElapsedTime();
    public static PIDCoefficients pidCoefficients = new PIDCoefficients(0, 0, 0);
    public Motion motion = new Motion(maxVelocity, acc, dec);

    public void update()
    {
        switch (liftState)
        {
            case WAIT_FOR_ROTATE:
                if (!armOT.isDown)
                {
                    //nextstate
                }
                break;
            case GOINGUP:

            case WAIT_FOR_OT:
            case GOINGDOWN:
        }

    }

}
