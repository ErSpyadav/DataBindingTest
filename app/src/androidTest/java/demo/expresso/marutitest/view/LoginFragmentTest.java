package demo.expresso.marutitest.view;

import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.fragment.app.Fragment;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;
import demo.expresso.marutitest.R;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.platform.app.InstrumentationRegistry.getArguments;
import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;

@RunWith(AndroidJUnit4.class)
public class LoginFragmentTest {


    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(MainActivity.class);

    MainActivity activity = null;

    @Before
    public void setUp() throws Exception {
        activity = activityTestRule.getActivity();
    }

    @Test
    public void isFragmentLoad() throws InterruptedException {

        LoginFragment loginFragment = LoginFragment.newInstance();
        FrameLayout frameLayout =activity.findViewById(R.id.fragment_container);
        Assert.assertNotNull(frameLayout);
        activity.getSupportFragmentManager().beginTransaction().add(frameLayout.getId(),new LoginFragment()).commitAllowingStateLoss();
        getInstrumentation().waitForIdleSync();

    }

    @After
    public void tearDown() throws Exception {
        activity = null;
        activityTestRule = null;
    }

}