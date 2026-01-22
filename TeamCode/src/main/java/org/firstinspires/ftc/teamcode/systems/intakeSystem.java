package org.firstinspires.ftc.teamcode.systems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class intakeSystem {
    private DcMotor intakeMotor;
    private Double intakeSpeed = 1.0;

    public void init(HardwareMap hMap){
        intakeMotor = hMap.get(DcMotorEx.class,"intakemotor");
        intakeMotor.setDirection(DcMotorSimple.Direction.FORWARD);
    }
    public void runIntake(){//runs intake forward
        intakeMotor.setPower(intakeSpeed);
    }

    public void stopIntake(){//stops intake
        intakeMotor.setPower(0.0);
    }

    public void reverseRunIntake(){//runs intake backwards
        intakeMotor.setPower(-intakeSpeed);
    }


}
