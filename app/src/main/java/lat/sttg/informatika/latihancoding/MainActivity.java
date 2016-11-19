package lat.sttg.informatika.latihancoding;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //Ini program untuk tampilan result pemesanan
    private TextView textval;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textval = (TextView)findViewById(R.id.txtPesan);

        Bundle b = getIntent().getExtras();
        int value = -1; // or other values
        String order = "";
        if(b != null)
            value = b.getInt("total");
            order = b.getString("order");

        textval.setText(order+"\nPesanan anda totalnya = "+ value);
    }
    private Boolean exit = true;

    @Override
    public void onBackPressed() {
        if (exit) {
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            startActivity(intent);
        }

    }
}
