package org.firstinspires.ftc.teamcode.systems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class mechanumDrive {
    private DcMotor leftFrontDrive;
    private DcMotor leftRearDrive;
    private DcMotor rightFrontDrive;
    private DcMotor rightRearDrive;

    public void init(HardwareMap hMap){
        leftFrontDrive = hMap.get(DcMotor.class,"leftfront");
        leftRearDrive = hMap.get(DcMotor.class,"leftrear");
        rightFrontDrive = hMap.get(DcMotor.class,"rightfront");
        rightRearDrive = hMap.get(DcMotor.class,"rightrear");

        leftFrontDrive.setDirection(DcMotor.Direction.FORWARD);
        leftRearDrive.setDirection(DcMotor.Direction.FORWARD);
        rightFrontDrive.setDirection(DcMotor.Direction.REVERSE);
        rightRearDrive.setDirection(DcMotor.Direction.REVERSE);

    }

    public void driveRobot(double move, double strafe, double turn) {
            // Calculate wheel powers.
            double frontLeftPower    =  move - strafe - turn;
            double frontRightPower   =  move + strafe + turn;
            double backLeftPower     =  move + strafe - turn;
            double backRightPower    =  move - strafe + turn;

            // Normalize wheel powers to be less than 1.0
            double max = Math.max(Math.abs(frontLeftPower), Math.abs(frontRightPower));
            max = Math.max(max, Math.abs(backLeftPower));
            max = Math.max(max, Math.abs(backRightPower));

            if (max > 1.0) {
                frontLeftPower /= max;
                frontRightPower /= max;
                backLeftPower /= max;
                backRightPower /= max;
            }

            // Send powers to the wheels.
            leftFrontDrive.setPower(frontLeftPower);
            rightFrontDrive.setPower(frontRightPower);
            leftRearDrive.setPower(backLeftPower);
            rightRearDrive.setPower(backRightPower);
    }

}
