package demo.expresso.marutitest.utils;

import android.text.TextUtils;
import android.widget.EditText;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationUtils {

    public static boolean isValidPhone(EditText phone) {
        String mobile=phone.getText().toString().trim();
        phone.setError(null);
        if (TextUtils.isEmpty(mobile)) {
            phone.setError("Mobile should not empty");
            return false;
        }

        String mobileRegex = "(0/91)?[6-9][0-9]{9}";
        Pattern p = Pattern.compile(mobileRegex);
        Matcher m = p.matcher(mobile);
        boolean isCorrect =(m.find() && m.group().equals(mobile));
        if(!isCorrect)
            phone.setError("Pleaase enter valid 10 digit mobile number");
        else
            phone.setError(null);

        return isCorrect;
    }


    public static boolean isPassword(EditText password) {
        String pass = password.getText().toString().trim();
        if (TextUtils.isEmpty(pass)) {
            password.setError("Password should not empty");
            return false;
        }
        else if (!TextUtils.isEmpty(pass) && pass.length()<8) {
            password.setError("Password should be 8 digit");
            return false;
        }

        String passwordRegex = "(?=^.{8,10}$)(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&amp;*()_+}{&quot;:;'?/&gt;.&lt;,])(?!.*\\s).*$";
        Pattern p = Pattern.compile(passwordRegex);
        Matcher m = p.matcher(pass);
        boolean isCorrect =(m.find() && m.group().equals(pass));
        if(!isCorrect)
            password.setError("enter password as Abc12!abc");
        else {
            password.setError(null);
        }
        return isCorrect;
    }

}
