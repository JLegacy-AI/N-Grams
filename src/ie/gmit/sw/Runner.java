package ie.gmit.sw;

import ie.gmit.sw.factory.NGramFrequencyGenerator;
import ie.gmit.sw.modelclasses.ProgressBar;

import java.awt.*;
import java.util.Scanner;

public class Runner {

	private NGramFrequencyGenerator ngf = new NGramFrequencyGenerator();
	private Scanner scan = new Scanner(System.in);
	private ProgressBar progressBar;

	public void menu() throws InterruptedException {
		while(true){
			//You should put the following code into a menu or Menu class
			System.out.println(ConsoleColour.WHITE);
			System.out.println("************************************************************");
			System.out.println("*      GMIT - Dept. Computer Science & Applied Physics     *");
			System.out.println("*                                                          *");
			System.out.println("*                  N-Gram Frequency Builder                *");
			System.out.println("*                                                          *");
			System.out.println("************************************************************");
			System.out.println("(1) Specify Text File Directory");
			System.out.println("(2) Specify n-Gram Size");
			System.out.println("(3) Specify Output File");
			System.out.println("(4) Build n-Grams ");
			System.out.println("(5) Quit");

			//Output a menu of options and solicit text from the user
			System.out.print(ConsoleColour.BLACK_BOLD_BRIGHT);
			System.out.print("Select Option [1-4]>\n");
			int op = scan.nextInt();
			option(op);
		}
	}

	public void option(int x) throws InterruptedException {
		if(x==1){
			setTextFileDirectory();
		}else if (x==2){
			setGramSize();
		}else if (x==3){
			setOutPutFile();
		}else if (x==4){
			buildGram();
		}else if (x==5){
			quit();
		}
	}

	public void setTextFileDirectory() throws InterruptedException {
		progressBar = new ProgressBar(10, ConsoleColour.GREEN);
		System.out.println("Enter Text File Directory Path: ");
		String path = scan.next();
		progressBar.start();
		ngf.setFilesDirectoryPath(path);
		progressBar.join();
	}

	public void setGramSize() throws InterruptedException {
		progressBar = new ProgressBar(10, ConsoleColour.GREEN);
		System.out.println("Enter Gram Size: ");
		int gsize = scan.nextInt();
		progressBar.start();
		System.out.println(ngf.setGrams(gsize));
		progressBar.join();
	}

	public void setOutPutFile() throws InterruptedException {
		progressBar = new ProgressBar(10, ConsoleColour.GREEN);
		System.out.println("Enter Output File Path: ");
		String path = scan.next();
		progressBar.start();
		System.out.println(ngf.setOutputFile(path));
		progressBar.join();
	}

	public void buildGram() throws InterruptedException {
		progressBar = new ProgressBar(1000, ConsoleColour.GREEN);
		progressBar.start();
		ngf.start();
		progressBar.join();
		ngf.join();
	}

	public void quit() throws InterruptedException {
		System.out.println("System Exiting...");
		progressBar = new ProgressBar(10, ConsoleColour.RED);
		progressBar.join();
		System.exit(0);
	}

	public static void main(String[] args) throws Exception {
		Runner run = new Runner();
		run.menu();
	}
}