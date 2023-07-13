package com.sda.java.advance.exercises;


import java.util.ArrayList;
import java.util.List;

public class Circle  implements Movable , Resizable{

    private Point2D center;

    private Point2D point ;


    public Circle(Point2D center, Point2D point) {
        this.center = center;
        this.point = point;
    }


    public  double getRadius(){
        return  Math.sqrt(Math.pow((center.getX() - point.getX()), 2)  +  Math.pow((center.getY() - point.getY()), 2)) ;
    }

    public double getPerimeter(){
        return  2 * 3.14 * getRadius();
    }

    public double getArea(){
        return  3.14 * Math.pow(getRadius(),2);
    }


//    (cosθx - sinθy,sinθx + cosθy)
    public List<Point2D> getSlicePoints(){
        List<Point2D> pointList = new ArrayList<>();

        Point2D temp = new Point2D(point.getX(), point.getY());

        while (true){
            double x =  - temp.getY();
            double y = temp.getX();
            Point2D point2D =  new Point2D(x,y);
            if(point2D.equals(point)){
                break;
            }
            pointList.add(point2D);
            temp =  point2D;
        }


        return pointList;
    }


    @Override
    public void move(MoveDirection moveDirection) {
        center.setX(center.getX() + moveDirection.getX());
        center.setY(center.getY() + moveDirection.getY());
        point.setX(point.getX() + moveDirection.getX());
        point.setY(point.getY() + moveDirection.getY());
    }

    @Override
    public String toString() {
        return "Circle{" +
                "center=" + center +
                ", point=" + point +
                '}';
    }

    @Override
    public void resize(double resizeFactor) {
        point.setX(point.getX() * resizeFactor - center.getX());
        point.setY(point.getY()* resizeFactor - center.getY());
    }


}
