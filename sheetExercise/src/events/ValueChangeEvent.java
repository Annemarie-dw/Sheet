package events;

public class ValueChangeEvent implements Event {

    private int rowNumber;
    private String column;
    private String oldValue;
    private String newValue;

    public ValueChangeEvent( int rowNumber, String column, String oldValue, String newValue ) {
        this.setRowNumber( rowNumber );
        this.setColumn( column );
        this.setOldValue( oldValue );
        this.setNewValue( newValue );

    }

    public int getRowNumber() {
        return rowNumber;
    }

    public String getColumn() {
        return column;
    }

    public String getOldValue() {
        return oldValue;
    }

    public String getNewValue() {
        return newValue;
    }

    public void setRowNumber( int rowNumber ) {
        this.rowNumber = rowNumber;
    }

    public void setColumn( String column ) {
        this.column = column;
    }

    public void setOldValue( String oldValue ) {
        this.oldValue = oldValue;
    }

    public void setNewValue( String newValue ) {
        this.newValue = newValue;
    }
}

