package example.concursomovil2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainDatos extends AppCompatActivity {

    TextView textViewNumeroTaxi;

    private EditText celNum;
    private EditText smsText;
    private Button enviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_datos);

        textViewNumeroTaxi = (TextView) findViewById( R.id.textViewNumeroTaxi);

        Intent i=getIntent();
        Bundle extras =i.getExtras();
        if (extras != null) {//ver si contiene datos
            String datoNombre=(String)extras.get("Numero");//Obtengo el nombre

            textViewNumeroTaxi.setText("Numero: "+datoNombre);
        }

        celNum = (EditText) findViewById(R.id.celNum);
        smsText = (EditText) findViewById(R.id.sms);
        enviar = (Button) findViewById(R.id.envio);

        enviar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                sendSmsByManager();
            }
        });
    }

    public void sendSmsByManager() {
       if (celNum.getText().length()==10) {
           try {
               // Get the default instance of the SmsManager
               SmsManager smsManager = SmsManager.getDefault();
               smsManager.sendTextMessage(celNum.getText().toString(), null,
                       smsText.getText().toString(), null, null);
               Toast.makeText(getApplicationContext(), "Tú sms se envió con éxito!",
                       Toast.LENGTH_LONG).show();
           } catch (Exception ex) {
               Toast.makeText(getApplicationContext(), "Tú sms no puede enviarse",
                       Toast.LENGTH_LONG).show();
               ex.printStackTrace();
           }
       }
        else{
           Toast.makeText(getApplicationContext(), "Número de dígitos incorrectos",
                   Toast.LENGTH_LONG).show();
       }
    }

    public void cerrar(View view) {
        finish();
    }
}
