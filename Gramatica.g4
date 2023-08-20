grammar Gramatica;
@header{
    import comp.src.datastructures.*;
    import comp.src.ast.*;
    import java.util.ArrayList;
    import java.util.List;
    import java.util.Stack;
}

@members{
    private int _type;
    private String _varName;
    private String _varValue;
    private List<String> _unusedVariables = new ArrayList<String>();
    private Simbolos symbol;
    private SimbolosTable symbolTable = new SimbolosTable();

    private Program program = new Program();
    private ArrayList<AbstractCommand> currentThread;

    private Stack<ArrayList<AbstractCommand>> allcomandos = new Stack<ArrayList<AbstractCommand>>();

    private String _commandId;
    private String _expId;
    private String _expContent;
    private Stack<String> _expcondicaoStack = new Stack<String>();
    private String _expcondicao;
    private String _expWhilecondicao;
    private Stack<String> _expWhilecondicaoStack = new Stack<String>();
    private ArrayList<AbstractCommand> TipoLista;
    private ArrayList<AbstractCommand> NaoLista;
    private ArrayList<AbstractCommand> whileList;

    public void exibeComandos(){
        for (AbstractCommand c : program.getcomandos()){
             System.out.println(c);
        }
    }
    public void generateCode(){
        program.generateTarget();
    }

    public void verifyID(String id) throws Exception{
       if (!symbolTable.exists(id)){
           throw new Exception("Symbol "+id+" not declared");
       }
    }
    public void verifyType(String id, int type) throws Exception{
       if (((Variaveis) symbolTable.get(id)).getType() != type){
           throw new Exception("Symbol "+id+" has wrong type");
       }
    }
}

program  : 'programa' declaration block 'fimprog;' {
    program.setVartable(symbolTable);
    program.setcomandos(allcomandos.pop());
    if(_unusedVariables.size() > 0){
        System.err.println("Unused variables: "+_unusedVariables);
    }
}
;

declaration: (declarationStatement)+;

declarationStatement : 'declara' type IDENTIFIER  {
	                  _varName = _input.LT(-1).getText();
	                  _varValue = null;
	                  symbol = new Variaveis(_varName, _type, _varValue);
	                  if (!symbolTable.exists(_varName)){
	                     symbolTable.add(symbol);
	                     _unusedVariables.add(_varName);
	                  }
	                  else{
	                  	 throw new Exception("Symbol "+_varName+" already declared");
	                  }
                    }
              (  COMMA
              	 IDENTIFIER {
	                  _varName = _input.LT(-1).getText();
	                  _varValue = null;
	                  symbol = new Variaveis(_varName, _type, _varValue);
	                  if (!symbolTable.exists(_varName)){
	                    symbolTable.add(symbol);
	                    _unusedVariables.add(_varName);
	                  }
	                  else{
	                  	 throw new Exception("Symbol "+_varName+" already declared");
	                  }
                    }
              )*
               SEMICOLON
;

block : {
    currentThread = new ArrayList<AbstractCommand>();
    allcomandos.push(currentThread);
}
        (command)+
;

command: cmdLe
       | cmdEscreve
       | cmdAtribui
       | cmdIf
       | cmdWhile
;

cmdLe : 'leia' OPENPARENTHESIS
               IDENTIFIER {
                   verifyID(_input.LT(-1).getText());
                   _commandId = _input.LT(-1).getText();
               }
               CLOSEPARENTHESIS
               SEMICOLON {
                    Variaveis var = (Variaveis) symbolTable.get(_commandId);
                    cmdLe command = new cmdLe(_commandId, var);
                    allcomandos.peek().add(command);
               }
;

cmdEscreve: 'escreva' OPENPARENTHESIS
                        IDENTIFIER {
                            verifyID(_input.LT(-1).getText());
                            _commandId = _input.LT(-1).getText();
                        }

                        CLOSEPARENTHESIS
                        SEMICOLON {
                            cmdEscreve command = new cmdEscreve(_commandId);
                            allcomandos.peek().add(command);
                        }
;


cmdAtribui: IDENTIFIER {
                   _varName = _input.LT(-1).getText();
                   verifyID(_varName);
                   _unusedVariables.remove(_varName);
                   _expId = _varName;
               }
               ATTRIBUTION { _expContent = ""; }
               exp
               SEMICOLON {
                   verifyType(_varName, _type);
                   cmdAtribui command = new cmdAtribui(_expId, _expContent);
                   allcomandos.peek().add(command);
               }
;

cmdIf: 'se' OPENPARENTHESIS
                (
                (
                (IDENTIFIER | NUMBER | TEXT) {
                    _expcondicao = _input.LT(-1).getText();
                }
                RELATIONALOPERATOR { _expcondicao += _input.LT(-1).getText(); }
                (IDENTIFIER | NUMBER | TEXT) { _expcondicao += _input.LT(-1).getText(); }
                )
                )
                CLOSEPARENTHESIS {
                    _expcondicaoStack.push(_expcondicao);
                }
                OPENBRACKETS {
                    currentThread = new ArrayList<AbstractCommand>();
                    allcomandos.push(currentThread);
                }
                (command)+
                CLOSEBRACKETS {
                    TipoLista = allcomandos.pop();
                }
                ( 'senao'
                  OPENBRACKETS {
                      currentThread = new ArrayList<AbstractCommand>();
                      allcomandos.push(currentThread);
                  }
                  (command)+
                  CLOSEBRACKETS {
                      NaoLista = allcomandos.pop();
                      cmdIf command = new cmdIf(_expcondicaoStack.pop(), TipoLista, NaoLista);
                      allcomandos.peek().add(command);
                  }
                )?
                {
                      if(NaoLista == null){
                          cmdIf command = new cmdIf(_expcondicaoStack.pop(), TipoLista, new ArrayList<AbstractCommand>());
                          allcomandos.peek().add(command);
                      }
                      NaoLista = null;
                }
;

cmdWhile: 'enquanto' OPENPARENTHESIS
                (
                (
                (IDENTIFIER | NUMBER | TEXT) { _expWhilecondicao = _input.LT(-1).getText(); }
                RELATIONALOPERATOR { _expWhilecondicao += _input.LT(-1).getText(); }
                (IDENTIFIER | NUMBER | TEXT) { _expWhilecondicao += _input.LT(-1).getText(); }
                )
                )
                CLOSEPARENTHESIS {
                     _expWhilecondicaoStack.push(_expWhilecondicao);
                }
                OPENBRACKETS {
                    currentThread = new ArrayList<AbstractCommand>();
                    allcomandos.push(currentThread);
                }
                (command)+
                CLOSEBRACKETS {
                    whileList = allcomandos.pop();
                    cmdWhile command = new cmdWhile(_expWhilecondicaoStack.pop(), whileList);
                    allcomandos.peek().add(command);
                }
;

exp: term (OPERATOR { _expContent += _input.LT(-1).getText(); }
            exp)? |
            SINGLETERMOPERATOR { _expContent += _input.LT(-1).getText(); }
            term (
            OPERATOR { _expContent += _input.LT(-1).getText(); }
            exp)? 
;

term: IDENTIFIER { verifyID(_input.LT(-1).getText());
                  _type = ((Variaveis) symbolTable.get(_input.LT(-1).getText())).getType();
                  _expContent += _input.LT(-1).getText();
                }
    | NUMBER {
        _type = Variaveis.NUMBER;
        _expContent += _input.LT(-1).getText();
    }
    | TEXT {
        _type = Variaveis.TEXT;
        _expContent += _input.LT(-1).getText();
    }
;

type: 'texto'{_type = Variaveis.TEXT;} | 'numero'{_type = Variaveis.NUMBER;};

SINGLETERMOPERATOR  :   'raiz' | 'log';

OPENPARENTHESIS	: '(';

CLOSEPARENTHESIS	: ')';

OPENBRACKETS  : '{';

CLOSEBRACKETS  : '}';

SEMICOLON	: ';';

OPERATOR	: '+' | '-' | '*' | '/' | '**';

ATTRIBUTION : '=';

RELATIONALOPERATOR    : '>' | '<' | '>=' | '<=' | '==' | '!=';

IDENTIFIER	: [a-z] ([a-z] | [A-Z] | [0-9])*;

NUMBER	: [0-9]+ ('.' [0-9]+)?;

TEXT: DOUBLEQUOTE (  [a-z] | [A-Z] | [0-9] | ' ' )+ DOUBLEQUOTE;

COMMA: ',';

DOUBLEQUOTE: '"';

WHITESPACE	: (' ' | '\t' | '\n' | '\r') -> skip;