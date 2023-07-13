package com.sda.java.advance.exercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CarService {

    List<Car> cars ;

    public CarService() {
        cars = new ArrayList<>();
    }

    public CarService(List<Car> cars) {
        this.cars = cars;
    }


    public  void addCar(Car car){
        if(!cars.contains(car)){
            cars.add(car);
        }
    }


    public  boolean  removeCar(Car car){
        return cars.remove(car);
    }


    public List<Car>  getV12EngineCars(){
        return  cars.stream().filter(e -> e.getEngineType().equals(EngineType.V12)).collect(Collectors.toList());
    }

    public List<Car>  getCarsBefore1999(){
        return  cars.stream().filter(e -> e.getYearManufacture() <= 1999).collect(Collectors.toList());
    }

    public Car  getMostExpensive(){
        return  cars.stream().max((c1 , c2) ->c2.getPrice().compareTo(c1.getPrice())).get();
    }

    public Car  getCheapest(){
        return  cars.stream().min((c1 , c2) ->c1.getPrice().compareTo(c2.getPrice())).get();
    }


    public  List<Car> getCarAtLeast3Manufacture(){
        return  cars.stream().filter(e -> e.getManufacturers().size()>=3).collect(Collectors.toList());
    }

    public  List<Car> sort(String attribute, String type){

        if(attribute.toLowerCase().equals("price")){

            if(type.toLowerCase().equals("acceding") )
                return  cars.stream().sorted((o1, o2) -> o1.getPrice().compareTo(o2.getPrice())).collect(Collectors.toList());
            else
                return  cars.stream().sorted((o1, o2) -> o2.getPrice().compareTo(o1.getPrice())).collect(Collectors.toList());
        }
        else {
            if (type.toLowerCase().equals("acceding"))
                return cars.stream().sorted((o1, o2) -> o1.getYearManufacture().compareTo(o2.getYearManufacture())).collect(Collectors.toList());
            else
                return cars.stream().sorted((o1, o2) -> o2.getYearManufacture().compareTo(o1.getYearManufacture())).collect(Collectors.toList());
        }
    }


    public boolean existCarInList(Car car){
        return  cars.contains(car);
    }


    public List<Car> sameManufactureCar(Manufacturer manufacturer){
        return cars.stream().filter(c -> c.getManufacturers().contains(manufacturer)).collect(Collectors.toList());
    }

    public List<Car> earlierCarManufacturedThanGiven(Manufacturer manufacturer){
        return cars.stream().filter(car -> {
            Optional<Manufacturer> optional =  car.getManufacturers().stream().filter(m -> m.getYearEstablishment() < manufacturer.getYearEstablishment()).findFirst();
            if(optional.isPresent()){
                return  true;
            }
            return  false;
        }).collect(Collectors.toList());
    }



    public List<Car> getCars() {
        return cars;
    }
}
