package ie.gmit.sw.modelclasses;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Objects;

public class FileParser {

    private String path;                                                                                    //Attribute for Storing Path of Input Files Directory

    public FileParser() {                                                                                     //Constructor
    }

    //Getter and Setters

    public FileParser(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    //Getter and Setter Ends

    private ArrayList<File> getFiles(){                                                             //Method for Extracting List of All Files of Input Directory
        File file = new File(this.path);
        if(file.isDirectory()){                                                                                 //Checking Weather  it is Directory or File
            return  filterFiles(Objects.requireNonNull(file.listFiles()));              //calling method which filter the Folder Files and Return Only Files
        }
        return null;
    }

    private ArrayList<File> filterFiles(File[] files){                                             //Method for Making List of All Files and Return Back
        ArrayList<File> fileArrayList = new ArrayList<>();
        for (File file : files) {
            if(file.isFile()){
                fileArrayList.add(file);
            }
        }
        return fileArrayList;
    }

    public  ArrayList<String> getAllFilesData(){                                                //Method Which Return data of files into ArrayList
        ArrayList<String> data = new ArrayList<>();
        for (File file : getFiles()) {
            data.add(readFile(file));
        }
        return data;
    }

    //
    private String readFile(File file){                                                                  //Method Takes FIle as an Argument then Read it and return String
        try(BufferedReader br = new BufferedReader(new FileReader(file))){
            String text = "", line;
            while((line=br.readLine())!=null){
                line = line.replace('\n','_');                             //Replacing NextLine Character With Underscore
                line = line.replace(' ','_');                                //Replacing Space Character with Underscore
                text += line;
            }
            return text;
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }


}
