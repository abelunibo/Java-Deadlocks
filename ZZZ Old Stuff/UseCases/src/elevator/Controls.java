package elevator;

/*
 * Copyright (C) 2000 by ETHZ/INF/CS
 * All rights reserved
 * 
 * @version $Id$
 * @author Roger Karrer
 */

import java.util.Vector;

// class of the shared control object
class Controls {
    //private Floor[] floors;
	Floor f1, f2, f3, f4;
	
	
    public Controls(/*int numFloors*/) {
        //floors = new Floor[numFloors+1];
        //for(int i = 0; i <= numFloors; i++) floors[i] = new Floor();
    }
    
    private Floor getFloor(int num){
    	if (num == 1)
    		return f1;
    	if (num == 3)
    		return f3;
    	if (num == 2)
    		return f2;
    	return f4;
    }

    // this is called to inform the control object of a down call on floor
    // onFloor
    public void pushDown(int onFloor, int toFloor) {
        Floor floor = getFloor(onFloor);
		synchronized(/*floors[onFloor]*/floor) {
            System.out.println("*** Someone on floor " + onFloor +
                    " wants to go to " + toFloor);
//            floors[onFloor].downPeople.addElement(new Integer(toFloor));
//            if(floors[onFloor].downPeople.size() == 1)
//                floors[onFloor].downFlag = false;
            floor.downPeople.addElement(new Integer(toFloor));
            if(floor.downPeople.size() == 1)
                floor.downFlag = false;
        }
    }

    // this is called to inform the control object of an up call on floor
    // onFloor
    public void pushUp(int onFloor, int toFloor) {
    	Floor floor = getFloor(onFloor);
        synchronized(/*floors[onFloor]*/ floor) {
            System.out.println("*** Someone on floor " + onFloor +
                    " wants to go to " + toFloor);
//            floors[onFloor].upPeople.addElement(new Integer(toFloor));
//            if(floors[onFloor].upPeople.size() == 1)
//                floors[onFloor].upFlag = false;
            
            floor.upPeople.addElement(new Integer(toFloor));
            if(floor.upPeople.size() == 1)
                floor.upFlag = false;
        }
    }

    // An elevator calls this if it wants to claim an up call
    // Sets the floor's upFlag to true if he has not already been set to true
    // Returns true if the elevator has successfully claimed the call, and
    // False if the call was already claimed (upFlag was already true)
    public boolean claimUp(String lift, int floor) {
        if(checkUp(floor)) {
        	Floor floorObj = getFloor(floor);
            synchronized(/*floors[floor]*/ floorObj) { // DONE
//                if(!floors[floor].upFlag) { // DONE
//                    floors[floor].upFlag = true; // DONE
//                    return true;
//                }
            	if(!floorObj.upFlag) { // DONE
            		floorObj.upFlag = true; // DONE
                    return true;
                }
            }
        }
        return false;
    }

    // An elevator calls this if it wants to claim an down call
    // Sets the floor's downFlag to true if he has not already been set to true
    // Returns true if the elevator has successfully claimed the call, and
    // False if the call was already claimed (downFlag was already true)
    public boolean claimDown(String lift, int floor) {
        if(checkDown(floor)) {
        	Floor floorObj = getFloor(floor);
            synchronized(/*floors[floor]*/ floorObj) {  // DONE
//                if(!floors[floor].downFlag) { // DONE
//                    floors[floor].downFlag = true;  // DONE
//                    return true;
//                }
            	if(!floorObj.downFlag) { // DONE
            		floorObj.downFlag = true;  // DONE
                    return true;
                }
            }
        }
        return false;
    }

    // An elevator calls this to see if an up call has occured on the given
    // floor.  If another elevator has already claimed the up call on the 
    // floor, checkUp() will return false.  This prevents an elevator from
    // wasting its time trying to claim a call that has already been claimed
    public boolean checkUp(int floor) {
    	Floor floorObj = getFloor(floor);
        synchronized(/*floors[floor]*/floorObj) {  // DONE
//            boolean ret = floors[floor].upPeople.size() != 0; // DONE
//            ret = ret && !floors[floor].upFlag; // DONE
//            return ret;
            boolean ret = floorObj.upPeople.size() != 0; // DONE
            ret = ret && !floorObj.upFlag; // DONE
            return ret;
        }
    }

    // An elevator calls this to see if a down call has occured on the given
    // floor.  If another elevator has already claimed the down call on the 
    // floor, checkUp() will return false.  This prevents an elevator from
    // wasting its time trying to claim a call that has already been claimed
    public boolean checkDown(int floor) {
    	Floor floorObj = getFloor(floor);
        synchronized(/*floors[floor]*/floorObj) {  // DONE
//            boolean ret = floors[floor].downPeople.size() != 0; // DONE
//            ret = ret && !floors[floor].downFlag; // DONE
//            return ret;
        	 boolean ret = floorObj.downPeople.size() != 0; // DONE
             ret = ret && !floorObj.downFlag; // DONE
             return ret;
        }
    }

    // An elevator calls this to get the people waiting to go up.  The
    // returned Vector contains Integer objects that represent the floors
    // to which the people wish to travel.  The floors vector and upFlag
    // are reset.
    public Vector getUpPeople(int floor) {
    	Floor floorObj = getFloor(floor);
        synchronized(/*floors[floor]*/floorObj) {  // DONE
//            Vector temp = floors[floor].upPeople;  // DONE
//            floors[floor].upPeople = new Vector(); // DONE
//            floors[floor].upFlag = false;  // DONE
        	Vector temp = floorObj.upPeople;  // DONE
        	floorObj.upPeople = new Vector(); // DONE
        	floorObj.upFlag = false;  // DONE
            return temp;
        }
    }

    // An elevator calls this to get the people waiting to go down.  The
    // returned Vector contains Integer objects that represent the floors
    // to which the people wish to travel.  The floors vector and downFlag
    // are reset.
    public Vector getDownPeople(int floor) {
    	Floor floorObj = getFloor(floor);
        synchronized(/*floors[floor]*/floorObj) {  // DONE
//            Vector temp = floors[floor].downPeople; // DONE
//            floors[floor].downPeople = new Vector();  // DONE
//            floors[floor].downFlag = false; // DONE
        	Vector temp = floorObj.downPeople; // DONE
        	floorObj.downPeople = new Vector();  // DONE
        	floorObj.downFlag = false; // DONE
            return temp;
        }
    }
}


