package ie.gmit.sw.factory;

import ie.gmit.sw.Runner;
import ie.gmit.sw.modelclasses.FileParser;
import ie.gmit.sw.modelclasses.NGramFrequency;
import ie.gmit.sw.modelclasses.ToCSV;

import java.util.ArrayList;
import java.util.HashMap;

public class NGramFrequencyGenerator extends  Thread implements FactoryMethods{

    private FileParser fp;                                                       //Attribute for Parsing Txt Files into String
    private NGramFrequency ng;                                       //Attribute for Converting String into N-Gram Frequency
    private ToCSV csv;                                                           //Attribute for adding N-Gram Frequency into CSV File

    public NGramFrequencyGenerator(){                           //Default Constructor
        fp = new FileParser();
        ng = new NGramFrequency();
        csv = new ToCSV();
    }

    @Override
    public void run(){                                                              //Method For Building Grams which run as a separate Thread
        buildGrams();
    }

    @Override
    public String setFilesDirectoryPath(String path) {      //Method of Getting Text Files Directory
        fp.setPath(path);
        return "Successfully Added";
    }

    @Override
    public String setOutputFile(String path) {              //Method for setting absolute Output FIle  path
        csv.setOutputPath(path);
        return "Successfully Added";
    }

    @Override
    public String setGrams(int gram) {                          //Setting Grams Size
       if(gram>=1 && gram<=5){
           ng.setGram(gram);
           return "Successfully Added";
       }
       return "Sorry Not Possible";
    }

    @Override
    public String buildGrams() {                                                            //Method for Creating N-Gram, by using path of  input files and Output FIle
        ArrayList<String> data = fp.getAllFilesData();
        ng.setData(data);

        HashMap<String, Integer> hashMap =  ng.getNGrams();     //HashMap Send to TO CSV Class for converting HashMap into CSV File
        csv.setHashMap(hashMap);

        csv.convertIntoCSV();

        return "Successfully CSV File Created";
    }

}
