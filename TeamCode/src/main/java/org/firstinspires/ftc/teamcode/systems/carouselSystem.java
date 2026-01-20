package org.firstinspires.ftc.teamcode.systems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class carouselSystem {
    private DcMotorEx carouselMotor;
    private final int encoderRes = 385;
    private int tpb = encoderRes/3;
    private int currentTics;
    private int targetTics;

    public void init(HardwareMap hMap){
        carouselMotor = hMap.get(DcMotorEx.class,"carouselmotor");
        carouselMotor.setDirection(DcMotor.Direction.REVERSE);
        carouselMotor.setTargetPositionTolerance(1);
    }
    

    public void advanceCarousel (){
        currentTics = carouselMotor.getCurrentPosition();
        targetTics = currentTics + tpb;
        carouselMotor.setTargetPosition(targetTics);
        carouselMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        carouselMotor.setPower(0.5);
    }

    // Create a public method that controls the carousel motor.
    // Look at the init method above for structure. You don't need anything in the parentheses.

    // Reference BasicOmniOpMode.java in FtcRobotController/java/org.firstinspires.ftc.robotcontroller/external.samples
    // See line 156 or setting power.

    // For this you will need to use the ticks of the motor to make 3 positions.
    // go on GoBilda site, find motor and speed. it'll give you teh number of ticks per revolution.
    // Divide that by 3.

    //  Use variables to store previous tick reading, then move relative to it.

    // Create a method for advancing to next position

    // create a method for running it manually


}
