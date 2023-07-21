/**
* @(#)FigureSkating.java
*
*
* @Alexia Tran
* APCSA 2nd period
* 2022/05/19
*/

import java.io.*;
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.JFileChooser;
import java.util.ArrayList;
import javax.swing.*;
import java.lang.System;

public class Main 
{
  /**
  *creates sList with SkaterList data so the arrayList info can be used
  */
  private static SkaterList sList = new SkaterList();

  /**
  *@param args The command-line arguments
  */
  public static void main(String[] args) 
  {
    JOptionPane optionPane = new JOptionPane();

       boolean done = false;
       while(!done)
       {
       	String menu = "1 - load file" + "\n" + "2 - edit skaters " + "\n" + "3 - create a report  " + "\n" + "4 - save all data to file";
       String inputValue = JOptionPane.showInputDialog(menu);
       int n = Integer.parseInt(inputValue);
       switch(n)
       {
          case 1 : loadFile();break;
          case 2 : editSkater();break;
          case 3 : reportMenu();break;
          case 4 : saveToFiles();break;
          default : done = true;break;
       }
       }
  }

  /**
  * Allows the edit menu to pop up after the main menu
  * Edit menu changes the data in skater list
  * add skater, delete skater, update technical level, update artistry level
  */
  public static void editSkater()
  {
    boolean done = true;
    while(done)
      {
        String menu = "1 - add skater" + "\n" + "2 - delete skater "  + "\n3 - update technical level" + "\n4 - update artistry level" + "\n5 - return to main menu";

        String inputValue = JOptionPane.showInputDialog(menu);
        int n = Integer.parseInt(inputValue);
        switch(n)
          {
            case 1 : addSkater();break;
            case 2 : removeSkater();break;
            case 3 : updateTechLev();break;
            case 4 : updateArtLev();break;
            case 5 : done = false; break;
            default : done = false; break;
          }
      }
  }
  
  /**
  * Allows the report menu to pop up after the main menu
  * Report menu shows data in the skater list
  * show all, find skater, find difference in score, show skaters of a specific
  * naitonality, show skaters
  * of a specific artistry level, show skaters of a specific technical level, show
  * skaters in ascending  
  * order, find average scores, show skaters in alphabetical order, and return to main menu
  */
  public static void reportMenu()
  {
    boolean done = true;
    while(done)
      {
        String menu = "1 - show all skaters" + "\n" + "2 - find skater by rank " + "\n" + "3 - find difference of score between highest and lowest ranking skaters " + "\n4 - show only skaters of a specific nationality" + "\n5 - show only skaters of a specific artistry level" + "\n6 - show only skaters of a specific technical level" + "\n7 - Show list of scores in ascending order " + "\n8 " + " - Find the average of all scores" + "\n9" + " - Show skaters in alphabetical order" + "\n10" + " - Return to Main Menu" ;

        String inputValue = JOptionPane.showInputDialog(menu);
        int n = Integer.parseInt(inputValue);
        switch(n)
          {
            case 1 : JOptionPane.showMessageDialog(null,sList.toString());break;
            case 2 : findSkaterByRank();break;
            case 3 : sList.findDifference();     JOptionPane.showMessageDialog(null,sList.findDifference());
              break;
            case 4 : sortNationality();break;
            case 5 : sortByArt();break;
            case 6 : sortByTech();break;
            case 7 : sortScore();break;
            case 8 : averageScore();break;
            case 9 : sortName();break;
            case 10 : done = false;break;
            default : done = false;break;
          }
      }
  }

  /**
  * Loads a file by used the load method for skaters
  */
  public static void loadFile()
  {
      boolean done = true;
      while(done)
      {
        String menu = "1 + Load Skater Data" + "\n" + "2 - Back to Main Menu ";
            String inputVal = JOptionPane.showInputDialog(menu);
            int n = Integer.parseInt(inputVal);
            switch (n)
            {
              case 1 : loadSkater();done = false;break;
              case 2 : done = false;break;
            } 
          }
  }

    /**
    *Selects a file from computer folders and see if it holds the necessary information
    * If the file gives name, naitonality, scores, rank, artistry level, technical
    * level, each on a sperate
    * line and in that order, the file is loaded.
    */
    public static void loadSkater()
    {
    try
    {
        JOptionPane.showMessageDialog(null, "Pick file for skaters", "loadFiles", JOptionPane.INFORMATION_MESSAGE);
        JFileChooser chooser = new JFileChooser();
    		chooser.requestFocus();
    		File infile = null;
    		if (chooser.showOpenDialog(null) ==     JFileChooser.APPROVE_OPTION)
	   	      {
	   	  	      infile = chooser.getSelectedFile();	
	       	  }
        Scanner in = new Scanner(infile);
        while(in.hasNext())
          {
              String name = in.nextLine();
              String nationality = in.nextLine();
              double score = in.nextDouble();
              in.nextLine();
              int rank = in.nextInt();
              in.nextLine();
              int artLev = in.nextInt();
              in.nextLine();
              int techLev = in.nextInt();
              in.nextLine();
              sList.addSkater(name, nationality, score, rank, artLev, techLev);
              //JOptionPane.showMessageDialog(null, "Data has been loaded");
          }
          in.close();
      }
      catch(Exception x)
      {
      JOptionPane.showMessageDialog(null, "Information could not load " + x);    
      }
}    
  /**
  * saves a file by using the save method for skaters
  */
  public static void saveToFiles()
  {
    boolean done = true;
    while(done)
  {
      String menu = "1 - Save Skater Data" + "\n" + "2 - Back to Main Menu ";
      String inputVal = JOptionPane.showInputDialog(menu);
      int n = Integer.parseInt(inputVal);
      switch (n)
        {
          case 1 : saveSkater(sList);break;
          case 2 : done = false;break;
        } 
  }
  }
  /**
  * Saves the skater list data to a file on the computer if all portions
  * of the requirement are satisfied by the saveToFile method in skater
  * Must have name, nationality, scores, rank, artistry level, technical
  * level, each on a seperate line and in that order
  */
  public static void saveSkater(SkaterList s)
   {
      String fileName = JOptionPane.showInputDialog("Enter the file name to save skaters to");
      try
      {
          PrintWriter output = new PrintWriter (fileName);
          output.println(s.save());            JOptionPane.showMessageDialog(null, "Data has been saved");
          output.close();
       }
      catch(IOException x)
      {
        JOptionPane.showMessageDialog(null, "Information could not be saved " +x);
      }
   }
  
  /**
  * addSkater creates a new skater in sList when the user inputs a name,
  * nationality, score, artistry level, technical level
  */
  public static void addSkater()
  {  
      JTextField field1 = new JTextField();
      JTextField field2 = new JTextField();		  
      JTextField field3 = new JTextField();
		  JTextField field4 = new JTextField();
	    JTextField field5 = new JTextField();
	    JTextField field6 = new JTextField();
      Object[] message = 
      {
        "Name:", field1,
        "Nationality:", field2,
        "Score:", field3,
        "Rank:", field4,
        "Artistry Level", field5,
        "Tecnical Level:", field6,
      };
      int option = JOptionPane.showConfirmDialog(null, message, "Add Skater", JOptionPane.OK_CANCEL_OPTION);
	    if (option == JOptionPane.OK_OPTION)
	        {   
              String value1 = field1.getText();
              String value2 = field2.getText();
              double v3 = Double.parseDouble(field3.getText());
              int v4 = Integer.parseInt(field4.getText());
              int v5 = Integer.parseInt(field5.getText());
              int v6 = Integer.parseInt(field6.getText());
              sList.addSkater(value1, value2, v3, v4, v5, v6);
          }
      else
              System.out.println("no data");
    }

  /**
  * removeSkater removes a skater from sList when the user inputs 
  * the name of the skater
  * skaters cannot have the same name so no error would be found
  */
  public static void removeSkater()
  {
      JTextField field1 = new JTextField();
      Object[] message = 
        {
          "Name of Skater", field1,
        };
      int option = JOptionPane.showConfirmDialog(null,message, "Delete skater", JOptionPane.OK_CANCEL_OPTION);
      if (option == JOptionPane.OK_OPTION);
          {
              String v1 = field1.getText();
              if (sList.removeSkater(v1))
                  JOptionPane.showMessageDialog(null, v1 + " was found and removed from the list");
              else
                  JOptionPane.showMessageDialog(null, v1 + " was not found and nothing was removed.");    
          }
  }
  
  /**
  * findSkaterByRank finds a skater when given a rank
  */
  public static void findSkaterByRank()
  {
      JTextField field1 = new JTextField();	
      Object[] message = 
      {
        "Rank:", field1,
      };
      int option = JOptionPane.showConfirmDialog(null, message, "Enter rank to find skater", JOptionPane.OK_CANCEL_OPTION);
      if(option == JOptionPane.OK_OPTION);
         {
            int v1 = Integer.parseInt(field1.getText());
            if(sList.findSkater(v1) == "")
              JOptionPane.showMessageDialog(null, v1 + " is an invalid rank and nothing was found.");
            else
                JOptionPane.showMessageDialog(null, v1 + " was found and is " + sList.findSkater(v1));;    
         }
  }

  /**
  * updateTechLev changes the technical level of a skater
  * new value is entered by user
  */
  public static void updateTechLev()
  {
      JTextField field1 = new JTextField();
      JTextField field2 = new JTextField();	
      Object[] message = 
      {
        "Name:", field1,
        "Technical Level :", field2,
      };
      int option = JOptionPane.showConfirmDialog(null, message, "Enter technical Level to update", JOptionPane.OK_CANCEL_OPTION);
      if(option == JOptionPane.OK_OPTION);
         {
            String value1 = field1.getText();
            String value2 = field2.getText();
            int v2 = Integer.parseInt(field2.getText());
            if(sList.updateTechLev(value1, v2))
              JOptionPane.showMessageDialog(null, value1 + " was updated.");
            else
                  JOptionPane.showMessageDialog(null, value1 + " was not found and nothing was updated.");    
         }
  }

  /**
  * updateArtLev changes the artistic level of a skater
  * new value is entered by user
  */
  public static void updateArtLev()
  {
      JTextField field1 = new JTextField();
      JTextField field2 = new JTextField();	
      Object[] message = 
      {
        "Name:", field1,
        "Artistry Level :", field2,
      };
      int option = JOptionPane.showConfirmDialog(null, message, "Enter artistry level to update", JOptionPane.OK_CANCEL_OPTION);
      if(option == JOptionPane.OK_OPTION);
         {
            String value1 = field1.getText();
            String value2 = field2.getText();
            int v2 = Integer.parseInt(field2.getText());
            if(sList.updateArtLev(value1, v2))
              JOptionPane.showMessageDialog(null, value1 + " was updated.");
            else
                  JOptionPane.showMessageDialog(null, value1 + " was not found and nothing was updated.");    
         }
    }
  /**
  * sortByTech sorts to only show skaters who have a specific technical level
  * if no skater has that score, a message is displayed
  * technical level input is from user
  */
  public static void sortByTech()
  {
      JTextField field1 = new JTextField();
      Object[] message = 
        {
          "Technical Level: ", field1,
        };
      int option = JOptionPane.showConfirmDialog(null,message, "Enter technical level to sort", JOptionPane.OK_CANCEL_OPTION);
      if(option == JOptionPane.OK_OPTION);
         {
            int v1 = Integer.parseInt(field1.getText());
            ArrayList<Skater> temp = sList.sortByTechLev(v1);
            String n = "";
            for(Skater s : temp)
              {
                n += s.toString() + "\n";
              }
            if (!n.equals(""))
               JOptionPane.showMessageDialog(null,n);
            else
               JOptionPane.showMessageDialog(null, "No skater has this technical level");     
         }
  }
  
  /**
  * sortByArt sorts to only show skaters who have a specific
  * artistry level
  * if no skater has that score, a message is displayed
  * artistry level input is from user
  */
  public static void sortByArt()
  {
      JTextField field1 = new JTextField();
      Object[] message = 
        {
          "Artistry Level: ", field1,
        };
      int option = JOptionPane.showConfirmDialog(null,message, "Enter artistry level to sort", JOptionPane.OK_CANCEL_OPTION);
         if(option == JOptionPane.OK_OPTION);
         {
            int v1 = Integer.parseInt(field1.getText());
            ArrayList<Skater> temp = sList.sortByArtLev(v1);
            String n = "";
            for(Skater s : temp)
              {
                n += s.toString() + "\n";
              }
            if (!n.equals(""))
               JOptionPane.showMessageDialog(null,n);
            else
               JOptionPane.showMessageDialog(null, "No skater has this artistry level");     
         }
  }
  
  /**
  * sortByNationality sorts to only show skaters who are a        
  * specific nationality
  * if no skater is that nationality, a message is displayed
  * nationality input is from user
  */
    public static void sortNationality()
    {
      JTextField field1 = new JTextField();
      Object[] message = 
        {
          "Nationality: ", field1,
        };
      int option = JOptionPane.showConfirmDialog(null,message, "Enter Nationality", JOptionPane.OK_CANCEL_OPTION);
      if(option == JOptionPane.OK_OPTION);
         {
            String value1 = field1.getText();
            ArrayList<Skater> temp = sList.sortByNationality(value1);
            String n = "";
            for(Skater s : temp)
              {
                n += s.toString() + "\n";
              }
            if (!n.equals(""))
               JOptionPane.showMessageDialog(null,n);
            else
               JOptionPane.showMessageDialog(null, "that nationality doesn't exist in the data");
            
         }
    }

  /**
  * sortScore sorts the skaters in ascending score order
  */
  public static void sortScore()
  {
    sList.sortScore();
    JOptionPane.showMessageDialog(null,sList.toString()); 
  }

  /**
  * averageScore calculates the average score of all skaters
  */
  public static void averageScore()
  {        
    JOptionPane.showMessageDialog(null,sList.averageScore());
  }

  /**
  * sortName sorts the skaters in alphabetical order
  */
  public static void sortName()
  {
    sList.sortName();
    JOptionPane.showMessageDialog(null,sList.toString());
  }
}