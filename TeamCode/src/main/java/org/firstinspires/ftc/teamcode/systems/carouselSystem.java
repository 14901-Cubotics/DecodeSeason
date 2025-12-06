package org.firstinspires.ftc.teamcode.systems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class carouselSystem {
    private DcMotorEx carouselMotor;

    public void init(HardwareMap hMap){
        carouselMotor = hMap.get(DcMotorEx.class,"carouselmotor");
        carouselMotor.setDirection(DcMotor.Direction.FORWARD);
    }

    // Create a public method that controls the carousel motor.
    // Look at the init method above for structure. You don't need anything in the parentheses.

    // Reference BasicOmniOpMode.java in FtcRobotController/java/org.firstinspires.ftc.robotcontroller/external.samples
    // See line 156 or setting power.

    // For this you will need to use the ticks of the motor to make 3 positions.


}
