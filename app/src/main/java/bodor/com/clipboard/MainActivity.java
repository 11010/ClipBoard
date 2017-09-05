package bodor.com.clipboard;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.graphics.drawable.ClipDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button buttoncopy;
    private Button buttonpast;
    private EditText editTextcopy;
    private EditText editTextpast;
    private ClipboardManager clipboardManager;
    private ClipData clipData;
    private String text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttoncopy = (Button) findViewById(R.id.btn_copy);
        buttonpast = (Button) findViewById(R.id.btn_past);
        editTextcopy = (EditText) findViewById(R.id.et_copy);
        editTextpast = (EditText) findViewById(R.id.et_past);

        clipboardManager = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);


        buttoncopy.setOnClickListener(this);
        buttonpast.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_copy:
                text = editTextcopy.getText().toString();
                clipData = ClipData.newPlainText("text",text);
                clipboardManager.setPrimaryClip(clipData);
                Toast.makeText(getApplicationContext(),"Copy Success!",Toast.LENGTH_SHORT);
                break;
            case R.id.btn_past:
                ClipData data =clipboardManager.getPrimaryClip();
                ClipData.Item item = data.getItemAt(0);
                String text  = item.getText().toString();
                editTextpast.setText(text);
                Toast.makeText(getApplicationContext(),"Past Success!",Toast.LENGTH_SHORT);
                break;
        }

    }
}
