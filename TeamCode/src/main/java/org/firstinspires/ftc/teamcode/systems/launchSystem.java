package org.firstinspires.ftc.teamcode.systems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class launchSystem {
    private DcMotorEx Flywheel;

    public void init (HardwareMap hMap){
        Flywheel = hMap.get(DcMotorEx.class,"carouselmotor");
        Flywheel.setDirection(DcMotor.Direction.REVERSE);
    }
    
}
