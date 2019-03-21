/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.vision;

/**
 * Add your docs here.
 */
public class PixyPacket {
    private int signature;
    private int x;
    private int y;
    private int width;
    private int height;
    
    public PixyPacket() {
        signature = 0;
        x = 0;
        y = 0;
        width = 0;
        height = 0;
    }

    public PixyPacket(int sig, int x, int y, int width, int height) {
        this.signature = sig;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void setSignature(int signature) {
        this.signature = signature;
    }

    public int getSignature() {
        return signature;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getX() {
        return x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getY() {
        return y;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getWidth() {
        return width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public int getSize() {
        return width * height;
    }

    //public int checksumError;
    
    public String toString() {
            return "" +
        " S: " + signature +
        " X: " + x + 
        " Y: " + y +
        " W: " + width + 
        " H: " + height;
    }
}
