/**
*author: Alexia Tran
*/

/**
* A skater has a name, nationality, score, rank, technical level, and artistry.
*/

public class Skater
  {
      //INSTANCE FIELDS
      private String name;
      private String nationality;
      private double score;
      private int rank;
      private int techLev;
      private int artLev;
    
      //CONSTRUCTORS

    /*records the skater name, nationality, rank, scores, artistry level, and technical level
    *@param name the name of the skater
    *@param nationality the nationality of the skater
    *@param score the score of the skater
    *@param rank the rank of the skater
    *@param artLev the artistry level of the skater
    *@param techLev the technical level of the skater
  */
  
      public Skater(String name, String nationality, double score, int rank, int artLev, int techLev)
    {
      this.name = name;
      this.nationality = nationality;
      this.score = score;
      this.rank = rank;
      this.artLev = artLev;
      this.techLev = techLev;
    }

      //ACCESSORS (including equals, compareTo and toString)
    
    /**
    * getName gets the name of the skater
    * @return the name of the skater
    **/
    public String getName()
    {
      return name;
    }
    
    /**
    * getNationality gets the nationality of the skater
    * @return the nationality of the skater
    **/
    public String getNationality()
    {
      return nationality;
    }

    /**
    * getScore gets the score of the skater
    * @return the score of the skater
    **/
    public double getScore()
    {
      return score;
    }

    /**
    * getRank gets the rank of the skater
    * @return the rank of the skater
    **/
    public int getRank()
    {
      return rank;
    }

    /**
    * getArtLev gets the artistry level of the skater
    * @return the artistry level of the skater
    **/
    public int getArtLev()
    {
      return artLev;
    }

    /**
    * getTechLev gets the technical level of the skater
    * @return the technical level of the skater
    **/
    public int getTechLev()
    {
      return techLev;
    }
    
    /**
	 * nameEquals compares skaters based on their name
	 * @return true or false
   * @param Object o 
	 */
    public boolean nameEquals(Object o)
    {
      Skater other = (Skater) o;
      return this.name.equals(other.name);
    }
    
    /**
	 * nationalityEquals compares skaters based on their nationality
	 * @return true or false
   * @param Object o 
	 */
    public boolean nationalityEquals(Object o)
    {
      Skater other = (Skater) o;
      return this.nationality.equals(other.nationality);
    }

   /**
	 * toString provides a String version of the name of a skater with
   * a nationality, score, rank, technical score and artistry score.
	 * @return the String version of skaters
	 */
      public String toString()
      {
      return name + " " + nationality + " " + rank + " " + score + " " + artLev + " " + techLev;
      }

    /**
	 * compareTo compares skaters based on their name
	 * @return the numerical value to see if skaters have the same name
   * @param Object o
	 */
      public int compareTo(Object o)
      {
      	Skater other = (Skater) o;
        return this.name.compareTo(other.name);
      }

     //MUTATORS for each instance field even if not using
    
    /**
	  * changeScore chnages the score of skaters by a value
    * @param value the value of by which the score will be altered
    */
    public void changeScore(double value)
    {
      score = score + value;
    }
    /**
	  * changeRank changes the rank of skaters to a value
    * @param value the value of by which the rank will become
    */
    public void changeRank(int value)
    {
      rank = value;
    }

    /**
	  * changeArtLev changes the artistry level of skaters to a value
    * @param value the value of by which the artistry level will become
    */
    public void changeArtLev(int value)
    {
      artLev = value;
    }

    /**
	  * changeTechLev changes the technical level of skaters to a value
    * @param value the value of by which the technical level will become
    */
    public void changeTechLev(int value)
    {
      techLev = value;
    }

    /**
    * changeName changes the name of the skater 
    * @param newName the new name the skater will have
    */
    public void changeName(String newName)
    {
      name = newName; //check if works becuase it is a string
    }

    /**
    * changeNationality changes the nationality of the skater 
    * @param newNationality the new nationality the skater will have
    */
    public void changeNationality(String newNationality)
    {
      nationality = newNationality; //check if works becuase it is a string
    }

    /**
    * saveToFile saves the data to the file
    * @return the String version of each varaible on their own line
    */
    
    public String save()
    {
      return name + "\n" + nationality  + "\n" + score + "\n" + rank + "\n" + techLev + "\n" + artLev;
    }
    
}



    
  