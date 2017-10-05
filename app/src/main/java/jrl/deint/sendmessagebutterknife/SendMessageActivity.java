package jrl.deint.sendmessagebutterknife;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import jrl.deint.sendmessagebutterknife.pojo.Messages;

/**
 * Esta clase envia un mensaje de un usuario a otro.
 * @author Jesús Roldán López
 * @version 1.0
 * <p>Conceptos aprendidos:</p>
 * <ul>
 *     <li>Concepto Context</li>
 *     <li>Paso de parámetros mediante el objeto @see android.os.Bundle</li>
 *     <li>Paso de mensajes entre dos actividades mediante la clase @see android.content.Intent</li>
 * </ul>
 */
public class SendMessageActivity extends AppCompatActivity {

    @BindView(R.id.edtMessage)
    EditText edtMessage;
    @BindView(R.id.edtUser)
    EditText edtUser;
    @BindView(R.id.btnOk)
    Button btnOk;
    private static final String TAG = "SendMessageActivity";

    private Messages messages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_message);

        // Vincular el id de las vistas en el XML con las clases View
        ButterKnife.bind(this);

        edtMessage = (EditText)findViewById(R.id.edtMessage);
        edtUser = (EditText)findViewById(R.id.edtUser);
        btnOk = (Button)findViewById(R.id.btnOk);

        //1. Registrar un Listener o Escuchador OnClickListener
        /*
        btnOk.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                //1. Recoger el mensaje
                //edtMessage.getText().toString();
                //2. Crear un objeto Bundle y añadir el mensaje
                Bundle bundle = new Bundle();

                //bundle.putString("message", edtMessage.getText().toString());
                //bundle.putString("user", edtUser.getText().toString());

                messages = new Messages(edtMessage.getText().toString(), edtUser.getText().toString());
                bundle.putSerializable("message", messages);


                //3.1. Crear un objeto Intent
                Intent intent = new Intent(SendMessageActivity.this,ViewMessageActivity.class);
                //3.2. Añadir el Bundle
                intent.putExtras(bundle);
                //4. Iniciar la Activity ViewMessageActivity
                startActivity(intent);
            }
        });
        */
        Log.d(TAG, "onCreate()");
    }

    @OnClick(R.id.btnOk)
    public void getOnClick (View view) {
        switch (view.getId()) {
            case R.id.btnOk:

                //1. Recoger el mensaje
                //edtMessage.getText().toString();
                //2. Crear un objeto Bundle y añadir el mensaje
                Bundle bundle = new Bundle();

                //bundle.putString("message", edtMessage.getText().toString());
                //bundle.putString("user", edtUser.getText().toString());

                bundle.putSerializable("message", new Messages(edtMessage.getText().toString(), edtUser.getText().toString()));

                //3.1. Crear un objeto Intent
                Intent intent = new Intent(SendMessageActivity.this,ViewMessageActivity.class);
                //3.2. Añadir el Bundle
                intent.putExtras(bundle);
                //4. Iniciar la Activity ViewMessageActivity
                startActivity(intent);
                break;
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }
}
