
package org.firstinspires.ftc.teamcode.drivee;
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
    public static final String LIFT_MOTOR = "motorLift";
    public static final String LIFT_MOTOR_REVERSE = "motorLiftR";
    public static final String LIFT_ENCODER = "liftEncoder";


    public final DcMotor frontLeftMotor, backLeftMotor, frontRightMotor, backRightMotor, intakeMotor;
    public final DcMotorEx liftMotor, liftMotorR, liftEncoder;
    public final IMU imu;

    public HardwareMapping(DcMotor frontLeftMotor, DcMotor backLeftMotor, DcMotor frontRightMotor, DcMotor backRightMotor, DcMotor intakeMotor, IMU imu, DcMotorEx liftMotor, DcMotorEx liftMotorR, DcMotorEx liftEncoder) {

        this.frontLeftMotor = frontLeftMotor;
        this.backLeftMotor = backLeftMotor;
        this.frontRightMotor = frontRightMotor;
        this.backRightMotor = backRightMotor;

        this.intakeMotor = intakeMotor;

        this.imu = imu;

        this.liftMotor = liftMotor;
        this.liftMotorR = liftMotorR;
        this.liftEncoder = liftEncoder;

        frontLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        backLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        liftMotorR.setDirection(DcMotorSimple.Direction.REVERSE);

        frontRightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backRightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        intakeMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        liftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        liftMotorR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);


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
                map.get(IMU.class, "imu"),
                (DcMotorEx) map.dcMotor.get(LIFT_MOTOR),
                (DcMotorEx) map.dcMotor.get(LIFT_MOTOR_REVERSE),
                (DcMotorEx) map.dcMotor.get(LIFT_ENCODER)
        );
    }
}