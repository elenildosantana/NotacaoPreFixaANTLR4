/******************************************************
 * A multi-line Javadoc-like comment about my grammar *
 ******************************************************/
grammar GramaticaPreFixa;

@header {
    package app.antlr4.notacao.gramatica;
}
expr returns[String prefixa]
    :   e1=expr op=(MUL|DIV) e2=expr {$prefixa = $op.text + $e1.prefixa + $e2.prefixa;} #MulDiv
    |   e1=expr op=(ADD|SUB) e2=expr {$prefixa = $op.text + $e1.prefixa + $e2.prefixa;} #AddSub
    |   INT                          {$prefixa = $INT.text;}                            #int
    |   DOUBLE                       {$prefixa = $DOUBLE.text;}                         #double
    |   '(' expr ')'                 {$prefixa = $expr.prefixa;}                        #parens
    ;

INT    :   [0-9]+;
DOUBLE :   [0-9]+'.'[0-9]+;

MUL : '*' ;
DIV : '/' ;
ADD : '+' ;
SUB : '-' ;
WS  : ' ' -> skip;