/*
 * @(#)Visitor.java                        2.1 2003/10/07
 *
 * Copyright (C) 1999, 2003 D.A. Watt and D.F. Brown
 * Dept. of Computing Science, University of Glasgow, Glasgow G12 8QQ Scotland
 * and School of Computer and Math Sciences, The Robert Gordon University,
 * St. Andrew Street, Aberdeen AB25 1HG, Scotland.
 * All rights reserved.
 *
 * This software is provided free for educational use only. It may
 * not be used for commercial purposes without the prior written permission
 * of the authors.
 */

package Triangle.AbstractSyntaxTrees;

public interface Visitor {

  // Commands
  Object visitAssignCommand(AssignCommand ast, Object o);
  Object visitCallCommand(CallCommand ast, Object o);
  Object visitEmptyCommand(EmptyCommand ast, Object o);
  Object visitIfCommand(IfCommand ast, Object o);
  Object visitLetCommand(LetCommand ast, Object o);
  Object visitSequentialCommand(SequentialCommand ast, Object o);
  Object visitWhileCommand(WhileCommand ast, Object o);


  // Expressions
  Object visitArrayExpression(ArrayExpression ast, Object o);
  Object visitBinaryExpression(BinaryExpression ast, Object o);
  Object visitCallExpression(CallExpression ast, Object o);
  Object visitCharacterExpression(CharacterExpression ast, Object o);
  Object visitEmptyExpression(EmptyExpression ast, Object o);
  Object visitIfExpression(IfExpression ast, Object o);
  Object visitIntegerExpression(IntegerExpression ast, Object o);
  Object visitLetExpression(LetExpression ast, Object o);
  Object visitRecordExpression(RecordExpression ast, Object o);
  Object visitUnaryExpression(UnaryExpression ast, Object o);
  Object visitVnameExpression(VnameExpression ast, Object o);

  // Declarations
  Object visitBinaryOperatorDeclaration(BinaryOperatorDeclaration ast, Object o);
  Object visitConstDeclaration(ConstDeclaration ast, Object o);
  Object visitFuncDeclaration(FuncDeclaration ast, Object o);
  Object visitProcDeclaration(ProcDeclaration ast, Object o);
  Object visitSequentialDeclaration(SequentialDeclaration ast, Object o);
  Object visitTypeDeclaration(TypeDeclaration ast, Object o);
  Object visitUnaryOperatorDeclaration(UnaryOperatorDeclaration ast, Object o);
  Object visitVarDeclaration(VarDeclaration ast, Object o);
  Object visitInitializedVarDeclaration(InitializedVarDeclaration ast, Object o); // TODO;
  Object visitLocalDeclaration(LocalDeclaration ast, Object o); // TODO;
  Object visitRecursiveDeclaration(RecursiveDeclaration ast, Object o);

  // Array Aggregates
  Object visitMultipleArrayAggregate(MultipleArrayAggregate ast, Object o);
  Object visitSingleArrayAggregate(SingleArrayAggregate ast, Object o);

  // Record Aggregates
  Object visitMultipleRecordAggregate(MultipleRecordAggregate ast, Object o);
  Object visitSingleRecordAggregate(SingleRecordAggregate ast, Object o);

  // Formal Parameters
  Object visitConstFormalParameter(ConstFormalParameter ast, Object o);
  Object visitFuncFormalParameter(FuncFormalParameter ast, Object o);
  Object visitProcFormalParameter(ProcFormalParameter ast, Object o);
  Object visitVarFormalParameter(VarFormalParameter ast, Object o);

  Object visitEmptyFormalParameterSequence(EmptyFormalParameterSequence ast, Object o);
  Object visitMultipleFormalParameterSequence(MultipleFormalParameterSequence ast, Object o);
  Object visitSingleFormalParameterSequence(SingleFormalParameterSequence ast, Object o);

  // Actual Parameters
  Object visitConstActualParameter(ConstActualParameter ast, Object o);
  Object visitFuncActualParameter(FuncActualParameter ast, Object o);
  Object visitProcActualParameter(ProcActualParameter ast, Object o);
  Object visitVarActualParameter(VarActualParameter ast, Object o);

  Object visitEmptyActualParameterSequence(EmptyActualParameterSequence ast, Object o);
  Object visitMultipleActualParameterSequence(MultipleActualParameterSequence ast, Object o);
  Object visitSingleActualParameterSequence(SingleActualParameterSequence ast, Object o);

  // Type Denoters
  Object visitAnyTypeDenoter(AnyTypeDenoter ast, Object o);
  Object visitArrayTypeDenoter(ArrayTypeDenoter ast, Object o);
  Object visitBoolTypeDenoter(BoolTypeDenoter ast, Object o);
  Object visitCharTypeDenoter(CharTypeDenoter ast, Object o);
  Object visitErrorTypeDenoter(ErrorTypeDenoter ast, Object o);
  Object visitSimpleTypeDenoter(SimpleTypeDenoter ast, Object o);
  Object visitIntTypeDenoter(IntTypeDenoter ast, Object o);
  Object visitRecordTypeDenoter(RecordTypeDenoter ast, Object o);

  Object visitMultipleFieldTypeDenoter(MultipleFieldTypeDenoter ast, Object o);
  Object visitSingleFieldTypeDenoter(SingleFieldTypeDenoter ast, Object o);

  // Literals, Identifiers and Operators
  Object visitCharacterLiteral(CharacterLiteral ast, Object o);
  Object visitIdentifier(Identifier ast, Object o);
  Object visitIntegerLiteral(IntegerLiteral ast, Object o);
  Object visitOperator(Operator ast, Object o);

  // Value-or-variable names
  Object visitDotVname(DotVname ast, Object o);
  Object visitSimpleVname(SimpleVname ast, Object o);
  Object visitSubscriptVname(SubscriptVname ast, Object o);

  // Programs
  Object visitProgram(Program ast, Object o);

  // New Declarations
  Object visitForDeclaration(ForDeclaration ast, Object o);

  //New Commands
  Object visitUntilCommand(UntilCommand ast, Object o);
  Object visitDoUntilCommand(DoUntilCommand ast, Object o);
  Object visitDoWhileCommand(DoWhileCommand ast, Object o);
  Object visitForCommand(ForCommand ast, Object o);


}
