/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package genethoc;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author nickdalton
 */
public class StudentSimulationTest 
{
    
    public StudentSimulationTest() {
    }
    
    @Before
    public void setUp() {
       
    }
    
    @After
    public void tearDown() {
    }

     //-------------------------------------------------------------------------
    protected long testDNALookups( GenHocDNAInterface testSim )
    { 
        assert testSim != null ; 
        long timesRoundloop = 0 ; 
        
        LocalDateTime thenow = LocalDateTime.now(); 
        LocalDateTime oneSecond = thenow.plusSeconds(1); 
        
        do
        { 
            for( int a = 0 ; a < 5 ; a++)
            { 
                timesRoundloop += 1 ; 
                testSim.testLookingForDNASequence(1) ;
            } 
            thenow = LocalDateTime.now(); 
        }while ( thenow.isBefore(oneSecond  )  ); 
        
        return timesRoundloop ; 
    }
    //-------------------------------------------------------------------------
    protected long testCrimeScneCodes( GenHocDNAInterface testSim )
    { 
        assert testSim != null ; 
        long timesRoundloop = 0 ; 
        
        LocalDateTime thenow = LocalDateTime.now(); 
        LocalDateTime oneSecond = thenow.plusSeconds(1); 
        
        do
        { 
            for( int a = 0 ; a < 5 ; a++)
            { 
                timesRoundloop += 1 ; 
                testSim.testLookingForCrimeSceneCodes(1) ;
            } 
            thenow = LocalDateTime.now(); 
        }while ( thenow.isBefore(oneSecond  )  ); 
       
        return timesRoundloop ; 
    }
    //-------------------------------------------------------------------------
    protected long LookingForFragement( GenHocDNAInterface testSim )
    { 
        assert testSim != null ; 
        long timesRoundloop = 0 ; 
        
        LocalDateTime thenow = LocalDateTime.now(); 
        LocalDateTime oneSecond = thenow.plusSeconds(1); 
        
        do
        { 
            for( int a = 0 ; a < 5 ; a++)
            { 
                timesRoundloop += 1 ; 
                testSim.testLookingForFragement(1) ;
            } 
            thenow = LocalDateTime.now(); 
        }while ( thenow.isBefore(oneSecond  )  ); 
       
        return timesRoundloop ; 
    }
    //-------------------------------------------------------------------------
    protected long testForDuplicates( GenHocDNAInterface testSim )
    { 
        assert testSim != null ; 
        long itemsPrcessed = 0 ; 
        
        Deque<DNASequenceInterface> premade = new ArrayDeque<DNASequenceInterface>();
        //ArrayList<DNASequence> premade = new ArrayList<DNASequence>( ); 
        final int MAX_PREMADE = 120000;
        for( int a = 0 ; a < MAX_PREMADE; a++ )
        { 
            premade.push( testSim.makeRandomDNASequence(2) ); 
        }
        
        int number = 10 ; 
        int dimension = 200 ;
        
        LocalDateTime thenow = LocalDateTime.now(); 
        LocalDateTime oneSecond = thenow.plusSeconds(7); 
        
        testSim.resetDatabase();
        do  // this is the slow part.
        { 
            for( int a = 0 ; a < dimension ; a++ )
            { 
                assert premade.peek() != null :"**Make constant MAX_PREMADE bigger**" ; 
                testSim.addDNASequence( premade.pop() ); 
            }
  
            testSim.testRemoveDuplicateDNASequnces(number) ;
            number += 20; 
            dimension += 200 ; 
            itemsPrcessed += dimension  ;
            thenow = LocalDateTime.now();
        }while ( thenow.isBefore(oneSecond  )  ); 
        
        return itemsPrcessed  * 1000 ; 
    }
    //------------------------------------------------------------------------
    @Test
    public void testDNASequence() 
    {
        System.out.println("testDNASequence");
        
        GenHocDNAInterface testSim = makeSimulationUnderTest(); 
        
        String dna = "TTTTAAAAGGGGCCCC";
        DNASequenceInterface ds = testSim.makeDNASequence(dna); 
        assert ds.getDnaSequence()!=null ; 
        assertEquals("failure - strings are not equal",dna, ds.getDnaSequence());  
    }
    //------------------------------------------------------------------------
    @Test
    public void makeRandomDNASequence() 
    {
        System.out.println("makeRandomDNASequence");
        System.err.println("TEST: makeRandomDNASequence");
        
       GenHocDNAInterface testSim = makeSimulationUnderTest(); 
        DNASequenceInterface  it = testSim.makeRandomDNASequence(10 ); 
        assertNotNull( it);  
        assert  it.getAllCrimeScenes().size() > 0 ; 
        assert it.getAllCrimeScenes().size() <= 10 ; 
    }
     //------------------------------------------------------------------------
    @Test
    public void addCrimeScene() 
    {
        System.out.println("addCrimeScene");
        
        GenHocDNAInterface testSim = makeSimulationUnderTest(); 
        DNASequenceInterface  it = testSim.makeRandomDNASequence(10 ); 
        assertNotNull( it);  
        String cs = "CRIMESEENTEST"; 
        assertFalse( it.linkedToCrimeScene(cs)); 
        it.addCrimeScene(cs); 
        assertTrue( it.linkedToCrimeScene(cs)); 
        assertFalse( it.linkedToCrimeScene("NOT_IN_CRIME_SCNE")); 
    }
    //-------------------------------------------------------------------------
    @Test
    public void testContainsFragment() 
    {
        System.out.println("testContainsFragment");
        
        GenHocDNAInterface testSim = makeSimulationUnderTest(); 
        
        String dna = "TTTTAAAAGGGGCCCC";
        String fragement = "GGGCCCC" ; 
        
        DNASequenceInterface ds = testSim.makeDNASequence(dna); 
        assert ds.getDnaSequence()!=null ; 
        assertEquals("failure - strings are not equal",dna, ds.getDnaSequence());
        assertTrue( ds.containsFragement(fragement ) ); 
        assertFalse( ds.containsFragement("NOT_APPEARING" ) ); 
    }
     //-------------------------------------------------------------------------
    /**
     * Test of main method, of class StudentSimulation.
     */
    @Test
    public void testMain() 
    {
        System.out.println("Marking");
     
        System.out.println("******   BASELINE  *********");
        GenHocDNAInterface  baseSim = new GetnHocDNADatabaseBASE( 0xFACE) ; 
        
        baseSim.readyForSelfTest();
        long testLooking = testDNALookups( baseSim); 
        System.out.println("LOOP TIMES = " + testLooking);
        long testCrimeScenes = testCrimeScneCodes( baseSim ); 
        System.out.println("Crime scene search = " + testCrimeScenes );
        long fragmentSearch = LookingForFragement( baseSim); 
        System.out.println("fragmentSearch search = " + fragmentSearch );
        
        // Make the size of the system smaller then expand faster. 
        long duplicates = testForDuplicates( baseSim); 
        System.out.println("testForDuplicates  = " + duplicates );
        
        System.out.println("(((((((   STUDENT  ))))))))");
          
        GenHocDNAInterface  testSim ; 
        testSim = makeSimulationUnderTest();  
     
        
        testSim.readyForSelfTest();
        long testLookingSTUDENT = testDNALookups( testSim); 
        System.out.println("LOOP TIMES STUDENT = " + testLookingSTUDENT);
        long testCrimeScenesSTUDENT = testCrimeScneCodes( testSim ); 
        System.out.println("Crime scene search STUDENT = " + testCrimeScenesSTUDENT );
        long fragmentSearchSTUDENT = LookingForFragement( testSim); 
        System.out.println("fragmentSearch search STUDENT = " + fragmentSearchSTUDENT );
        long duplicatesSTUDENT = testForDuplicates( testSim); 
        System.out.println("testForDuplicates STUDENT = " + duplicatesSTUDENT );
        
        System.out.println("------   Score  ------");
        double duplicateWarp = (duplicatesSTUDENT/(double)duplicates);
        if( duplicateWarp < 1.0 )duplicateWarp = 1; 
        
        System.out.printf("The Warp factor is how many times FASTER you are than the original base case %n"); 
        
        System.out.printf("DNALOOKUPS WARP  = %.0f ( ~ 270 good) %n",  (testLookingSTUDENT/(double)testLooking));
        System.out.printf("Crime scenes WARP = %.0f ( ~ 96 good) %n" , (testCrimeScenesSTUDENT/(double)testCrimeScenes));
        System.out.printf("fragment Search WARP =  %.0f (~ 1 OK)  %n" , (fragmentSearchSTUDENT/(double)fragmentSearch));
        System.out.printf("Duplicates  WARP =  %.1f (~ 3.4 good) %n" , duplicateWarp);
        
        
        if( duplicateWarp >- 2 )
        { 
            System.out.println("Well done on Duplicate warp factor"); 
        }
        
       // StudentSimulation.main(args);
        // TODO review the generated test code and remove the default call to fail.
    }
    protected GenHocDNAInterface makeSimulationUnderTest()
    { 
         return new StudentSimulation( 0xFACE) ; //   
         //return new MasterSolution( 0xFACE) ; //  MasterSolution( 0xFACE) ; 
    }
   
    @Test 
    public void testIntegrity() 
    { 
        
         GenHocDNAInterface  testSim  = makeSimulationUnderTest(); 
          
         boolean shouldBeFalse =  testSim.searchForDNA("Does not exist"); 
        
         org.junit.Assert.assertFalse(shouldBeFalse);
        // plant a sequence and find it. 
         DNASequenceInterface exists = testSim.makeRandomDNASequence(); 
         testSim.addDNASequence(exists);
        
        
     
         boolean shouldBeTrue = testSim.searchForDNA(exists.getDnaSequence());
         org.junit.Assert.assertTrue (shouldBeTrue);
    }
    
}
