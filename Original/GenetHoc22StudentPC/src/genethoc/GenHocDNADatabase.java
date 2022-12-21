/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package genethoc;

import java.time.LocalDateTime;
import java.util.*;


/**
 *
 * @author nickdalton
 */
public class GenHocDNADatabase implements GenHocDNAInterface
{
    /**
     * You can change this code if you like. 
     */
    List<DNASequenceInterface> database = new ArrayList<DNASequenceInterface>() ; 
    
    
    /* DONT CHANGE THIS CODE NSD */ 
    Random dice; // dont' change NSD 
    final static int kFragementPositiveTests = 500; // dont' change NSD 

    public static void main(String[] args) 
    {
       GenHocDNADatabase db = new GenHocDNADatabase( System.currentTimeMillis() ) ; 
       db.everythingWhichShouldBeImproved(); 
    }
    
    public GenHocDNADatabase(long seed ) 
    {
        database = new ArrayList<DNASequenceInterface>(); 
        dice  = new Random() ;         
    }
    
    @Override
    public void everythingWhichShouldBeImproved()
    { 
       System.out.println("self test ( should take about ~2 seconds ) " ) ; 
       selfTest() ;
       //speedTest() ; 
       System.out.println("testLookingForDNASequence" ) ; 
       testLookingForDNASequence(5000) ;
       System.out.println("testLookingForCrimeSceneCodes" ) ; 
       testLookingForCrimeSceneCodes(500) ; 
       System.out.println("testLookingForFragement" ) ;
       testLookingForFragement( kFragementPositiveTests ) ; 
        System.out.println("testRemoveDuplicateDNASequnces" ) ;
       testRemoveDuplicateDNASequnces(500); 
       System.out.println( "DONE");
    }
   /* public void speedTest() 
    { 
        Deque<DNASequence> premade = new ArrayDeque<DNASequence>();
        //ArrayList<DNASequence> premade = new ArrayList<DNASequence>( ); 
        for( int a = 0 ; a < 22000; a++ )
        { 
            premade.push( this.makeRandomDNASequence() ); 
        }
     
        
        int number = 10 ; 
        int dimension = 200 ;
        this.resetDatabase();
        for( int a = 0 ; a < 14 ; a++ )
        { 
           long start = System.nanoTime(); 
            for( int b = 0 ; b < dimension ; b++ )
            { 
                assert premade.peek() != null ; 
                this.addDNASequence( premade.pop() );
            }
            this.testRemoveDuplicateDNASequnces(number) ;
           long end = System.nanoTime();
           System.out.printf("%d\t%d\n",dimension, ( end-start) ); 
            
            number += 20; 
            dimension += 200 ; 
            
        }
    }*/
    /**
     * by Dr Andrew Chemist Chief technology officer GenetHoc Ltd.
     */
    @Override
    public void  addDNASequence( DNASequenceInterface it ) 
    { 
        assert it != null ; 
        database.add( it ); 
    }
    @Override
    public int size()
    { 
        return database.size();
    }
       
    /**
     * y Dr Andrew Chemist Chief technology officer GenetHoc Ltd.
     */
    @Override
    public  void selfTest() 
    { 
        readyForSelfTest(); 
        testDatabaseIntegrity() ; 
    }
    @Override
    public  void readyForSelfTest()
    { 
        prepareDataBase(); 
    }
    @Override
    public  void prepareDataBase()
    { 
      readyDataBase(); 
    }
   
     /**
     *   By Dr Andrew Chemist Chief technology officer GenetHoc Ltd. 
     */
    @Override
    public  void loadDNAFromDatabase() 
    { 
        loadSimulatedDNAFromDatabase(); 
    }
    /**
     *   By Dr Andrew Chemist Chief technology officer GenetHoc Ltd. 
     */
    static int idCode = 1000000; 
    
    @Override
    public  DNASequenceInterface makeRandomDNASequence()
    { 
       return  makeRandomDNASequence( 600 );  
    }
    @Override
    public  DNASequenceInterface makeRandomDNASequence( int maxCrimeScens)
    { 
       DNASequence it = new DNASequence( DNASequenceInterface.generateRandomDNA( dice ),
                                                                ""+ (++idCode));
       it.addRandomCrimeLocations(it, dice ,maxCrimeScens );
       return it ;  
    }
    /**
     *  Students - you can override this if you invent your own DNASequence
     * @return 
     */
    @Override
    public DNASequenceInterface makeDNASequence( String dna )
    { 
         DNASequenceInterface it = makeRandomDNASequence();
         it.setDnaSequence(dna);
         it.addRandomCrimeLocations(it, dice); 
         return it ;     
    }
    @Override
    public void resetDatabase()
    { 
          this.database = new  ArrayList<DNASequenceInterface>() ; 
    }
    /** 
     *    By Dr Andrew Chemist Chief technology officer GenetHoc Ltd. 
     *   this creates a fake database - note will always take 2 seconds. 
     *    
     */
    @Override
    public  void loadSimulatedDNAFromDatabase () 
    { 
        resetDatabase(); 
        LocalDateTime thenow = LocalDateTime.now(); 
        LocalDateTime oneSecond = thenow.plusSeconds(2); // dont change. 
        
        do
        { 
            for( int a = 0 ; a < 50 ; a++)
            { 
                addDNASequence( makeRandomDNASequence() );
            } 
            thenow = LocalDateTime.now(); 
        }while ( thenow.isBefore(oneSecond  )  ); 
    }
    /**
     *   By Dr Andrew Chemist Chief technology officer GenetHoc Ltd. 
     * checks database has not been corrupted. Kept disappearing. 
     */ 
    @Override
    public  boolean testLookingForDNASequence(int howMany)
    {  assert howMany > 0 ; 
      return   prepLookingForDNASequence(howMany); 
    }
    /**
     *   By Dr Andrew Chemist Chief technology officer GenetHoc Ltd. 
     */ 
    @Override
    public  boolean prepLookingForDNASequence(int howMany )
    {  assert howMany > 0 ; 
        return lookForNegativeDNASeq(howMany) &&  lookForPositiveDNASeq(howMany);  
    }
    /**
     *   By Dr Andrew Chemist Chief technology officer GenetHoc Ltd. 
     */
    @Override
    public   DNASequenceInterface pickRandomSeqence( Random rn ) 
    {   
        DNASequenceInterface existing =  database.get(  rn.nextInt( database.size()) ); 
        return existing; 
    }
     //--------------------------------------------------------------------------
    /**
     *   By Dr Andrew Chemist Chief technology officer GenetHoc Ltd. 
     */ 
    @Override
    public  boolean lookForPositiveDNASeq( int howMany )
    { 
        assert howMany > 0 ; 
        boolean result = true ; 
        // do not change 50000  Dr Andrew Chemist Chief technology officer GenetHoc Ltd.
        for( int a = 0 ; a < howMany ; a++)
        { 
            DNASequenceInterface existing =  pickRandomSeqence(dice); 
            String existString = existing.getDnaSequence(); 
      
            if( searchForDNA( existString  ) == false )
            { 
                System.out.println("You made a mistake - could not find DNA which existed  ");
                result= false ;
            } 
        } 
        return result ; 
    }
    //--------------------------------------------------------------------------
    /**
     *   By Dr Andrew Chemist Chief technology officer GenetHoc Ltd. 
     */ 
    @Override
    public  boolean lookForNegativeDNASeq(int howMany  )
    { 
      assert howMany > 0 ; 
      boolean result = true ; 
       // do not change 50000  Dr Andrew Chemist Chief technology officer GenetHoc Ltd.
      for( int a = 0 ; a < howMany ; a++)
        {
            if( searchForDNA( "Dr Andrew Chemist Chief technology officer GenetHoc"  ) == true  )
            { 
                    System.out.println("You made a mistake - could not find DNA which existed  ");
                    result= false ;
            } 
        } 
      return result ; 
    } 
    //--------------------------------------------------------------------------
    /**
     *   By Dr Andrew Chemist Chief technology officer GenetHoc Ltd. 
     *  @return true if the dna sequences is in the databaase of DNASeqences 
     */
    @Override
    public  boolean searchForDNA( String dna ) 
    { 
        for( DNASequenceInterface it:  database )
        { 
           if(it.sameDNASequence( dna ))return true ; 
        }
        return false ; 
    }
    //--------------------------------------------------------------------------     
    /**
     *   By Dr Andrew Chemist Chief technology officer GenetHoc Ltd. 
     * checks database has not been corrupted. Kept disappearing. 
     */ 
    @Override
    public  boolean testDatabaseIntegrity()
    { 
        LocalDateTime thenow2 = LocalDateTime.now(); 
        LocalDateTime oneSecond = thenow2.plusSeconds(1); 
        do 
        { 
            for( DNASequenceInterface it : database )
            { 
                if( it.isDNA() == false  )
                { 
                    return false; 
                }
            }
        thenow2 = LocalDateTime.now();
        }while ( thenow2.isBefore(oneSecond  )  ); 
        
        return true ; 
    }
     /**
     *   By Dr Andrew Chemist Chief technology officer GenetHoc Ltd. 
     */
     public void readyDataBase()
    { 
         contactDatabase(); 
    }
 
    
    /**
     *   By Dr Andrew Chemist Chief technology officer GenetHoc Ltd. 
     * take data from the database and look for a match of a fragment inside
     * the DNA list you have 
     * 
     * @param  fragment sequence which could be any where in the DNA
     * @return 
     */
    @Override
    public  boolean testLookingForFragement( int howMany)
    { 
       return testLookingForFragementPositive(  howMany) ;
    }
    @Override
    public  boolean testLookingForFragementPositive(int kFragementPositiveTests )
    { 
        Random rn = this.dice ; 
        boolean result = true ; 
       
        for( int a = 0 ; a < kFragementPositiveTests ; a++)
        { 
            DNASequenceInterface existing =  database.get(  rn.nextInt( database.size()) );
            
            String existString = existing.getDnaSequence(); 
            existString = existString.substring( rn.nextInt( existString.length()-5),
                    existString.length()); 
      
            List<DNASequenceInterface> foundlist = searchForDNAFragment( existString ) ; 
            
            if( foundlist.size() == 0  )
            { 
                System.out.println("You made a mistake - could not find DNA *FRAGMENT* which existed  ");
                result= false ;
            } 
        } 
        return result ; 
    }
    /**
     *   By Dr Andrew Chemist Chief technology officer GenetHoc Ltd. 
     *   Looks in the crime scene for the 
     *   @return  number of times a  crimeSceneCode in a DNA sequence 
     */
    @Override
    public  int howManySequencesForCrimeScene( String crimeSceneCode ) 
    { 
        assert crimeSceneCode != null ;
        int howMany = 0; 
        for(  DNASequenceInterface seq:  database )
        { 
           if(  seq.linkedToCrimeScene(crimeSceneCode)==true)howMany+= 1; 
        }
        
        return howMany ; 
    }
    
    /**
     *   By Dr Andrew Chemist Chief technology officer GenetHoc Ltd. 
     *  
     *   
     */
    @Override
    public  List<String> getSomeRandomCrimeScenes(int howMany) 
    { 
        assert howMany >0 ; 
        List<String> all = new ArrayList<String>() ; 
        
        for( int a = 0 ; a < howMany ; a++ )
        { 
            DNASequenceInterface existing = pickRandomSeqence(dice); 
            all.add( existing.getRandomCrimeScene(dice)); 
        } 
        
        return all ;
    }
    /**
     *   By Dr Andrew Chemist Chief technology officer GenetHoc Ltd. 
     */ 
    @Override
    public  boolean  testLookingForCrimeSceneCodes(int howMany ) 
    { 
        List<String> knownExistingCodes = getSomeRandomCrimeScenes(howMany) ;
        
        for( String code : knownExistingCodes )
        { 
          int count =   howManySequencesForCrimeScene( code ); 
          if( count <= 0 )
          { 
              System.out.println("CRIME SCENE CODE NOT FOUND"); 
              return false ; 
          }
        }
        return true ; 
    }
    
    /**
     *  contactDatabase in this case call the load DNAFromDatabase
     *   By Dr Andrew Chemist Chief technology officer GenetHoc Ltd. 
     */
    @Override
    public  void contactDatabase()
    { 
        loadDNAFromDatabase(); 
    }
    
    /**
     *   By Dr Andrew Chemist Chief technology officer GenetHoc Ltd. 
     * take data from the database and look for a match of a fragment inside
     * the DNA list you have 
     * 
     * @param  fragment sequence which could be any where in the DNA
     * @return 
     */
    @Override
    public List<DNASequenceInterface> searchForDNAFragment(String fragment)
    { 
        List<DNASequenceInterface> results = new ArrayList<>() ; 
        
        for( DNASequenceInterface it : database )
        { 
            if( it.containsFragement(  fragment ) )
            { 
                results.add( it); 
            }
        }
        return results ;  
    }
     /**
     *   By Dr Andrew Chemist Chief technology officer GenetHoc Ltd. 
     * take data from the database and sees if the whole sequence matches a 
     * whole sequence. 
     * 
     * @param  wholeDNA sequence which could be any where in the DNA
     * @return 
     */
    @Override
    public  boolean containsWholeDNASequence( String wholeDNA )
    { 
        for( DNASequenceInterface it : database )
        { 
            if( it.sameDNASequence( wholeDNA ) )
            { 
                return true ; 
            }
        }
        return false ; 
    }
     /**
     *   By Dr Andrew Chemist Chief technology officer GenetHoc Ltd. 
     */ 
    @Override
    public int removeDuplicateDNASequnces() 
    { 
        List<DNASequenceInterface> duplicates = new ArrayList<DNASequenceInterface>() ; 
        for( int a = 0 ; a <   database.size();a++)
        { 
           DNASequenceInterface thisOne = database.get(a); 
           for(int b = a+1 ; b <  database.size(); b++   )
           { 
               DNASequenceInterface otherOne = database.get(b); 
               assert  thisOne != otherOne ; // skip self 
               if( thisOne.sameDNASequence(otherOne.getDnaSequence()))
               { 
                  duplicates.add( otherOne ); 
                  thisOne.addCrimeScenseFrom(otherOne);
               }
           } 
        }
        
        for( DNASequenceInterface dup : duplicates ) 
        { 
           database.remove( dup ); 
        }
        return duplicates.size(); 
    }
    /**
     *   By Dr Andrew Chemist Chief technology officer GenetHoc Ltd.
     *  artificially create duplicates by copying others 
     */ 
    @Override
    public void testRemoveDuplicateDNASequnces(final int DUPLICATES  ) 
    { 
        
        int before = database.size(); 
        assert DUPLICATES < database.size();
        List<DNASequenceInterface> duplicates = new ArrayList<>() ; 
        
        for( int a = 0 ; a < DUPLICATES ; a++ )
        { 
            DNASequenceInterface dup; 
            do
            { 
                DNASequenceInterface existing = pickRandomSeqence(dice); 
                dup =  makeDNASequence( existing.getDnaSequence());
            } while(duplicates.contains(dup)==true  ); 
            duplicates.add( dup ); 
        } 
        for(  DNASequenceInterface dup: duplicates)
        { 
           addDNASequence( dup ); 
        }
        
        assert database.size() == before + DUPLICATES :"Error making duplicates" ; 
        
        int removed =  removeDuplicateDNASequnces(); 
      
        assert removed == DUPLICATES : "Number of duplicates found wrong Removed=" +
                removed + " before " + before + " " +  DUPLICATES + " " + 
                database.size()  ; 
        assert database.size()== before ;
  
    }
   
}
