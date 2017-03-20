// Generated from H:\git\decaf-Muzual\Skeleton\tmp/DecafParser.g4 by ANTLR 4.6
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class DecafParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.6", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		CLASS=1, BOOLEAN=2, BREAK=3, CALLOUT=4, CONTINUE=5, ELSE=6, FALSE=7, FOR=8, 
		IF=9, RETURN=10, TRUE=11, VOID=12, INT=13, LCURLY=14, RCURLY=15, SEMICOLON=16, 
		LSQRBRK=17, RSQRBRK=18, COMMA=19, LPAREN=20, RPAREN=21, UNDERSCORE=22, 
		ASSIGNOPERATOR=23, ARITHPLUS=24, ARITHMINUS=25, EXCLMRK=26, ARITHMOD=27, 
		ARITHDIV=28, ARITHMULT=29, GRTTHAN=30, LESTHAN=31, GRTEQUAL=32, LESEQUAL=33, 
		EQUALOP=34, NOTEQUAL=35, AND=36, OR=37, ID=38, WS_=39, SL_COMMENT=40, 
		CHAR_LITERAL=41, STRING_LITERAL=42, BOOL_LITERAL=43, INT_LITERAL=44;
	public static final int
		RULE_program = 0, RULE_field_decl = 1, RULE_field_name = 2, RULE_method_decl = 3, 
		RULE_method_params = 4, RULE_block = 5, RULE_var_decl = 6, RULE_type = 7, 
		RULE_statement = 8, RULE_assign_op = 9, RULE_method_call = 10, RULE_method_name = 11, 
		RULE_location = 12, RULE_expr = 13, RULE_callout_arg = 14, RULE_bin_op = 15, 
		RULE_strong_arith_op = 16, RULE_weak_arith_op = 17, RULE_rel_op = 18, 
		RULE_eq_op = 19, RULE_cond_op = 20, RULE_literal = 21;
	public static final String[] ruleNames = {
		"program", "field_decl", "field_name", "method_decl", "method_params", 
		"block", "var_decl", "type", "statement", "assign_op", "method_call", 
		"method_name", "location", "expr", "callout_arg", "bin_op", "strong_arith_op", 
		"weak_arith_op", "rel_op", "eq_op", "cond_op", "literal"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'class'", "'boolean'", "'break'", "'callout'", "'continue'", "'else'", 
		"'false'", "'for'", "'if'", "'return'", "'true'", "'void'", "'int'", "'{'", 
		"'}'", "';'", "'['", "']'", "','", "'('", "')'", "'_'", "'='", "'+'", 
		"'-'", "'!'", "'%'", "'/'", "'*'", "'>'", "'<'", "'>='", "'<='", "'=='", 
		"'!='", "'&&'", "'||'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "CLASS", "BOOLEAN", "BREAK", "CALLOUT", "CONTINUE", "ELSE", "FALSE", 
		"FOR", "IF", "RETURN", "TRUE", "VOID", "INT", "LCURLY", "RCURLY", "SEMICOLON", 
		"LSQRBRK", "RSQRBRK", "COMMA", "LPAREN", "RPAREN", "UNDERSCORE", "ASSIGNOPERATOR", 
		"ARITHPLUS", "ARITHMINUS", "EXCLMRK", "ARITHMOD", "ARITHDIV", "ARITHMULT", 
		"GRTTHAN", "LESTHAN", "GRTEQUAL", "LESEQUAL", "EQUALOP", "NOTEQUAL", "AND", 
		"OR", "ID", "WS_", "SL_COMMENT", "CHAR_LITERAL", "STRING_LITERAL", "BOOL_LITERAL", 
		"INT_LITERAL"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "DecafParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public DecafParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode CLASS() { return getToken(DecafParser.CLASS, 0); }
		public TerminalNode ID() { return getToken(DecafParser.ID, 0); }
		public TerminalNode LCURLY() { return getToken(DecafParser.LCURLY, 0); }
		public TerminalNode RCURLY() { return getToken(DecafParser.RCURLY, 0); }
		public TerminalNode EOF() { return getToken(DecafParser.EOF, 0); }
		public List<Field_declContext> field_decl() {
			return getRuleContexts(Field_declContext.class);
		}
		public Field_declContext field_decl(int i) {
			return getRuleContext(Field_declContext.class,i);
		}
		public List<Method_declContext> method_decl() {
			return getRuleContexts(Method_declContext.class);
		}
		public Method_declContext method_decl(int i) {
			return getRuleContext(Method_declContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).exitProgram(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(44);
			match(CLASS);
			setState(45);
			match(ID);
			setState(46);
			match(LCURLY);
			setState(50);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(47);
					field_decl();
					}
					} 
				}
				setState(52);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			setState(56);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << VOID) | (1L << INT))) != 0)) {
				{
				{
				setState(53);
				method_decl();
				}
				}
				setState(58);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(59);
			match(RCURLY);
			setState(60);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Field_declContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<Field_nameContext> field_name() {
			return getRuleContexts(Field_nameContext.class);
		}
		public Field_nameContext field_name(int i) {
			return getRuleContext(Field_nameContext.class,i);
		}
		public TerminalNode SEMICOLON() { return getToken(DecafParser.SEMICOLON, 0); }
		public List<TerminalNode> COMMA() { return getTokens(DecafParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(DecafParser.COMMA, i);
		}
		public Field_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_field_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).enterField_decl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).exitField_decl(this);
		}
	}

	public final Field_declContext field_decl() throws RecognitionException {
		Field_declContext _localctx = new Field_declContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_field_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(62);
			type();
			setState(63);
			field_name();
			setState(68);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(64);
				match(COMMA);
				setState(65);
				field_name();
				}
				}
				setState(70);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(71);
			match(SEMICOLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Field_nameContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(DecafParser.ID, 0); }
		public TerminalNode LSQRBRK() { return getToken(DecafParser.LSQRBRK, 0); }
		public TerminalNode INT_LITERAL() { return getToken(DecafParser.INT_LITERAL, 0); }
		public TerminalNode RSQRBRK() { return getToken(DecafParser.RSQRBRK, 0); }
		public Field_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_field_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).enterField_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).exitField_name(this);
		}
	}

	public final Field_nameContext field_name() throws RecognitionException {
		Field_nameContext _localctx = new Field_nameContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_field_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(78);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				{
				setState(73);
				match(ID);
				}
				break;
			case 2:
				{
				setState(74);
				match(ID);
				setState(75);
				match(LSQRBRK);
				setState(76);
				match(INT_LITERAL);
				setState(77);
				match(RSQRBRK);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Method_declContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(DecafParser.ID, 0); }
		public TerminalNode LPAREN() { return getToken(DecafParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(DecafParser.RPAREN, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode VOID() { return getToken(DecafParser.VOID, 0); }
		public Method_paramsContext method_params() {
			return getRuleContext(Method_paramsContext.class,0);
		}
		public Method_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_method_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).enterMethod_decl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).exitMethod_decl(this);
		}
	}

	public final Method_declContext method_decl() throws RecognitionException {
		Method_declContext _localctx = new Method_declContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_method_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(82);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BOOLEAN:
			case INT:
				{
				setState(80);
				type();
				}
				break;
			case VOID:
				{
				setState(81);
				match(VOID);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(84);
			match(ID);
			setState(85);
			match(LPAREN);
			setState(87);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==BOOLEAN || _la==INT) {
				{
				setState(86);
				method_params();
				}
			}

			setState(89);
			match(RPAREN);
			setState(90);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Method_paramsContext extends ParserRuleContext {
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public List<TerminalNode> ID() { return getTokens(DecafParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(DecafParser.ID, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(DecafParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(DecafParser.COMMA, i);
		}
		public Method_paramsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_method_params; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).enterMethod_params(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).exitMethod_params(this);
		}
	}

	public final Method_paramsContext method_params() throws RecognitionException {
		Method_paramsContext _localctx = new Method_paramsContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_method_params);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			{
			setState(92);
			type();
			setState(93);
			match(ID);
			}
			setState(101);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(95);
				match(COMMA);
				setState(96);
				type();
				setState(97);
				match(ID);
				}
				}
				setState(103);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockContext extends ParserRuleContext {
		public TerminalNode LCURLY() { return getToken(DecafParser.LCURLY, 0); }
		public TerminalNode RCURLY() { return getToken(DecafParser.RCURLY, 0); }
		public List<Var_declContext> var_decl() {
			return getRuleContexts(Var_declContext.class);
		}
		public Var_declContext var_decl(int i) {
			return getRuleContext(Var_declContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).exitBlock(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(104);
			match(LCURLY);
			setState(108);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==BOOLEAN || _la==INT) {
				{
				{
				setState(105);
				var_decl();
				}
				}
				setState(110);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(114);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BREAK) | (1L << CALLOUT) | (1L << CONTINUE) | (1L << FOR) | (1L << IF) | (1L << RETURN) | (1L << LCURLY) | (1L << ID))) != 0)) {
				{
				{
				setState(111);
				statement();
				}
				}
				setState(116);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(117);
			match(RCURLY);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Var_declContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(DecafParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(DecafParser.ID, i);
		}
		public TerminalNode SEMICOLON() { return getToken(DecafParser.SEMICOLON, 0); }
		public List<TerminalNode> COMMA() { return getTokens(DecafParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(DecafParser.COMMA, i);
		}
		public Var_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).enterVar_decl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).exitVar_decl(this);
		}
	}

	public final Var_declContext var_decl() throws RecognitionException {
		Var_declContext _localctx = new Var_declContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_var_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(119);
			type();
			setState(120);
			match(ID);
			setState(125);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(121);
				match(COMMA);
				setState(122);
				match(ID);
				}
				}
				setState(127);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(128);
			match(SEMICOLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(DecafParser.INT, 0); }
		public TerminalNode BOOLEAN() { return getToken(DecafParser.BOOLEAN, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).exitType(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(130);
			_la = _input.LA(1);
			if ( !(_la==BOOLEAN || _la==INT) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public LocationContext location() {
			return getRuleContext(LocationContext.class,0);
		}
		public Assign_opContext assign_op() {
			return getRuleContext(Assign_opContext.class,0);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode SEMICOLON() { return getToken(DecafParser.SEMICOLON, 0); }
		public Method_callContext method_call() {
			return getRuleContext(Method_callContext.class,0);
		}
		public TerminalNode IF() { return getToken(DecafParser.IF, 0); }
		public TerminalNode LPAREN() { return getToken(DecafParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(DecafParser.RPAREN, 0); }
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(DecafParser.ELSE, 0); }
		public TerminalNode FOR() { return getToken(DecafParser.FOR, 0); }
		public TerminalNode ID() { return getToken(DecafParser.ID, 0); }
		public TerminalNode ASSIGNOPERATOR() { return getToken(DecafParser.ASSIGNOPERATOR, 0); }
		public TerminalNode COMMA() { return getToken(DecafParser.COMMA, 0); }
		public TerminalNode RETURN() { return getToken(DecafParser.RETURN, 0); }
		public TerminalNode BREAK() { return getToken(DecafParser.BREAK, 0); }
		public TerminalNode CONTINUE() { return getToken(DecafParser.CONTINUE, 0); }
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).exitStatement(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_statement);
		int _la;
		try {
			setState(167);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(132);
				location();
				setState(133);
				assign_op();
				setState(134);
				expr(0);
				setState(135);
				match(SEMICOLON);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(137);
				method_call();
				setState(138);
				match(SEMICOLON);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(140);
				match(IF);
				setState(141);
				match(LPAREN);
				setState(142);
				expr(0);
				setState(143);
				match(RPAREN);
				setState(144);
				block();
				setState(147);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ELSE) {
					{
					setState(145);
					match(ELSE);
					setState(146);
					block();
					}
				}

				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(149);
				match(FOR);
				setState(150);
				match(ID);
				setState(151);
				match(ASSIGNOPERATOR);
				setState(152);
				expr(0);
				setState(153);
				match(COMMA);
				setState(154);
				expr(0);
				setState(155);
				block();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(157);
				match(RETURN);
				setState(159);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CALLOUT) | (1L << LPAREN) | (1L << ARITHMINUS) | (1L << EXCLMRK) | (1L << ID) | (1L << CHAR_LITERAL) | (1L << BOOL_LITERAL) | (1L << INT_LITERAL))) != 0)) {
					{
					setState(158);
					expr(0);
					}
				}

				setState(161);
				match(SEMICOLON);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(162);
				match(BREAK);
				setState(163);
				match(SEMICOLON);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(164);
				match(CONTINUE);
				setState(165);
				match(SEMICOLON);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(166);
				block();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Assign_opContext extends ParserRuleContext {
		public TerminalNode ASSIGNOPERATOR() { return getToken(DecafParser.ASSIGNOPERATOR, 0); }
		public TerminalNode ARITHPLUS() { return getToken(DecafParser.ARITHPLUS, 0); }
		public TerminalNode ARITHMINUS() { return getToken(DecafParser.ARITHMINUS, 0); }
		public Assign_opContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assign_op; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).enterAssign_op(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).exitAssign_op(this);
		}
	}

	public final Assign_opContext assign_op() throws RecognitionException {
		Assign_opContext _localctx = new Assign_opContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_assign_op);
		try {
			setState(174);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ASSIGNOPERATOR:
				enterOuterAlt(_localctx, 1);
				{
				setState(169);
				match(ASSIGNOPERATOR);
				}
				break;
			case ARITHPLUS:
				enterOuterAlt(_localctx, 2);
				{
				setState(170);
				match(ARITHPLUS);
				setState(171);
				match(ASSIGNOPERATOR);
				}
				break;
			case ARITHMINUS:
				enterOuterAlt(_localctx, 3);
				{
				setState(172);
				match(ARITHMINUS);
				setState(173);
				match(ASSIGNOPERATOR);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Method_callContext extends ParserRuleContext {
		public Method_nameContext method_name() {
			return getRuleContext(Method_nameContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(DecafParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(DecafParser.RPAREN, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(DecafParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(DecafParser.COMMA, i);
		}
		public TerminalNode CALLOUT() { return getToken(DecafParser.CALLOUT, 0); }
		public TerminalNode STRING_LITERAL() { return getToken(DecafParser.STRING_LITERAL, 0); }
		public List<Callout_argContext> callout_arg() {
			return getRuleContexts(Callout_argContext.class);
		}
		public Callout_argContext callout_arg(int i) {
			return getRuleContext(Callout_argContext.class,i);
		}
		public Method_callContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_method_call; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).enterMethod_call(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).exitMethod_call(this);
		}
	}

	public final Method_callContext method_call() throws RecognitionException {
		Method_callContext _localctx = new Method_callContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_method_call);
		int _la;
		try {
			setState(205);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(176);
				method_name();
				setState(177);
				match(LPAREN);
				setState(186);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CALLOUT) | (1L << LPAREN) | (1L << ARITHMINUS) | (1L << EXCLMRK) | (1L << ID) | (1L << CHAR_LITERAL) | (1L << BOOL_LITERAL) | (1L << INT_LITERAL))) != 0)) {
					{
					setState(178);
					expr(0);
					setState(183);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(179);
						match(COMMA);
						setState(180);
						expr(0);
						}
						}
						setState(185);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(188);
				match(RPAREN);
				}
				break;
			case CALLOUT:
				enterOuterAlt(_localctx, 2);
				{
				setState(190);
				match(CALLOUT);
				setState(191);
				match(LPAREN);
				setState(192);
				match(STRING_LITERAL);
				setState(202);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(193);
					match(COMMA);
					setState(194);
					callout_arg();
					setState(199);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(195);
						match(COMMA);
						setState(196);
						callout_arg();
						}
						}
						setState(201);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(204);
				match(RPAREN);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Method_nameContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(DecafParser.ID, 0); }
		public Method_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_method_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).enterMethod_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).exitMethod_name(this);
		}
	}

	public final Method_nameContext method_name() throws RecognitionException {
		Method_nameContext _localctx = new Method_nameContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_method_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(207);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LocationContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(DecafParser.ID, 0); }
		public TerminalNode LSQRBRK() { return getToken(DecafParser.LSQRBRK, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RSQRBRK() { return getToken(DecafParser.RSQRBRK, 0); }
		public LocationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_location; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).enterLocation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).exitLocation(this);
		}
	}

	public final LocationContext location() throws RecognitionException {
		LocationContext _localctx = new LocationContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_location);
		try {
			setState(215);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(209);
				match(ID);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(210);
				match(ID);
				setState(211);
				match(LSQRBRK);
				setState(212);
				expr(0);
				setState(213);
				match(RSQRBRK);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public LocationContext location() {
			return getRuleContext(LocationContext.class,0);
		}
		public Method_callContext method_call() {
			return getRuleContext(Method_callContext.class,0);
		}
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public TerminalNode ARITHMINUS() { return getToken(DecafParser.ARITHMINUS, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode EXCLMRK() { return getToken(DecafParser.EXCLMRK, 0); }
		public TerminalNode LPAREN() { return getToken(DecafParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(DecafParser.RPAREN, 0); }
		public Strong_arith_opContext strong_arith_op() {
			return getRuleContext(Strong_arith_opContext.class,0);
		}
		public Weak_arith_opContext weak_arith_op() {
			return getRuleContext(Weak_arith_opContext.class,0);
		}
		public Bin_opContext bin_op() {
			return getRuleContext(Bin_opContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).exitExpr(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 26;
		enterRecursionRule(_localctx, 26, RULE_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(229);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				{
				setState(218);
				location();
				}
				break;
			case 2:
				{
				setState(219);
				method_call();
				}
				break;
			case 3:
				{
				setState(220);
				literal();
				}
				break;
			case 4:
				{
				setState(221);
				match(ARITHMINUS);
				setState(222);
				expr(6);
				}
				break;
			case 5:
				{
				setState(223);
				match(EXCLMRK);
				setState(224);
				expr(5);
				}
				break;
			case 6:
				{
				setState(225);
				match(LPAREN);
				setState(226);
				expr(0);
				setState(227);
				match(RPAREN);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(245);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(243);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(231);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(232);
						strong_arith_op();
						setState(233);
						expr(5);
						}
						break;
					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(235);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(236);
						weak_arith_op();
						setState(237);
						expr(4);
						}
						break;
					case 3:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(239);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(240);
						bin_op();
						setState(241);
						expr(3);
						}
						break;
					}
					} 
				}
				setState(247);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Callout_argContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode STRING_LITERAL() { return getToken(DecafParser.STRING_LITERAL, 0); }
		public Callout_argContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_callout_arg; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).enterCallout_arg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).exitCallout_arg(this);
		}
	}

	public final Callout_argContext callout_arg() throws RecognitionException {
		Callout_argContext _localctx = new Callout_argContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_callout_arg);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(250);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CALLOUT:
			case LPAREN:
			case ARITHMINUS:
			case EXCLMRK:
			case ID:
			case CHAR_LITERAL:
			case BOOL_LITERAL:
			case INT_LITERAL:
				{
				setState(248);
				expr(0);
				}
				break;
			case STRING_LITERAL:
				{
				setState(249);
				match(STRING_LITERAL);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Bin_opContext extends ParserRuleContext {
		public Rel_opContext rel_op() {
			return getRuleContext(Rel_opContext.class,0);
		}
		public Eq_opContext eq_op() {
			return getRuleContext(Eq_opContext.class,0);
		}
		public Cond_opContext cond_op() {
			return getRuleContext(Cond_opContext.class,0);
		}
		public Bin_opContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bin_op; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).enterBin_op(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).exitBin_op(this);
		}
	}

	public final Bin_opContext bin_op() throws RecognitionException {
		Bin_opContext _localctx = new Bin_opContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_bin_op);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(255);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case GRTTHAN:
			case LESTHAN:
			case GRTEQUAL:
			case LESEQUAL:
				{
				setState(252);
				rel_op();
				}
				break;
			case EQUALOP:
			case NOTEQUAL:
				{
				setState(253);
				eq_op();
				}
				break;
			case AND:
			case OR:
				{
				setState(254);
				cond_op();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Strong_arith_opContext extends ParserRuleContext {
		public TerminalNode ARITHMULT() { return getToken(DecafParser.ARITHMULT, 0); }
		public TerminalNode ARITHDIV() { return getToken(DecafParser.ARITHDIV, 0); }
		public TerminalNode ARITHMOD() { return getToken(DecafParser.ARITHMOD, 0); }
		public Strong_arith_opContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_strong_arith_op; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).enterStrong_arith_op(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).exitStrong_arith_op(this);
		}
	}

	public final Strong_arith_opContext strong_arith_op() throws RecognitionException {
		Strong_arith_opContext _localctx = new Strong_arith_opContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_strong_arith_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(257);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ARITHMOD) | (1L << ARITHDIV) | (1L << ARITHMULT))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Weak_arith_opContext extends ParserRuleContext {
		public TerminalNode ARITHPLUS() { return getToken(DecafParser.ARITHPLUS, 0); }
		public TerminalNode ARITHMINUS() { return getToken(DecafParser.ARITHMINUS, 0); }
		public Weak_arith_opContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_weak_arith_op; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).enterWeak_arith_op(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).exitWeak_arith_op(this);
		}
	}

	public final Weak_arith_opContext weak_arith_op() throws RecognitionException {
		Weak_arith_opContext _localctx = new Weak_arith_opContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_weak_arith_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(259);
			_la = _input.LA(1);
			if ( !(_la==ARITHPLUS || _la==ARITHMINUS) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Rel_opContext extends ParserRuleContext {
		public TerminalNode GRTTHAN() { return getToken(DecafParser.GRTTHAN, 0); }
		public TerminalNode LESTHAN() { return getToken(DecafParser.LESTHAN, 0); }
		public TerminalNode GRTEQUAL() { return getToken(DecafParser.GRTEQUAL, 0); }
		public TerminalNode LESEQUAL() { return getToken(DecafParser.LESEQUAL, 0); }
		public Rel_opContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rel_op; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).enterRel_op(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).exitRel_op(this);
		}
	}

	public final Rel_opContext rel_op() throws RecognitionException {
		Rel_opContext _localctx = new Rel_opContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_rel_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(261);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << GRTTHAN) | (1L << LESTHAN) | (1L << GRTEQUAL) | (1L << LESEQUAL))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Eq_opContext extends ParserRuleContext {
		public TerminalNode EQUALOP() { return getToken(DecafParser.EQUALOP, 0); }
		public TerminalNode NOTEQUAL() { return getToken(DecafParser.NOTEQUAL, 0); }
		public Eq_opContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eq_op; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).enterEq_op(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).exitEq_op(this);
		}
	}

	public final Eq_opContext eq_op() throws RecognitionException {
		Eq_opContext _localctx = new Eq_opContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_eq_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(263);
			_la = _input.LA(1);
			if ( !(_la==EQUALOP || _la==NOTEQUAL) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Cond_opContext extends ParserRuleContext {
		public TerminalNode AND() { return getToken(DecafParser.AND, 0); }
		public TerminalNode OR() { return getToken(DecafParser.OR, 0); }
		public Cond_opContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cond_op; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).enterCond_op(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).exitCond_op(this);
		}
	}

	public final Cond_opContext cond_op() throws RecognitionException {
		Cond_opContext _localctx = new Cond_opContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_cond_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(265);
			_la = _input.LA(1);
			if ( !(_la==AND || _la==OR) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LiteralContext extends ParserRuleContext {
		public TerminalNode INT_LITERAL() { return getToken(DecafParser.INT_LITERAL, 0); }
		public TerminalNode CHAR_LITERAL() { return getToken(DecafParser.CHAR_LITERAL, 0); }
		public TerminalNode BOOL_LITERAL() { return getToken(DecafParser.BOOL_LITERAL, 0); }
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).enterLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DecafParserListener ) ((DecafParserListener)listener).exitLiteral(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(267);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << CHAR_LITERAL) | (1L << BOOL_LITERAL) | (1L << INT_LITERAL))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 13:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 4);
		case 1:
			return precpred(_ctx, 3);
		case 2:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3.\u0110\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\3\2\3\2\3\2\3\2\7\2"+
		"\63\n\2\f\2\16\2\66\13\2\3\2\7\29\n\2\f\2\16\2<\13\2\3\2\3\2\3\2\3\3\3"+
		"\3\3\3\3\3\7\3E\n\3\f\3\16\3H\13\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\5\4Q\n"+
		"\4\3\5\3\5\5\5U\n\5\3\5\3\5\3\5\5\5Z\n\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\7\6f\n\6\f\6\16\6i\13\6\3\7\3\7\7\7m\n\7\f\7\16\7p\13\7\3\7"+
		"\7\7s\n\7\f\7\16\7v\13\7\3\7\3\7\3\b\3\b\3\b\3\b\7\b~\n\b\f\b\16\b\u0081"+
		"\13\b\3\b\3\b\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\5\n\u0096\n\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n"+
		"\u00a2\n\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u00aa\n\n\3\13\3\13\3\13\3\13\3"+
		"\13\5\13\u00b1\n\13\3\f\3\f\3\f\3\f\3\f\7\f\u00b8\n\f\f\f\16\f\u00bb\13"+
		"\f\5\f\u00bd\n\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\7\f\u00c8\n\f\f\f"+
		"\16\f\u00cb\13\f\5\f\u00cd\n\f\3\f\5\f\u00d0\n\f\3\r\3\r\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\5\16\u00da\n\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\5\17\u00e8\n\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\7\17\u00f6\n\17\f\17\16\17\u00f9\13\17\3\20"+
		"\3\20\5\20\u00fd\n\20\3\21\3\21\3\21\5\21\u0102\n\21\3\22\3\22\3\23\3"+
		"\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\27\2\3\34\30\2\4\6\b\n\f"+
		"\16\20\22\24\26\30\32\34\36 \"$&(*,\2\t\4\2\4\4\17\17\3\2\35\37\3\2\32"+
		"\33\3\2 #\3\2$%\3\2&\'\4\2++-.\u011f\2.\3\2\2\2\4@\3\2\2\2\6P\3\2\2\2"+
		"\bT\3\2\2\2\n^\3\2\2\2\fj\3\2\2\2\16y\3\2\2\2\20\u0084\3\2\2\2\22\u00a9"+
		"\3\2\2\2\24\u00b0\3\2\2\2\26\u00cf\3\2\2\2\30\u00d1\3\2\2\2\32\u00d9\3"+
		"\2\2\2\34\u00e7\3\2\2\2\36\u00fc\3\2\2\2 \u0101\3\2\2\2\"\u0103\3\2\2"+
		"\2$\u0105\3\2\2\2&\u0107\3\2\2\2(\u0109\3\2\2\2*\u010b\3\2\2\2,\u010d"+
		"\3\2\2\2./\7\3\2\2/\60\7(\2\2\60\64\7\20\2\2\61\63\5\4\3\2\62\61\3\2\2"+
		"\2\63\66\3\2\2\2\64\62\3\2\2\2\64\65\3\2\2\2\65:\3\2\2\2\66\64\3\2\2\2"+
		"\679\5\b\5\28\67\3\2\2\29<\3\2\2\2:8\3\2\2\2:;\3\2\2\2;=\3\2\2\2<:\3\2"+
		"\2\2=>\7\21\2\2>?\7\2\2\3?\3\3\2\2\2@A\5\20\t\2AF\5\6\4\2BC\7\25\2\2C"+
		"E\5\6\4\2DB\3\2\2\2EH\3\2\2\2FD\3\2\2\2FG\3\2\2\2GI\3\2\2\2HF\3\2\2\2"+
		"IJ\7\22\2\2J\5\3\2\2\2KQ\7(\2\2LM\7(\2\2MN\7\23\2\2NO\7.\2\2OQ\7\24\2"+
		"\2PK\3\2\2\2PL\3\2\2\2Q\7\3\2\2\2RU\5\20\t\2SU\7\16\2\2TR\3\2\2\2TS\3"+
		"\2\2\2UV\3\2\2\2VW\7(\2\2WY\7\26\2\2XZ\5\n\6\2YX\3\2\2\2YZ\3\2\2\2Z[\3"+
		"\2\2\2[\\\7\27\2\2\\]\5\f\7\2]\t\3\2\2\2^_\5\20\t\2_`\7(\2\2`g\3\2\2\2"+
		"ab\7\25\2\2bc\5\20\t\2cd\7(\2\2df\3\2\2\2ea\3\2\2\2fi\3\2\2\2ge\3\2\2"+
		"\2gh\3\2\2\2h\13\3\2\2\2ig\3\2\2\2jn\7\20\2\2km\5\16\b\2lk\3\2\2\2mp\3"+
		"\2\2\2nl\3\2\2\2no\3\2\2\2ot\3\2\2\2pn\3\2\2\2qs\5\22\n\2rq\3\2\2\2sv"+
		"\3\2\2\2tr\3\2\2\2tu\3\2\2\2uw\3\2\2\2vt\3\2\2\2wx\7\21\2\2x\r\3\2\2\2"+
		"yz\5\20\t\2z\177\7(\2\2{|\7\25\2\2|~\7(\2\2}{\3\2\2\2~\u0081\3\2\2\2\177"+
		"}\3\2\2\2\177\u0080\3\2\2\2\u0080\u0082\3\2\2\2\u0081\177\3\2\2\2\u0082"+
		"\u0083\7\22\2\2\u0083\17\3\2\2\2\u0084\u0085\t\2\2\2\u0085\21\3\2\2\2"+
		"\u0086\u0087\5\32\16\2\u0087\u0088\5\24\13\2\u0088\u0089\5\34\17\2\u0089"+
		"\u008a\7\22\2\2\u008a\u00aa\3\2\2\2\u008b\u008c\5\26\f\2\u008c\u008d\7"+
		"\22\2\2\u008d\u00aa\3\2\2\2\u008e\u008f\7\13\2\2\u008f\u0090\7\26\2\2"+
		"\u0090\u0091\5\34\17\2\u0091\u0092\7\27\2\2\u0092\u0095\5\f\7\2\u0093"+
		"\u0094\7\b\2\2\u0094\u0096\5\f\7\2\u0095\u0093\3\2\2\2\u0095\u0096\3\2"+
		"\2\2\u0096\u00aa\3\2\2\2\u0097\u0098\7\n\2\2\u0098\u0099\7(\2\2\u0099"+
		"\u009a\7\31\2\2\u009a\u009b\5\34\17\2\u009b\u009c\7\25\2\2\u009c\u009d"+
		"\5\34\17\2\u009d\u009e\5\f\7\2\u009e\u00aa\3\2\2\2\u009f\u00a1\7\f\2\2"+
		"\u00a0\u00a2\5\34\17\2\u00a1\u00a0\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a2\u00a3"+
		"\3\2\2\2\u00a3\u00aa\7\22\2\2\u00a4\u00a5\7\5\2\2\u00a5\u00aa\7\22\2\2"+
		"\u00a6\u00a7\7\7\2\2\u00a7\u00aa\7\22\2\2\u00a8\u00aa\5\f\7\2\u00a9\u0086"+
		"\3\2\2\2\u00a9\u008b\3\2\2\2\u00a9\u008e\3\2\2\2\u00a9\u0097\3\2\2\2\u00a9"+
		"\u009f\3\2\2\2\u00a9\u00a4\3\2\2\2\u00a9\u00a6\3\2\2\2\u00a9\u00a8\3\2"+
		"\2\2\u00aa\23\3\2\2\2\u00ab\u00b1\7\31\2\2\u00ac\u00ad\7\32\2\2\u00ad"+
		"\u00b1\7\31\2\2\u00ae\u00af\7\33\2\2\u00af\u00b1\7\31\2\2\u00b0\u00ab"+
		"\3\2\2\2\u00b0\u00ac\3\2\2\2\u00b0\u00ae\3\2\2\2\u00b1\25\3\2\2\2\u00b2"+
		"\u00b3\5\30\r\2\u00b3\u00bc\7\26\2\2\u00b4\u00b9\5\34\17\2\u00b5\u00b6"+
		"\7\25\2\2\u00b6\u00b8\5\34\17\2\u00b7\u00b5\3\2\2\2\u00b8\u00bb\3\2\2"+
		"\2\u00b9\u00b7\3\2\2\2\u00b9\u00ba\3\2\2\2\u00ba\u00bd\3\2\2\2\u00bb\u00b9"+
		"\3\2\2\2\u00bc\u00b4\3\2\2\2\u00bc\u00bd\3\2\2\2\u00bd\u00be\3\2\2\2\u00be"+
		"\u00bf\7\27\2\2\u00bf\u00d0\3\2\2\2\u00c0\u00c1\7\6\2\2\u00c1\u00c2\7"+
		"\26\2\2\u00c2\u00cc\7,\2\2\u00c3\u00c4\7\25\2\2\u00c4\u00c9\5\36\20\2"+
		"\u00c5\u00c6\7\25\2\2\u00c6\u00c8\5\36\20\2\u00c7\u00c5\3\2\2\2\u00c8"+
		"\u00cb\3\2\2\2\u00c9\u00c7\3\2\2\2\u00c9\u00ca\3\2\2\2\u00ca\u00cd\3\2"+
		"\2\2\u00cb\u00c9\3\2\2\2\u00cc\u00c3\3\2\2\2\u00cc\u00cd\3\2\2\2\u00cd"+
		"\u00ce\3\2\2\2\u00ce\u00d0\7\27\2\2\u00cf\u00b2\3\2\2\2\u00cf\u00c0\3"+
		"\2\2\2\u00d0\27\3\2\2\2\u00d1\u00d2\7(\2\2\u00d2\31\3\2\2\2\u00d3\u00da"+
		"\7(\2\2\u00d4\u00d5\7(\2\2\u00d5\u00d6\7\23\2\2\u00d6\u00d7\5\34\17\2"+
		"\u00d7\u00d8\7\24\2\2\u00d8\u00da\3\2\2\2\u00d9\u00d3\3\2\2\2\u00d9\u00d4"+
		"\3\2\2\2\u00da\33\3\2\2\2\u00db\u00dc\b\17\1\2\u00dc\u00e8\5\32\16\2\u00dd"+
		"\u00e8\5\26\f\2\u00de\u00e8\5,\27\2\u00df\u00e0\7\33\2\2\u00e0\u00e8\5"+
		"\34\17\b\u00e1\u00e2\7\34\2\2\u00e2\u00e8\5\34\17\7\u00e3\u00e4\7\26\2"+
		"\2\u00e4\u00e5\5\34\17\2\u00e5\u00e6\7\27\2\2\u00e6\u00e8\3\2\2\2\u00e7"+
		"\u00db\3\2\2\2\u00e7\u00dd\3\2\2\2\u00e7\u00de\3\2\2\2\u00e7\u00df\3\2"+
		"\2\2\u00e7\u00e1\3\2\2\2\u00e7\u00e3\3\2\2\2\u00e8\u00f7\3\2\2\2\u00e9"+
		"\u00ea\f\6\2\2\u00ea\u00eb\5\"\22\2\u00eb\u00ec\5\34\17\7\u00ec\u00f6"+
		"\3\2\2\2\u00ed\u00ee\f\5\2\2\u00ee\u00ef\5$\23\2\u00ef\u00f0\5\34\17\6"+
		"\u00f0\u00f6\3\2\2\2\u00f1\u00f2\f\4\2\2\u00f2\u00f3\5 \21\2\u00f3\u00f4"+
		"\5\34\17\5\u00f4\u00f6\3\2\2\2\u00f5\u00e9\3\2\2\2\u00f5\u00ed\3\2\2\2"+
		"\u00f5\u00f1\3\2\2\2\u00f6\u00f9\3\2\2\2\u00f7\u00f5\3\2\2\2\u00f7\u00f8"+
		"\3\2\2\2\u00f8\35\3\2\2\2\u00f9\u00f7\3\2\2\2\u00fa\u00fd\5\34\17\2\u00fb"+
		"\u00fd\7,\2\2\u00fc\u00fa\3\2\2\2\u00fc\u00fb\3\2\2\2\u00fd\37\3\2\2\2"+
		"\u00fe\u0102\5&\24\2\u00ff\u0102\5(\25\2\u0100\u0102\5*\26\2\u0101\u00fe"+
		"\3\2\2\2\u0101\u00ff\3\2\2\2\u0101\u0100\3\2\2\2\u0102!\3\2\2\2\u0103"+
		"\u0104\t\3\2\2\u0104#\3\2\2\2\u0105\u0106\t\4\2\2\u0106%\3\2\2\2\u0107"+
		"\u0108\t\5\2\2\u0108\'\3\2\2\2\u0109\u010a\t\6\2\2\u010a)\3\2\2\2\u010b"+
		"\u010c\t\7\2\2\u010c+\3\2\2\2\u010d\u010e\t\b\2\2\u010e-\3\2\2\2\33\64"+
		":FPTYgnt\177\u0095\u00a1\u00a9\u00b0\u00b9\u00bc\u00c9\u00cc\u00cf\u00d9"+
		"\u00e7\u00f5\u00f7\u00fc\u0101";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}