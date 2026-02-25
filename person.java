public class Person{
    //fields
    private int endStation;

    //constructor
    /**
     * The constructor for the Person class
     * @param endStation the station at which the person will stop taking cars
     */
    public Person(int endStation){
        this.endStation = endStation;
    }

    //methods
    /**
     * Gets the end station
     * @return endStation
     */
    public int getEndStation(){
        return endStation;
    }

    /**
     * Changes the person's end station
     * @param i the person's new endStation
     */
    public void changeEndStation(int i){
        endStation = i;
    }

    public String toString(){
        return "Dest: " + endStation;
    }
}   