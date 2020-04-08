package demo.expresso.marutitest.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import demo.expresso.marutitest.viewmodel.LoginViewModel;
import demo.expresso.marutitest.R;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    LoginViewModel mViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction().
                replace(R.id.fragment_container, new LoginFragment(), "SOMETAG").
                commit();
        mViewModel = ViewModelProviders.of(this).get(LoginViewModel.class);

    }

    public LoginViewModel getmViewModel(){
        return mViewModel;
    }

    public  void switchFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,fragment).commit();
    }
}
