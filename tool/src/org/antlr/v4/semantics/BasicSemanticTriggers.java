// $ANTLR 3.3 Nov 30, 2010 12:50:56 BasicSemanticTriggers.g 2011-06-11 10:28:59

/*
 [The "BSD license"]
 Copyright (c) 2010 Terence Parr
 All rights reserved.
 Redistribution and use in source and binary forms, with or without
 modification, are permitted provided that the following conditions
 are met:
 1. Redistributions of source code must retain the above copyright
    notice, this list of conditions and the following disclaimer.
 2. Redistributions in binary form must reproduce the above copyright
    notice, this list of conditions and the following disclaimer in the
    documentation and/or other materials provided with the distribution.
 3. The name of the author may not be used to endorse or promote products
    derived from this software without specific prior written permission.
 THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY EXPRESS OR
 IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
 IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT, INDIRECT,
 INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
 NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
 THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/
package org.antlr.v4.semantics;

import org.antlr.runtime.*;
import org.antlr.runtime.BitSet;
import org.antlr.runtime.tree.*;
import org.antlr.v4.tool.*;

import java.util.*;
/** Triggers for the basic semantics of the input.  Side-effects:
 *  Set token, block, rule options in the tree.  Load field option
 *  with grammar options. Only legal options are set.
 */
public class BasicSemanticTriggers extends TreeFilter {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "SEMPRED", "FORCED_ACTION", "DOC_COMMENT", "SRC", "NLCHARS", "COMMENT", "DOUBLE_QUOTE_STRING_LITERAL", "DOUBLE_ANGLE_STRING_LITERAL", "ACTION_STRING_LITERAL", "ACTION_CHAR_LITERAL", "ARG_ACTION", "NESTED_ACTION", "ACTION", "ACTION_ESC", "WSNLCHARS", "OPTIONS", "TOKENS", "SCOPE", "IMPORT", "FRAGMENT", "LEXER", "PARSER", "TREE", "GRAMMAR", "PROTECTED", "PUBLIC", "PRIVATE", "RETURNS", "THROWS", "CATCH", "FINALLY", "TEMPLATE", "MODE", "COLON", "COLONCOLON", "COMMA", "SEMI", "LPAREN", "RPAREN", "IMPLIES", "LT", "GT", "ASSIGN", "QUESTION", "BANG", "STAR", "PLUS", "PLUS_ASSIGN", "OR", "ROOT", "DOLLAR", "DOT", "RANGE", "ETC", "RARROW", "TREE_BEGIN", "AT", "NOT", "RBRACE", "TOKEN_REF", "RULE_REF", "INT", "WSCHARS", "ESC_SEQ", "STRING_LITERAL", "HEX_DIGIT", "UNICODE_ESC", "WS", "ERRCHAR", "RULE", "RULES", "RULEMODIFIERS", "RULEACTIONS", "BLOCK", "REWRITE_BLOCK", "OPTIONAL", "CLOSURE", "POSITIVE_CLOSURE", "SYNPRED", "CHAR_RANGE", "EPSILON", "ALT", "ALTLIST", "ID", "ARG", "ARGLIST", "RET", "COMBINED", "INITACTION", "LABEL", "GATED_SEMPRED", "SYN_SEMPRED", "BACKTRACK_SEMPRED", "WILDCARD", "LIST", "ELEMENT_OPTIONS", "ST_RESULT", "RESULT", "ALT_REWRITE"
    };
    public static final int EOF=-1;
    public static final int SEMPRED=4;
    public static final int FORCED_ACTION=5;
    public static final int DOC_COMMENT=6;
    public static final int SRC=7;
    public static final int NLCHARS=8;
    public static final int COMMENT=9;
    public static final int DOUBLE_QUOTE_STRING_LITERAL=10;
    public static final int DOUBLE_ANGLE_STRING_LITERAL=11;
    public static final int ACTION_STRING_LITERAL=12;
    public static final int ACTION_CHAR_LITERAL=13;
    public static final int ARG_ACTION=14;
    public static final int NESTED_ACTION=15;
    public static final int ACTION=16;
    public static final int ACTION_ESC=17;
    public static final int WSNLCHARS=18;
    public static final int OPTIONS=19;
    public static final int TOKENS=20;
    public static final int SCOPE=21;
    public static final int IMPORT=22;
    public static final int FRAGMENT=23;
    public static final int LEXER=24;
    public static final int PARSER=25;
    public static final int TREE=26;
    public static final int GRAMMAR=27;
    public static final int PROTECTED=28;
    public static final int PUBLIC=29;
    public static final int PRIVATE=30;
    public static final int RETURNS=31;
    public static final int THROWS=32;
    public static final int CATCH=33;
    public static final int FINALLY=34;
    public static final int TEMPLATE=35;
    public static final int MODE=36;
    public static final int COLON=37;
    public static final int COLONCOLON=38;
    public static final int COMMA=39;
    public static final int SEMI=40;
    public static final int LPAREN=41;
    public static final int RPAREN=42;
    public static final int IMPLIES=43;
    public static final int LT=44;
    public static final int GT=45;
    public static final int ASSIGN=46;
    public static final int QUESTION=47;
    public static final int BANG=48;
    public static final int STAR=49;
    public static final int PLUS=50;
    public static final int PLUS_ASSIGN=51;
    public static final int OR=52;
    public static final int ROOT=53;
    public static final int DOLLAR=54;
    public static final int DOT=55;
    public static final int RANGE=56;
    public static final int ETC=57;
    public static final int RARROW=58;
    public static final int TREE_BEGIN=59;
    public static final int AT=60;
    public static final int NOT=61;
    public static final int RBRACE=62;
    public static final int TOKEN_REF=63;
    public static final int RULE_REF=64;
    public static final int INT=65;
    public static final int WSCHARS=66;
    public static final int ESC_SEQ=67;
    public static final int STRING_LITERAL=68;
    public static final int HEX_DIGIT=69;
    public static final int UNICODE_ESC=70;
    public static final int WS=71;
    public static final int ERRCHAR=72;
    public static final int RULE=73;
    public static final int RULES=74;
    public static final int RULEMODIFIERS=75;
    public static final int RULEACTIONS=76;
    public static final int BLOCK=77;
    public static final int REWRITE_BLOCK=78;
    public static final int OPTIONAL=79;
    public static final int CLOSURE=80;
    public static final int POSITIVE_CLOSURE=81;
    public static final int SYNPRED=82;
    public static final int CHAR_RANGE=83;
    public static final int EPSILON=84;
    public static final int ALT=85;
    public static final int ALTLIST=86;
    public static final int ID=87;
    public static final int ARG=88;
    public static final int ARGLIST=89;
    public static final int RET=90;
    public static final int COMBINED=91;
    public static final int INITACTION=92;
    public static final int LABEL=93;
    public static final int GATED_SEMPRED=94;
    public static final int SYN_SEMPRED=95;
    public static final int BACKTRACK_SEMPRED=96;
    public static final int WILDCARD=97;
    public static final int LIST=98;
    public static final int ELEMENT_OPTIONS=99;
    public static final int ST_RESULT=100;
    public static final int RESULT=101;
    public static final int ALT_REWRITE=102;

    // delegates
    // delegators


        public BasicSemanticTriggers(TreeNodeStream input) {
            this(input, new RecognizerSharedState());
        }
        public BasicSemanticTriggers(TreeNodeStream input, RecognizerSharedState state) {
            super(input, state);

        }


    public String[] getTokenNames() { return BasicSemanticTriggers.tokenNames; }
    public String getGrammarFileName() { return "BasicSemanticTriggers.g"; }


    // TODO: SHOULD we fix up grammar AST to remove errors?  Like kill refs to bad rules?
    // that is, rewrite tree?  maybe all passes are filters until code gen, which needs
    // tree grammar. 'course we won't try codegen if errors.
    public String name;
    GrammarASTWithOptions root;
    Grammar g; // which grammar are we checking
    BasicSemanticChecks checker;
    public BasicSemanticTriggers(TreeNodeStream input, Grammar g) {
    	this(input);
    	this.g = g;
    	checker = new BasicSemanticChecks(g);
    }



    // $ANTLR start "topdown"
    // BasicSemanticTriggers.g:86:1: topdown : ( grammarSpec | rules | mode | option | rule | tokenAlias | rewrite );
    public final void topdown() throws RecognitionException {
        try {
            // BasicSemanticTriggers.g:87:2: ( grammarSpec | rules | mode | option | rule | tokenAlias | rewrite )
            int alt1=7;
            alt1 = dfa1.predict(input);
            switch (alt1) {
                case 1 :
                    // BasicSemanticTriggers.g:87:4: grammarSpec
                    {
                    pushFollow(FOLLOW_grammarSpec_in_topdown87);
                    grammarSpec();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // BasicSemanticTriggers.g:88:4: rules
                    {
                    pushFollow(FOLLOW_rules_in_topdown92);
                    rules();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // BasicSemanticTriggers.g:89:4: mode
                    {
                    pushFollow(FOLLOW_mode_in_topdown97);
                    mode();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 4 :
                    // BasicSemanticTriggers.g:90:4: option
                    {
                    pushFollow(FOLLOW_option_in_topdown102);
                    option();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 5 :
                    // BasicSemanticTriggers.g:91:4: rule
                    {
                    pushFollow(FOLLOW_rule_in_topdown107);
                    rule();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 6 :
                    // BasicSemanticTriggers.g:92:4: tokenAlias
                    {
                    pushFollow(FOLLOW_tokenAlias_in_topdown112);
                    tokenAlias();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 7 :
                    // BasicSemanticTriggers.g:93:4: rewrite
                    {
                    pushFollow(FOLLOW_rewrite_in_topdown117);
                    rewrite();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "topdown"


    // $ANTLR start "bottomup"
    // BasicSemanticTriggers.g:96:1: bottomup : ( multiElementAltInTreeGrammar | astOps | ruleref | tokenRefWithArgs | elementOption | checkGrammarOptions | wildcardRoot );
    public final void bottomup() throws RecognitionException {
        try {
            // BasicSemanticTriggers.g:97:2: ( multiElementAltInTreeGrammar | astOps | ruleref | tokenRefWithArgs | elementOption | checkGrammarOptions | wildcardRoot )
            int alt2=7;
            switch ( input.LA(1) ) {
            case ALT:
                {
                alt2=1;
                }
                break;
            case BANG:
            case ROOT:
                {
                alt2=2;
                }
                break;
            case RULE_REF:
                {
                alt2=3;
                }
                break;
            case TOKEN_REF:
                {
                alt2=4;
                }
                break;
            case ELEMENT_OPTIONS:
                {
                alt2=5;
                }
                break;
            case GRAMMAR:
                {
                alt2=6;
                }
                break;
            case TREE_BEGIN:
                {
                alt2=7;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // BasicSemanticTriggers.g:97:4: multiElementAltInTreeGrammar
                    {
                    pushFollow(FOLLOW_multiElementAltInTreeGrammar_in_bottomup129);
                    multiElementAltInTreeGrammar();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // BasicSemanticTriggers.g:98:4: astOps
                    {
                    pushFollow(FOLLOW_astOps_in_bottomup134);
                    astOps();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // BasicSemanticTriggers.g:99:4: ruleref
                    {
                    pushFollow(FOLLOW_ruleref_in_bottomup139);
                    ruleref();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 4 :
                    // BasicSemanticTriggers.g:100:4: tokenRefWithArgs
                    {
                    pushFollow(FOLLOW_tokenRefWithArgs_in_bottomup144);
                    tokenRefWithArgs();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 5 :
                    // BasicSemanticTriggers.g:101:4: elementOption
                    {
                    pushFollow(FOLLOW_elementOption_in_bottomup149);
                    elementOption();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 6 :
                    // BasicSemanticTriggers.g:102:4: checkGrammarOptions
                    {
                    pushFollow(FOLLOW_checkGrammarOptions_in_bottomup154);
                    checkGrammarOptions();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 7 :
                    // BasicSemanticTriggers.g:103:4: wildcardRoot
                    {
                    pushFollow(FOLLOW_wildcardRoot_in_bottomup160);
                    wildcardRoot();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "bottomup"

    public static class grammarSpec_return extends TreeRuleReturnScope {
    };

    // $ANTLR start "grammarSpec"
    // BasicSemanticTriggers.g:106:1: grammarSpec : ^( GRAMMAR ID ( DOC_COMMENT )? prequelConstructs ^( RULES ( . )* ) ) ;
    public final BasicSemanticTriggers.grammarSpec_return grammarSpec() throws RecognitionException {
        BasicSemanticTriggers.grammarSpec_return retval = new BasicSemanticTriggers.grammarSpec_return();
        retval.start = input.LT(1);

        GrammarAST ID1=null;

        try {
            // BasicSemanticTriggers.g:107:5: ( ^( GRAMMAR ID ( DOC_COMMENT )? prequelConstructs ^( RULES ( . )* ) ) )
            // BasicSemanticTriggers.g:107:9: ^( GRAMMAR ID ( DOC_COMMENT )? prequelConstructs ^( RULES ( . )* ) )
            {
            match(input,GRAMMAR,FOLLOW_GRAMMAR_in_grammarSpec178); if (state.failed) return retval;

            match(input, Token.DOWN, null); if (state.failed) return retval;
            ID1=(GrammarAST)match(input,ID,FOLLOW_ID_in_grammarSpec180); if (state.failed) return retval;
            // BasicSemanticTriggers.g:107:23: ( DOC_COMMENT )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==DOC_COMMENT) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // BasicSemanticTriggers.g:107:23: DOC_COMMENT
                    {
                    match(input,DOC_COMMENT,FOLLOW_DOC_COMMENT_in_grammarSpec182); if (state.failed) return retval;

                    }
                    break;

            }

            if ( state.backtracking==1 ) {

              	    	name = (ID1!=null?ID1.getText():null);
              	    	checker.checkGrammarName(ID1.token);
              	    	root = (GrammarRootAST)((GrammarAST)retval.start);

            }
            pushFollow(FOLLOW_prequelConstructs_in_grammarSpec199);
            prequelConstructs();

            state._fsp--;
            if (state.failed) return retval;
            match(input,RULES,FOLLOW_RULES_in_grammarSpec202); if (state.failed) return retval;

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); if (state.failed) return retval;
                // BasicSemanticTriggers.g:113:33: ( . )*
                loop4:
                do {
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( ((LA4_0>=SEMPRED && LA4_0<=ALT_REWRITE)) ) {
                        alt4=1;
                    }
                    else if ( (LA4_0==UP) ) {
                        alt4=2;
                    }


                    switch (alt4) {
                	case 1 :
                	    // BasicSemanticTriggers.g:113:33: .
                	    {
                	    matchAny(input); if (state.failed) return retval;

                	    }
                	    break;

                	default :
                	    break loop4;
                    }
                } while (true);


                match(input, Token.UP, null); if (state.failed) return retval;
            }

            match(input, Token.UP, null); if (state.failed) return retval;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "grammarSpec"


    // $ANTLR start "checkGrammarOptions"
    // BasicSemanticTriggers.g:117:1: checkGrammarOptions : GRAMMAR ;
    public final void checkGrammarOptions() throws RecognitionException {
        GrammarAST GRAMMAR2=null;

        try {
            // BasicSemanticTriggers.g:118:2: ( GRAMMAR )
            // BasicSemanticTriggers.g:118:4: GRAMMAR
            {
            GRAMMAR2=(GrammarAST)match(input,GRAMMAR,FOLLOW_GRAMMAR_in_checkGrammarOptions225); if (state.failed) return ;
            if ( state.backtracking==1 ) {
              checker.checkTreeFilterOptions((GrammarRootAST)GRAMMAR2,
              										root.getOptions());
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "checkGrammarOptions"


    // $ANTLR start "prequelConstructs"
    // BasicSemanticTriggers.g:130:1: prequelConstructs : ( ^(o+= OPTIONS ( . )+ ) | ^(i+= IMPORT ( delegateGrammar )+ ) | ^(t+= TOKENS ( . )+ ) )* ;
    public final void prequelConstructs() throws RecognitionException {
        GrammarAST o=null;
        GrammarAST i=null;
        GrammarAST t=null;
        List list_o=null;
        List list_i=null;
        List list_t=null;

        try {
            // BasicSemanticTriggers.g:131:2: ( ( ^(o+= OPTIONS ( . )+ ) | ^(i+= IMPORT ( delegateGrammar )+ ) | ^(t+= TOKENS ( . )+ ) )* )
            // BasicSemanticTriggers.g:131:4: ( ^(o+= OPTIONS ( . )+ ) | ^(i+= IMPORT ( delegateGrammar )+ ) | ^(t+= TOKENS ( . )+ ) )*
            {
            // BasicSemanticTriggers.g:131:4: ( ^(o+= OPTIONS ( . )+ ) | ^(i+= IMPORT ( delegateGrammar )+ ) | ^(t+= TOKENS ( . )+ ) )*
            loop8:
            do {
                int alt8=4;
                switch ( input.LA(1) ) {
                case OPTIONS:
                    {
                    alt8=1;
                    }
                    break;
                case IMPORT:
                    {
                    alt8=2;
                    }
                    break;
                case TOKENS:
                    {
                    alt8=3;
                    }
                    break;

                }

                switch (alt8) {
            	case 1 :
            	    // BasicSemanticTriggers.g:131:6: ^(o+= OPTIONS ( . )+ )
            	    {
            	    o=(GrammarAST)match(input,OPTIONS,FOLLOW_OPTIONS_in_prequelConstructs248); if (state.failed) return ;
            	    if (list_o==null) list_o=new ArrayList();
            	    list_o.add(o);


            	    match(input, Token.DOWN, null); if (state.failed) return ;
            	    // BasicSemanticTriggers.g:131:19: ( . )+
            	    int cnt5=0;
            	    loop5:
            	    do {
            	        int alt5=2;
            	        int LA5_0 = input.LA(1);

            	        if ( ((LA5_0>=SEMPRED && LA5_0<=ALT_REWRITE)) ) {
            	            alt5=1;
            	        }
            	        else if ( (LA5_0==UP) ) {
            	            alt5=2;
            	        }


            	        switch (alt5) {
            	    	case 1 :
            	    	    // BasicSemanticTriggers.g:131:19: .
            	    	    {
            	    	    matchAny(input); if (state.failed) return ;

            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt5 >= 1 ) break loop5;
            	    	    if (state.backtracking>0) {state.failed=true; return ;}
            	                EarlyExitException eee =
            	                    new EarlyExitException(5, input);
            	                throw eee;
            	        }
            	        cnt5++;
            	    } while (true);


            	    match(input, Token.UP, null); if (state.failed) return ;

            	    }
            	    break;
            	case 2 :
            	    // BasicSemanticTriggers.g:132:5: ^(i+= IMPORT ( delegateGrammar )+ )
            	    {
            	    i=(GrammarAST)match(input,IMPORT,FOLLOW_IMPORT_in_prequelConstructs261); if (state.failed) return ;
            	    if (list_i==null) list_i=new ArrayList();
            	    list_i.add(i);


            	    match(input, Token.DOWN, null); if (state.failed) return ;
            	    // BasicSemanticTriggers.g:132:17: ( delegateGrammar )+
            	    int cnt6=0;
            	    loop6:
            	    do {
            	        int alt6=2;
            	        int LA6_0 = input.LA(1);

            	        if ( (LA6_0==ASSIGN||LA6_0==ID) ) {
            	            alt6=1;
            	        }


            	        switch (alt6) {
            	    	case 1 :
            	    	    // BasicSemanticTriggers.g:132:17: delegateGrammar
            	    	    {
            	    	    pushFollow(FOLLOW_delegateGrammar_in_prequelConstructs263);
            	    	    delegateGrammar();

            	    	    state._fsp--;
            	    	    if (state.failed) return ;

            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt6 >= 1 ) break loop6;
            	    	    if (state.backtracking>0) {state.failed=true; return ;}
            	                EarlyExitException eee =
            	                    new EarlyExitException(6, input);
            	                throw eee;
            	        }
            	        cnt6++;
            	    } while (true);


            	    match(input, Token.UP, null); if (state.failed) return ;

            	    }
            	    break;
            	case 3 :
            	    // BasicSemanticTriggers.g:133:5: ^(t+= TOKENS ( . )+ )
            	    {
            	    t=(GrammarAST)match(input,TOKENS,FOLLOW_TOKENS_in_prequelConstructs274); if (state.failed) return ;
            	    if (list_t==null) list_t=new ArrayList();
            	    list_t.add(t);


            	    match(input, Token.DOWN, null); if (state.failed) return ;
            	    // BasicSemanticTriggers.g:133:17: ( . )+
            	    int cnt7=0;
            	    loop7:
            	    do {
            	        int alt7=2;
            	        int LA7_0 = input.LA(1);

            	        if ( ((LA7_0>=SEMPRED && LA7_0<=ALT_REWRITE)) ) {
            	            alt7=1;
            	        }
            	        else if ( (LA7_0==UP) ) {
            	            alt7=2;
            	        }


            	        switch (alt7) {
            	    	case 1 :
            	    	    // BasicSemanticTriggers.g:133:17: .
            	    	    {
            	    	    matchAny(input); if (state.failed) return ;

            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt7 >= 1 ) break loop7;
            	    	    if (state.backtracking>0) {state.failed=true; return ;}
            	                EarlyExitException eee =
            	                    new EarlyExitException(7, input);
            	                throw eee;
            	        }
            	        cnt7++;
            	    } while (true);


            	    match(input, Token.UP, null); if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            if ( state.backtracking==1 ) {
              checker.checkNumPrequels(list_o, list_i, list_t);
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "prequelConstructs"


    // $ANTLR start "delegateGrammar"
    // BasicSemanticTriggers.g:138:1: delegateGrammar : ( ^( ASSIGN ID id= ID ) | id= ID ) ;
    public final void delegateGrammar() throws RecognitionException {
        GrammarAST id=null;

        try {
            // BasicSemanticTriggers.g:139:5: ( ( ^( ASSIGN ID id= ID ) | id= ID ) )
            // BasicSemanticTriggers.g:139:9: ( ^( ASSIGN ID id= ID ) | id= ID )
            {
            // BasicSemanticTriggers.g:139:9: ( ^( ASSIGN ID id= ID ) | id= ID )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==ASSIGN) ) {
                alt9=1;
            }
            else if ( (LA9_0==ID) ) {
                alt9=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // BasicSemanticTriggers.g:139:11: ^( ASSIGN ID id= ID )
                    {
                    match(input,ASSIGN,FOLLOW_ASSIGN_in_delegateGrammar306); if (state.failed) return ;

                    match(input, Token.DOWN, null); if (state.failed) return ;
                    match(input,ID,FOLLOW_ID_in_delegateGrammar308); if (state.failed) return ;
                    id=(GrammarAST)match(input,ID,FOLLOW_ID_in_delegateGrammar312); if (state.failed) return ;

                    match(input, Token.UP, null); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // BasicSemanticTriggers.g:140:10: id= ID
                    {
                    id=(GrammarAST)match(input,ID,FOLLOW_ID_in_delegateGrammar326); if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==1 ) {
              checker.checkImport(id.token);
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "delegateGrammar"


    // $ANTLR start "rules"
    // BasicSemanticTriggers.g:145:1: rules : RULES ;
    public final void rules() throws RecognitionException {
        GrammarAST RULES3=null;

        try {
            // BasicSemanticTriggers.g:145:7: ( RULES )
            // BasicSemanticTriggers.g:145:9: RULES
            {
            RULES3=(GrammarAST)match(input,RULES,FOLLOW_RULES_in_rules353); if (state.failed) return ;
            if ( state.backtracking==1 ) {
              checker.checkNumRules(RULES3);
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "rules"


    // $ANTLR start "mode"
    // BasicSemanticTriggers.g:147:1: mode : ^( MODE ID ( . )* ) ;
    public final void mode() throws RecognitionException {
        GrammarAST ID4=null;

        try {
            // BasicSemanticTriggers.g:147:6: ( ^( MODE ID ( . )* ) )
            // BasicSemanticTriggers.g:147:8: ^( MODE ID ( . )* )
            {
            match(input,MODE,FOLLOW_MODE_in_mode365); if (state.failed) return ;

            match(input, Token.DOWN, null); if (state.failed) return ;
            ID4=(GrammarAST)match(input,ID,FOLLOW_ID_in_mode367); if (state.failed) return ;
            // BasicSemanticTriggers.g:147:18: ( . )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( ((LA10_0>=SEMPRED && LA10_0<=ALT_REWRITE)) ) {
                    alt10=1;
                }
                else if ( (LA10_0==UP) ) {
                    alt10=2;
                }


                switch (alt10) {
            	case 1 :
            	    // BasicSemanticTriggers.g:147:18: .
            	    {
            	    matchAny(input); if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);


            match(input, Token.UP, null); if (state.failed) return ;
            if ( state.backtracking==1 ) {
              checker.checkMode(ID4.token);
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "mode"

    public static class option_return extends TreeRuleReturnScope {
    };

    // $ANTLR start "option"
    // BasicSemanticTriggers.g:149:1: option : {...}? ^( ASSIGN o= ID optionValue ) ;
    public final BasicSemanticTriggers.option_return option() throws RecognitionException {
        BasicSemanticTriggers.option_return retval = new BasicSemanticTriggers.option_return();
        retval.start = input.LT(1);

        GrammarAST o=null;
        BasicSemanticTriggers.optionValue_return optionValue5 = null;


        try {
            // BasicSemanticTriggers.g:150:5: ({...}? ^( ASSIGN o= ID optionValue ) )
            // BasicSemanticTriggers.g:150:9: {...}? ^( ASSIGN o= ID optionValue )
            {
            if ( !((inContext("OPTIONS"))) ) {
                if (state.backtracking>0) {state.failed=true; return retval;}
                throw new FailedPredicateException(input, "option", "inContext(\"OPTIONS\")");
            }
            match(input,ASSIGN,FOLLOW_ASSIGN_in_option392); if (state.failed) return retval;

            match(input, Token.DOWN, null); if (state.failed) return retval;
            o=(GrammarAST)match(input,ID,FOLLOW_ID_in_option396); if (state.failed) return retval;
            pushFollow(FOLLOW_optionValue_in_option398);
            optionValue5=optionValue();

            state._fsp--;
            if (state.failed) return retval;

            match(input, Token.UP, null); if (state.failed) return retval;
            if ( state.backtracking==1 ) {

                 	    GrammarAST parent = (GrammarAST)((GrammarAST)retval.start).getParent();   // OPTION
                 		GrammarAST parentWithOptionKind = (GrammarAST)parent.getParent();
                  	boolean ok = checker.checkOptions(parentWithOptionKind,
                  									  o.token, (optionValue5!=null?optionValue5.v:null));
              		//  store options into XXX_GRAMMAR, RULE, BLOCK nodes
                  	if ( ok ) {
                  		((GrammarASTWithOptions)parentWithOptionKind).setOption((o!=null?o.getText():null), (optionValue5!=null?optionValue5.v:null));
                  	}

            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "option"

    public static class optionValue_return extends TreeRuleReturnScope {
        public String v;
    };

    // $ANTLR start "optionValue"
    // BasicSemanticTriggers.g:163:1: optionValue returns [String v] : ( ID | STRING_LITERAL | INT | STAR );
    public final BasicSemanticTriggers.optionValue_return optionValue() throws RecognitionException {
        BasicSemanticTriggers.optionValue_return retval = new BasicSemanticTriggers.optionValue_return();
        retval.start = input.LT(1);

        retval.v = ((GrammarAST)retval.start).token.getText();
        try {
            // BasicSemanticTriggers.g:165:5: ( ID | STRING_LITERAL | INT | STAR )
            // BasicSemanticTriggers.g:
            {
            if ( input.LA(1)==STAR||input.LA(1)==INT||input.LA(1)==STRING_LITERAL||input.LA(1)==ID ) {
                input.consume();
                state.errorRecovery=false;state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "optionValue"


    // $ANTLR start "rule"
    // BasicSemanticTriggers.g:171:1: rule : ^( RULE r= ID ( . )* ) ;
    public final void rule() throws RecognitionException {
        GrammarAST r=null;

        try {
            // BasicSemanticTriggers.g:171:5: ( ^( RULE r= ID ( . )* ) )
            // BasicSemanticTriggers.g:171:9: ^( RULE r= ID ( . )* )
            {
            match(input,RULE,FOLLOW_RULE_in_rule480); if (state.failed) return ;

            match(input, Token.DOWN, null); if (state.failed) return ;
            r=(GrammarAST)match(input,ID,FOLLOW_ID_in_rule484); if (state.failed) return ;
            // BasicSemanticTriggers.g:171:22: ( . )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0>=SEMPRED && LA11_0<=ALT_REWRITE)) ) {
                    alt11=1;
                }
                else if ( (LA11_0==UP) ) {
                    alt11=2;
                }


                switch (alt11) {
            	case 1 :
            	    // BasicSemanticTriggers.g:171:22: .
            	    {
            	    matchAny(input); if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);


            match(input, Token.UP, null); if (state.failed) return ;
            if ( state.backtracking==1 ) {
              checker.checkInvalidRuleDef(r.token);
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "rule"


    // $ANTLR start "ruleref"
    // BasicSemanticTriggers.g:174:1: ruleref : RULE_REF ;
    public final void ruleref() throws RecognitionException {
        GrammarAST RULE_REF6=null;

        try {
            // BasicSemanticTriggers.g:175:5: ( RULE_REF )
            // BasicSemanticTriggers.g:175:7: RULE_REF
            {
            RULE_REF6=(GrammarAST)match(input,RULE_REF,FOLLOW_RULE_REF_in_ruleref507); if (state.failed) return ;
            if ( state.backtracking==1 ) {
              checker.checkInvalidRuleRef(RULE_REF6.token);
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "ruleref"


    // $ANTLR start "tokenAlias"
    // BasicSemanticTriggers.g:178:1: tokenAlias : {...}? ^( ASSIGN ID STRING_LITERAL ) ;
    public final void tokenAlias() throws RecognitionException {
        GrammarAST ID7=null;

        try {
            // BasicSemanticTriggers.g:179:2: ({...}? ^( ASSIGN ID STRING_LITERAL ) )
            // BasicSemanticTriggers.g:179:4: {...}? ^( ASSIGN ID STRING_LITERAL )
            {
            if ( !((inContext("TOKENS"))) ) {
                if (state.backtracking>0) {state.failed=true; return ;}
                throw new FailedPredicateException(input, "tokenAlias", "inContext(\"TOKENS\")");
            }
            match(input,ASSIGN,FOLLOW_ASSIGN_in_tokenAlias526); if (state.failed) return ;

            match(input, Token.DOWN, null); if (state.failed) return ;
            ID7=(GrammarAST)match(input,ID,FOLLOW_ID_in_tokenAlias528); if (state.failed) return ;
            match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_tokenAlias530); if (state.failed) return ;

            match(input, Token.UP, null); if (state.failed) return ;
            if ( state.backtracking==1 ) {
              checker.checkTokenAlias(ID7.token);
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "tokenAlias"


    // $ANTLR start "tokenRefWithArgs"
    // BasicSemanticTriggers.g:183:1: tokenRefWithArgs : {...}? ^( TOKEN_REF ARG_ACTION ) ;
    public final void tokenRefWithArgs() throws RecognitionException {
        GrammarAST TOKEN_REF8=null;

        try {
            // BasicSemanticTriggers.g:184:2: ({...}? ^( TOKEN_REF ARG_ACTION ) )
            // BasicSemanticTriggers.g:184:4: {...}? ^( TOKEN_REF ARG_ACTION )
            {
            if ( !((!inContext("RESULT ..."))) ) {
                if (state.backtracking>0) {state.failed=true; return ;}
                throw new FailedPredicateException(input, "tokenRefWithArgs", "!inContext(\"RESULT ...\")");
            }
            TOKEN_REF8=(GrammarAST)match(input,TOKEN_REF,FOLLOW_TOKEN_REF_in_tokenRefWithArgs555); if (state.failed) return ;

            match(input, Token.DOWN, null); if (state.failed) return ;
            match(input,ARG_ACTION,FOLLOW_ARG_ACTION_in_tokenRefWithArgs557); if (state.failed) return ;

            match(input, Token.UP, null); if (state.failed) return ;
            if ( state.backtracking==1 ) {
              checker.checkTokenArgs(TOKEN_REF8.token);
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "tokenRefWithArgs"

    public static class elementOption_return extends TreeRuleReturnScope {
    };

    // $ANTLR start "elementOption"
    // BasicSemanticTriggers.g:189:1: elementOption : {...}? ^( ELEMENT_OPTIONS ( ^( ASSIGN o= ID value= ID ) | ^( ASSIGN o= ID value= STRING_LITERAL ) | o= ID ) ) ;
    public final BasicSemanticTriggers.elementOption_return elementOption() throws RecognitionException {
        BasicSemanticTriggers.elementOption_return retval = new BasicSemanticTriggers.elementOption_return();
        retval.start = input.LT(1);

        GrammarAST o=null;
        GrammarAST value=null;

        try {
            // BasicSemanticTriggers.g:190:5: ({...}? ^( ELEMENT_OPTIONS ( ^( ASSIGN o= ID value= ID ) | ^( ASSIGN o= ID value= STRING_LITERAL ) | o= ID ) ) )
            // BasicSemanticTriggers.g:190:7: {...}? ^( ELEMENT_OPTIONS ( ^( ASSIGN o= ID value= ID ) | ^( ASSIGN o= ID value= STRING_LITERAL ) | o= ID ) )
            {
            if ( !((!inContext("RESULT ..."))) ) {
                if (state.backtracking>0) {state.failed=true; return retval;}
                throw new FailedPredicateException(input, "elementOption", "!inContext(\"RESULT ...\")");
            }
            match(input,ELEMENT_OPTIONS,FOLLOW_ELEMENT_OPTIONS_in_elementOption586); if (state.failed) return retval;

            match(input, Token.DOWN, null); if (state.failed) return retval;
            // BasicSemanticTriggers.g:192:7: ( ^( ASSIGN o= ID value= ID ) | ^( ASSIGN o= ID value= STRING_LITERAL ) | o= ID )
            int alt12=3;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==ASSIGN) ) {
                int LA12_1 = input.LA(2);

                if ( (LA12_1==DOWN) ) {
                    int LA12_3 = input.LA(3);

                    if ( (LA12_3==ID) ) {
                        int LA12_4 = input.LA(4);

                        if ( (LA12_4==ID) ) {
                            alt12=1;
                        }
                        else if ( (LA12_4==STRING_LITERAL) ) {
                            alt12=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 12, 4, input);

                            throw nvae;
                        }
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 12, 3, input);

                        throw nvae;
                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 12, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA12_0==ID) ) {
                alt12=3;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // BasicSemanticTriggers.g:192:9: ^( ASSIGN o= ID value= ID )
                    {
                    match(input,ASSIGN,FOLLOW_ASSIGN_in_elementOption597); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    o=(GrammarAST)match(input,ID,FOLLOW_ID_in_elementOption601); if (state.failed) return retval;
                    value=(GrammarAST)match(input,ID,FOLLOW_ID_in_elementOption605); if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;

                    }
                    break;
                case 2 :
                    // BasicSemanticTriggers.g:193:11: ^( ASSIGN o= ID value= STRING_LITERAL )
                    {
                    match(input,ASSIGN,FOLLOW_ASSIGN_in_elementOption619); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    o=(GrammarAST)match(input,ID,FOLLOW_ID_in_elementOption623); if (state.failed) return retval;
                    value=(GrammarAST)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_elementOption627); if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;

                    }
                    break;
                case 3 :
                    // BasicSemanticTriggers.g:194:10: o= ID
                    {
                    o=(GrammarAST)match(input,ID,FOLLOW_ID_in_elementOption641); if (state.failed) return retval;

                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return retval;
            if ( state.backtracking==1 ) {

                  	boolean ok = checker.checkTokenOptions((GrammarAST)o.getParent(),
                  										   o.token, (value!=null?value.getText():null));
                  	if ( ok ) {
              			if ( value!=null ) {
              	    		TerminalAST terminal = (TerminalAST)((GrammarAST)retval.start).getParent();
              	    		terminal.setOption((o!=null?o.getText():null), (value!=null?value.getText():null));
                  		}
                  		else {
              	    		TerminalAST terminal = (TerminalAST)((GrammarAST)retval.start).getParent();
              	    		terminal.setOption(TerminalAST.defaultTokenOption, (o!=null?o.getText():null));
                  		}
                  	}

            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "elementOption"

    public static class multiElementAltInTreeGrammar_return extends TreeRuleReturnScope {
    };

    // $ANTLR start "multiElementAltInTreeGrammar"
    // BasicSemanticTriggers.g:214:1: multiElementAltInTreeGrammar : {...}? ^( ALT ~ ( SEMPRED | ACTION ) (~ ( SEMPRED | ACTION ) )+ ) ;
    public final BasicSemanticTriggers.multiElementAltInTreeGrammar_return multiElementAltInTreeGrammar() throws RecognitionException {
        BasicSemanticTriggers.multiElementAltInTreeGrammar_return retval = new BasicSemanticTriggers.multiElementAltInTreeGrammar_return();
        retval.start = input.LT(1);

        try {
            // BasicSemanticTriggers.g:215:2: ({...}? ^( ALT ~ ( SEMPRED | ACTION ) (~ ( SEMPRED | ACTION ) )+ ) )
            // BasicSemanticTriggers.g:215:4: {...}? ^( ALT ~ ( SEMPRED | ACTION ) (~ ( SEMPRED | ACTION ) )+ )
            {
            if ( !((inContext("ALT_REWRITE"))) ) {
                if (state.backtracking>0) {state.failed=true; return retval;}
                throw new FailedPredicateException(input, "multiElementAltInTreeGrammar", "inContext(\"ALT_REWRITE\")");
            }
            match(input,ALT,FOLLOW_ALT_in_multiElementAltInTreeGrammar681); if (state.failed) return retval;

            match(input, Token.DOWN, null); if (state.failed) return retval;
            if ( (input.LA(1)>=FORCED_ACTION && input.LA(1)<=NESTED_ACTION)||(input.LA(1)>=ACTION_ESC && input.LA(1)<=ALT_REWRITE) ) {
                input.consume();
                state.errorRecovery=false;state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            // BasicSemanticTriggers.g:216:28: (~ ( SEMPRED | ACTION ) )+
            int cnt13=0;
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( ((LA13_0>=FORCED_ACTION && LA13_0<=NESTED_ACTION)||(LA13_0>=ACTION_ESC && LA13_0<=ALT_REWRITE)) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // BasicSemanticTriggers.g:216:28: ~ ( SEMPRED | ACTION )
            	    {
            	    if ( (input.LA(1)>=FORCED_ACTION && input.LA(1)<=NESTED_ACTION)||(input.LA(1)>=ACTION_ESC && input.LA(1)<=ALT_REWRITE) ) {
            	        input.consume();
            	        state.errorRecovery=false;state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt13 >= 1 ) break loop13;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(13, input);
                        throw eee;
                }
                cnt13++;
            } while (true);


            match(input, Token.UP, null); if (state.failed) return retval;
            if ( state.backtracking==1 ) {

              		int altNum = ((GrammarAST)retval.start).getParent().getChildIndex() + 1; // alts are 1..n
              		GrammarAST firstNode = (GrammarAST)((GrammarAST)retval.start).getChild(0);
              		checker.checkRewriteForMultiRootAltInTreeGrammar(root.getOptions(),
              														 firstNode.token,
              														 altNum);

            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "multiElementAltInTreeGrammar"

    public static class astOps_return extends TreeRuleReturnScope {
    };

    // $ANTLR start "astOps"
    // BasicSemanticTriggers.g:227:1: astOps : ( ^( ROOT el= . ) | ^( BANG el= . ) );
    public final BasicSemanticTriggers.astOps_return astOps() throws RecognitionException {
        BasicSemanticTriggers.astOps_return retval = new BasicSemanticTriggers.astOps_return();
        retval.start = input.LT(1);

        GrammarAST el=null;

        try {
            // BasicSemanticTriggers.g:228:2: ( ^( ROOT el= . ) | ^( BANG el= . ) )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==ROOT) ) {
                alt14=1;
            }
            else if ( (LA14_0==BANG) ) {
                alt14=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // BasicSemanticTriggers.g:228:4: ^( ROOT el= . )
                    {
                    match(input,ROOT,FOLLOW_ROOT_in_astOps716); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    el=(GrammarAST)input.LT(1);
                    matchAny(input); if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;
                    if ( state.backtracking==1 ) {
                      checker.checkASTOps(root.getOptions(), ((GrammarAST)retval.start), el);
                    }

                    }
                    break;
                case 2 :
                    // BasicSemanticTriggers.g:229:4: ^( BANG el= . )
                    {
                    match(input,BANG,FOLLOW_BANG_in_astOps729); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    el=(GrammarAST)input.LT(1);
                    matchAny(input); if (state.failed) return retval;

                    match(input, Token.UP, null); if (state.failed) return retval;
                    if ( state.backtracking==1 ) {
                      checker.checkASTOps(root.getOptions(), ((GrammarAST)retval.start), el);
                    }

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "astOps"

    public static class rewrite_return extends TreeRuleReturnScope {
    };

    // $ANTLR start "rewrite"
    // BasicSemanticTriggers.g:232:1: rewrite : ( RESULT | ST_RESULT ) ;
    public final BasicSemanticTriggers.rewrite_return rewrite() throws RecognitionException {
        BasicSemanticTriggers.rewrite_return retval = new BasicSemanticTriggers.rewrite_return();
        retval.start = input.LT(1);

        try {
            // BasicSemanticTriggers.g:233:2: ( ( RESULT | ST_RESULT ) )
            // BasicSemanticTriggers.g:233:4: ( RESULT | ST_RESULT )
            {
            if ( (input.LA(1)>=ST_RESULT && input.LA(1)<=RESULT) ) {
                input.consume();
                state.errorRecovery=false;state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            if ( state.backtracking==1 ) {
              checker.checkRewriteOk(root.getOptions(),((GrammarAST)retval.start));
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "rewrite"


    // $ANTLR start "wildcardRoot"
    // BasicSemanticTriggers.g:237:1: wildcardRoot : ^( TREE_BEGIN WILDCARD ( . )* ) ;
    public final void wildcardRoot() throws RecognitionException {
        GrammarAST WILDCARD9=null;

        try {
            // BasicSemanticTriggers.g:238:5: ( ^( TREE_BEGIN WILDCARD ( . )* ) )
            // BasicSemanticTriggers.g:238:7: ^( TREE_BEGIN WILDCARD ( . )* )
            {
            match(input,TREE_BEGIN,FOLLOW_TREE_BEGIN_in_wildcardRoot770); if (state.failed) return ;

            match(input, Token.DOWN, null); if (state.failed) return ;
            WILDCARD9=(GrammarAST)match(input,WILDCARD,FOLLOW_WILDCARD_in_wildcardRoot772); if (state.failed) return ;
            // BasicSemanticTriggers.g:238:29: ( . )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( ((LA15_0>=SEMPRED && LA15_0<=ALT_REWRITE)) ) {
                    alt15=1;
                }
                else if ( (LA15_0==UP) ) {
                    alt15=2;
                }


                switch (alt15) {
            	case 1 :
            	    // BasicSemanticTriggers.g:238:29: .
            	    {
            	    matchAny(input); if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);


            match(input, Token.UP, null); if (state.failed) return ;
            if ( state.backtracking==1 ) {
              checker.checkWildcardRoot(WILDCARD9.token);
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "wildcardRoot"

    // Delegated rules


    protected DFA1 dfa1 = new DFA1(this);
    static final String DFA1_eotS =
        "\15\uffff";
    static final String DFA1_eofS =
        "\15\uffff";
    static final String DFA1_minS =
        "\1\33\3\uffff\1\2\2\uffff\1\127\1\61\1\3\1\uffff\1\0\1\uffff";
    static final String DFA1_maxS =
        "\1\145\3\uffff\1\2\2\uffff\2\127\1\3\1\uffff\1\0\1\uffff";
    static final String DFA1_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\uffff\1\5\1\7\3\uffff\1\4\1\uffff\1\6";
    static final String DFA1_specialS =
        "\13\uffff\1\0\1\uffff}>";
    static final String[] DFA1_transitionS = {
            "\1\1\10\uffff\1\3\11\uffff\1\4\32\uffff\1\5\1\2\31\uffff\2\6",
            "",
            "",
            "",
            "\1\7",
            "",
            "",
            "\1\10",
            "\1\12\17\uffff\1\12\2\uffff\1\11\22\uffff\1\12",
            "\1\13",
            "",
            "\1\uffff",
            ""
    };

    static final short[] DFA1_eot = DFA.unpackEncodedString(DFA1_eotS);
    static final short[] DFA1_eof = DFA.unpackEncodedString(DFA1_eofS);
    static final char[] DFA1_min = DFA.unpackEncodedStringToUnsignedChars(DFA1_minS);
    static final char[] DFA1_max = DFA.unpackEncodedStringToUnsignedChars(DFA1_maxS);
    static final short[] DFA1_accept = DFA.unpackEncodedString(DFA1_acceptS);
    static final short[] DFA1_special = DFA.unpackEncodedString(DFA1_specialS);
    static final short[][] DFA1_transition;

    static {
        int numStates = DFA1_transitionS.length;
        DFA1_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA1_transition[i] = DFA.unpackEncodedString(DFA1_transitionS[i]);
        }
    }

    class DFA1 extends DFA {

        public DFA1(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 1;
            this.eot = DFA1_eot;
            this.eof = DFA1_eof;
            this.min = DFA1_min;
            this.max = DFA1_max;
            this.accept = DFA1_accept;
            this.special = DFA1_special;
            this.transition = DFA1_transition;
        }
        public String getDescription() {
            return "86:1: topdown : ( grammarSpec | rules | mode | option | rule | tokenAlias | rewrite );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TreeNodeStream input = (TreeNodeStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 :
                        int LA1_11 = input.LA(1);


                        int index1_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( ((inContext("OPTIONS"))) ) {s = 10;}

                        else if ( ((inContext("TOKENS"))) ) {s = 12;}


                        input.seek(index1_11);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 1, _s, input);
            error(nvae);
            throw nvae;
        }
    }


    public static final BitSet FOLLOW_grammarSpec_in_topdown87 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rules_in_topdown92 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_mode_in_topdown97 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_option_in_topdown102 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule_in_topdown107 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tokenAlias_in_topdown112 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rewrite_in_topdown117 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_multiElementAltInTreeGrammar_in_bottomup129 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_astOps_in_bottomup134 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleref_in_bottomup139 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tokenRefWithArgs_in_bottomup144 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_elementOption_in_bottomup149 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_checkGrammarOptions_in_bottomup154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_wildcardRoot_in_bottomup160 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GRAMMAR_in_grammarSpec178 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_grammarSpec180 = new BitSet(new long[]{0x0000000000580040L,0x0000000000000400L});
    public static final BitSet FOLLOW_DOC_COMMENT_in_grammarSpec182 = new BitSet(new long[]{0x0000000000580000L,0x0000000000000400L});
    public static final BitSet FOLLOW_prequelConstructs_in_grammarSpec199 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_RULES_in_grammarSpec202 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_GRAMMAR_in_checkGrammarOptions225 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OPTIONS_in_prequelConstructs248 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IMPORT_in_prequelConstructs261 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_delegateGrammar_in_prequelConstructs263 = new BitSet(new long[]{0x0000400000000008L,0x0000000000800000L});
    public static final BitSet FOLLOW_TOKENS_in_prequelConstructs274 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ASSIGN_in_delegateGrammar306 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_delegateGrammar308 = new BitSet(new long[]{0x0000000000000000L,0x0000000000800000L});
    public static final BitSet FOLLOW_ID_in_delegateGrammar312 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ID_in_delegateGrammar326 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULES_in_rules353 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MODE_in_mode365 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_mode367 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF8L,0x0000007FFFFFFFFFL});
    public static final BitSet FOLLOW_ASSIGN_in_option392 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_option396 = new BitSet(new long[]{0x0002000000000000L,0x0000000000800012L});
    public static final BitSet FOLLOW_optionValue_in_option398 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_set_in_optionValue0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_in_rule480 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_rule484 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF8L,0x0000007FFFFFFFFFL});
    public static final BitSet FOLLOW_RULE_REF_in_ruleref507 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ASSIGN_in_tokenAlias526 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_tokenAlias528 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_tokenAlias530 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_TOKEN_REF_in_tokenRefWithArgs555 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ARG_ACTION_in_tokenRefWithArgs557 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ELEMENT_OPTIONS_in_elementOption586 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ASSIGN_in_elementOption597 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_elementOption601 = new BitSet(new long[]{0x0000000000000000L,0x0000000000800000L});
    public static final BitSet FOLLOW_ID_in_elementOption605 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ASSIGN_in_elementOption619 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_elementOption623 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_elementOption627 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ID_in_elementOption641 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ALT_in_multiElementAltInTreeGrammar681 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_set_in_multiElementAltInTreeGrammar683 = new BitSet(new long[]{0xFFFFFFFFFFFEFFE0L,0x0000007FFFFFFFFFL});
    public static final BitSet FOLLOW_set_in_multiElementAltInTreeGrammar690 = new BitSet(new long[]{0xFFFFFFFFFFFEFFE8L,0x0000007FFFFFFFFFL});
    public static final BitSet FOLLOW_ROOT_in_astOps716 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_BANG_in_astOps729 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_set_in_rewrite747 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TREE_BEGIN_in_wildcardRoot770 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_WILDCARD_in_wildcardRoot772 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF8L,0x0000007FFFFFFFFFL});

}