package demo.expresso.marutitest;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;
import demo.expresso.marutitest.view.LoginFragment;
import demo.expresso.marutitest.view.MainActivity;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;


@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Before
    public void init(){
        activityTestRule.getActivity().getSupportFragmentManager().beginTransaction();
    }

    @Test
    public void loadFragment(){
       FragmentManager mFragmentManager = activityTestRule.getActivity().getSupportFragmentManager();
        Fragment frag = mFragmentManager.findFragmentById(R.id.fragment_container);
        if (frag instanceof LoginFragment) {
           System.out.print("Login Fragment");
        } else {
            System.out.print("Login Fragment");
        }

        onView(withId(R.id.fragment_container)).check(matches(isDisplayed()));
    }

    @After
    public void after(){
        activityTestRule=null;
    }

}


