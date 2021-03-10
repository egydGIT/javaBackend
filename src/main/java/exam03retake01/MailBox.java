package exam03retake01;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MailBox {

    private List<Mail> mails = new ArrayList<>();


    public List<Mail> getMails() {
        // return mails;
        return new ArrayList<>(mails);                  // copy konstruktor
    }

    public void addMail(Mail mail) {
        mails.add(mail);
    }

//    public List<Mail> findByCriteria(String s) {
//        // paraméterként egy keresési feltételt vár, és leveleket ad vissza
//        List<Mail> foundMails = new ArrayList<>();
//        String[] array = s.split(":");
//        String[] splittedEmail = array[1].split("@");
//        for (Mail m : mails) {
//            if (array[0].contains("from")) {
//                if (m.getFrom().getName().toLowerCase().contains(array[1].toLowerCase())
//                        || m.getFrom().getEmail().toLowerCase().contains(splittedEmail[0].toLowerCase())) {
//                    foundMails.add(m);
//                }
//            }
//        }
//        return foundMails;
//    }

    public List<Mail> findByCriteria(String criteria) {
        // paraméterként egy keresési feltételt vár, és leveleket ad vissza
        if (criteria.startsWith("to:")) {
            return findTo(criteria.substring(3));
        }
        if (criteria.startsWith("from:")) {
            return findFrom(criteria.substring(5));
        }
        else {
            return findContent(criteria);
        }
    }

    private List<Mail> findContent(String criteria) {               // Szűrés tétele
        List<Mail> foundMails = new ArrayList<>();
        for (Mail mail: mails) {
//            if (mail.getMessage().contains(criteria) || mail.getSubject().contains(criteria)) {
//                foundMails.add(mail);
//            }
            if (mail.match(criteria)) {
                foundMails.add(mail);
            }
        }
        return foundMails;
    }

    private List<Mail> findTo(String substring) {
        List<Mail> foundMails = new ArrayList<>();
        for (Mail mail: mails) {
            for (Contact contact: mail.getTo()) {
//                if (contact.getName().toLowerCase().equals(substring) || contact.getEmail().equals(substring)) {
//                    foundMails.add(mail);
//                }
                if (contact.match(substring)) {
                    foundMails.add(mail);
                }
            }
        }
        return foundMails;
    }

    private List<Mail> findFrom(String substring) {
        List<Mail> foundMails = new ArrayList<>();
        for (Mail mail: mails) {
//            if (mail.getFrom().getName().toLowerCase().equals(substring) || mail.getFrom().getEmail().equals(substring)) {
//                foundMails.add(mail);
//            }
            if (mail.getFrom().match(substring)) {
                foundMails.add(mail);
            }
        }
        return foundMails;
    }

}
