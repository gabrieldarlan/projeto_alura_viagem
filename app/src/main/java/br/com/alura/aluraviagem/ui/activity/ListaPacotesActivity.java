package br.com.alura.aluraviagem.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.List;

import br.com.alura.aluraviagem.R;
import br.com.alura.aluraviagem.dao.PacoteDao;
import br.com.alura.aluraviagem.model.Pacote;
import br.com.alura.aluraviagem.ui.adapter.ListaPacotesAdapter;

public class ListaPacotesActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Pacotes";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_lista_pacotes);

        setTitle(TITULO_APPBAR);

        configuraLista();

    }

    private void configuraLista() {
        ListView listaDePacotes = findViewById(R.id.lista_pacotes_listview);
        List<Pacote> pacotes = new PacoteDao().lista();
        listaDePacotes.setAdapter(new ListaPacotesAdapter(pacotes, this));
    }
}
