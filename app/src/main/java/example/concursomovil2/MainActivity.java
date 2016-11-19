package example.concursomovil2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editTextUsuario, editTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextUsuario=(EditText) findViewById(R.id.editTextUsuario);
        editTextPassword=(EditText) findViewById(R.id.editTextPassword);

    }

    public void ingresar(View v) {
        if(editTextUsuario.getText().toString().equals("admin") && editTextPassword.getText().toString().equals("admin")){
            Intent i = new Intent(this, MainSistema.class );
            i.putExtra("Usuario", editTextUsuario.getText().toString());
            startActivity(i);
            Toast.makeText(getApplicationContext(),"Redirecting...", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(getApplicationContext(), "Error Redirecting...", Toast.LENGTH_SHORT).show();
        }
    }

    public void registro(View v) {
        Intent i = new Intent(this, MainRegistro.class);
        startActivity(i);
    }
}
