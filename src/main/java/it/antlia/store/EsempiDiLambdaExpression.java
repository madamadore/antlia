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



public class EsempiDiLambdaExpression {
    
    public static void esempiConButton() {

        Button btn = new Button(new MouseEvent() {
            @Override
            public void onClick() {
                //....
            }
        });

        Button b = new Button((x,y)->{});

    }
    public static void esempiConStore() {

        // le seguenti dichiarazioni di un oggetto di tipo 
        // Store<Book> sono equivalenti.
        // Store<T> è un'interfaccia, ma qui non viene istanziata
        // un'iterfaccia, bensì un oggetto anonimo che implementa 
        // l'interfaccia Store<T>
        Store<Book> store1 = new Store<Book>() {
            @Override
            public Book getAny(int i) {
                return null;
            }
        };
        Store<Book> store2 = i -> null;
        Store<Book> store3 = i -> { return null; };
        Store<Book> store4 = (i) -> { 
            /// toher stuff
            return null; 
        };
    }
}
