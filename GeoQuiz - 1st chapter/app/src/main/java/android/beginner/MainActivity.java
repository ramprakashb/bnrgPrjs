package android.beginner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //wiring up widgets
    private Button mTrueButton;
    private Button mFalseButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //getting reference to widgets
        mTrueButton = (Button) findViewById(R.id.true_button);
        //setting listeners
        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
                    public void onClick(View v) {
                Toast toast = Toast.makeText(MainActivity.this,
                                R.string.correct_toast,
                               Toast.LENGTH_SHORT);
                /**
                 * Toast.setGravity method allows us to define the toast anywhere in the
                 * screen rather than defining it in the bottom of the screen.
                 * Here we define it in the Top Left of the screen
                 *
                 * Note: we cannot simply define it like
                 *  Toast.setGravity() because setGravity is a non static method so we
                 *  need to define an instance of Toast class.
                 */
                toast.setGravity(Gravity.TOP | Gravity.LEFT, 0, 0);
                toast.show();
            }
        });

        mFalseButton = (Button) findViewById(R.id.false_button);
        //setting listeners
        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public  void onClick(View v) {
                Toast toast = Toast.makeText(MainActivity.this,
                                R.string.incorrect_toast,
                                Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.TOP | Gravity.LEFT, 0, 0);
                toast.show();
            }
        });
    }
}