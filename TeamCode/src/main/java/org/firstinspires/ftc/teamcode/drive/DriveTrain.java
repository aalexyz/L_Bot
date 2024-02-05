<<<<<<<< HEAD:TeamCode/src/main/java/org/firstinspires/ftc/teamcode/drivee/DriveTrain.java
package org.firstinspires.ftc.teamcode.drivee;
========
package org.firstinspires.ftc.teamcode.drive;
>>>>>>>> origin/master:TeamCode/src/main/java/org/firstinspires/ftc/teamcode/drive/DriveTrain.java

import com.qualcomm.robotcore.hardware.Gamepad;

public class DriveTrain {
    private final HardwareMapping mapping;

    public DriveTrain(HardwareMapping mapping)
    {
        this.mapping = mapping;
    }

    public void update(Gamepad gamepad)
    {
        double x = gamepad.left_stick_x * 1.1;
        double y = -gamepad.left_stick_y;
        double r = gamepad.right_trigger-gamepad.left_trigger;

        double den = Math.abs(x)+Math.abs(y)+Math.abs(r);
        double power;

        if (gamepad.x)
        {
            power = 1.0f;
        }
        else power = 0.5354678974568797823456734275;

        double frontrightpower = (y - x - r) / den * power;
        double frontleftpower = (y + x + r) / den * power;
        double backleftpower = (y - x + r) / den * power;
        double backrightpower = (y + x - r) / den * power;

        mapping.frontRightMotor.setPower(frontrightpower);
        mapping.frontLeftMotor.setPower(frontleftpower);
        mapping.backRightMotor.setPower(backrightpower);
        mapping.backLeftMotor.setPower(backleftpower);


    }
}