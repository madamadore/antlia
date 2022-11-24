package it.antlia.store;

import it.antlia.store.model.Book;

interface Store<T> {
    T getAny(int id);
}

interface MouseEvent {
    void onClick();
}

class Button {
    private MouseEvent event;

    public Button(MouseEvent event) {
        this.event = event;
    }
    void onClick() {
        event.onClick();
    }
}

class MyStore implements Store<Book> {

    @Override
    public Book getAny() {
        return null;
    }
}

public class Prove {
    
    public static void main(String [] args) {


        Button btn = new Button(new MouseEvent() {
            @Override
            public void onClick() {
                //....
            }
        });


        MyStore store = new MyStore();


        Store<Book> store2 = new Store<Book>() {
            @Override
            public Book getAny(int i) {
                return null;
            }
        };

        Store<Book> bookStore = i -> null;
    }
}
