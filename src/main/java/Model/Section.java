package model;

/**
 * Created by Sokolov on 04.02.2015.
 */
public class Section {
    float mass;
    float lenght,height,weight;
    TowerSection typ;
    String name;
    int id;



    Section (){
        //


    }


    public Section(String s, int id){

        this.name =s;
        this.id=id;


    }




    Section (TowerSection typ) {
        this.typ = typ;


    }


    Section (TowerSection typ, float lenght,float height,float weight,float mass){

        this.mass = mass;
        this.height=height;
        this.lenght=lenght;
        this.weight=weight;
        this.typ=typ;




    }




    public void setParams (){



    }





}
