package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button mSqrtOp;
    private EditText mEditTextOp1;
    private EditText mEditTextOp2;
    private TextView mTextViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /**
         * getting ref to widgets
         * get the ref of plus button
         * wiring up widgets
         */
        Button mPlusOp = (Button) findViewById(R.id.button_op_plus);
        /**
         * get the ref of the edit text for reading input 1
         */
        mEditTextOp1 = (EditText) findViewById(R.id.editText_op1);
        /**
         * get the ref of the edit text for reading input 2
         */
        mEditTextOp2 = (EditText) findViewById(R.id.editText_op2);
        /**
        * get the ref of the txt view for displaying output
        */
        mTextViewResult = (TextView) findViewById(R.id.textView_result);
        /**
         * setting listeners on click of the input
         */
        mPlusOp.setOnClickListener(new View.OnClickListener() {
            /**
             *
             * @param v the view object is passed as a parameter to the onClick method
             */

            @Override
                public void onClick(View v) {
                /**
                 * For plus input if the user does not provide any input then a Error toast shown in the screen
                 * If not then both the inputs provided are added together and displayed
                 */
                    if (!mEditTextOp1.getText().toString().toString().trim().equals("") && !mEditTextOp2.getText().toString().trim().equals("")) {
                        mTextViewResult.setText(String.valueOf(Double.parseDouble(mEditTextOp1.getText().toString()) + Double.parseDouble((mEditTextOp2.getText().toString()))));
                    } else if (mEditTextOp1.getText().toString().trim().equals("")  || mEditTextOp2.getText().toString().trim().equals("")) {
                        Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                        /**
                         * Clear the output when divide by zero
                         * And set the focus to the first edit text for the user to enter input
                         */
                        mTextViewResult.setText("");
                        mEditTextOp1.requestFocus();
                    }
            }
        });
        /**
         * get the reference for subtraction
         */

        Button mMinusOp = (Button) findViewById(R.id.button_op_minus);
        /**
         * setting listeners for subtraction
         */
        mMinusOp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**
                 * For minus input if the user does not provide any input then a Error toast shown in the screen
                 * If not then both the inputs provided are subtracted together and displayed
                 */
                if (!mEditTextOp1.getText().toString().toString().trim().equals("") && !mEditTextOp2.getText().toString().trim().equals("")) {
                    mTextViewResult.setText(String.valueOf(Double.parseDouble(mEditTextOp1.getText().toString()) - Double.parseDouble((mEditTextOp2.getText().toString()))));
                } else if (mEditTextOp1.getText().toString().trim().equals("")  || mEditTextOp2.getText().toString().trim().equals("")) {
                    Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                    /**
                     * Clear the output when divide by zero
                     * And set the focus to the first edit text for the user to enter input
                     */
                    mTextViewResult.setText("");
                    mEditTextOp1.requestFocus();
                }
            }
        });
        /**
         * get reference for multiplication
         */
        Button mMultOp = (Button) findViewById(R.id.button_op_mult);
        /**
         * setting listener for multiplication
         */
        mMultOp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**
                 * For multiplication input if the user does not provide any input then a Error toast shown in the screen
                 * If not then both the inputs provided are multiplied together and displayed
                 */
                if (!mEditTextOp1.getText().toString().toString().trim().equals("") && !mEditTextOp2.getText().toString().trim().equals("")) {
                    mTextViewResult.setText(String.valueOf(Double.parseDouble(mEditTextOp1.getText().toString()) * Double.parseDouble(mEditTextOp2.getText().toString())));
                } else if (mEditTextOp1.getText().toString().trim().equals("")  || mEditTextOp2.getText().toString().trim().equals("")) {
                    Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                    /**
                     * Clear the output when divide by zero
                     * And set the focus to the first edit text for the user to enter input
                     */
                    mTextViewResult.setText("");
                    mEditTextOp1.requestFocus();
                }
            }
        });
        /**
         * get reference for division
         */
        Button mDivOp = (Button) findViewById(R.id.button_op_div);
        /**
         * setting listeners for division
         */
        mDivOp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**
                 * For division input if the user does not provide any input then a Error toast shown in the screen
                 * If not then both the inputs provided are divided together and displayed.
                 * One another condition which checked is divide by zero, if the second input is zero
                 * then error is displayed on screen.
                 */
                if (mEditTextOp1.getText().toString().trim().equals("")  || mEditTextOp2.getText().toString().trim().equals("")) {
                    Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                } else if (Double.parseDouble(mEditTextOp2.getText().toString()) == 0) {
                    /**
                     * Clear the output when divide by zero
                     * And set the focus to the first edit text for the user to enter input
                     */
                    mTextViewResult.setText("");
                    mEditTextOp1.requestFocus();
                } else if (!mEditTextOp1.getText().toString().toString().trim().equals("") && !mEditTextOp2.getText().toString().trim().equals("")) {
                    mTextViewResult.setText(String.valueOf(Double.parseDouble(mEditTextOp1.getText().toString()) / Double.parseDouble(mEditTextOp2.getText().toString())));
                }
            }
        });
        /**
         * get reference for percentage
         */
        Button mPercentOp = (Button) findViewById(R.id.button_op_pct);
        /**
         * setting listeners for percentage
         */
        mPercentOp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**
                 * For percentage input if the user does not provide the first input then a Error toast shown in the screen
                 * If not then the first input is divided by hundred and displayed on screen
                 */
                if (!mEditTextOp1.getText().toString().toString().trim().equals("")) {
                    mTextViewResult.setText(String.valueOf(Double.parseDouble(mEditTextOp1.getText().toString()) / 100));
                } else if(mEditTextOp1.getText().toString().trim().equals("")) {
                    Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                    /**
                     * Clear the output when divide by zero
                     * And set the focus to the first edit text for the user to enter input
                     */
                    mTextViewResult.setText("");
                    mEditTextOp1.requestFocus();
                } else if (mEditTextOp1.getText().toString().trim().equals("") && mEditTextOp2.getText().toString().trim().equals("")) {
                    Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                    /**
                     * Clear the output when divide by zero
                     * And set the focus to the first edit text for the user to enter input
                     */
                    mTextViewResult.setText("");
                    mEditTextOp1.requestFocus();
                }
            }
        });
        /**
         * getting reference for square root
         */
        Button mSqrtOp = (Button) findViewById(R.id.button_op_sqrt);
        /**
         * setting listeners for square root
         */
        mSqrtOp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**
                 * For square root input if the user does not provide the first input then a Error toast shown in the screen
                 * If not then the square root of the first input is calculated and displayed on screen
                 */
                if (!mEditTextOp1.getText().toString().toString().trim().equals("")) {
                    mTextViewResult.setText(String.valueOf(Math.sqrt(Double.parseDouble((mEditTextOp1).getText().toString()))));
                } else if(mEditTextOp1.getText().toString().trim().equals("")) {
                    Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                    /**
                     * Clear the output when divide by zero
                     * And set the focus to the first edit text for the user to enter input
                     */
                    mTextViewResult.setText("");
                    mEditTextOp1.requestFocus();
                } else if (mEditTextOp1.getText().toString().trim().equals("") && mEditTextOp2.getText().toString().trim().equals("")) {
                    Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                    /**
                     * Clear the output when divide by zero
                     * And set the focus to the first edit text for the user to enter input
                     */
                    mTextViewResult.setText("");
                    mEditTextOp1.requestFocus();
                }
            }
        });
    }

}