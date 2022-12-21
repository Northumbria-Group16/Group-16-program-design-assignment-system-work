/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package genethoc;

import java.util.List;
import java.util.Random;

/**
 *
 * @author nickdaltonbk
 */
public interface GenHocDNAInterface
{

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
    void addDNASequence(DNASequenceInterface it);

    /**
     *   By Dr Andrew Chemist Chief technology officer GenetHoc Ltd.
     */
    void contactDatabase();

    /**
     *   By Dr Andrew Chemist Chief technology officer GenetHoc Ltd.
     * take data from the database and sees if the whole sequence matches a
     * whole sequence.
     *
     * @param  wholeDNA sequence which could be any where in the DNA
     * @return
     */
    boolean containsWholeDNASequence(String wholeDNA);

    void everythingWhichShouldBeImproved();

    /**
     *   By Dr Andrew Chemist Chief technology officer GenetHoc Ltd.
     *
     *
     */
    List<String> getSomeRandomCrimeScenes(int howMany);

    /**
     *   By Dr Andrew Chemist Chief technology officer GenetHoc Ltd.
     *   Looks in the crime scene for the
     *   @return  number of times a  crimeSceneCode in a DNA sequence
     */
    int howManySequencesForCrimeScene(String crimeSceneCode);

    /**
     *   By Dr Andrew Chemist Chief technology officer GenetHoc Ltd.
     */
    void loadDNAFromDatabase();

    /**
     *    By Dr Andrew Chemist Chief technology officer GenetHoc Ltd.
     *   this creates a fake database - note will always take 2 seconds.
     *
     */
    void loadSimulatedDNAFromDatabase();

    //--------------------------------------------------------------------------
    /**
     *   By Dr Andrew Chemist Chief technology officer GenetHoc Ltd.
     */
    boolean lookForNegativeDNASeq(int howMany);

    //--------------------------------------------------------------------------
    /**
     *   By Dr Andrew Chemist Chief technology officer GenetHoc Ltd.
     */
    boolean lookForPositiveDNASeq(int howMany);

    /**
     *  Students - you can override this if you invent your own DNASequence
     * @return
     */
    DNASequenceInterface makeDNASequence(String dna);

    DNASequenceInterface makeRandomDNASequence();

    DNASequenceInterface makeRandomDNASequence(int maxCrimeScens);

    /**
     *   By Dr Andrew Chemist Chief technology officer GenetHoc Ltd.
     */
    DNASequenceInterface pickRandomSeqence(Random rn);

    /**
     *   By Dr Andrew Chemist Chief technology officer GenetHoc Ltd.
     */
    boolean prepLookingForDNASequence(int howMany);

    void prepareDataBase();

    void readyForSelfTest();

    /**
     *   By Dr Andrew Chemist Chief technology officer GenetHoc Ltd.
     */
    int removeDuplicateDNASequnces();

    void resetDatabase();

    //--------------------------------------------------------------------------
    /**
     *   By Dr Andrew Chemist Chief technology officer GenetHoc Ltd.
     *  @return true if the dna sequences is in the databaase of DNASeqences
     */
    boolean searchForDNA(String dna);

    /**
     *   By Dr Andrew Chemist Chief technology officer GenetHoc Ltd.
     * take data from the database and look for a match of a fragment inside
     * the DNA list you have
     *
     * @param  fragment sequence which could be any where in the DNA
     * @return
     */
    public List<DNASequenceInterface> searchForDNAFragment(String fragment);

    /**
     * y Dr Andrew Chemist Chief technology officer GenetHoc Ltd.
     */
    void selfTest();

    int size();

    //--------------------------------------------------------------------------
    /**
     *   By Dr Andrew Chemist Chief technology officer GenetHoc Ltd.
     * checks database has not been corrupted. Kept disappearing.
     */
    boolean testDatabaseIntegrity();

    /**
     *   By Dr Andrew Chemist Chief technology officer GenetHoc Ltd.
     */
    boolean testLookingForCrimeSceneCodes(int howMany);

    /**
     *   By Dr Andrew Chemist Chief technology officer GenetHoc Ltd.
     * checks database has not been corrupted. Kept disappearing.
     */
    boolean testLookingForDNASequence(int howMany);

    /**
     *   By Dr Andrew Chemist Chief technology officer GenetHoc Ltd.
     * take data from the database and look for a match of a fragment inside
     * the DNA list you have
     *
     * @param  fragment sequence which could be any where in the DNA
     * @return
     */
    boolean testLookingForFragement(int howMany);

    boolean testLookingForFragementPositive(int kFragementPositiveTests);

    /**
     *   By Dr Andrew Chemist Chief technology officer GenetHoc Ltd.
     *  artificially create duplicates by copying others
     */
    void testRemoveDuplicateDNASequnces(final int DUPLICATES);
    
}
