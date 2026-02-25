import java.util.*;

public class Car {
    //fields
    private int currStat; //current station
    private int endStat; //end station
    private int dir; //direction
    private ArrayList<Person> people; //list of passengers

    //constructor

    /**
     * The constructor for the Car class
     * @param currStat Station at which the car is located
     * @param endStat Station at which the car ends
     */
    public Car(int currStat, int endStat){
        this.currStat = currStat;
        this.endStat = endStat;
        people = new ArrayList<Person>();
        if(endStat > currStat){
            dir = 1;
        }
        else{
            dir = -1;
        }
    }

    //methods

    /**
     * Calculates the car's position for next tic
     * @return station the car moves to
     */
    public int move(){
        if(currStat != endStat){
            currStat += dir;
        }
        return currStat;
    }

    /**
     * Adds people to the car
     * @param people list of people that enter the car
     */
    public void addPassenger(ArrayList<Person> people){
        this.people.addAll(people);
    }

    /**
     * If the car reaches the end, it returns all of it's passengers.
     * If it is not at the end, it drops of all passengers that need to be dropped at the station
     * @return ArrayList of people dropped off
     */
    public ArrayList<Person> dropPassenger(){
        ArrayList<Person> droppedOff = new ArrayList<Person>();
        if(currStat == endStat){
            droppedOff = (ArrayList) people.clone();
            people.clear();
        }
        else{
            for(int i = people.size() - 1; i > -1; i--){
                if(currStat == people.get(i).getEndStation()){
                    droppedOff.add(people.get(i));
                    people.remove(i);
                }
            }
        }
        return droppedOff;
    }
    /**
     * Changes the car's endStation
     * @param station the car's new endStation
     */
    public void changeEndStation(int station){
        endStat = station;
    }

    /**
     * Gets the number of passengers
     * @return people.size()
     */
    public int getLoad(){
        return people.size();
    }

    /**
     * Gets the end station
     * @return endStat
     */
    public int getEndStat(){
        return endStat;
    }

    /**
     * Gets the current station
     * @return currStat
     */
    public int getStat(){
        return currStat;
    }

    /**
     * Gets the direction
     * @return dir
     */
    public int getDir(){
        return dir;
    }

    public String toString(){
        return "Station: " + currStat +
        " End Station: " + endStat +
        " Direction: " + dir +
        " Load: " + getLoad();
    }
}
