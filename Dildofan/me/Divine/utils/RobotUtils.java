// 
// Decompiled by Procyon v0.5.36
// 

package me.Divine.utils;

import java.awt.AWTException;
import java.awt.Robot;

public class RobotUtils
{
    public static void clickMouse(final int button) {
        try {
            final Robot bot = new Robot();
            if (button == 0) {
                bot.mousePress(16);
                bot.mouseRelease(16);
            }
            else {
                if (button != 1) {
                    return;
                }
                bot.mousePress(4096);
                bot.mouseRelease(4096);
            }
        }
        catch (AWTException e) {
            e.printStackTrace();
        }
    }
    
    public static void setMouse(final int button, final boolean state) {
        try {
            final Robot bot = new Robot();
            if (button == 0) {
                if (state) {
                    bot.mousePress(16);
                }
                else {
                    bot.mouseRelease(16);
                }
            }
            else {
                if (button != 1) {
                    return;
                }
                if (state) {
                    bot.mousePress(4096);
                }
                else {
                    bot.mouseRelease(4096);
                }
            }
        }
        catch (AWTException e) {
            e.printStackTrace();
        }
    }
}
