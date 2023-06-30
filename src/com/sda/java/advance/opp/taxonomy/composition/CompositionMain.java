package com.sda.java.advance.opp.taxonomy.composition;

public class CompositionMain {


//    composition esht kur krijojme nje attribute te nje klase tjeter
//    te klasa jone aktuale
//    encapsulation esht kru deklarojme atributet e nje klase private
//    te cilat nuk mund te aksesohen jasht skopit te klases
//    ne kete rast perdorim metoda publike sic jan getters and setters
    static class Room{
        private TV tv;
        private Bed bed;

        public TV getTv() {
            return tv;
        }

        public void setTv(TV tv) {
            this.tv = tv;
        }

        public Bed getBed() {
            return bed;
        }

        public void setBed(Bed bed) {
            this.bed = bed;
        }

        public  void showRoom(){
            System.out.printf("Room has TV: {type: %s , resolution: %d} " +
                    "and Bed: {name:%s ,bedSizePerMeterSqrt: %d}\n",
                    tv.type, tv.resolution, bed.name, bed.bedSizePerMeterSqrt );
        }
    }

    static  class TV{
        String type;
        int resolution;

    }

    static class Bed {
        String name ;
        int bedSizePerMeterSqrt;
    }

    public static void main(String[] args) {
        TV t1 =  new TV();
        t1.type = "LG";
        t1.resolution = 120;
        Bed b1 = new Bed();
        b1.name = "sthBed";
        b1.bedSizePerMeterSqrt = 2 ;
        Room r1 = new Room();
        r1.setBed(b1);
        r1.setTv(t1);

        r1.showRoom();
    }
}
