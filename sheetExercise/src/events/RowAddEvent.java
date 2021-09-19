package events;

public class RowAddEvent implements Event {

    private int rowNumber;

    public RowAddEvent ( int rowNumber ){
        this.setRowNumber( rowNumber );

    }

    public int getRowNumber() {
        return rowNumber;
    }

    public void setRowNumber( int rowNumber ) {
        this.rowNumber = rowNumber;
    }
}
