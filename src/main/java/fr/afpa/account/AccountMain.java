package fr.afpa.account;

import java.util.ArrayList;

/**
 * Classe principale du projet, contient la fonction "main"
 */
public class AccountMain
{
	public static void main(String[] args) 
	{
		System.out.println("\n----- Exercice de programmation objet - classes \"Account\" & \"Customer\" -----");
		
		// Instancier des objets de la classe "Account"
		// Création des comptes
		/*
		 * Crée deux instances de la classe Account avec des IBAN, des soldes et des autorisations de découvert spécifiques.
		 */
		Account account1 = new Account("FR7630006000011234567890189", 500, 100);
		Account account2 = new Account("FR7630006000011234567890190", 1000, 200);

		// Instancier des objets de la classe "Customer"
		// Création d'un client
		/*
		 * Crée une instance de la classe Customer avec le nom "John Doe".
		 */
		Customer customer = new Customer("John Doe");
		
		// Ajouter un ou plusieurs objet de "Account" à des "Customer"
		// Association des comptes au client
		/*
		 * Ajoute les deux comptes bancaires à la liste des comptes du client.
		 */
		customer.addAccount(account1);
		customer.addAccount(account2);
		
		// Afficher les informations des employés avec System.out.println
		// Affichage des informations du client
		/*
		 * 	Affiche les informations du client, y compris les détails de ses comptes bancaires.
		 */
		System.out.println(customer);

		
        // Test des méthodes
        account1.addMoney(200);
        account1.removeMoney(300);
        account1.transfer(account2, 400);
		

		/*
		* Teste les méthodes addMoney, removeMoney et transfer 
		de la classe Account.
		*/
        // Affichage des comptes après opérations
        System.out.println(account1);
        System.out.println(account2);
		
		// 2-1-2) Vérification de l'IBAN
		System.out.println("\n----- 2.1.2) \tVérification de l'IBAN -----");
		//Crée un objet Account et teste la méthode checkIban avec différents IBAN.
		//Affiche les résultats de la vérification.
		// Vérification de l'IBAN
		Account account3 = new Account("FR7630001007941234567890185", 5000, 200);
		
		boolean isCorrectIban = Account.checkIban("FR7630006000011234567890189");
		System.out.println("IBAN FR7630006000011234567890189 est valide : " + isCorrectIban);
		// vérification de l'IBAN "FR76 4255 9000 0112 3456 78901 21"
		isCorrectIban = Account.checkIban("FR7642559000011234567890121");
		System.out.println("IBAN FR7642559000011234567890121 est valide : " + isCorrectIban);
		
		// 2-2) Méthode principale pour tester la classe Customer
		System.out.println("\n----- 2.2.1\tClasse \"Customer\" -----");
		// Instancier des objets de la classe Customer
		Customer customer1 = new Customer(1, "John", "Doe");
		Customer customer2 = new Customer(2, "Jane", "Smith");

		// Afficher les informations des clients
		/*System.out.println(customer1);
		System.out.println(customer2);*/

		// Modifier les prénoms et noms des clients
		customer1.setFirstName("Johnny");
		customer1.setLastName("Doeman");
		customer2.setFirstName("Janet");
		customer2.setLastName("Smithson");

		// Afficher les informations des clients après modification
		System.out.println(customer1);
		System.out.println(customer2);

		// 2.2.2	Relation entre « Customer » et « Account »
		System.out.println("\n----- 2.2.2\tRelation entre « Customer » et « Account »  -----");
		// Créer des comptes
        Account account4 = new Account("FR7630001007941234567890185", 5000, 1000);
        Account account5 = new Account("FR7642559000011234567890121", 3000, 500);

        // Créer un client
        Customer customer4 = new Customer(1, "John", "Doe");

        // Ajouter des comptes au client
        customer4.addAccount(account4);
        customer4.addAccount(account5);

        // Afficher les informations du client et ses comptes
        System.out.println(customer4);
        customer4.displayAccounts();

        // Effectuer des opérations
        account4.addMoney(1000);
        account4.removeMoney(2000);
        account4.transfer(account5, 1000);

        // Afficher les comptes après les opérations
        System.out.println("Après les opérations:");
        customer4.displayAccounts();

        // Supprimer un compte du client
        customer4.removeAccount(account4);

        // Afficher les comptes après suppression
        System.out.println("Après suppression d'un compte:");
        customer4.displayAccounts();

		// 2.2.4	La classse ArrayList
		System.out.println("\n----- 2.2.4\tLa classe ArrayList  -----");
		// Instanciation d'une ArrayList de Customer
        ArrayList<Customer> customerss = new ArrayList<>();
		// Création de clients
        Customer customer6 = new Customer(1, "John", "Doe");
        Customer customer7 = new Customer(2, "Jane", "Smith");

        // Ajout de clients à la liste
        customerss.add(customer6);
        customerss.add(customer7);

        // Création de comptes
        Account account6 = new Account("FR7630001007941234567890185", 5000, 1000);
        Account account7 = new Account("FR7642559000011234567890121", 3000, 500);

        // Ajout de comptes aux clients
        customer6.addAccount(account7);
        customer7.addAccount(account6);

        // Affichage des clients et de leurs comptes
        for (Customer customers : customers) {
            System.out.println(customers);
            customers.displayAccounts();
        }

        // Suppression d'un compte
        customer1.removeAccount(account6);

        // Affichage après suppression
        System.out.println("Après suppression d'un compte:");
        for (Customer customer : customers) {
            System.out.println(customer);
            customer.displayAccounts();
        }
    }
}