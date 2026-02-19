import java.util.*;

public class Car {
    //fields
    private int maxPer;
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
        maxPer = 3;
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
        currStat += dir;
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
            return droppedOff;
        }
        else{
            for(int i = people.size() - 1; i > -1; i++){
                if(currStat == people.get(i).getStation()){
                    droppedOff.add(people.get(i));
                    people.remove(i);
                }
            }
        }
        return droppedOff;
    }

    public ArrayList<Person> passengerHandle(int station, ArrayList<Person> people){
        ArrayList<Person> droppedOff = new ArrayList<Person>();
        addPassenger(people);
        droppedOff = dropPassenger();
        return droppedOff;
    }

    public boolean full(){
        return people.size() == maxPer;
    }

}
