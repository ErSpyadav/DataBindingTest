package demo.expresso.marutitest.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Objects;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import demo.expresso.marutitest.viewmodel.LoginViewModel;
import demo.expresso.marutitest.R;
import demo.expresso.marutitest.databinding.WelcomeFragmentBinding;

public class WelcomeFragment extends Fragment {

    public static WelcomeFragment newInstance() {
        return new WelcomeFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        WelcomeFragmentBinding binding = DataBindingUtil.inflate(inflater, R.layout.welcome_fragment, container, false);
        LoginViewModel mViewModel = ((MainActivity) Objects.requireNonNull(getActivity())).getmViewModel();
        mViewModel.setActivity(getActivity());
        binding.setViewModel(mViewModel);
        return binding.getRoot();
    }


}
