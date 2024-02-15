package org.firstinspires.ftc.teamcode.drivee;

import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.IMU;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;

public class FieldCentric {

    private final HardwareMapA mappingA;
    IMU imu;
    double botHeading;
    public FieldCentric(HardwareMapA mappingA)
    {
        this.mappingA = mappingA;

        IMU.Parameters parameters = new IMU.Parameters
                (new RevHubOrientationOnRobot(
                RevHubOrientationOnRobot.LogoFacingDirection.RIGHT,
                RevHubOrientationOnRobot.UsbFacingDirection.DOWN)
        );
        mappingA.imu.initialize(parameters);
// trb schimbate iar crd


    }
    public void update (Gamepad gamepad)
    {

        double x = gamepad.left_stick_x * 1.1;
        double y = -gamepad.left_stick_y;
        double r = gamepad.right_trigger-gamepad.left_trigger;



        botHeading = imu.getRobotYawPitchRollAngles().getYaw(AngleUnit.RADIANS);

        double rotX = x * Math.cos(-botHeading) - y * Math.sin(-botHeading);
        double rotY = x * Math.sin(-botHeading) + y * Math.cos(-botHeading);

        rotX = rotX * 1.1;
        double power;

        if (gamepad.x)
        {
            power = 1.0f;
        }
        else power = 0.5;

        double denominator = Math.max(Math.abs(rotY) + Math.abs(rotX) + Math.abs(r), 1);
        double frontleftpower = (rotY + rotX + r) / denominator * power;
        double backleftpower = (rotY - rotX + r) / denominator * power;
        double frontrightpower = (rotY - rotX - r) / denominator * power;
        double backrightpower = (rotY + rotX - r) / denominator * power;
        mappingA.frontRightMotor.setPower(frontrightpower);
        mappingA.frontLeftMotor.setPower(frontleftpower);
        mappingA.backRightMotor.setPower(backrightpower);
        mappingA.backLeftMotor.setPower(backleftpower);



    }
}
