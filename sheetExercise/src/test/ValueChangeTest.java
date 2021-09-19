package test;

import domain.Sheet;
import events.ValueChangeEvent;
import listeners.MyValueListener;
import listeners.ValueListener;

public class ValueChangeTest {

    public static void main( String[] args ) {

        Sheet sheet2 = new Sheet();
        MyValueListener listener = new MyValueListener();

        sheet2.addListener( listener );
        sheet2.set( 2, "a", "foo" );
//        sheet2.set( 1, "b","bar" );
//        sheet2.set( 2, "a", "baz" );
//        sheet2.set( 10000, "b", "foo" );

    }

}

