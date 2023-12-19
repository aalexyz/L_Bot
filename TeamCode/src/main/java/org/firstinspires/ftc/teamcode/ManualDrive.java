package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

import static java.lang.Math.*;

@TeleOp(name = "manual")
public class ManualDrive extends BaseLOPMode {
    private HardwareMapping mapping;
    @Override
    public void setup() {
        mapping = HardwareMapping.from(hardwareMap);
        mapping.frontRightMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        mapping.backRightMotor.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    @Override
    public void run() {
        double y = -gamepad1.left_stick_y; // Y is reversed
        double x = gamepad1.left_stick_x * 1.1;
        double rx = gamepad1.right_stick_x;

        x -= gamepad1.left_bumper ? 0.5 : 0;
        x += gamepad1.right_bumper ? 0.5 : 0;

        double denominator = max(abs(y) + abs(x) + abs(rx), 1);
        double frontLeftPower = (y + x + rx) / denominator;
        double backLeftPower = (y - x + rx) / denominator;
        double frontRightPower = (y - x - rx) / denominator;
        double backRightPower = (y + x - rx) / denominator;

        mapping.frontLeftMotor.setPower(frontLeftPower);
        mapping.backLeftMotor.setPower(backLeftPower);
        mapping.frontRightMotor.setPower(frontRightPower);
        mapping.backRightMotor.setPower(backRightPower);
    }
}
