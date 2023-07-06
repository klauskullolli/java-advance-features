package com.sda.java.advance.io;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Question implements Serializable {

    private int id;

    private  String description;
    private List<Alternative> alternatives ;
    private Alternative solution;

    public Question(int id,  String description) {
        this.id = id;
        this.description = description;
        alternatives =  new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Alternative> getAlternatives() {
        return alternatives;
    }

    public void setAlternatives(List<Alternative> alternatives) {
        this.alternatives = alternatives;
    }

    public Alternative getSolution() {
        return solution;
    }


    public void setSolution(int alternativeId) {
        boolean hasAlternative = false;
        for(Alternative a : alternatives){
            if(alternativeId==a.getId()){
                solution = a;
                hasAlternative=true;
                break;
            }
        }

        if(!hasAlternative){
            System.out.println("This alternative does not exist");
        }
    }

    public void setSolution(Alternative solution) {
        this.solution = solution;
    }

    public void addAlternative(Alternative alternative){
        if(!alternatives.contains(alternative)){
            alternatives.add(alternative);
        }
    }

    public  void  addAlternatives(List<Alternative> alternatives){
        for(Alternative a : alternatives){
            if(this.alternatives.contains(a)){
                continue;
            }
            this.alternatives.add(a);
        }
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", alternatives=" + alternatives +
                ", solution=" + solution +
                '}';
    }


    @Override
    public boolean equals(Object obj) {
        return id == ((Question)obj).getId();
    }
}
