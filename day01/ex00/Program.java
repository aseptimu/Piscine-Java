package ex00;

public class Program {
    public static void main(String[] args) {
        User vasya = new User();
        User petya = new User();

        vasya.setName("Vasya");
        vasya.setBalance(100);
        vasya.setIdentifier(0);

        petya.setName("Petya");
        petya.setBalance(200);
        petya.setIdentifier(1);

        Transaction t1 = new Transaction(petya, vasya, 1000);
        System.out.println(t1.getStatus() + "\nVasya balance: " +
                vasya.getBalance() + "\nPetya balance: " + petya.getBalance());

        Transaction t2 = new Transaction(petya, vasya, -50);
        System.out.println(t2.getStatus() + " " + t2.getCategory() + "\nVasya balance: " +
                vasya.getBalance() + "\nPetya balance: " + petya.getBalance());

        Transaction t3 = new Transaction(petya, vasya, 100);
        System.out.println(t3.getStatus() + " " + t3.getCategory() + "\nVasya balance: " +
                vasya.getBalance() + "\nPetya balance: " + petya.getBalance());
    }
}
