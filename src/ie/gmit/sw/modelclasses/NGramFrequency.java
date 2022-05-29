package ie.gmit.sw.modelclasses;

import java.util.ArrayList;
import java.util.HashMap;

public class NGramFrequency {

    private int gram;                               //Attribute which Decide Gram Size
    private ArrayList<String>  data;      //Attribute which Contain Data of All Files

    //Constructors, Getters and Setters
    public NGramFrequency() {
    }

    public NGramFrequency(ArrayList<String> data) {
        this.data = data;
    }

    public int getGram() {
        return gram;
    }

    public void setGram(int gram) {
        this.gram = gram;
    }

    public ArrayList<String> getData() {
        return data;
    }

    public void setData(ArrayList<String> data) {
        this.data = data;
    }

    //Constructors, getters and Setters End


    public HashMap<String, Integer> getNGrams(){                                //Method Which Return HashMap of Grams
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (String datum : data) {                                                                     //Data of One FIle

            //Main N-Gram Algorithm Start
            for (int i = 0; i< datum.length()-gram ; i++){
                if(hashMap.containsKey(datum.substring(i,i+gram))){             //If Gram Present increase Frequency
                    int x = hashMap.get(datum.substring(i,i+gram));
                    hashMap.put(datum.substring(i,i+gram), x+1);
                }else{
                    hashMap.put(datum.substring(i,i+gram), 1);                          //If Gram Not Present Then Add into HashMap
                }
            }
            //N-Gram Algorithm Ends

        }
        return hashMap;
    }

}
