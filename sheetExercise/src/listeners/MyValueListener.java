package listeners;


import events.ValueChangeEvent;

public class MyValueListener implements ValueListener {

    private ValueChangeEvent valueChangeEvent;

    @Override
    public void onChange( Object obj ) {

      ValueChangeEvent event = ( (ValueChangeEvent ) obj );
        setValueChangeEvent( event );

        String rowStr = "Row number = " + event.getRowNumber() + "\n";
        String columnStr = "Column = " + event.getColumn() + "\n";
        String oldValueStr = "Old value = " + event.getOldValue() + "\n";
        String newValueStr = "New value = " + event.getNewValue() + "\n";

        System.out.println(rowStr + columnStr + oldValueStr + newValueStr);


    }

    public void setValueChangeEvent( ValueChangeEvent valueChangeEvent ) {
        this.valueChangeEvent = valueChangeEvent;
    }
}
