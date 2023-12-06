package com.example.diario.crud;

import com.example.diario.model.Profesor;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class CRUPProfesor {

    private final static int calculateIndex() {
        Realm realm = Realm.getDefaultInstance();
        Number currentIdNum = realm.where(Profesor.class).max("id");
        int nextId;
        if (currentIdNum == null) {

            nextId = 0;

        } else {

            nextId = currentIdNum.intValue() + 1;


        }

        return  nextId;
    }



    ///Create


    public final static void addProfesor (final Profesor profesor){
        Realm realm = Realm.getDefaultInstance();

        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {

                int index =CRUPProfesor.calculateIndex();
                Profesor realmProfesor =realm.createObject(Profesor.class,index);
                realmProfesor.setName(profesor.getName());
                realmProfesor.setEmail(profesor.getEmail());
            }
        });



    }



    //// Encontrar Toda la Lista de profesores


    //Read

    public final static List<Profesor> getAllProfesor(){
        Realm realm = Realm.getDefaultInstance();
        RealmResults<Profesor> profesors= realm.where(Profesor.class).findAll();
        for(Profesor profesor: profesors){


        }

        return profesors;


    }


    //Busca el Objeto por Nombre

    public final static Profesor getAllProfesorbyName(String Name){
        Realm realm = Realm.getDefaultInstance();
        Profesor profesor = realm.where(Profesor.class).equalTo("name",Name).findFirst();


        return profesor;

    }


    //Busca el Objeto por el otro Id
    public final static Profesor getAllProfesorbyId(int id){
        Realm realm = Realm.getDefaultInstance();
        Profesor profesor = realm.where(Profesor.class).equalTo("id",id).findFirst();


        return profesor;

    }




    //Update


    public final static void updateprofesorById(int id, String name){
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        Profesor profesor = realm.where(Profesor.class).equalTo("id",id).findFirst();
        profesor.setName(name);
        realm.insertOrUpdate(profesor);
        realm.commitTransaction();

    }




    //delete por Id


    public final static void deleteprofesorById(int id){
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        Profesor profesor = realm.where(Profesor.class).equalTo("id",id).findFirst();
        profesor.deleteFromRealm();
        realm.commitTransaction();

    }

    //Delete All


    public final static void deleteforallprofesors(){
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        RealmResults<Profesor> profesors= realm.where(Profesor.class).findAll();
        //profesors.deleteAllFromRealm();
        realm.deleteAll();
        realm.commitTransaction();

    }
















}
