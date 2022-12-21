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
public class DNASequence implements DNASequenceInterface 
{
    protected String dnaSequence = null  ; 
    protected String sampleID  = null ; 
    protected LocalDateTime enteredIntoDB = null ; 
    protected String criminalIDConfirmedAs = null ; 
    protected List<String> crimeScenes  = null ; // no duplicates allowed. 

    /**
     *   By Dr Andrew Chemist Chief technology officer GenetHoc Ltd. 
     */
    public DNASequence(String dnaSequence, String sampleID) 
    {
        assert isDNA( dnaSequence ) == true ; 
        
        this.dnaSequence = dnaSequence;
        this.sampleID = sampleID;
        this.enteredIntoDB = null ; 
        this.crimeScenes = new LinkedList<String>() ; 
    }
    
    public Collection<String> getAllCrimeScenes(){ return crimeScenes;  } 
    
    
    /**
     *   By Dr Andrew Chemist Chief technology officer GenetHoc Ltd. 
     */
    @Override
    public void addCrimeScene(String whereID ) 
    {
        if( this.crimeScenes.contains( whereID) ) return ; // must be 
        this.crimeScenes.add( whereID );
    }
    /**
     *  By Dr Andrew Chemist Chief technology officer GenetHoc Ltd.
     * @param whereID
     * @return 
     */
    @Override
    public boolean linkedToCrimeScene( String whereID)
    { 
       assert crimeScenes !=null ; 
        for( String it : crimeScenes ) 
        { 
            if( whereID.equals( it ))return true ; 
        }
        return false ; 
    }
    /**
     *  By Dr Andrew Chemist Chief technology officer GenetHoc Ltd.
     * @param whereID
     * @return 
     */
    @Override
    public void addCrimeScenseFrom( DNASequenceInterface other  )
    { 
        for( String it : other.getAllCrimeScenes() ) 
        { 
          this.addCrimeScene(it); 
        }
    }
    /**
     *   By Dr Andrew Chemist Chief technology officer GenetHoc Ltd.
     *  return any crime scene in the list used for testing. 
     */
    @Override
    public String getRandomCrimeScene(  Random dice )
    { 
        assert crimeScenes != null ; 
        return crimeScenes.get( dice.nextInt(crimeScenes.size()  )); 
    }
    
    @Override
    public boolean sameDNASequence( String it ) 
    { 
        return this.dnaSequence.equals( it); 
    }
    @Override
    public boolean  isDNA(  )
    { 
       return  isDNA(  this.dnaSequence ); 
    }
    /**
     *   By Dr Andrew Chemist Chief technology officer GenetHoc Ltd. 
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.dnaSequence);
        return hash;
    }
    /**
     *   By Dr Andrew Chemist Chief technology officer GenetHoc Ltd. 
     */
    @Override
    public boolean equals(Object obj) 
    {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DNASequence other = (DNASequence) obj;
        if (!Objects.equals(this.dnaSequence, other.dnaSequence)) {
            return false;
        }
        return true;
    }
    /**
     *   By Dr Andrew Chemist Chief technology officer GenetHoc Ltd. 
     */
    
    @Override
    public String toString() {
        return "DNASequence{" + "sampleID=" + sampleID +
                ", enteredIntoDB=" + enteredIntoDB + 
                ", crime location=" + criminalIDConfirmedAs + 
                 '}';
    }
     @Override
    public boolean containsFragement( String dnaFragment )
    { 
        return dnaSequence.contains(dnaFragment);
    }
    /**
     *   By Dr Andrew Chemist Chief technology officer GenetHoc Ltd. 
     */

    @Override
    public String getDnaSequence() {
        return dnaSequence;
    }
    /**
     *   By Dr Andrew Chemist Chief technology officer GenetHoc Ltd. 
     */
    @Override
    public void setDnaSequence(String dnaSequence) {
        this.dnaSequence = dnaSequence;
    }
    /**
     *   By Dr Andrew Chemist Chief technology officer GenetHoc Ltd. 
     */
    @Override
    public String getSampleID() {
        return sampleID;
    }
    /**
     *   By Dr Andrew Chemist Chief technology officer GenetHoc Ltd. 
     */

    @Override
    public void setSampleID(String sampleID) {
        this.sampleID = sampleID;
    }
/**
     *   By Dr Andrew Chemist Chief technology officer GenetHoc Ltd. 
     * /
    public LocalDateTime getEnteredIntoDB() {
        return enteredIntoDB;
    }
/**
     *   By Dr Andrew Chemist Chief technology officer GenetHoc Ltd. 
     * /
    public void setEnteredIntoDB(LocalDateTime enteredIntoDB) {
        this.enteredIntoDB = enteredIntoDB;
    }
/**
     *   By Dr Andrew Chemist Chief technology officer GenetHoc Ltd. 
     */
    @Override
    public String getCriminalIDConfirmedAs() {
        return criminalIDConfirmedAs;
    }
/**
     *   By Dr Andrew Chemist Chief technology officer GenetHoc Ltd. 
     */
    @Override
    public void setCriminalIDConfirmedAs(String criminalIDConfirmedAs) {
        this.criminalIDConfirmedAs = criminalIDConfirmedAs;
    }
     /**
     *   By Dr Andrew Chemist Chief technology officer GenetHoc Ltd. 
     */
  
 
    
    /**
     *   By Dr Andrew Chemist Chief technology officer GenetHoc Ltd. 
     */
    public DNASequenceInterface addRandomCrimeLocations( DNASequenceInterface it , Random rn )
    { 
        return addRandomCrimeLocations( it , rn, 600 ); 
    }
   public  DNASequenceInterface addRandomCrimeLocations( DNASequenceInterface it , Random rn,
                                                                int maxLocatins )
    { 
        assert maxLocatins > 0 ; 
        int a  = rn.nextInt(maxLocatins)+1 ; 
        while( a-- > 0 )
        { 
            String where = DNASequenceInterface.randomString( 10, rn) ; 
            it.addCrimeScene("CRMLOC"+where);
        } 
        return it; 
    }
        
    /**
     *   By Dr Andrew Chemist Chief technology officer GenetHoc Ltd. 
     */
    static boolean isDNA( String it )
    { 
        for(int a = 0 ; a < it.length() ;a++ )
        { 
             if(!( ( it.charAt(a) =='A' )|| 
                   ( it.charAt(a) =='G' ) || 
                   ( it.charAt(a) =='C' )  ||  
                   ( it.charAt(a) =='T' )
                     )) return false ; 
        }
        return true ; 
    } 
}
