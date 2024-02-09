package org.firstinspires.ftc.teamcode.utils;

import com.qualcomm.robotcore.util.ElapsedTime;

public class PID {


    public double kp=0 , ki=0 , kd=0;

    public PID(double kp , double ki , double kd){
        this.kp=kp;
        this.ki=ki;
        this.kd=kd;
    }
    double integralSum=0;
    double lasterror=0;
    ElapsedTime timer=new ElapsedTime();

    double pid(double reference , double state){ // "getVelocity"
        double error=reference-state;
        integralSum+=error*timer.seconds();
        double derivtive=(error-lasterror)/timer.seconds();
        double output=error*kp+integralSum*ki+derivtive*kd;
        lasterror=error;
        timer.reset();

        return output;
    }
}
