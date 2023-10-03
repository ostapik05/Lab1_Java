package task3;

public class ValidateEmail {
    public static boolean validateEmail(final String email) {

        final int atSymbol = email.indexOf('@');
        final int dotSymbol = email.lastIndexOf('.');

        if (email == null || email.isEmpty()) {
            return false;
        }

        if (atSymbol < 1 || dotSymbol < atSymbol + 2 || dotSymbol >= email.length() - 2) {
            return false;
        }

        if (email.contains(" ")) {
            return false;
        }

        return true;
    }

    public static void main(final String[] args) {
        final String email = "girniakostap@gmail.com!@";
        System.out.println(validateEmail(email));
    }
}
