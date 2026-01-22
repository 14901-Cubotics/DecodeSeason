package org.firstinspires.ftc.teamcode.systems;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.telemetry;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class carouselSystem {
    private DcMotorEx carouselMotor;
    private int posCurrent = 0;
    private final int pos1 = 251;
    private final int pos2 = 502;
    private final int pos3 = 752;

    public void init(HardwareMap hMap){
        carouselMotor = hMap.get(DcMotorEx.class,"carouselmotor");
        carouselMotor.setDirection(DcMotor.Direction.REVERSE);
        carouselMotor.setTargetPositionTolerance(1);
    }
    

    public void advanceCarousel (){
        switch (posCurrent){
            case 0:
                carouselMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                posCurrent= 1;
                break;
            case 1:
                carouselMotor.setTargetPosition(pos1);
                carouselMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                posCurrent = 2;
                break;
            case 2:
                carouselMotor.setTargetPosition(pos2);
                carouselMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                posCurrent = 3;
                break;
            case 3:
                carouselMotor.setTargetPosition(pos3);
                carouselMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                posCurrent = 0;
                break;

        }
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
