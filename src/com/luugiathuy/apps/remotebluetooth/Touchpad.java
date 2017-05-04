package com.luugiathuy.apps.remotebluetooth;

import java.awt.AWTException;
import java.awt.Robot;

public class Touchpad {
	
public Touchpad(String ch)
{Robot robot;
try {
	robot = new Robot();

	String a="";
for(int i=0;i<ch.indexOf(" ");i++)
{
	
	a=a+ch.charAt(i);
	
}
int x=Integer.parseInt(a);
String b="";
for(int i=ch.indexOf(" ");i<ch.length();i++)
{
	
	b=b+ch.charAt(i);
	
}
int y=Integer.parseInt(b);
robot.mouseMove(x,y);
} catch (AWTException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
}
}
