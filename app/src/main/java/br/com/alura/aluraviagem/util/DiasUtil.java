package br.com.alura.aluraviagem.util;

public class DiasUtil {

    public static final String PLURA = " dias";
    public static final String SINGULAR = " dia";

    public static String formataEmTexto(int quantidadeDeDias) {
        if (quantidadeDeDias > 1)
            return quantidadeDeDias + PLURA;
        return quantidadeDeDias + SINGULAR;

    }

}
