package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class HardwareMapping {
    public static final String FRONT_LEFT_MOTOR = "motorFL";
    public static final String FRONT_RIGHT_MOTOR = "motorFR";
    public static final String BACK_LEFT_MOTOR = "motorBL";
    public static final String BACK_RIGHT_MOTOR = "motorBR";

    public final DcMotor frontLeftMotor, backLeftMotor, frontRightMotor, backRightMotor;

    public HardwareMapping(DcMotor frontLeftMotor, DcMotor backLeftMotor, DcMotor frontRightMotor, DcMotor backRightMotor) {
        this.frontLeftMotor = frontLeftMotor;
        this.backLeftMotor = backLeftMotor;
        this.frontRightMotor = frontRightMotor;
        this.backRightMotor = backRightMotor;
    }

    public static HardwareMapping from(HardwareMap map) {
        return new HardwareMapping(map.dcMotor.get(FRONT_LEFT_MOTOR),
                map.dcMotor.get(BACK_LEFT_MOTOR),
                map.dcMotor.get(FRONT_RIGHT_MOTOR),
                map.dcMotor.get(BACK_RIGHT_MOTOR));
    }
}
