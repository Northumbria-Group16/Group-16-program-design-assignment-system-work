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
public class DNAScanApp 
{
    /**
     * @param args the command line arguments
     */
   
    
    public static void main(String[] args) 
    {
       GenHocDNADatabase db = new StudentSimulation( System.currentTimeMillis() ) ; 
       db.everythingWhichShouldBeImproved(); 
    }
    
}
