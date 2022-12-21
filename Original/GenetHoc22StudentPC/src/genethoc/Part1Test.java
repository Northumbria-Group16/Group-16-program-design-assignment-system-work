/* 
   Students this is the section to change. 
*/
package genethoc;


import java.util.*;

/**
 *
 * @author nickdaltonbk
 */
public class Part1Test
{
    /* 
       Question 1; change this code so the code goes faster. 
    */

    public List<String> q1 =  new  LinkedList<String>() ;  // you can change this if you like but not name 
    
    public void Test1( String itemToAdd )
    { 
        q1.add( q1.size()/2 , itemToAdd ) ; 
    }
    /* 
        Question 2; change this code so the code goes faster.
    */
    public List<String> q2  =  new ArrayList<String>() ;   // you can change this if you like but not name 
    
    public void Test2( String itemToAdd )
    { 
        q2.add( 0 , itemToAdd ) ; // add to front 
    }
    /* 
          Q3 uses the variable q3 to building up a long Strong 
    */
    public Object  q3 = new String( ""); 
    public void  Question3( String addThis ) 
    { 
        q3 = q3 + addThis ; 
        
    }
    
    public Collection<String> q4 = new ArrayList<String>();   // you can change this if you like but not name 
    public void Test4Setup( String addThis)
    { 
        q4.add( addThis ); 
    }
    /**
     *  Q4 slightly more complicated this looks in the arrayList for 
     *  the value findThis. This may or mayNot exist. return true if exists.
     * @param findThis
     * @return true if is inside - false if not found. 
     */
    public boolean Test4FindThis( String findThis)
    { 
        for( String it: q4)
        { 
            if( it.equals( findThis ))return true ; 
        } 
        
        return false ; 
    }
    /*
      Q5 - add only unique elemnts to this collection of strings 
           order not important. 
    */
    
    public Collection<String> q5 = new ArrayList<String>();  // you can change this if you like but not name 
    public void Test5AddEveryOneOfTheseToQ5( Collection<String> that )
    { 
    
        for( String it: that )
        { 
          if( ! q5.contains( it))
            { 
                q5.add( it ); 
                break ; 
            }
        } 
    }
      

    Part1Test()
    { 
        
    }
    public static void main(String[] args)
    {
        System.err.println("---TEST STUDENT--");
        Part1Test student = new Part1Test(); 
        TestPart1.runAssessment( student );
        System.err.println("---END TEST STUDENT--");
    }
    
}
