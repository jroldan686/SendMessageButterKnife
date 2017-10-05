package jrl.deint.sendmessagebutterknife;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import jrl.deint.sendmessagebutterknife.pojo.Messages;

/**
 * Esta clase recibe un mensaje de un usuario y se muestra en pantalla.
 * @author Jesús Roldán López
 * @version 1.0
 */
//TODO 1: Recoger el Intent...
public class ViewMessageActivity extends AppCompatActivity {

    @BindView(R.id.txvViewMessage)
    TextView txvViewMessage;
    @BindView(R.id.txvViewUser)
    TextView txvViewUser;
    private static final String TAG = "ViewMessageActivity";

    Messages messages;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_message);

        // Vincular el id de las vistas en el XML con las clases View
        ButterKnife.bind(this);

        txvViewMessage = (TextView)findViewById(R.id.txvViewMessage);
        txvViewUser = (TextView)findViewById(R.id.txvViewUser);

        //1. Recoger el Intent que se ha enviado
        //Intent intent = getIntent();
        //2. Recoger el mensaje del Bundle
        //Bundle bundle = intent.getExtras();
        //3. Mostrar mensaje
        //txvViewMessage.setText(bundle.getString("message"));
        /*
        txvViewMessage.setText(getIntent().getExtras().getString("message"));

        String viewUser = String.format(getResources().getString(R.string.txvViewUser),
                getIntent().getExtras().getString("user"));
        */
        messages = (Messages)getIntent().getExtras().getSerializable("message");
        txvViewMessage.setText(messages.getMessage());
        String viewUser = String.format(getResources().getString(R.string.txvViewUser), messages.getUser());
        txvViewUser.setText(viewUser);

        Log.d(TAG, "onCreate()");
    }
}
