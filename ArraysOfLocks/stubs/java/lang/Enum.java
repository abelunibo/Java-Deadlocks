package java.lang;

/**
 * @generated
 */
public abstract class Enum extends java.lang.Object implements java.lang.Comparable, java.io.Serializable {
   /**
    * @generated
    */
   /*@ public behavior
     @ requires true;
     @ ensures true;
     @ assignable \everything;
     @*/
   public final java.lang.String name();

   /**
    * @generated
    */
   /*@ public behavior
     @ requires true;
     @ ensures true;
     @ assignable \everything;
     @*/
   public final int ordinal();

   /**
    * @generated
    */
   /*@ protected behavior
     @ requires true;
     @ ensures true;
     @ assignable \everything;
     @*/
   protected Enum(java.lang.String param0, int param1);

   /**
    * @generated
    */
   /*@ public behavior
     @ requires true;
     @ ensures true;
     @ assignable \everything;
     @*/
   public final java.lang.Class getDeclaringClass();
}