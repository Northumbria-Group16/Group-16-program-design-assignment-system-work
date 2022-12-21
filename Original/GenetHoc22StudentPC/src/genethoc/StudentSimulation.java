/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package genethoc;

/**
 *
 * @author nickdalton
 */
public class StudentSimulation  extends GenHocDNADatabase
{ 
    /**
     * Over ride methods of GenHocDNADatabase to speed them up. 
     *  You could override the DNASequence as well like this. 
     */
    static  class StudentDNASqeuence extends DNASequence
    { 
        public StudentDNASqeuence(String dnaSequence, String sampleID) 
        {
            super(dnaSequence, sampleID);
        }
        
    }
    //=================== END OF CLASS ===========================
    public   DNASequence makeRandomDNASequence(int maxCrimeScens  )
    { 
    
    DNASequence it = new StudentDNASqeuence(
                  DNASequenceInterface.generateRandomDNA( this.dice ), ""+ 
                                            (++GenHocDNADatabase.idCode));
       it.addRandomCrimeLocations(it, this.dice,maxCrimeScens );
       return it ; 
        
    }
         
    /** 
     * for assessment purposes don't change 
     * @param seed 
     */
    public StudentSimulation(long seed) 
    {
        super(seed);
    }
    
    public static void main(String[] args) 
    {
       StudentSimulation db = new StudentSimulation( System.currentTimeMillis() ) ; 
       db.everythingWhichShouldBeImproved(); 
    }
    
    
   
    
}
