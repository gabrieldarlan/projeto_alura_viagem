package br.com.alura.aluraviagem.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.math.BigDecimal;

import br.com.alura.aluraviagem.PagamentoActivity;
import br.com.alura.aluraviagem.R;
import br.com.alura.aluraviagem.model.Pacote;
import br.com.alura.aluraviagem.util.DataUtil;
import br.com.alura.aluraviagem.util.DiasUtil;
import br.com.alura.aluraviagem.util.MoedaUtil;
import br.com.alura.aluraviagem.util.ResourcesUtil;

public class ResumoPacoteActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Resumo do pacote";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_pacote);
        setTitle(TITULO_APPBAR);

        Pacote pacoteSaoPaulo =
                new Pacote("São Paulo", "@drawable/sao_paulo_sp",
                        2, new BigDecimal("243.99"));

        mostraLocal(pacoteSaoPaulo);
        mostraImagem(pacoteSaoPaulo);
        mostraDias(pacoteSaoPaulo);
        mostraPreco(pacoteSaoPaulo);
        mostraData(pacoteSaoPaulo);

        Intent intent = new Intent(this, PagamentoActivity.class);
        startActivity(intent);
    }

    private void mostraData(Pacote pacote) {
        TextView data = findViewById(R.id.resumo_pacote_data);
        String dataFormadataDaViagem = DataUtil.periodoEmTexto(pacote.getDias());
        data.setText(dataFormadataDaViagem);
    }


    private void mostraPreco(Pacote pacote) {
        TextView preco = findViewById(R.id.resumo_pacote_preco);
        String precoFormatado = MoedaUtil.formataParaBrasileiro(pacote.getPreco());
        preco.setText(precoFormatado);
    }

    private void mostraDias(Pacote pacote) {
        TextView dias = findViewById(R.id.resumo_pacote_dias);
        String diasEmTexto = DiasUtil.formataEmTexto(pacote.getDias());
        dias.setText(diasEmTexto);
    }

    private void mostraImagem(Pacote pacote) {
        ImageView imagem = findViewById(R.id.resumo_pacote_imagem);
        Drawable drawableDoPacote =
                ResourcesUtil.devolveDrawable(this, pacote.getImagem());
        imagem.setImageDrawable(drawableDoPacote);
    }

    private void mostraLocal(Pacote pacote) {
        TextView local = findViewById(R.id.resumo_pacote_local);
        local.setText(pacote.getLocal());
    }
}
