package fr.afpa.account;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe qui représente un client, propriétaire de comptes bancaires
 */

/*
 * Déclare la classe Customer. Elle importe également les classes
 * ArrayList et List de la bibliothèque standard Java pour gérer des
 * collections de comptes bancaires.
 */
public class Customer {

    /*
     * Déclare deux attributs privés :
     * • name : le nom du client, de type String.
     * • accounts : une liste de comptes bancaires associés au client,
     * de type List<Account>.
     */
    /*private String name;
    private List<Account> accounts;*/

    /*
     * Pour implémenter la classe Customer en Java conformément au diagramme UML
     * fourni, nous devons créer une classe avec des attributs pour l'identifiant,
     * le prénom et le nom de famille. Ensuite, nous devons ajouter un constructeur,
     * des accesseurs (getters), des mutateurs (setters) et une méthode toString.
     */
    private int id;
    private String firstName;
    private String lastName;
    private List<Account> accounts;

    /*
     * Constructeur de la classe Customer. Il initialise le nom du client
     * (name) avec la valeur passée en paramètre et crée une nouvelle liste
     * vide pour les comptes (accounts).
     */
    // public Customer(String name) {
    //     this.firstName = name;
    //     this.accounts = new ArrayList<>();
    // }

    /*
     * pour l'identifiant, le prénom et le nom de famille. Ensuite, nous devons
     * ajouter un constructeur :
     */
    public Customer(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.accounts = new ArrayList<>();
    }

    /*
     * Méthode getter pour l'attribut name. Elle renvoie la valeur de name.
     */
    /*public String getName() {
        return name;
    }*/

    /*
     * pour l'identifiant :
     */
    public int getId() {
        return id;
    }

    // Getter pour le prénom
    public String getFirstName() {
        return firstName;
    }

    // Getter pour le nom de famille
    public String getLastName() {
        return lastName;
    }

    /*
     * Méthode setter pour l'attribut name. Elle permet de modifier la valeur de
     * name.
     */
    /*public void setName(String name) {
        this.name = name;
    }*/

     // Setter pour le nom de famille
     public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // Setter pour le prénom
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    // autres méthodes

    /*
     * Méthode pour ajouter un compte bancaire à la liste des comptes du client.
     * Elle
     * prend en paramètre un compte (account) et l'ajoute à la liste accounts.
     */
    public void addAccount(Account account) {
        this.accounts.add(account);
    }

    // Supprimer un compte
    public boolean removeAccount(Account account) {
        return accounts.remove(account);
    }

    // Méthode pour afficher les comptes du client
    public void displayAccounts() {
        for (Account account : accounts) {
            System.out.println(account);
        }
    }


    /*
     * Méthode toString pour afficher les informations du client sous forme de
     * chaîne
     * de caractères. Elle est utilisée pour imprimer les détails du client de
     * manière lisible.
     */
    /*@Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", accounts=" + accounts +
                '}';
    }*/

    // Méthode toString pour une représentation en chaîne de caractères de l'objet
    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

}
