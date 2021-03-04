package com.practice.android.geoquizchapter2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity  {
    //wiring up widgets
    private Button mTrueButton;
    private Button mFalseButton;
    private ImageButton mNextButton;
    private ImageButton mPrevButton;
    private TextView mQuestionTextView;
    //Cheat button
    private Button mCheatButton;

    //For logging adding a TAG
    private static final String TAG = "QuizActivity";
    private static final String KEY_INDEX = "index";
    private static final String ANSWER_INDEX = "answer";
    private static final String MARKS_INDEX = "marks";
    private static final int REQUEST_CODE_CHEAT = 0;

    private Question[] mQuestionBank = new Question[] {
            //Here we call the Question constructor several times
            //and create an array of Question objects.
            new Question(R.string.question_australia, true),
            new Question(R.string.question_oceans, true),
            new Question(R.string.question_mideast, false),
            new Question(R.string.question_africa, false),
            new Question(R.string.question_americas, true),
            new Question(R.string.question_asia, true)
    };
    private int mCurrentIndex = 0;
    //variable to check if user has selected the output
    private boolean manswerEntered = false;
    private int mMarksObtained = 0;

    int messageResId = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Log message
        Log.d(TAG, "onCreate(Bundle) Called");

        setContentView(R.layout.activity_main);
        //Checking the savedInstanceState

        if (savedInstanceState != null) {
            mCurrentIndex = savedInstanceState.getInt(KEY_INDEX, 0);
            manswerEntered = savedInstanceState.getBoolean(ANSWER_INDEX, false);
            mMarksObtained = savedInstanceState.getInt(ANSWER_INDEX, 0);
        }

        mQuestionTextView = (TextView) findViewById(R.id.question_text_view);
        int question = mQuestionBank[mCurrentIndex].getTextResId();   //Commenting bec of updateQuestion method
        mQuestionTextView.setText(question);  //Commenting bec of updateQuestion method

        //getting reference to widgets
        mTrueButton = (Button) findViewById(R.id.true_button); //Commenting for teseting android lint
        //mTrueButton = (Button)findViewById(R.id.question_text_view); //This throws a lint->correctness->mismatched type error
        //setting listeners
        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* Toast toast = Toast.makeText(MainActivity.this,
                        R.string.correct_toast,
                        Toast.LENGTH_SHORT);

                */
                if (mQuestionBank[mCurrentIndex].isAnswerTrue()) {
                    mMarksObtained++;
                    messageResId=R.string.correct_toast;
                    Log.d("marks inc ", String.format(Locale.US, "marks_inc = %d", mMarksObtained));
                    Toast.makeText(MainActivity.this, messageResId, Toast.LENGTH_SHORT).show();
                } else {
                    mMarksObtained--;
                    messageResId=R.string.incorrect_toast;
                    Log.d("marks dec ", String.format(Locale.US, "marks_dec = %d", mMarksObtained));
                    Toast.makeText(MainActivity.this, messageResId, Toast.LENGTH_SHORT).show();
                }
                /**
                 * Toast.setGravity method allows us to define the toast anywhere in the
                 * screen rather than defining it in the bottom of the screen.
                 * Here we define it in the Top Left of the screen
                 *
                 * Note: we cannot simply define it like
                 *  Toast.setGravity() because setGravity is a non static method so we
                 *  need to define an instance of Toast class.
                 */
                /*
                toast.setGravity(Gravity.TOP | Gravity.LEFT, 0, 0);
                toast.show();

                 */
            }
        });

        mFalseButton = (Button) findViewById(R.id.false_button);
        //setting listeners
        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public  void onClick(View v) {
                /*
                Toast toast = Toast.makeText(MainActivity.this,
                        R.string.incorrect_toast,
                        Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.TOP | Gravity.LEFT, 0, 0);
                toast.show();

                 */
                if (mQuestionBank[mCurrentIndex].isAnswerTrue()) {
                    mMarksObtained++;
                    messageResId = R.string.correct_toast;
                    Log.d("false_button_true ", String.format(Locale.US, "marks = %d", mMarksObtained));
                    Toast.makeText(MainActivity.this, messageResId, Toast.LENGTH_SHORT).show();
                } else {
                    mMarksObtained--;
                    messageResId=R.string.incorrect_toast;
                    Log.d("false_button_false ", String.format(Locale.US, "marks = %d", mMarksObtained));
                    Toast.makeText(MainActivity.this, messageResId, Toast.LENGTH_SHORT).show();
                }
            }
        });

        mNextButton = (ImageButton) findViewById (R.id.next_button);
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                manswerEntered = false;
                mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;
                updateQuestion(mMarksObtained);
            }
        }
        );
        //Setting up listener for cheat button
        mCheatButton = (Button) findViewById(R.id.cheat_button);
        mCheatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Start CheatActivity
                boolean answerIsTrue = mQuestionBank[mCurrentIndex].isAnswerTrue();
                Intent intent = CheatActivity.newIntent(MainActivity.this, answerIsTrue);
                //startActivity(intent); //this does not have request code (intent return val)
                startActivityForResult(intent, REQUEST_CODE_CHEAT);
            }
        });

        /**
         * This section deals with moving the screen to next page when
         * pressing the text view
         */
        mQuestionTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                manswerEntered = false;
                mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;
                //int question = mQuestionBank[mCurrentIndex].getTextResId(); //Commenting bec of updateQuestion method
                //mQuestionTextView.setText(question); //Commenting bec of updateQuestion method
                updateQuestion(mMarksObtained);
            }
            }
        );
        mPrevButton = (ImageButton) findViewById (R.id.prev_button);
        Log.d("Value - before : ", String.format(Locale.US, "Value - before = %d", mCurrentIndex));
        mPrevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                manswerEntered = false;
                if (mCurrentIndex == 0) {
                    mCurrentIndex = 6;
                }
                mCurrentIndex = mCurrentIndex - 1;
                Log.d("Value: ", String.format(Locale.US, "Value = %d", mCurrentIndex));
                updateQuestion(mMarksObtained);
            }
            }
        );


        updateQuestion(mMarksObtained);

    }
    private void updateQuestion(int mMarksObtained) {
        int finalMarks = 0;
        if (mCurrentIndex == mQuestionBank.length - 1) {
            finalMarks = mMarksObtained;
            Log.d("at last question", String.format(Locale.US, "question number = %d", mCurrentIndex));
            Log.d("final marks", String.format(Locale.US, "marks = %d", mMarksObtained));
            Toast.makeText(this, "final "+finalMarks, Toast.LENGTH_LONG).show();
        }
        int question = mQuestionBank[mCurrentIndex].getTextResId();
        mQuestionTextView.setText(question);
    }
    public void checkAnswer(boolean userPressedTrue) {
        boolean answerIsTrue = mQuestionBank[mCurrentIndex].isAnswerTrue();
        int messageResId = 0;
        if(userPressedTrue == answerIsTrue) {
            messageResId = R.string.correct_toast;
        } else {
            messageResId = R.string.incorrect_toast;
        }
        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "onStart() called");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume() called");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause() called");
    }

    //override onSaveInstanceState(Bundle) to write the value of mCurrentIndex to
    //bundle with the constant as its key.
    //The types that save to and restore from a Bundle are primitive types and
    //classes that classes that implement the Serializable or Parcelable interfaces.
    // It is a bad practice to put custom types into a Bundle, however because the data might
    //be state when you get it back out.
    //It is a better choice to use some other kind of storage for the data and put
    //a primitive identifier into the Bundle instead.
    @Override
    public void onSaveInstanceState (Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        Log.i(TAG, "onSaveInstanceState");
        savedInstanceState.putInt(KEY_INDEX, mCurrentIndex);
        savedInstanceState.putBoolean(ANSWER_INDEX, manswerEntered);
        savedInstanceState.putInt(MARKS_INDEX, mMarksObtained);
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "onStop() called");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy() called");
    }
}