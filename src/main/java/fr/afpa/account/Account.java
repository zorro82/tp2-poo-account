package fr.afpa.account;
 /*
  * 1) Importe la classe Pattern pour 
  les expressions régulières, même si elle n'est pas utilisée dans cet exemple,
   elle pourrait être utile pour d'autres validations.
  */
//import java.util.regex.Pattern;

/**
 * Classe représentant un compte bancaire
 *  une classe est une structure qui permet de définir des objets avec des 
 * attributs et des méthodes.
 */

 // 2.	Déclaration de la classe Account et des attributs:
 // Déclare la classe Account et les attributs privés IBAN, balance, et
 // overdraftAuthorization.
public class Account {    
    
     // Attributs
    /*Déclare trois attributs privés :
    •	IBAN : un identifiant unique pour le compte bancaire, de type String.
    •	balance : le solde du compte, de type int.
    •	overdraftAuthorization : le montant autorisé de découvert, de type int.
    */
     private String IBAN;
     private int balance;
     private int overdraftAuthorization;
 
     // Constructeurs
     /*
      * 3) Constructeur de la classe Account. Il initialise les attributs IBAN, 
      balance, et overdraftAuthorization avec les valeurs passées en paramètres.
      */
    /*
     * Initialise les attributs de l'objet Account lors de sa création.
     */
     public Account(String IBAN, int balance, int overdraftAuthorization) {
        this.IBAN = IBAN;
        this.balance = balance;
        this.overdraftAuthorization = overdraftAuthorization;
    }
        // 4) Méthodes d'accès et de modification des attributs de la classe. 
     // Getters
     /*
      * Méthode getter pour l'attribut IBAN. Elle renvoie la valeur de IBAN.
      */
     public String getIBAN() {
        return IBAN;
    }

    /*
     * Méthode getter pour l'attribut balance. Elle renvoie la valeur de balance.
     */
    public int getBalance() {
        return balance;
    }

    /*
     * Méthode getter pour l'attribut overdraftAuthorization. Elle renvoie la 
     * valeur de overdraftAuthorization.
     */
    public int getOverdraftAuthorization() {
        return overdraftAuthorization;
    }

     // Setters
     /*
      * Méthode setter pour l'attribut IBAN. Elle permet de modifier la valeur de IBAN.
      */
     public void setIBAN(String IBAN) {
        this.IBAN = IBAN;
    }

    /*
     * Méthode setter pour l'attribut balance. Elle permet de modifier la valeur de balance.
     */
    public void setBalance(int balance) {
        this.balance = balance;
    }

    /* 
    *Méthode setter pour l'attribut overdraftAuthorization. Elle permet de modifier la 
    valeur de overdraftAuthorization.
    */
    public void setOverdraftAuthorization(int overdraftAuthorization) {
        this.overdraftAuthorization = overdraftAuthorization;
    }

     // Autres méthodes

    /*
     * Méthode pour ajouter de l'argent au compte. Elle prend en paramètre un montant (amount)
     *  et l'ajoute au solde (balance).
     */

    // 5) Méthodes de gestion de l'argent:
    public void addMoney(int amount) {
        this.balance += amount;
    }

    /*
     * Méthode pour retirer de l'argent du compte. Elle prend en paramètre un montant (amount)
     *  et vérifie si le retrait ne dépasse pas l'autorisation de découvert (overdraftAuthorization). 
     * Si c'est le cas, elle affiche un message et retourne false. Sinon, elle déduit le montant du 
     * solde et retourne true.
     */
    public boolean removeMoney(int amount) {
        if (this.balance - amount < -this.overdraftAuthorization) {
            System.out.println("Retrait impossible, dépasse l'autorisation de découvert!");
            return false;
        }
        this.balance -= amount;
        return true;
    }

    /*
     * Méthode pour transférer de l'argent vers un autre compte. Elle prend en paramètre un autre 
     * compte (toAccount) et un montant (amount). Elle tente de retirer l'argent du compte courant.
     *  Si le retrait est réussi, elle ajoute l'argent au compte cible et retourne true. Sinon, 
     * elle retourne false.
     */
    public boolean transfer(Account toAccount, int amount) {
        if (this.removeMoney(amount)) {
            toAccount.addMoney(amount);
            return true;
        }
        return false;
    }

    /*
    * 6) Méthode toString pour afficher les informations du compte sous forme de chaîne de caractères. Elle est utilisée pour imprimer les détails du compte de manière lisible.
    */
    //Retourne une représentation sous forme de chaîne de caractères de l'objet Account.
    @Override
    public String toString() {
        return "Account{" +
                "IBAN='" + IBAN + '\'' +
                ", balance=" + balance +
                ", overdraftAuthorization=" + overdraftAuthorization +
                '}';
    }

    // 7) Méthode statique de vérification de l'IBAN
    /*
        * Vérifie si une chaîne de caractères est un IBAN valide.
rearranged est la chaîne avec les quatre premiers caractères déplacés à la fin.
numericIban convertit chaque caractère en une valeur numérique.
mod97 est utilisée pour vérifier la validité de l'IBAN.
        */
    public static boolean checkIban(String stringToCheck) {
        if (stringToCheck == null || stringToCheck.length() < 15 || stringToCheck.length() > 34) {
            return false;
        }
        String rearranged = stringToCheck.substring(4) + stringToCheck.substring(0, 4);
        StringBuilder numericIban = new StringBuilder();
        for (char c : rearranged.toCharArray()) {
            int numericValue = Character.getNumericValue(c);
            if (numericValue < 0 || numericValue > 35) {
                return false;
            }
            numericIban.append(numericValue);
        }
        return mod97(numericIban.toString()) == 1;
    }

    /*
        * 8.	Méthode mod97:
        * Calcule le reste de la division de la chaîne de caractères convertie par 97.
        */
    private static int mod97(String input) {
        int checksum = 0;
        for (int i = 0; i < input.length(); i++) {
            checksum = (checksum * 10 + (input.charAt(i) - '0')) % 97;
        }
        return checksum;
    }
}