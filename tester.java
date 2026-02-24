public class Tester {
    public static void main(String[] args) {
        Road r = new Road(32);
        r.populatePeople(50);
        r.populateCars(20);

        for(int i = 0; i < r.stationCount(); i++){
            System.out.println(r.toString());
            r.runRoad();
        }

        System.out.println(r.toString());
    }
}
