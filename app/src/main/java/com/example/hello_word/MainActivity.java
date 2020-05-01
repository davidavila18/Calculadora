package com.example.hello_word;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.text.DecimalFormat;
import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    EditText nVO;
    EditText nVSA;
    EditText nDMO;
    TextView nVTO;
    TextView nVMN;

    DecimalFormat fmt = new DecimalFormat("$ ###,###,###.00");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nVO = findViewById(R.id.vo);
        nVSA = findViewById(R.id.vsa);
        nDMO = findViewById(R.id.dmo);
        nVTO = findViewById(R.id.tVTO);
        nVMN = findViewById(R.id.tVMN);
    }

    public void Button(View view) {

        String cVO = nVO.getText().toString();
        String cVSA = nVSA.getText().toString();
        String cDMO = nDMO.getText().toString();

        double VTAD=0, VMN=0;
        if ((cVO.isEmpty() || cVSA.isEmpty()) || cDMO.isEmpty()) {
            Toast toast=Toast.makeText(this,"Llene todos los campos",Toast.LENGTH_SHORT);
            toast.show();
        }
        else {
            int VO = Integer.parseInt(cVO);
            int VSA = Integer.parseInt(cVSA);
            int DMO = Integer.parseInt(cDMO);
            VTAD = VO * 1.2142;
            //VTAD = Format(VTAD, "$#,##")
            if (DMO <= 210) {
                VMN = VSA * 1.2142;
                //777
            } else if (DMO >= 211 && DMO <= 360) {
                VMN = VSA * 0.9 * 1.2142;
            } else if (DMO >= 361 && DMO <= 540) {
                VMN = VSA * 0.8 * 1.2142;
            } else if (DMO >= 541 && DMO <= 720) {
                VMN = VSA * 0.7 * 1.2142;
            } else if (DMO >= 721) {
                VMN = VSA * 0.6 * 1.2142;
            }

            if ((VSA - VMN) >= 5000000) {
                VMN = VSA - 5000000;
            }
            Toast toast2=Toast.makeText(this,"Nuevo resultado",Toast.LENGTH_LONG);
            toast2.show();
            String x=(fmt.format(VTAD));
            nVTO.setText(x);
            nVMN.setText(fmt.format(VMN));

        }
    }
    public void Limpiar (View view){
        nVO.setText("");
        nVSA.setText("");
        nDMO.setText("");
        nVTO.setText("0");
        nVMN.setText("0");
    }
}
