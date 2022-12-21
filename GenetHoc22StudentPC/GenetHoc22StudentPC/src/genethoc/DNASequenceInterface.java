/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package genethoc;

import java.util.Collection;
import java.util.Random;

/**
 *
 * @author nickdaltonbk
 */
public interface DNASequenceInterface
{

    /**
     *   By Dr Andrew Chemist Chief technology officer GenetHoc Ltd.
     */
    void addCrimeScene(String whereID);

    /**
     *  By Dr Andrew Chemist Chief technology officer GenetHoc Ltd.
     * @param whereID
     * @return
     */
    void addCrimeScenseFrom(DNASequenceInterface other);

    DNASequenceInterface addRandomCrimeLocations( DNASequenceInterface it , Random rn ); 
    DNASequenceInterface addRandomCrimeLocations( DNASequenceInterface it , Random rn, int maxLocatins ); 
    /**
     *   By Dr Andrew Chemist Chief technology officer GenetHoc Ltd.
     */
    boolean equals(Object obj);

    /**
     *   By Dr Andrew Chemist Chief technology officer GenetHoc Ltd.
     */
    Collection<String> getAllCrimeScenes(); 
    /**
     *   By Dr Andrew Chemist Chief technology officer GenetHoc Ltd.
     */
    String getCriminalIDConfirmedAs();

    /**
     *   By Dr Andrew Chemist Chief technology officer GenetHoc Ltd.
     */
    String getDnaSequence();

    /**
     *   By Dr Andrew Chemist Chief technology officer GenetHoc Ltd.
     *  return any crime scene in the list used for testing.
     */
    String getRandomCrimeScene(Random dice);

    /**
     *   By Dr Andrew Chemist Chief technology officer GenetHoc Ltd.
     */
    String getSampleID();

    /**
     *   By Dr Andrew Chemist Chief technology officer GenetHoc Ltd.
     */
    int hashCode();

    boolean isDNA();

    /**
     *  By Dr Andrew Chemist Chief technology officer GenetHoc Ltd.
     * @param whereID
     * @return
     */
    boolean linkedToCrimeScene(String whereID);

    boolean sameDNASequence(String it);

    /**
     *   By Dr Andrew Chemist Chief technology officer GenetHoc Ltd.
     */
    void setCriminalIDConfirmedAs(String criminalIDConfirmedAs);

    /**
     *   By Dr Andrew Chemist Chief technology officer GenetHoc Ltd.
     */
    void setDnaSequence(String dnaSequence);

    /**
     *   By Dr Andrew Chemist Chief technology officer GenetHoc Ltd.
     */
    void setSampleID(String sampleID);
     /**
     *   By Dr Andrew Chemist Chief technology officer GenetHoc Ltd.
     */
    boolean containsFragement( String dnaFragment ); 

    /**
     *   By Dr Andrew Chemist Chief technology officer GenetHoc Ltd.
     */
    String toString();
    
    
    
    
     /**
     *   By Dr Andrew Chemist Chief technology officer GenetHoc Ltd. 
     */
    static  public  String generateRandomDNA( Random rn)
    { 
        StringBuffer bx = new StringBuffer() ; 
        assert rn != null ; 
       
        char letter[] = { 'A', 'C', 'G' , 'T' } ; 
        
        for( int a = 0 ; a < 10_000 ; a++ )
        { 
           bx.append( letter[ rn.nextInt(letter.length)] ); 
        }
        return bx.toString(); 
    }
    /* 
            internal checking only not production code. 
    */
    public static String randomString( int howLong , Random rn) 
    { 
        assert howLong > 0 :"No negatives"; 
        String a = ""; 
        for( int b = 0 ; b < howLong ; b++  )
        { 
            a += (char)(rn.nextInt('Z'-'A'))+ 'A'; 
        }
        return a; 
    }
   
    
    
}
