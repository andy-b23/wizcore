package engelbergbleyel.at.wizcore;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class StartTutorial extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_tutorial);

        Button button = (Button) findViewById(R.id.btn_toMain);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CheckBox cb = (CheckBox) findViewById(R.id.chk_tut);

                if (cb.isChecked()) {
                    Log.i("A","cb checked");

                    SharedPreferences sharedPref = StartTutorial.this.getSharedPreferences("tut",Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPref.edit();
                    editor.putBoolean("tut", false);
                    editor.commit();
                }
                startActivity(new Intent(StartTutorial.this, MainMenu.class));
            }
        });
    }
}
