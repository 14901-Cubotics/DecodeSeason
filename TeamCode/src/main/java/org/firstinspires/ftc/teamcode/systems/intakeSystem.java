package org.firstinspires.ftc.teamcode.systems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class intakeSystem {
    private DcMotor intakeMotor;

    public void init(HardwareMap hMap){
        intakeMotor = hMap.get(DcMotorEx.class,"intakemotor");
        intakeMotor.setDirection(DcMotorSimple.Direction.FORWARD);
    }

    // Create a public method that controls the intake motor.
    // Look at the init method above for structure. You don't need anything in the parentheses.

    // Reference BasicOmniOpMode.java in FtcRobotController/java/org.firstinspires.ftc.robotcontroller/external.samples
    // See line 156 or setting power.


    // Create a public method that runs the intake in reverse.


}
