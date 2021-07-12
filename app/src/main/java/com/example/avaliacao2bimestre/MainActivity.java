package com.example.avaliacao2bimestre;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //atributos
    private EditText txtNome;
    private ImageView imgVolta;

    private ImageView img1;
    private ImageView img2;
    private ImageView img3;
    private ImageView img4;
    private ImageView img5;
    private ImageView imgApp;

    private Button btnComecar;

    private TextView lblResult;
    private TextView lblResultVc;
    private TextView lblResultApp;


    private String nome;
    private int escolhaUsuario = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ligando os atributos com os objetos da interface

        txtNome = findViewById(R.id.txtNome);
        imgVolta = findViewById(R.id.imgVolta);

        img1 = findViewById(R.id.img1);
        img2 = findViewById(R.id.img2);
        img3 = findViewById(R.id.img3);
        img4 = findViewById(R.id.img4);
        img5 = findViewById(R.id.img5);
        imgApp = findViewById(R.id.imgApp);

        btnComecar = findViewById(R.id.btnComecar);

        lblResult = findViewById(R.id.lblResult);
        lblResultVc = findViewById(R.id.lblResultVc);
        lblResultApp = findViewById(R.id.lblResultApp);

        //escutadores

        btnComecar.setOnClickListener(new EscutadorBotaoComecar());

    }

    class EscutadorBotaoComecar implements View.OnClickListener {
        @Override
        public void onClick(View v) {

            nome = txtNome.getText().toString();
            if(!txtNome.getText().toString().isEmpty() && escolhaUsuario != 0 && escolhaUsuario != 6){

            }

        }
    }

    // classe interna para tratar os cliques nas imagens

    private class EscutadorClickImagem implements View.OnClickListener {
        @Override
        public void onClick(View view) {

            // Precisamos identificar qual imagem o usuário clicou.
            // Devemos converter View em ImageView, e depois utilizar o metodo getId().
            ImageView img = (ImageView) view;
            switch (img.getId()) {
                case R.id.img1:
                    escolhaUsuario = 1;
                    break;
                case R.id.img2:
                    escolhaUsuario = 2;
                    break;
                case R.id.img3:
                    escolhaUsuario = 3;
                    break;
                case R.id.img4:
                    escolhaUsuario = 4;
                    break;
                case R.id.img5:
                    escolhaUsuario = 5;
                    break;
                case R.id.imgVolta:
                    escolhaUsuario = 6;
                    break;
            }
        }
    }
}
//----------------------------------------------------------------------------------------------------------------------------------------------
//            // Vamos gerar aleatoriamente a escolha do app.
//            // O método nextInt(n) gera um número aleatório entre 0 e (n-1).
//            // Como queremos de 1 a 3, geramos de 0 a 2, e somamos 1.
//            // OBS: Isso é Java básico!!!
//            int escolhaApp = new Random().nextInt(3) + 1;
//            // Precisamos colocar a imagem correta que reflete
//            // A escolha do App:
//            switch ( escolhaApp ) {
//                case 1:
//                    imgApp.setImageResource(R.drawable.pedra);
//                    break;
//                case 2:
//                    imgApp.setImageResource(R.drawable.papel);
//                    break;
//                case 3:
//                    imgApp.setImageResource(R.drawable.tesoura);
//                    break;
//            }
////----------------------------------------------------------------------------
//            // Vamos ver quem ganhou... e informar o resultado.
//            if ( ( escolhaApp == 1 && escolhaUsuario == 3 ) ||
//                    ( escolhaApp == 2 && escolhaUsuario == 1 ) ||
//                    ( escolhaApp == 3 && escolhaUsuario == 2 ) )
//            {
//                lblResultado.setText("O app ganhou!!!!");
//            }
//            else
//            {
//                if ( (escolhaApp == 3 && escolhaUsuario == 1) ||
//                        (escolhaApp == 1 && escolhaUsuario == 2) ||
//                        (escolhaApp == 2 && escolhaUsuario == 3) )
//                {
//                    lblResultado.setText("Você ganhou!!");
//                }
//                else
//                {
//                    lblResultado.setText("Deu empate!");
//                }
//            }
//        }
//    }
