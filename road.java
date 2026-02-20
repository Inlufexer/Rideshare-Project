public class Road {
    //fields
    Station[] stations;

    //constructor
    public Road(){
        stations = new Station[32];
    }

    //methods

    public void populatePeople(int people){
        for(int i = 0; i < people - 1; i++){
            int station = (int)(Math.random() * 32);
            Person person = new Person((int)(Math.random() * 32));
            while(person.getStation() == station){
                person.changeEndStation((int)(Math.random() * 32));
            }
            stations[station].addPassenger(person);
        }
    }

    public void populateCars(int cars){
        for(int i = 0; i < cars - 1; i++){
            int station = (int)(Math.random() * 32);
            Car car = new Car(station, (int)(Math.random() * 32));
            if(car.getEndStat() == station){
                car.changeEndStation((int)(Math.random() * 32));
            }
            stations[station].takeCar(car);
        }
    }

    public void moveCars(){
        
    }
}
