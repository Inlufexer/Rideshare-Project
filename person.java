public class Person{
    //fields
    private int endStation;

    //constructor
    public Person(int endStation){
        this.endStation = endStation;
    }

    //methods
    public int getEndStation(){
        return endStation;
    }

    public void changeEndStation(int i){
        endStation = i;
    }

    public String toString(){
        return "Dest: " + endStation;
    }
}   