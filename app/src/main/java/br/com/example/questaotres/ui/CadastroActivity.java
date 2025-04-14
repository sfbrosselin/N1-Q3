package br.com.example.questaotres.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import br.com.example.questaotres.R;
import br.com.example.questaotres.utils.VoltarFunc;

public class CadastroActivity extends AppCompatActivity {

    public static final String EXTRA_NOME = "br.com.example.questaotres.extra_nome";
    private Button btnCadastrar, btnVoltar;
    private TextInputLayout inputNomeLayout;
    private TextInputEditText inputName;;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cadastro);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.cadastro), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        inputNomeLayout = findViewById(R.id.inputNomeLayout);
        inputName = findViewById(R.id.inputNome);
        btnCadastrar = findViewById(R.id.btnCadastrar);
        btnVoltar = findViewById(R.id.btnVoltar);


        VoltarFunc voltarFunc = new VoltarFunc();
        voltarFunc.voltarFunction(btnVoltar, this);

        btnCadastrar.setOnClickListener(view -> {
            if (validarCampo()) {
                getNome();
            } else {
                inputNomeLayout.setError("Preencha seu nome!");
            }
        });



    }

    public void getNome(){
        Intent intent = new Intent(this, HomeActivity.class);
        String nome = inputName.getText().toString();

        Bundle bundle = new Bundle();
        bundle.putString(EXTRA_NOME, nome);
        intent.putExtras(bundle);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(intent);
            }
        },2000);
        Toast.makeText(this, "Carregando...", Toast.LENGTH_SHORT).show();
    }

    public boolean validarCampo(){
        inputName.findViewById(R.id.inputNome);

        String nome = inputName.getText().toString().trim();

        return !nome.isEmpty();
    }

}

