package projeto006.com.br.projeto006;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    //declarar os atributos da Classe
    EditText edtTempo, edtVelMedia;
    Button btnCalcular, btnLimpar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * Atribuir os componentes visuais da activity_main
         * nos atributos da classe
         */

        edtTempo = (EditText) findViewById(R.id.edtTempo);
        edtVelMedia = (EditText) findViewById(R.id.edtVelMedia);

        btnCalcular = (Button) findViewById(R.id.btnCalcular);
        btnLimpar = (Button) findViewById(R.id.btnLimpar);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edtTempo.getText().length() <= 0 ||
                        edtVelMedia.getText().length() <= 0) {
                    Toast.makeText(getBaseContext(), "Informe TODOS os campos!!!",
                            Toast.LENGTH_SHORT).show();
                    edtTempo.requestFocus();
                } else {
                    Double tempo = Double.parseDouble(edtTempo.getText().toString());
                    Double velocidade = Double.parseDouble(edtVelMedia.getText().toString());

                    Double distancia = (tempo * velocidade);

                    Double litros_usados = (distancia / 12);

                    AlertDialog.Builder alerta = new
                            AlertDialog.Builder(MainActivity.this);

                    alerta.setTitle("QUANTIDADE DE LITROS");
                    alerta.setMessage("A velocidade média é : "
                            + new DecimalFormat("0.00").format(velocidade)
                            + ("\ne Tempo gasto na viagem foi de : ")
                            + new DecimalFormat("0.00").format(tempo)
                            +(" horas.")
                            +("\nA distância percorrida foi : ")
                            + new DecimalFormat("0.00").format(distancia)
                            +(" km")
                            + ("\ne a quantidade de litros gastos foi de : ")
                            + new DecimalFormat("0.00").format(litros_usados));
                    alerta.setNeutralButton("Fechar", null);
                    alerta.show();
                }
            }
        });

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtTempo.setText("");
                edtVelMedia.setText("");
                edtTempo.requestFocus();
            }
        });
    }
}
