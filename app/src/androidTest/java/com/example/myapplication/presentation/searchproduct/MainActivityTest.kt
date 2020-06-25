package com.example.myapplication.presentation.searchproduct


import android.content.Context
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.myapplication.presentation.searchproduct.MainActivity
import com.example.myapplication.presentation.searchproduct.MainViewModel
import org.junit.Before
import javax.inject.Inject


import android.util.Log
import android.view.View
import android.widget.EditText
import androidx.appcompat.widget.SearchView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.pressImeActionButton
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import com.example.myapplication.R
import org.hamcrest.CoreMatchers.allOf
import org.hamcrest.Matcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
@LargeTest
class MainActivityTest {

    @get:Rule
    val activityRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun validateThatSearchIsOk() {
        try {
            //Arrange
            onView(withId(R.id.action_search)).perform(click())
            onView(isAssignableFrom(SearchView::class.java))
                .perform(typeSearchViewText("lord")).perform(pressImeActionButton())
            //Act
            onView(
                withId(
                    R.id.action_search

                    //Assert
                )
            ).check(matches(isDisplayed()))
        } catch (exception: Exception) {
            Log.e("TEST", exception.message)
        }
    }

    private fun typeSearchViewText(text: String?): ViewAction? {
        return object : ViewAction {
            override fun getConstraints(): Matcher<View> {
                //Ensure that only apply if it is a SearchView and if it is visible.
                return allOf(isDisplayed(), isAssignableFrom(SearchView::class.java))
            }

            override fun getDescription(): String {
                return "Change view text"
            }

            override fun perform(uiController: UiController?, view: View) {
                (view as SearchView).setQuery(text, false)
            }
        }
    }
}
