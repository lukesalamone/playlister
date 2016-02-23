package luke.com.playlist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * Created by luke on 2/9/16.
 */
public class LoginActivity extends AppCompatActivity{

    boolean usernameClicked;
    boolean passwordClicked;
    TextView username;
    TextView password;

    public LoginActivity(){
        usernameClicked = false;
        passwordClicked = false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = (TextView) findViewById(R.id.username);
        password = (TextView) findViewById(R.id.password);
    }

    @Override
    protected void onStart(){
        super.onStart();
    }

    @Override
    protected void onResume(){
        super.onResume();
    }

    @Override
    protected void onStop(){
        super.onStop();
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
    }

    public void usernameClicked(View view){
        if(!usernameClicked){
            username.setText("");
        }
        usernameClicked = true;
    }

    public void passwordClicked(View view){
        if(!passwordClicked){
            password.setText("");
        }
        passwordClicked = true;
    }

    // TODO probably should verify credentials!
    public void login(View view){
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        MainActivity.context().startActivity(intent);
    }

    public void signup(View view){
        Intent intent = new Intent(getApplicationContext(), SignupActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        MainActivity.context().startActivity(intent);
    }
}// end LoginActivity class
