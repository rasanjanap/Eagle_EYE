/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DATA;

//import com.alee.laf.text.WebTextField;
//import com.alee.managers.tooltip.TooltipManager;
//import com.alee.managers.tooltip.TooltipWay;
import java.awt.event.KeyEvent;
import java.util.StringTokenizer;
import javax.swing.JComponent;
import java.text.SimpleDateFormat;

/**
 *
 * @author Supipi Dilranda
 */
public class FieldValidation {

    public boolean requiredFieldValidationAdd(String NIC, String Name, String DOB, String TelNo, String Address, String City, String Email, String Details) {
        //----------To check whether these fields are null or not---------------
        return NIC.isEmpty() || Name.isEmpty() || DOB.isEmpty() || TelNo.isEmpty() || Address.isEmpty() || City.isEmpty() || Email.isEmpty() || Details.isEmpty();
    }

    public boolean validateNIC(String NIC) {

        return NIC.matches("^[0-9]{9}[vVxX]$");
    }

    public boolean validateName(String Name) {

        return Name.matches("^[a-zA-Z. ]{1,}");
    }

    public boolean validateDOB(String DOB) {

        return DOB.matches("^([0-9]{2})/([0-9]{2})/([0-9]{4})$");
    }

    public boolean validateTelNo(String TelNo) {

        return TelNo.matches("^[0-9]{10}$");
    }

    public boolean validateAddress(String Address) {

        return Address.matches("^[a-zA-Z0-9,.;-_'/' ]{4,}$");
    }

    public boolean validateCity(String City) {

        return City.matches("^[a-zA-Z0-9,.;-_'/' ]{4,}$");
    }

    public boolean validateEmail(String Email) {

        boolean status = true;

        if (Email == null || Email.indexOf("@") < 0 || Email.indexOf(".") < 0 || Email.indexOf(".") > Email.length()) {
            status = false;
        }

        return status;
    }

    public boolean validateDetails(String Details) {

        return Details.matches("^[a-zA-Z. ]{1,}");
    }

    //---------------------Befor Insert & Update  check have worng value--------------------
    public boolean validateAll(String NIC, String Name, String DOB, String TelNo, String Address, String City, String Email, String Details) {

        if (validateNIC(NIC)) {
            if (validateName(Name)) {
                if (validateDOB(DOB)) {
                    if (validateTelNo(TelNo)) {
                        if (validateAddress(Address)) {
                            if (validateCity(City)) {
                                if (validateEmail(Email)) {
                                    if (validateDetails(Details)) {
                                        {
                                            return true;

                                        }
                                    }

                                }
                            }
                        }
                    }

                }
            }
        }

        return false;

    }

}
