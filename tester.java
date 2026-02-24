public class Tester {
    public static void main(String[] args) {
        Road r = new Road(10);
        r.populatePeople(30);
        r.populateCars(10);

        for(int i = 0; i < r.stationCount(); i++){
            System.out.println(r.toString());
            r.runRoad();
        }

        System.out.println(r.toString());
    }
}
