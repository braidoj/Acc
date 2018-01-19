package com.example.sony.acc;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements SensorEventListener {

    //Cria um objeto para o sensor do acelerômetro
    private Sensor meuAcelerômetro;

    // Criado para acessar o acelerômetro
    private SensorManager gerenciamentoAcelerômetro;

    // Cria um objeto para o TextView
    private TextView visorDoTextoX, visorDoTextoY,visorDoTextoZ;

    // Cria a tela inicial do applicativo
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Cria o gerenciador do acelerômetro//
        gerenciamentoAcelerômetro = (SensorManager)getSystemService(SENSOR_SERVICE);

        //Cria o acelerômetro
        meuAcelerômetro = gerenciamentoAcelerômetro.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        //Registra o sensor
        gerenciamentoAcelerômetro.registerListener(this,meuAcelerômetro,SensorManager.SENSOR_DELAY_NORMAL);

        //Atribui as TextViews a cada eixo
        visorDoTextoX = (TextView) findViewById(R.id.visorDoTextoX);
        visorDoTextoY = (TextView)findViewById(R.id.visorDoTextoY);
        visorDoTextoZ = (TextView)findViewById(R.id.visorDoTextoZ);

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {
        /*método não utilizado - chamado pois todos códigos utilizados como exemplo
         *apresentam este método
        */

    }

    @Override
    //Faz a leitura da aceleração em cada eixo
    public void onSensorChanged(SensorEvent sensorEvent) {
        visorDoTextoX.setText("X= " + sensorEvent.values[0]);
        visorDoTextoY.setText("Y= " + sensorEvent.values[1]);
        visorDoTextoZ.setText("Z= " + sensorEvent.values[2]);

    }

    //Estabelece o método para acionar o botão de salvamento de dados
    //Liga o código java com o botão adicionado na interface
    //final Button salvarDadosButton = findViewById(R.id.salvarBotao);

    //Cria um objeto de arquivo
    //File AceleracaoTxt = new File;


}
