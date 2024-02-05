<<<<<<<< HEAD:TeamCode/src/main/java/org/firstinspires/ftc/teamcode/drivee/HardwareMapping.java
package org.firstinspires.ftc.teamcode.drivee;
========
package org.firstinspires.ftc.teamcode.drive;
>>>>>>>> origin/master:TeamCode/src/main/java/org/firstinspires/ftc/teamcode/drive/HardwareMapping.java

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.IMU;

public class HardwareMapping {
    public static final String FRONT_LEFT_MOTOR = "motorFL";
    public static final String FRONT_RIGHT_MOTOR = "motorFR";
    public static final String BACK_LEFT_MOTOR = "motorBL";
    public static final String BACK_RIGHT_MOTOR = "motorBR";
    public static final String INTAKE_MOTOR = "motorIntake";
<<<<<<<< HEAD:TeamCode/src/main/java/org/firstinspires/ftc/teamcode/drivee/HardwareMapping.java
    public static final String LIFT_MOTOR = "motorLift";
    public static final String LIFT_MOTOR_REVERSE = "motorLiftR";

    public final DcMotor frontLeftMotor, backLeftMotor, frontRightMotor, backRightMotor, intakeMotor;
    public final DcMotor liftMotor, liftMotorR;
    public final IMU imu;

    public HardwareMapping(DcMotor frontLeftMotor, DcMotor backLeftMotor, DcMotor frontRightMotor, DcMotor backRightMotor, DcMotor intakeMotor, IMU imu, DcMotor liftMotor, DcMotor liftMotorR) {
========

    public final DcMotor frontLeftMotor, backLeftMotor, frontRightMotor, backRightMotor, intakeMotor;
    public final IMU imu;

    public HardwareMapping(DcMotor frontLeftMotor, DcMotor backLeftMotor, DcMotor frontRightMotor, DcMotor backRightMotor, DcMotor intakeMotor, IMU imu) {
>>>>>>>> origin/master:TeamCode/src/main/java/org/firstinspires/ftc/teamcode/drive/HardwareMapping.java
        this.frontLeftMotor = frontLeftMotor;
        this.backLeftMotor = backLeftMotor;
        this.frontRightMotor = frontRightMotor;
        this.backRightMotor = backRightMotor;
<<<<<<<< HEAD:TeamCode/src/main/java/org/firstinspires/ftc/teamcode/drivee/HardwareMapping.java

        this.intakeMotor = intakeMotor;

========
        this.intakeMotor = intakeMotor;
>>>>>>>> origin/master:TeamCode/src/main/java/org/firstinspires/ftc/teamcode/drive/HardwareMapping.java
        this.imu = imu;

        this.liftMotor = liftMotor;
        this.liftMotorR = liftMotorR;

        frontLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        backLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        liftMotorR.setDirection(DcMotorSimple.Direction.REVERSE);

        frontRightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backRightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        intakeMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
<<<<<<<< HEAD:TeamCode/src/main/java/org/firstinspires/ftc/teamcode/drivee/HardwareMapping.java
        liftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        liftMotorR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

========
>>>>>>>> origin/master:TeamCode/src/main/java/org/firstinspires/ftc/teamcode/drive/HardwareMapping.java

        frontLeftMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        frontRightMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backLeftMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backRightMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        intakeMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    }

    public static HardwareMapping from(HardwareMap map) {
        return new HardwareMapping(
                map.dcMotor.get(FRONT_LEFT_MOTOR),
                map.dcMotor.get(BACK_LEFT_MOTOR),
                map.dcMotor.get(FRONT_RIGHT_MOTOR),
                map.dcMotor.get(BACK_RIGHT_MOTOR),
                map.dcMotor.get(INTAKE_MOTOR),
<<<<<<<< HEAD:TeamCode/src/main/java/org/firstinspires/ftc/teamcode/drivee/HardwareMapping.java
                map.get(IMU.class, "imu"),
                map.dcMotor.get(LIFT_MOTOR),
                map.dcMotor.get(LIFT_MOTOR_REVERSE)
                );
========
                map.get(IMU.class, "imu"));
>>>>>>>> origin/master:TeamCode/src/main/java/org/firstinspires/ftc/teamcode/drive/HardwareMapping.java
    }
}