package org.firstinspires.ftc.teamcode.systems;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class launchSystem {
    private DcMotorEx flywheel;
   // private carouselSystem carousel;
    private final  double TICKSPERREV = 28;
    private final double TPSECOND = TICKSPERREV * 100;
    private final double MAXVELOCITY = TPSECOND;
    private final double IDLEVELOCITY = 100.00;
    private final double SHORTVELOCITY = 60.00;
    private final double LONGVELOCITY = 80.00;

    public void init (HardwareMap hMap){
        flywheel = hMap.get(DcMotorEx.class,"flywheel");
        flywheel.setDirection(DcMotorEx.Direction.REVERSE);
        flywheel.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER);
    }

    public void activateFlywheel(){
        flywheel.setVelocity(800);
    }
    public void idleFlywheel(){
        flywheel.setVelocity(IDLEVELOCITY);
    }
    public void activateLongFlywheel(){
        flywheel.setVelocity(LONGVELOCITY);
    }
    public void activateShortFlywheel(){
        flywheel.setVelocity(SHORTVELOCITY);
    }
    public void stopFlywheel(){
        flywheel.setVelocity(0);
    }

    // Setup functions
    // create a state machine for launching.
    // have 2, states, Idle and Launch.
    // Use velocity for the readings.
    // create a launch
}
