package domain;

import events.RowAddEvent;
import events.ValueChangeEvent;
import listeners.Listener;
import listeners.RowListener;
import listeners.ValueListener;

import java.util.*;
import java.util.logging.Logger;

public class Sheet {

    private List<Map<String, String>> rows = new ArrayList<>();
    private final int maxRows = 100;
    private final Logger LOGGER = Logger.getLogger( String.valueOf( Sheet.class ) );

    private List<Listener> listeners = new ArrayList<>();
    private ValueListener valueListener;
    private RowListener rowListener;



    public void addListener( Listener listener ) {
        listeners.add( listener );
    }

    public void set( int rowNumber, String column, String newValue ) {

        if ( rowNumber > maxRows ) {
            throw new IllegalArgumentException( "Row number " + rowNumber + " can not exceeds the maximum row number of " + maxRows );
        }

        Map<String, String> row = getOrCreateRow( rowNumber );

        String oldValue = row.put( column, newValue );

        for ( Listener listener : listeners ) {

            if ( listener instanceof ValueListener ) {
                valueListener = ( ValueListener ) listener;
                valueListener.onChange( new ValueChangeEvent(rowNumber, column, oldValue, newValue  ) );
            }
        }
    }

    public String get( int rowNumber, String key ) {

        boolean rowExist = doesRowExist( rowNumber );

        if ( !rowExist ) {
            throw new IllegalArgumentException( "The row " + rowNumber + " does not exist!" );
        }

        Map<String, String> row = getRow( rowNumber );

        String value = row.get( key );

        return value;

    }

    private Map<String, String> getOrCreateRow( int rowNumber ) {

        boolean rowExist = doesRowExist( rowNumber );

        if ( !rowExist ) {
            addRows( rowNumber );
        }

        Map<String, String> row = getRow( rowNumber );

        return row;
    }

    private void addRows( int rowNumber ) {

        int rowSize = rows.size();

        int numberOfRowsToAdd = rowNumber - rowSize;

        for ( int i = 0; i < numberOfRowsToAdd; i++ ) {
            int index = rowSize++;
            Map<String, String> row = new LinkedHashMap<>();
            rows.add( index, row );

        for ( Listener listener : listeners ) {
            if ( listener instanceof  RowListener )  {
                rowListener = ( RowListener ) listener;
                rowListener.onChange( new RowAddEvent( (index) +1 ) );
            }

        }

        }
    }

    private Map<String, String> getRow( int rowNumber ) {

        int index = convertRowToIndex( rowNumber );

        Map<String, String> row = rows.get( index );

        return row;
    }

    public void printSheet() {

        System.out.println( "Sheet size = " + rows.size() );
        rows.forEach( System.out::println );
    }

    private int convertRowToIndex( int row ) {
        int index = row - 1;
        return index;
    }

    private boolean doesRowExist( int row ) {

        if ( row <= rows.size() ) {
            return true;
        }
        return false;

    }

}



