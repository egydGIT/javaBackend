/*
Levelezés
Egy levelet egy Mail osztály tárol, a következő attribútumokkal: feladó, címzettek, tárgy és szöveg.
A feladót és a címzetteket egy Contract tárol, melynek két attribútuma van: viselt név és e-mail cím.
A MailBox tárolja a leveleket egy Mail listában. Ennek legyen egy findByCriteria() metódusa,
mely paraméterként egy keresési feltételt vár, és leveleket ad vissza.

A keresési feltételek lehetnek:

from:John Doe vagy from:johndoe@example.com - from: előtaggal visszaadja az összes olyan levelet,
ahol a feladó neve vagy e-mail címe pontosan a from: után szereplő szöveg
to:John Doe vagy to:johndoe@example.com - from: előtaggal visszaadja az összes olyan levelet,
ahol a címzettek között szerepel olyan, akinek a neve vagy e-mail címe pontosan a to: után szereplő szöveg
egyéb esetben visszaadja az összes olyan levelet, amiben szerepel a tárgyban vagy üzenetben a megadott szó
 */

package exam03retake01;

import java.util.List;

public class Mail {

    private Contact from;
    private List<Contact> to;
    private String subject;
    private String message;

    public Mail(Contact from, List<Contact> to, String subject, String message) {
        this.from = from;
        this.to = to;
        this.subject = subject;
        this.message = message;
    }

    public Contact getFrom() {
        return from;
    }

    public List<Contact> getTo() {
        return to;
    }

    public String getSubject() {
        return subject;
    }

    public String getMessage() {
        return message;
    }
}
