package com.databinding;

import java.beans.PropertyEditorSupport;

/*
* INFO : PropertyEditor 의 value 는 threadfull 즉 쓰레드 safe 하지 못하므로
*        절대로 빈으로 등록하여서 (빈은 동일한 스레드를 가짐) 사용하면 안된다.
*/
public class EventEditor extends PropertyEditorSupport {

    @Override
    public String getAsText() {
        Event event = (Event)getValue();
        return event.getId().toString();
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        setValue(new Event(Integer.parseInt(text)));
    }
}
