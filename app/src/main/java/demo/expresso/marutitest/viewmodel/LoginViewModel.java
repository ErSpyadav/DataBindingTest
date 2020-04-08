package demo.expresso.marutitest.viewmodel;


import android.app.Activity;
import android.app.Application;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import demo.expresso.marutitest.model.User;
import demo.expresso.marutitest.view.MainActivity;
import demo.expresso.marutitest.view.WelcomeFragment;

public class LoginViewModel extends AndroidViewModel {
    public MutableLiveData<String> phone = new MutableLiveData<>();
    private MutableLiveData<User> user = new MutableLiveData<>();
    private Activity activity;

    public LoginViewModel(@NonNull Application application) {
        super(application);
    }


    LiveData<User> getUser() {
        if (user == null)
            user = new MutableLiveData<>();
        return user;
    }

    public void onLoginClicked(User user){
        Toast.makeText(getApplication(),user.getPhone(),Toast.LENGTH_LONG).show();
        ((MainActivity)activity).switchFragment(WelcomeFragment.newInstance());
        phone.postValue(user.getPhone());

    }

    public void setPhone(String name) {
        phone.setValue(name);
    }
    public LiveData<String> getPhone() {
        return phone;
    }

    public void setActivity(Activity activity){
     this.activity=activity;
    }
}
