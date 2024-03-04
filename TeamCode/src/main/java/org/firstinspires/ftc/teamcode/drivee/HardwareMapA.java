
package org.firstinspires.ftc.teamcode.drivee;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class HardwareMapA {
    public static final String FRONT_LEFT_MOTOR = "motorFL";
    public static final String FRONT_RIGHT_MOTOR = "motorFR";
    public static final String BACK_LEFT_MOTOR = "motorBL";
    public static final String BACK_RIGHT_MOTOR = "motorBR";
    public static final String SLIDER_MOTOR = "motorSlider";
    public static final String ROTATION_MOTOR = "motorRotation";
    public static final String CLAW_SERVO_1 = "servoClaw1";
    public static final String CLAW_MINI_1 = "miniClaw1";
    public static final String CLAW_MINI_2 = "miniClaw2";

    public final DcMotor frontLeftMotor, backLeftMotor, frontRightMotor, backRightMotor;
    public final DcMotorEx motorSlider, motorRotation;
    public final Servo servoC1, miniC1, miniC2;

    public HardwareMapA(DcMotor frontLeftMotor, DcMotor backLeftMotor, DcMotor frontRightMotor, DcMotor backRightMotor, DcMotorEx motorSlider, DcMotorEx motorRotation, Servo servoC1, Servo miniC1, Servo miniC2) {

        this.frontLeftMotor = frontLeftMotor;
        this.backLeftMotor = backLeftMotor;
        this.frontRightMotor = frontRightMotor;
        this.backRightMotor = backRightMotor;

        this.motorSlider = motorSlider;
        this.motorRotation = motorRotation;

        this.servoC1 = servoC1;
        this.miniC1 = miniC1;
        this.miniC2 = miniC2;


        frontLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        backLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);


        frontRightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backRightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motorRotation.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motorSlider.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        frontLeftMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        frontRightMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backLeftMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backRightMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

    }

    public static HardwareMapA from(HardwareMap map) {
        return new HardwareMapA(
                map.dcMotor.get(FRONT_LEFT_MOTOR),
                map.dcMotor.get(BACK_LEFT_MOTOR),
                map.dcMotor.get(FRONT_RIGHT_MOTOR),
                map.dcMotor.get(BACK_RIGHT_MOTOR),
                (DcMotorEx) map.dcMotor.get(SLIDER_MOTOR),
                (DcMotorEx) map.dcMotor.get(ROTATION_MOTOR),
                map.servo.get(CLAW_SERVO_1),
                map.servo.get(CLAW_MINI_1),
                map.servo.get(CLAW_MINI_2)
        );
    }
}