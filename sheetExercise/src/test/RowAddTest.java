package test;

import domain.Sheet;
import events.RowAddEvent;
import listeners.RowListener;

public class RowAddTest {

    public static void main( String[] args ) {

        Sheet sheet1 = new Sheet();

        RowListener rowListener = new RowListener() {
            @Override
            public void onChange( Object obj ) {
                RowAddEvent event = (RowAddEvent ) obj;

                String rowStr = "Row number = " + event.getRowNumber() + "\n";
                System.out.println(rowStr);

            }
        };

        sheet1.addListener( rowListener );
        sheet1.set( 2, "a","foo" );
        sheet1.set( 5, "b", "foo" );
        sheet1.set( 1, "c","bar" );
//        sheet1.set( 1000, "d", "baz" );


    }
}
