/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DATA;

/**
 *
 * @author SUPIPI
 */
public class Validation {
    
     public boolean requiredFieldValidationAdd(String Id, String UName, String UNic, String UEmail, String Password ) {
        //----------To check whether these fields are null or not---------------
        return Id.isEmpty() || UName.isEmpty() || UNic.isEmpty() || UEmail.isEmpty() || Password.isEmpty() ;
    }
    
}
