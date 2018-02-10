/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.antlr4.notacao.modelo;

import app.antlr4.notacao.gramatica.GramaticaPreFixaLexer;
import app.antlr4.notacao.gramatica.GramaticaPreFixaParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

/**
 *
 * @author nildo
 */
public class NotacaoPreFixa {

    private final String expressao;

    public NotacaoPreFixa(String expressao) {
        this.expressao = expressao;
    }

    public String getNotacaoPreFixa() {
        ANTLRInputStream inputStream = new ANTLRInputStream(this.expressao);
        GramaticaPreFixaLexer lexer = new GramaticaPreFixaLexer(inputStream);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        GramaticaPreFixaParser parser = new GramaticaPreFixaParser(tokenStream);
        String notacaoPreFixa = parser.expr().prefixa;
        return notacaoPreFixa;
    }

    public String getExpressao() {
        return expressao;
    }

}
