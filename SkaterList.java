/**
*author: Alexia Tran
*/
 /**
 *
 * SkaterList.java
 *
 * A class that models a set of skater objects.  A skater lsit  has an ArrayList of skaters.
 *          
 */

import java.util.ArrayList;
public class SkaterList
  {
    // declare an ArrayList
    private ArrayList<Skater> skaters;
    
    //constructor to construct/instantiate the ArrayList

   /**
	 * Constructs an empty skater list
	 */
    public SkaterList()
    {
      skaters = new ArrayList<Skater>();
    }

    //Copy all method headings from UML, make sure you have correct method heading, create empty body.  If method returns a value, return something just so it will compile until you are ready to write that method.  
    
    /**
    * save saves the data to the file
    * @return the String version of each varaible on their own line
    */
    public String save()
    {
    	  String output = "";
	    	for(Skater data: skaters) 
	    	{
	    		output += data.save();  
	    	}
	    	return output;
    }

    /**
	 * toString provides a String version of the name of a skater with a 
   * nationality, score, rank, technical score and artistry score.
	 * @return the String version of skaters
	 */
    public String toString()
    {
      String output = "";
    for(Skater e: skaters)
      output +=e + "\n";
    return output;
    }

    /**
    * addSkater adds a skater object into the Skater list
    * @param name the name of the skater
    * @param nationality the nationality of the skater
    * @param scores the scores of the skater
    * @param rank the rank of the skater
    * @param artLev the artistry level of the skater
    * @param techLev the technical level of the skater
    */
    public void addSkater(String name, String nationality, double score, int rank, int artLev, int techLev )
    {
      skaters.add(new Skater(name, nationality, score, rank, artLev, techLev));
    }

    /**
    * removeSkater removes a skater object into the Skater list
    * @param name the name of the skater
    * @param nationality the nationality of the skater
    * @param scores the scores of the skater
    * @param rank the rank of the skater
    * @param artLev the artistry level of the skater
    * @param techLev the technical level of the skater
    * @return boolean if skater was removed
    */
    public boolean removeSkater(String name)
    {    
      for (int i = 0; i < skaters.size(); i++)
        {
          if(skaters.get(i).getName().equals(name))
          {
              skaters.remove(i);
              return true;   
          }
        }
      return false;
    }

    /**
    * updateTechLev updates the technical level of the skater
    * @param name the name of the skater who is being updated
    * @param techLev the technical Level which will be changed to
    * @return boolean if techLev was changed
    */
    public boolean updateTechLev(String name, int techLev)
    {
      String list;
      for (int i= 0; i < skaters.size(); i++)
           {
             list = skaters.get(i).getName();
             if (list.equals(name))
             {
               skaters.get(i).changeTechLev(techLev);
               return true;
             }
           }
      return false;
    }
    
    /**
    * updateArtLev updates the artistry level of the skater
    * @param name the name of the skater who is being updated
    * @param artLev the artistry Level which will be changed to
    * @return boolean if techLev was changed
    */
    public boolean updateArtLev(String name, int artLev)
    {
      String list;
      for (int i= 0; i < skaters.size(); i++)
           {
             list = skaters.get(i).getName();
             if (list.equals(name))
             {
               skaters.get(i).changeArtLev(artLev);
               return true;
             }
           }
      return false;
    }
    
    /**
    * sortName sorts the names of the skaters in alphabetical order
    */
    public void sortName()
    {
      Skater temp;
      for(int p = 1;p < skaters.size() ; p++)
        for(int q = 0; q < skaters.size() - p; q++)
          {
            if(skaters.get(q).getName().compareTo(skaters.get(q+1).getName()) >1)
              {
                temp = skaters.get(q);
                skaters.set(q, skaters.get(q+1));
                skaters.set(q+1, temp);
              }
          }
    }

    /**
    * sortByNationality creates a new arraylist of skaters that are a specific nationality
    * @param nationality the nationality of the skaters
    * @return the new arraylist of skaters who are a specific nationality
    */
    public ArrayList<Skater> sortByNationality(String nationality)
    {
      ArrayList<Skater> byNationality = new ArrayList<Skater>();
      for(int i = 0; i < skaters.size(); i++)
          {
            if(skaters.get(i).getNationality().equals(nationality))
               byNationality.add(skaters.get(i));
          }
      return byNationality;
    }

    /**
    * sortByTechLev creates a new arraylist of skaters that have a specific technical level
    * @param techLev the technical level of the skaters
    * @return the new arraylist of skaters who have a specific techncial level
    */
    public ArrayList<Skater> sortByTechLev(int techLev)
    {
      ArrayList<Skater> byTechLev = new ArrayList<Skater>();
      for(int i = 0; i < skaters.size(); i++)
          {
             if(skaters.get(i).getTechLev() == techLev)
               byTechLev.add(skaters.get(i));
          }
      return byTechLev;
    }
    
    /**
    * sortByArtLev creates a new arraylist of skaters that have a specific artistry level
    * @param artLev the artistry level of the skaters
    * @return the new arraylist of skaters who have a specific artistry level
    */
    public ArrayList<Skater> sortByArtLev(int artLev)
    {
      ArrayList<Skater> byArtLev = new ArrayList<Skater>();
      for(int i = 0; i < skaters.size(); i++)
          {
             if(skaters.get(i).getArtLev() == artLev)
               byArtLev.add(skaters.get(i));
          }
      return byArtLev;
    }
    /**
    * findSkater finds a skater of a specific rank 
    * @param rank the rank  of the skater
    * @return the name of the skater with that rank
    */
    public String findSkater(int rank)
    {
      String skater = "";
      for(int i = 0; i < skaters.size(); i ++)  
        {
          if (skaters.get(i).getRank() == rank)
            skater += skaters.get(i).getName();
        }
      return skater;
    }

    /**
    * sortScore sorts the skaters by ascending scores 
    */
    public void sortScore()
    {
      Skater temp;
      for(int p = 1;p < skaters.size() ; p++)
        for(int q = 0; q < skaters.size() - p; q++)
          {
            if(skaters.get(q).getScore() > (skaters.get(q+1).getScore()) )
              {
                temp = skaters.get(q);
                skaters.set(q, skaters.get(q+1));
                skaters.set(q+1, temp);
              }
          }
    }

    /**
    * findDifference finds the difference between the highest
    * ranking skater and the lowest ranking skater
    * @return the difference between the two scores
    */
    public double findDifference()
    {
      double difference = 0.0;
      int minIndex = 0;
      int maxIndex = 0;
      int length;
      length = skaters.size();
      for (int startIndex = 0; startIndex < length-1; startIndex++) 
          {  
            if(skaters.get(startIndex).getRank() < skaters.get(minIndex).getRank())
              minIndex = startIndex;
            if(skaters.get(startIndex).getRank() > skaters.get(maxIndex).getRank())
              maxIndex = startIndex;  
          }
      difference = Math.round(-100 * (skaters.get(maxIndex).getScore() - skaters.get(minIndex).getScore()))/ 100.0;
      return difference;
    }

    /**
    * averageScore calculates the average scores 
    * @return the average scores of all skaters
    */
    public double averageScore()
    {
      double sum = 0;
      int count = 0;
      double average = 0.0;
      for(int i = 0; i < skaters.size(); i ++)
        {
          sum = sum + skaters.get(i).getScore();
          count++;
        }
      average = Math.round(100 * sum/count /100.0);
      return average;
    }

    /**
    * showAll returns all the data of every skater
    * @return all the data of every skater in the arraylist
    */
    public String showAll()
    {
      String all = "";
      for (int i = 0; i < skaters.size(); i++)
        {
          all += skaters.get(i);
        }
      return all;
    }
  }
