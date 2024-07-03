package fr.afpa.account;

public class BankDemo {
    public static void main(String[] args) {
        // Création des comptes avec des informations différentes
        Account account1 = new Account("FR7630006000011234567890189", 500, 100);
        Account account2 = new Account("FR7630006000011234567890190", 1000, 200);
        Account account3 = new Account("FR7630006000011234567890191", 200, 50);

        // Affichage des informations initiales des comptes
        System.out.println("Informations initiales des comptes:");
        System.out.println(account1);
        System.out.println(account2);
        System.out.println(account3);

        // Ajout d'argent aux comptes
        account1.addMoney(300);
        account2.addMoney(500);
        account3.addMoney(100);

        // Affichage des comptes après ajout d'argent
        System.out.println("\nAprès ajout d'argent:");
        System.out.println(account1);
        System.out.println(account2);
        System.out.println(account3);

        // Retrait d'argent des comptes
        account1.removeMoney(600);
        account2.removeMoney(1200);  // Ceci devrait échouer
        account3.removeMoney(150);

        // Affichage des comptes après retrait d'argent
        System.out.println("\nAprès retrait d'argent:");
        System.out.println(account1);
        System.out.println(account2);
        System.out.println(account3);

        // Transfert d'argent entre les comptes
        account1.transfer(account3, 200);
        account2.transfer(account1, 300);

        // Affichage des comptes après transfert d'argent
        System.out.println("\nAprès transfert d'argent:");
        System.out.println(account1);
        System.out.println(account2);
        System.out.println(account3);
    }
}
