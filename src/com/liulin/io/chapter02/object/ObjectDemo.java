package com.liulin.io.chapter02.object;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Create by DbL on 2020/4/23 0023
 */
public class ObjectDemo {
    public static void main(String[] args) {
        /*User user = new User("DBL",18);
        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("G:/user"));){
            objectOutputStream.writeObject(user);

        }catch (Exception e){
            e.printStackTrace();
        }*/

        try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("G:/user"))){
            User user = (User) objectInputStream.readObject();
            System.out.println(user.toString());
        }catch (Exception e){

        }
    }
}
