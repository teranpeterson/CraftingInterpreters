package jlox;

abstract class Stmt {
  interface Visitor<T> {
    T visitExpressionStmt(Expression stmt);
    T visitPrintStmt(Print stmt);
    T visitVarStmt(Var stmt);
  }
  static class Expression extends Stmt {
    Expression(Expr expression) {
      this.expression = expression;
    }

    @Override
    <T> T accept(Visitor<T> visitor) {
      return visitor.visitExpressionStmt(this);
    }

    final Expr expression;
  }
  static class Print extends Stmt {
    Print(Expr expression) {
      this.expression = expression;
    }

    @Override
    <T> T accept(Visitor<T> visitor) {
      return visitor.visitPrintStmt(this);
    }

    final Expr expression;
  }
  static class Var extends Stmt {
    Var(Token name, Expr initializer) {
      this.name = name;
      this.initializer = initializer;
    }

    @Override
    <T> T accept(Visitor<T> visitor) {
      return visitor.visitVarStmt(this);
    }

    final Token name;
    final Expr initializer;
  }

  abstract <T> T accept(Visitor<T> visitor);
}
