package ie.gmit.sw.factory;

public interface FactoryMethods {
    String setFilesDirectoryPath(String path);                  //Method for  Getting Text Files Directory
    String setOutputFile(String path);                               //Method for Getting Output CSV File Path
    String setGrams(int gram);                                          //Method for getting Gram Size 1-5
    String buildGrams();                                                     //Method for Building n-Grams
}
