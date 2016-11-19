package lat.sttg.informatika.latihancoding;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class PesanActivity extends AppCompatActivity {
    private CheckBox original, mocha, cap, vanilla, java;
    private EditText originaljml, mochajml, capjml, vanillajml, javajml;
    private Button btnPesan;
    int jml;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesan);

        //inisialisasi Checkbox
        original = (CheckBox) findViewById(R.id.check1);
        mocha = (CheckBox) findViewById(R.id.check2);
        cap = (CheckBox) findViewById(R.id.check3);
        java = (CheckBox) findViewById(R.id.check5);
        vanilla = (CheckBox) findViewById(R.id.check4);

        //inisialisasi Edittext
        originaljml = (EditText) findViewById(R.id.editjml1);
        mochajml = (EditText) findViewById(R.id.editjml2);
        capjml = (EditText) findViewById(R.id.editjml3);
        vanillajml = (EditText) findViewById(R.id.editjml4);
        javajml = (EditText) findViewById(R.id.editjml5);

        btnPesan = (Button) findViewById(R.id.btnPesan);
        btnPesan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int jmlori = 0;
                String pesanan = "Anda memesan : ";
                if (original.isChecked()) {
                    int original = 5000;
                    int countori = Integer.parseInt(originaljml.getText().toString());
                    jmlori = original * countori;
                    jml = jml + jmlori;
                    pesanan = pesanan + "Kopi original("+countori+") ";
                }
                else{
                    jml = jml + jmlori;
                }

                int jmlmocha = 0;
                if (mocha.isChecked()) {
                    int hargamocha = 7000;
                    int countmocha = Integer.parseInt(mochajml.getText().toString());
                    jmlmocha = hargamocha * countmocha;
                    jml = jml + jmlmocha;
                    pesanan = pesanan + "Kopi mocha("+countmocha+") ";
                }
                else{
                    jml = jml + jmlmocha;
                }

                Toast.makeText(getApplicationContext(), "Total = " + jml+"\n Pesanan = "+pesanan, Toast.LENGTH_LONG).show();

                Intent intent = new Intent(PesanActivity.this, MainActivity.class);
                Bundle b = new Bundle();
                b.putInt("total", jml);
                b.putString("order", pesanan);
                intent.putExtras(b); //Put your id to your next Intent
                startActivity(intent);
                finish();

            }
        });


    }
}
