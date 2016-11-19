package lat.sttg.informatika.latihancoding;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    EditText userlogin;
    EditText passlogin;
    Button btnlogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        userlogin = (EditText)findViewById(R.id.username);
        passlogin = (EditText)findViewById(R.id.password);
        btnlogin = (Button)findViewById(R.id.btnLogin);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String useranda = userlogin.getText().toString();
                String passanda = passlogin.getText().toString();

                if(useranda.equals("admin") && passanda.equals("1234")){
                    Intent myIntent = new Intent(Login.this, PesanActivity.class);
                    startActivity(myIntent);
                }
                else{
                    Toast.makeText(getApplicationContext(),
                            "Username dan password anda salah",
                            Toast.LENGTH_LONG).show();
                }

            }
        });

    }
}
