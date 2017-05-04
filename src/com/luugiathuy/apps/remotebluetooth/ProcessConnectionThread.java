package com.luugiathuy.apps.remotebluetooth;

import java.awt.Event;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

import javax.microedition.io.StreamConnection;

public class ProcessConnectionThread implements Runnable{

	private StreamConnection mConnection;
	private Touchpad touch;
	// Constant that indicate command from devices
	private static final int EXIT_CMD = -1;
	private static final int BUTTON_RIGHT = 68;
	private static final int BUTTON_LEFT = 71;
	private static final int Mouse_mouve=84;
	private static final int AVANT=65;
	private static final int APRES=66;
	public ProcessConnectionThread(StreamConnection connection)
	{
		mConnection = connection;
	}
	
	@Override
	public void run() {
		try {
			
			// prepare to receive data
			InputStream inputStream = mConnection.openInputStream();
         		
			System.out.println("waiting for input");
			String msg;
	        char c;
			while (true) {
	        	
	        	int command = inputStream.read();
	             c=(char)command;
	             msg=""+c;
	             System.out.print(msg);
//	             char O=msg.charAt(0);
//	             System.out.println(O);
	            /* if(O =='T')
	             {	 
	             int n=5;
	             
	             String absice=null;
	             for( int i =1 ;i<n;i++)
	             {absice=absice+msg.charAt(i);
	            	 
	            	 
	             		}
	             int x = 0;
	             System.out.println("Absice"+x);
	             String coordonnee=null;
	             for( int i =n ;i<msg.length();i++)
	             {coordonnee=coordonnee+msg.charAt(i);
	            	 
	            	 
	             		}
	        	int y= 0;
	        	System.out.println("coordonnee"+y);
	        	Robot robot = new Robot();
	        	robot.mouseMove(x, y);
	             }*/
	        	if (command == EXIT_CMD)
	        		
	        	{	
	        		System.out.println("finish process");
	        		break;
	        	}
	        	
	        	processCommand(command);
        	}
        } catch (Exception e) {
    		e.printStackTrace();
    	}
	}
	
	/**
	 * Process the command from client
	 * @param command the command code
	 */
	private void processCommand(int command) {
		try {
			Robot robot = new Robot();
		

    
    			
			switch (command) {
	    	case BUTTON_RIGHT:
	    		MouseEvent Event = null;
	    		
                robot.mousePress(Event.META_MASK);
                robot.mouseRelease(Event.META_MASK);
	    		
	    		System.out.println("Right");
	    		break;
	    	case BUTTON_LEFT:
	    		MouseEvent Event1 = null;
	    		 robot.mousePress(Event1.BUTTON1_MASK);
	    		 robot.mouseRelease(Event1.BUTTON1_MASK); 
	    		   
	    		 System.out.println("Left");
	    		break;
	   		
	    	case AVANT:
	    		robot.keyPress(KeyEvent.VK_RIGHT);
	    		// release the key after it is pressed. Otherwise the event just keeps getting trigged	    		
	    		System.out.println("Right");
	    		robot.keyRelease(KeyEvent.VK_RIGHT);
	    		
	    		break;
	    			
	    	case APRES:
	    		robot.keyPress(KeyEvent.VK_LEFT);
	    		System.out.println("Left");
	    		// release the key after it is pressed. Otherwise the event just keeps getting trigged	    		
	    		robot.keyRelease(KeyEvent.VK_LEFT);
	    		
	  	      
	    		break;
	    
			}
			  	} catch (Exception e) {
			e.printStackTrace();
		}
}
}
