package ie.gmit.sw.modelclasses;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;

public class ToCSV {

    private String outputPath;                                                                                                  //Attribute For  OUTPUT file Path
    private HashMap<String, Integer> hashMap = new HashMap<>();                         //Attribute for Storing Frequency of Grams


    //Constructor, Getters and Setters Start
    public ToCSV() {
    }

    public ToCSV(HashMap<String, Integer> hashMap) {
        this.hashMap = hashMap;
    }

    public ToCSV(String outputPath, HashMap<String, Integer> hashMap) {
        this.outputPath = outputPath;
        this.hashMap = hashMap;
    }

    public String getOutputPath() {
        return outputPath;
    }

    public void setOutputPath(String outputPath) {
        this.outputPath = outputPath;
    }

    public HashMap<String, Integer> getHashMap() {
        return hashMap;
    }

    public void setHashMap(HashMap<String, Integer> hashMap) {
        this.hashMap = hashMap;
    }

    //Constructor, Getters and Setters End


    //Main Method For Converting HashMap into CSV FIle to Provided Path
    public String convertIntoCSV(){
        File file = new File(outputPath);
        if(!file.exists()){                         //If Provided File is Not Present then Create FIle
            try {
                file.createNewFile();
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
        //Used Try-Catch with Resources
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(outputPath,true))){       //Append Grams to The End of Files
            for (String s : hashMap.keySet()) {
                if(s.charAt(0) =='\u0022'){                                                                 //This Condition Used Because if We Found Comma Then We Have to Set because in
                    bw.write("\"\" \"");                                                                //CSV File Comma Represent Start of new Cell or Column
                }else {
                    bw.write("\""+s+"\"");
                }
                bw.write(",");
                bw.write("\""+hashMap.get(s)+"\"");
                bw.newLine();
            }
            return "1";
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return "-1";
    }

}
