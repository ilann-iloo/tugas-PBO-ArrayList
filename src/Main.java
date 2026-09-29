import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input data nasabah dari pengguna
        System.out.println("=== PENDAFTARAN NASABAH BARU ===");
        System.out.print("Masukkan Nama Depan: ");
        String fName = scanner.nextLine();
        System.out.print("Masukkan Nama Belakang: ");
        String lName = scanner.nextLine();

        Customer customer = new Customer(fName, lName);
        System.out.println("\nNasabah " + customer.getFirstName() + " " + customer.getLastName() + " berhasil dibuat!");

        // Menambahkan akun pertama dengan saldo awal dari input
        System.out.print("\nMasukkan saldo awal untuk Akun pertama: Rp ");
        double initialBalance = scanner.nextDouble();
        
        customer.setAccount(new Account(initialBalance));
        System.out.println("Akun berhasil ditambahkan. Total akun: " + customer.getNumOfAccounts());

        // Mengakses akun pertama untuk melakukan simulasi transaksi
        Account currentAccount = customer.getAccount(0);
        System.out.println("\n--- SIMULASI TRANSAKSI ---");
        System.out.println("Saldo saat ini: Rp " + currentAccount.getBalance());

        // Simulasi Setor Tunai
        System.out.print("Masukkan jumlah uang yang ingin disetor: Rp ");
        double depositAmount = scanner.nextDouble();
        if (currentAccount.deposit(depositAmount)) {
            System.out.println("Setor tunai berhasil! Saldo baru: Rp " + currentAccount.getBalance());
        } else {
            System.out.println("Jumlah setor tunai tidak valid.");
        }

        // Simulasi Tarik Tunai
        System.out.print("Masukkan jumlah uang yang ingin ditarik: Rp ");
        double withdrawAmount = scanner.nextDouble();
        if (currentAccount.withdraw(withdrawAmount)) {
            System.out.println("Tarik tunai berhasil! Sisa saldo: Rp " + currentAccount.getBalance());
        } else {
            System.out.println("Tarik tunai gagal! Saldo tidak mencukupi atau jumlah tidak valid.");
        }

        System.out.println("\nTerima kasih, program selesai.");
        scanner.close();
    }
}