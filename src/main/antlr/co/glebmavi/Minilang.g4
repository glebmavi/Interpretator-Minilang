grammar Minilang;

program: statement+ ;

statement
    : assignment ';'
    | ifStatement
    | whileStatement
    | printStatement ';'
    ;

assignment  : Identifier '=' expression ;
ifStatement : 'if' '(' expression ')' block ( 'else' block )? ;
whileStatement : 'while' '(' expression ')' block ;
printStatement : 'print' '(' expression ')' ;

block       : '{' statement+ '}' ;

expression
    : '-' expression
    | expression op=('*'|'/') expression
    | expression op=('+'|'-') expression
    | expression '%' expression
    | expression compOp expression
    | '(' expression ')'
    | Number
    | StringLiteral
    | Identifier
    ;

compOp
    : '<'
    | '>'
    | '<='
    | '>='
    | '=='
    ;

Identifier  : [a-zA-Z_][a-zA-Z_0-9]* ;
Number      : [0-9]+ ;
StringLiteral : '\'' (~['\r\n])* '\'' | '"' (~["\r\n])* '"' ;
WS          : [ \t\r\n]+ -> skip ;
