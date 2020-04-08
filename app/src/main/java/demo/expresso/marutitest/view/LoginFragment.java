package demo.expresso.marutitest.view;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import demo.expresso.marutitest.viewmodel.LoginViewModel;
import demo.expresso.marutitest.R;
import demo.expresso.marutitest.model.User;
import demo.expresso.marutitest.utils.ValidationUtils;
import demo.expresso.marutitest.databinding.LoginFragmentBinding;

public class LoginFragment extends Fragment {

    EditText phone;
    EditText password;
    Button loginBtn;
    boolean isValidPhone, isValidPass;
    LoginViewModel mViewModel;

    TextInputLayout input1, input2;

    public static LoginFragment newInstance() {
        return new LoginFragment();
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        LoginFragmentBinding binding = DataBindingUtil.inflate(inflater, R.layout.login_fragment, container, false);
        User user = new User("", "");
        mViewModel = ((MainActivity) getActivity()).getmViewModel();
        mViewModel.setActivity(getActivity());
        binding.setUser(user);
        binding.setViewModel(mViewModel);
        return binding.getRoot();

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        phone = (EditText) view.findViewById(R.id.phone_number);
        password = (EditText) view.findViewById(R.id.password);
        loginBtn = (Button) view.findViewById(R.id.login_btn);
        phone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (ValidationUtils.isValidPhone(phone)) {
                    isValidPhone = true;
                    enableButton();
                }
            }
        });
        phone.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (ValidationUtils.isValidPhone(phone)) {
                    isValidPhone = true;
                    enableButton();
                }
            }
        });

        password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                isValidPass = false;
                if (ValidationUtils.isPassword(password))
                    isValidPass = true;
                enableButton();
            }
        });

        password.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                isValidPass = false;
                if (ValidationUtils.isPassword(password))
                    isValidPass = true;
                enableButton();

            }
        });


    }

    public void enableButton() {
        if (isValidPhone && isValidPass)
            loginBtn.setEnabled(true);
        else
            loginBtn.setEnabled(false);

    }

}
