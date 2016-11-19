package example.concursomovil2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainSistema extends AppCompatActivity {

    TextView textViewUsuario;
    EditText editTextNumeroTaxi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_sistema);

        textViewUsuario = (TextView) findViewById( R.id.textViewUsuario );

        Intent i=getIntent();
        Bundle extras =i.getExtras();
        if (extras != null) {//ver si contiene datos
            String datoNombre=(String)extras.get("Usuario");//Obtengo el nombre

            textViewUsuario.setText("Usuario: "+datoNombre);
        }

        editTextNumeroTaxi = (EditText) findViewById(R.id.editTextNumeroTaxi);
    }

    public void aceptar(View view) {
            Intent i = new Intent(this, MainDatos.class );
            startActivity(i);
            Toast.makeText(getApplicationContext(),"Redirecting...", Toast.LENGTH_SHORT).show();
    }

    public void cerrar(View view) {
        //finish();
        if(editTextNumeroTaxi.getText().toString().equals("2016")){
            Intent i = new Intent(this, MainDatos.class );
            i.putExtra("Numero", editTextNumeroTaxi.getText().toString());
            startActivity(i);
            Toast.makeText(getApplicationContext(),"Redirecting...", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(getApplicationContext(), "Error Redirecting...", Toast.LENGTH_SHORT).show();
        }
    }
}
