package org.firstinspires.ftc.teamcode.systems;


import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.NormalizedColorSensor;
import com.qualcomm.robotcore.hardware.NormalizedRGBA;

public class carouselSystem {
    private DcMotorEx carouselMotor;
    HardwareMap hMap;
    private NormalizedColorSensor colorSensor;
    OpMode myOpMode;

    public void init(OpMode op){
        myOpMode = op;
        hMap = myOpMode.hardwareMap;

        // set up carousel motor
        carouselMotor = hMap.get(DcMotorEx.class,"carouselmotor");
        carouselMotor.setDirection(DcMotor.Direction.REVERSE);
        carouselMotor.setTargetPositionTolerance(2);

        colorSensor = hMap.get(NormalizedColorSensor.class,"colorsensor");
        colorSensor.setGain(15);
    }

    // Function determines if the yellow flags were detected.
    private boolean colorDetected (){
        NormalizedRGBA colors = colorSensor.getNormalizedColors();

        float normRed, normGreen, normBlue;
        normRed = colors.red / colors.alpha;
        normGreen = colors.green / colors.alpha;
        normBlue = colors.blue / colors.alpha;
        if (normRed > 0.5 && normGreen > 0.9 && normBlue < 0.6){
            return true;
        } else {
            return false;
        }
    }
    public void advanceCarousel (){
        carouselMotor.setPower(0.25);
        carouselMotor.setTargetPosition(carouselMotor.getCurrentPosition()+(752/3));
        carouselMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        while (carouselMotor.isBusy()) {
            if (colorDetected()) {
                carouselMotor.setPower(0);
                carouselMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            }
        }
    }



}
