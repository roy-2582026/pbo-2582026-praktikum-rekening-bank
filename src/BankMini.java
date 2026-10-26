import java.util.Scanner;

public class BankMini {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        Rekening rekening = new Rekening("001", "Ani", 100000);

        // Saldo hanya dapat diubah melalui metode setor() dan tarik()git add src/BankMini.java

        // Percobaan akses langsung ke saldo:
        // rekening.saldo = 1000000;
        // Error: saldo has private access in Rekening

        System.out.println("============ BANK MINI ============");
        System.out.println("Rekening 001 an Ani");

        int pilihan;

        do {
            System.out.print("Menu (1 setor, 2 tarik, 3 info, 0 keluar): ");
            pilihan = input.nextInt();

            switch (pilihan) {

                case 1:
                    System.out.print("Jumlah: ");
                    int jumlahSetor = input.nextInt();

                    if (rekening.setor(jumlahSetor)) {
                        System.out.println("Berhasil");
                    } else {
                        System.out.println("Ditolak");
                    }
                    break;

                case 2:
                    System.out.print("Jumlah: ");
                    int jumlahTarik = input.nextInt();

                    if (rekening.tarik(jumlahTarik)) {
                        System.out.println("Berhasil");
                    } else {
                        System.out.println("Ditolak");
                    }
                    break;

                case 3:
                    rekening.cetakInfo();
                    break;

                case 0:
                    break;

                default:
                    System.out.println("Menu tidak dikenal");
            }

        } while (pilihan != 0);

        System.out.println("=========== SALDO AKHIR ===========");
        rekening.cetakInfo();

        input.close();
    }
}