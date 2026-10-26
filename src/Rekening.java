import java.text.NumberFormat;
import java.util.Locale;

public class Rekening {
    // 1. Field private sesuai ketentuan
    private String nomor;
    private String pemilik;
    private int saldo;

    // 2. Constructor dengan parameter bernama sama, diisi memakai this
    public Rekening(String nomor, String pemilik, int saldo) {
        this.nomor = nomor;
        this.pemilik = pemilik;
        this.saldo = saldo;
    }

    // 3. Saldo read-only (hanya ada getter, tanpa setter saldo)
    public int getSaldo() {
        return saldo;
    }

    // Method private untuk format rupiah
    private String formatRupiah(int angka) {
        Locale localeID = new Locale("in", "ID");
        NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(localeID);
        return formatRupiah.format(angka).replace("Rp", "Rp ");
    }

    // 4. Method setor dengan validasi jumlah > 0
    public boolean setor(int jumlah) {
        if (jumlah > 0) {
            saldo += jumlah;
            return true;
        }
        return false;
    }

    // 4. Method tarik dengan validasi jumlah > 0 dan tidak melebihi saldo
    public boolean tarik(int jumlah) {
        if (jumlah > 0 && jumlah <= saldo) {
            saldo -= jumlah;
            return true;
        }
        return false;
    }

    // 5. Method cetakInfo mencetak format: 001 | Ani | Rp120.000
    public void cetakInfo() {
        System.out.println(nomor + " | " + pemilik + " | " + formatRupiah(saldo));
    }
}