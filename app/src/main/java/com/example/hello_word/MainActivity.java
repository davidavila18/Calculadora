package com.example.hello_word;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText nVO;
    EditText nVSA;
    EditText nDMO;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nVO = findViewById(R.id.vo);
        nVSA = findViewById(R.id.vsa);
        nDMO = findViewById(R.id.dmo);
    }
    public void boton1(View view){
        String cVO = VO.getText().toString();
        int VO=Integer.parseInt(cVO);
        String cVSA = VSA.getText().toString();
        int VSA=Integer.parseInt(cVSA);
        String cDMO = DMO.getText().toString();
        int DMO=Integer.parseInt(cDMO);

        if((VO=0) & (VSA = 0) & (DMO = 0)){
            Toast.makeText(this,"LLene los campos");
        }
        else{
            VTAD = VO * 1.2142;
            //VTAD = Format(VTAD, "$#,##")
            if (DMO <=210) {
                VMN = VSA * 1.2142;
                //777
            }
            else if( DMO >= 211 & DMO <= 360) {
                VMN = VSA * 0.9 * 1.2142;
            }
            else if( DMO >= 361 & DMO <= 540) {
                VMN = VSA * 0.8 * 1.2142;
            }
            else if(DMO >= 541 & DMO <= 720){
                VMN = VSA * 0.7 * 1.2142;
            }
            else if( DMO >= 721){
                VMN=VSA*0.6*1.2142;
            }

            if((VSA - VMN) >= 5000000){
                VMN = VSA - 5000000
            }
    }

}
