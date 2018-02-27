import java.io.Serializable;

/**
 * All Java enum implicitly extends java.lang.Enum class that extends Object class and implements
 * Serializable and Comparable interfaces,so we can't extend any class in enum(single inheritance),An enum type is
 * implicitly final unless it contains at least one enum constant that has a class body.
 *
 * Enum can implement interfaces.
 *
 * Enum constructors are always private.Enum type can not be instantiated.you can't create instance
 * of Enum using new operator.
 *
 * we can declare abstract methods in Java enum,the all the enum fields must implement the abstract
 * method.
 *
 * we can define a method in enum and enum fields can override them too.
 *
 * enum constants are implicitly static and final,but it's variable can still be changed.
 */
public enum MyEnum implements Serializable{
    BROKER,TOPIC,UNKNOWN
}
