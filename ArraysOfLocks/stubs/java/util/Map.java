package java.util;

/**
 * @generated
 */
public interface Map {
   /**
    * @generated
    */
   /*@ public behavior
     @ requires true;
     @ ensures true;
     @ assignable \everything;
     @*/
   public abstract int size();

   /**
    * @generated
    */
   /*@ public behavior
     @ requires true;
     @ ensures true;
     @ assignable \everything;
     @*/
   public abstract boolean isEmpty();

   /**
    * @generated
    */
   /*@ public behavior
     @ requires true;
     @ ensures true;
     @ assignable \everything;
     @*/
   public abstract boolean containsKey(java.lang.Object param0);

   /**
    * @generated
    */
   /*@ public behavior
     @ requires true;
     @ ensures true;
     @ assignable \everything;
     @*/
   public abstract boolean containsValue(java.lang.Object param0);

   /**
    * @generated
    */
   /*@ public behavior
     @ requires true;
     @ ensures true;
     @ assignable \everything;
     @*/
   public abstract java.lang.Object get(java.lang.Object param0);

   /**
    * @generated
    */
   /*@ public behavior
     @ requires true;
     @ ensures true;
     @ assignable \everything;
     @*/
   public abstract java.lang.Object remove(java.lang.Object param0);

   /**
    * @generated
    */
   /*@ public behavior
     @ requires true;
     @ ensures true;
     @ assignable \everything;
     @*/
   public abstract void clear();

   /**
    * @generated
    */
   /*@ public behavior
     @ requires true;
     @ ensures true;
     @ assignable \everything;
     @*/
   public abstract java.util.Set keySet();

   /**
    * @generated
    */
   /*@ public behavior
     @ requires true;
     @ ensures true;
     @ assignable \everything;
     @*/
   public abstract java.util.Collection values();

   /**
    * @generated
    */
   /*@ public behavior
     @ requires true;
     @ ensures true;
     @ assignable \everything;
     @*/
   public abstract java.util.Set entrySet();

   /**
    * @generated
    */
   public static interface Entry {
      /**
       * @generated
       */
      /*@ public behavior
        @ requires true;
        @ ensures true;
        @ assignable \everything;
        @*/
      public abstract boolean equals(java.lang.Object param0);

      /**
       * @generated
       */
      /*@ public behavior
        @ requires true;
        @ ensures true;
        @ assignable \everything;
        @*/
      public abstract int hashCode();
   }
}