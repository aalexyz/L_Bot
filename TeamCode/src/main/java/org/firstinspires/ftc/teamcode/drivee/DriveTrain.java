package org.firstinspires.ftc.teamcode.drivee;
import com.qualcomm.robotcore.hardware.Gamepad;

public class DriveTrain {
    private final HardwareMapA mappingA;

    public DriveTrain(HardwareMapA mappingA)
    {
        this.mappingA = mappingA;
    }

    public void update(Gamepad gamepad)
    {
        double x = gamepad.left_stick_x * 1.1;
        double y = -gamepad.left_stick_y;
        double r = gamepad.right_trigger-gamepad.left_trigger;

        double den = Math.abs(x)+Math.abs(y)+Math.abs(r);
        double power;

        if (gamepad.a)
        {
            power = 1.0f;
        }
        else power = 0.5;

        double frontrightpower = (y - x - r) / den * power;
        double frontleftpower = (y + x + r) / den * power;
        double backleftpower = (y - x + r) / den * power;
        double backrightpower = (y + x - r) / den * power;

        mappingA.frontRightMotor.setPower(frontrightpower);
        mappingA.frontLeftMotor.setPower(frontleftpower);
        mappingA.backRightMotor.setPower(backrightpower);
        mappingA.backLeftMotor.setPower(backleftpower);


    }
}
