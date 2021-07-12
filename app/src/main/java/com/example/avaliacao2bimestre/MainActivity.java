package com.example.avaliacao2bimestre;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    //atributos - tela
    private EditText txtNome;
    private ImageView imgVolta;

    private CheckBox chkPar;
    private CheckBox chkImpar;
    private CheckBox chkPar2;
    private CheckBox chkImpar2;

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

    //atributos - código
    private String nome;
    private int escolhaUsuario = 0;
    private boolean par = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ligando os atributos com os objetos da interface

        txtNome = findViewById(R.id.txtNome);
        imgVolta = findViewById(R.id.imgVolta);

        chkPar = findViewById(R.id.chkPar);
        chkImpar = findViewById(R.id.chkImpar);
        chkPar2 = findViewById(R.id.chkPar2);
        chkImpar2 = findViewById(R.id.chkImpar2);

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

        //escutador do botão para começar
        btnComecar.setOnClickListener(new EscutadorBotaoComecar());

        // Criando um objeto escutador de cliques das imagens:
        EscutadorClickImagem eci = new EscutadorClickImagem();

        // Associando o objeto criado acima nas imagens:
        img1.setOnClickListener( eci );
        img2.setOnClickListener( eci );
        img3.setOnClickListener( eci );
        img4.setOnClickListener( eci );
        img5.setOnClickListener( eci );
        imgVolta.setOnClickListener( eci );

        // Criando um objeto escutador de cliques dos checkboxs:
        EscutadorCheckBox checked = new EscutadorCheckBox();

        // Associando o objeto criado acima nos checkboxs:
        chkImpar.setOnClickListener( checked );
        chkPar.setOnClickListener( checked );
    }

    class EscutadorBotaoComecar implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            nome = txtNome.getText().toString();
            if(!txtNome.getText().toString().isEmpty() && escolhaUsuario != 0 && escolhaUsuario != 6){

                // bloqueamos a edição do nome
                // pq só poderá mudar se iniciar o jogo do zero
                txtNome.setEnabled(false);

                //vamos a checkbox do app
                if (par){
                    //app = ímpar
                    chkImpar2.setChecked(true);
                    chkPar2.setChecked(false);
                }else{
                    //app = par
                    chkImpar2.setChecked(false);
                    chkPar2.setChecked(true);
                }

                // Vamos gerar aleatoriamente a escolha do app.
                // O método nextInt(n) gera um número aleatório entre 0 e (n-1).
                // Como queremos de 1 a 3, geramos de 0 a 2, e somamos 1.

                int escolhaApp = new Random().nextInt(4) + 1;

                // Precisamos colocar a imagem correta que reflete
                // A escolha do App:

                switch ( escolhaApp ) {
                    case 1:
                        imgApp.setImageResource(R.drawable.um);
                        break;
                    case 2:
                        imgApp.setImageResource(R.drawable.dois);
                        break;
                    case 3:
                        imgApp.setImageResource(R.drawable.tres);
                        break;
                    case 4:
                        imgApp.setImageResource(R.drawable.quatro);
                        break;
                    case 5:
                        imgApp.setImageResource(R.drawable.cinco);
                        break;
                }

                // vamos somar as duas escolhas
                // vemos se deu par ou ímpar
                // vamos verificar qual foi a escolha do usuário
                // exibir resultado

                if( (escolhaApp + escolhaUsuario) % 2 == 0){
                    //par
                    if(par){
                        lblResult.setText(nome + " ganhou!");
                        lblResultVc.setText(Integer.parseInt((String) lblResultVc.getText())+1);
                    }else{
                        lblResult.setText(nome + ", você perdeu =(");
                        lblResultApp.setText(Integer.parseInt((String) lblResultApp.getText())+1);
                    }
                }else{
                    //ímpar
                    if(!par){
                        lblResult.setText(nome + " ganhou!");
                        lblResultVc.setText(Integer.parseInt((String) lblResultVc.getText())+1);
                    }else{
                        lblResult.setText(nome + ", você perdeu =(");
                        lblResultApp.setText(Integer.parseInt((String) lblResultApp.getText())+1);
                    }
                }
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
                    System.exit(0);
                    break;
            }
        }
    }

    // escutador das checkboxs
    // o usuário só poderá clicar nos dois primeiros checkbox
    private class EscutadorCheckBox implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            CheckBox chk = (CheckBox) v;

            switch ( chk.getId() ){
                //se selecionar PAR
                //impar será descelecionado
                case R.id.chkPar:
                    chkImpar.setChecked(false);
                    //o boolean 'par' recebe true
                    //quando par for selecionado
                    par = true;
                    break;

                //se selecionar IMPAR
                //par será descelecionado
                case R.id.chkImpar:
                    chkImpar.setChecked(true);
                    //o boolean 'par' recebe false
                    //quando impar for selecionado
                    par = false;
                    break;
            }
        }
    }
}
