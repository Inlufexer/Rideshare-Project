import java.util.*;

public class Car {
    //fields
    private int currStat;
    private int endStat;
    private int dir;
    private ArrayList<Person> people;

    //constructor

    /**
     * 
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
        people.addAll(people);
    }

    /**
     * 
     * @return ArrayList of people dropped off.
     * If the car reaches the end, it returns all of it's passengers.
     * If it is not at the end, it drops of all passengers that need to be dropped at the station
     */
    public ArrayList<Person> dropPassenger(){
        ArrayList<Person> droppedOff = new ArrayList<Person>();
        if(currStat == endStat){
            droppedOff = (ArrayList) people.clone();
            people.clear();
        }
        else{
            for(int i = people.size() - 1; i > -1; i--){
                if(currStat == people.get(i).getStation()){
                    droppedOff.add(people.get(i));
                    people.remove(i);
                }
            }
        }
        return droppedOff;
    }

    public void changeEndStation(int station){
        endStat = station;
    }

    public int getLoad(){
        return people.size();
    }

    public int getEndStat(){
        return endStat;
    }

    public int getStat(){
        return currStat;
    }

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
