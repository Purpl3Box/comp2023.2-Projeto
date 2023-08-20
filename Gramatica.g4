grammar Gramatica;
@header{
    import comp.src.datastructures.*;
    import comp.src.ast.*;
    import java.util.ArrayList;
    import java.util.List;
    import java.util.Stack;
}

@members{
    private int _tipo;
    private String _varName;
    private String _varValue;
    private List<String> _variaveisSemUso = new ArrayList<String>();
    private Simbolos symbol;
    private SimbolosTable symbolTable = new SimbolosTable();

    private Program program = new Program();
    private ArrayList<AbstractCommand> currentThread;

    private Stack<ArrayList<AbstractCommand>> allcomandos = new Stack<ArrayList<AbstractCommand>>();

    private String _commandId;
    private String _expressionId;
    private String _expressionContent;
    private Stack<String> _expressionConditionStack = new Stack<String>();
    private String _expressionCondition;
    private String _expressionWhileCondition;
    private Stack<String> _expressionWhileConditionStack = new Stack<String>();
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
           throw new Exception("Simbolo nao declarado no input: "+id);
       }
    }
    public void verifyType(String id, int type) throws Exception{
       if (((Variaveis) symbolTable.get(id)).getType() != type){
           throw new Exception("Simbolo com tipo errado: "+id);
       }
    }
}

program  : 'programa' declara bloco 'fimprog;' {
    program.setVartable(symbolTable);
    program.setcomandos(allcomandos.pop());
    if(_variaveisSemUso.size() > 0){
        System.err.println("Variaveis sem uso: "+_variaveisSemUso);
    }
}
;

declara: (declaracao)+;

declaracao : 'declare' type ID  {
	                  _varName = _input.LT(-1).getText();
	                  _varValue = null;
	                  symbol = new Variaveis(_varName, _tipo, _varValue);
	                  if (!symbolTable.exists(_varName)){
	                     symbolTable.add(symbol);
	                     _variaveisSemUso.add(_varName);
	                  }
	                  else{
	                  	 throw new Exception("Variavel ja declarada: " +_varName);
	                  }
                    }
              (  VIR
              	 ID {
	                  _varName = _input.LT(-1).getText();
	                  _varValue = null;
	                  symbol = new Variaveis(_varName, _tipo, _varValue);
	                  if (!symbolTable.exists(_varName)){
	                    symbolTable.add(symbol);
	                    _variaveisSemUso.add(_varName);
	                  }
	                  else{
	                  	 throw new Exception("Variavel ja declarada: " +_varName);
	                  }
                    }
              )*
               SC
;

bloco : {
    currentThread = new ArrayList<AbstractCommand>();
    allcomandos.push(currentThread);
}
        (cmd)+
;

cmd: cmdLeitura
    | cmdEscrita
    | cmdExpr
    | cmdIf
    | cmdWhile;

cmdLeitura : 'leia' AP
               ID {
                   verifyID(_input.LT(-1).getText());
                   _commandId = _input.LT(-1).getText();
               }
               FP
               SC {
                    Variaveis var = (Variaveis) symbolTable.get(_commandId);
                    cmdLe command = new cmdLe(_commandId, var);
                    allcomandos.peek().add(command);
               }
;

cmdEscrita: 'escreva' AP
                        ID {
                            verifyID(_input.LT(-1).getText());
                            _commandId = _input.LT(-1).getText();
                        }

                        FP
                        SC {
                            cmdEscreve command = new cmdEscreve(_commandId);
                            allcomandos.peek().add(command);
                        }
;


cmdExpr: ID {
                   _varName = _input.LT(-1).getText();
                   verifyID(_varName);
                   _variaveisSemUso.remove(_varName);
                   _expressionId = _varName;
               }
               ATTR { _expressionContent = ""; }
               expr
               SC {
                   verifyType(_varName, _tipo);
                   cmdAtribui command = new cmdAtribui(_expressionId, _expressionContent);
                   allcomandos.peek().add(command);
               }
;

cmdIf: 'se' AP
                (
                (
                (ID | NUMBER | TEXT) {
                    _expressionCondition = _input.LT(-1).getText();
                }
                OR { _expressionCondition += _input.LT(-1).getText(); }
                (ID | NUMBER | TEXT) { _expressionCondition += _input.LT(-1).getText(); }
                )
                )
                FP {
                    _expressionConditionStack.push(_expressionCondition);
                }
                AC {
                    currentThread = new ArrayList<AbstractCommand>();
                    allcomandos.push(currentThread);
                }
                (cmd)+
                FC {
                    TipoLista = allcomandos.pop();
                }
                ( 'senao'
                  AC {
                      currentThread = new ArrayList<AbstractCommand>();
                      allcomandos.push(currentThread);
                  }
                  (cmd)+
                  FC {
                      NaoLista = allcomandos.pop();
                      cmdIf command = new cmdIf(_expressionConditionStack.pop(), TipoLista, NaoLista);
                      allcomandos.peek().add(command);
                  }
                )?
                {
                      if(NaoLista == null){
                          cmdIf command = new cmdIf(_expressionConditionStack.pop(), TipoLista, new ArrayList<AbstractCommand>());
                          allcomandos.peek().add(command);
                      }
                      NaoLista = null;
                }
;

cmdWhile: 'enquanto' AP
                (
                (
                (ID | NUMBER | TEXT) { _expressionWhileCondition = _input.LT(-1).getText(); }
                OR { _expressionWhileCondition += _input.LT(-1).getText(); }
                (ID | NUMBER | TEXT) { _expressionWhileCondition += _input.LT(-1).getText(); }
                )
                )
                FP {
                     _expressionWhileConditionStack.push(_expressionWhileCondition);
                }
                AC {
                    currentThread = new ArrayList<AbstractCommand>();
                    allcomandos.push(currentThread);
                }
                (cmd)+
                FC {
                    whileList = allcomandos.pop();
                    cmdWhile command = new cmdWhile(_expressionWhileConditionStack.pop(), whileList);
                    allcomandos.peek().add(command);
                }
;

expr: termo (OP { _expressionContent += _input.LT(-1).getText(); }
            expr)? |
            RZ { _expressionContent += _input.LT(-1).getText(); }
            termo (
            OP { _expressionContent += _input.LT(-1).getText(); }
            expr)? 
;

termo: ID { verifyID(_input.LT(-1).getText());
                  _tipo = ((Variaveis) symbolTable.get(_input.LT(-1).getText())).getType();
                  _expressionContent += _input.LT(-1).getText();
                }
    | NUMBER {
        _tipo = Variaveis.NUMBER;
        _expressionContent += _input.LT(-1).getText();
    }
    | TEXT {
        _tipo = Variaveis.TEXT;
        _expressionContent += _input.LT(-1).getText();
    }
;

type: 'texto'{_tipo = Variaveis.TEXT;} | 'numero'{_tipo = Variaveis.NUMBER;};

RZ  :   'raiz';

AP	: '(';

FP	: ')';

AC  : '{';

FC  : '}';

SC	: ';';

OP	: '+' | '-' | '*' | '/' | '**';

ATTR : ':=';

OR    : '>' | '<' | '>=' | '<=' | '==' | '!=';

ID	: [a-z] ([a-z] | [A-Z] | [0-9])*;

NUMBER	: [0-9]+ ('.' [0-9]+)?;

TEXT: AD (  [a-z] | [A-Z] | [0-9] | ' ' )+ AD;

VIR: ',';

AD: '"';

WS	: (' ' | '\t' | '\n' | '\r') -> skip;