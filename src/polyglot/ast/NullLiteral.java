package jltools.ast;

import jltools.util.*;
import jltools.types.LocalContext;

/**
 * An Literal represents the Java literal <code>null</code>.
 */
public class NullLiteral extends Literal 
{
  /**
   * Creates a new NullLiteral object.
   */
  public NullLiteral() {}

  public NullLiteral(Node ext) {this.ext = ext;}

    public NullLiteral reconstruct(Node ext) {
	if (this.ext == ext) { return this; } else {return new NullLiteral(ext);}
    }

  public Node typeCheck(LocalContext c)
  {
    setCheckedType( c.getTypeSystem().getNull());
    return this;
  }

  public void translate( LocalContext c, CodeWriter w)
  {
    w.write( "null");
  }

  public void dump( CodeWriter w)
  {
    w.write( "NULL ");
    dumpNodeInfo( w);
  }
}
