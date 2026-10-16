import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterType;
import com.unpri.charactermanager.model.CharacterManager;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        System.out.println("=== Character Manager v0.3 — Analytics ===\n");

        CharacterManager manager = new CharacterManager();

        // ===== BAGIAN A: CRUD dasar =====
        manager.addCharacter(new Character("Arjuna", CharacterType.WARRIOR, 5));
        manager.addCharacter(new Character("Merlin", CharacterType.MAGE, 3));
        manager.addCharacter(new Character("Athena", CharacterType.ARCHER, 4));

        System.out.println();
        manager.addCharacter(new Character("Arjuna", CharacterType.HEALER, 1));   // duplikat, harus ditolak

        System.out.println("\nTotal karakter: " + manager.getTotalCharacters());

        System.out.println("\n--- Eksperimen defensive copy ---");
        ArrayList<Character> salinan = manager.getAllCharacters();
        salinan.clear();                                                          // kosongkan salinan
        System.out.println("Setelah salinan.clear(), total di manager: " + manager.getTotalCharacters());

        System.out.println("\n--- Pencarian ---");
        Character hasil = manager.findByName("Merlin");
        System.out.println(hasil != null ? "Ditemukan: " + hasil : "Tidak ditemukan");

        System.out.println("\n--- Penghapusan ---");
        manager.removeCharacter("Athena");
        System.out.println("Total setelah hapus: " + manager.getTotalCharacters());

        // ===== BAGIAN B: Mini-Challenge =====
        System.out.println("\n--- Rata-rata level ---");
        System.out.println("Rata-rata (2 karakter): " + manager.getAverageLevel());

        System.out.println("\n--- Filter berdasarkan tipe ---");
        manager.addCharacter(new Character("Zeno", CharacterType.WARRIOR, 2));
        ArrayList<Character> warriors = manager.findByType(CharacterType.WARRIOR);
        System.out.println("Jumlah WARRIOR: " + warriors.size());
        for (Character c : warriors) {
            System.out.println("  " + c);
        }
        System.out.println("Jumlah HEALER: " + manager.findByType(CharacterType.HEALER).size());

        System.out.println("\n--- Edge case: manager kosong ---");
        CharacterManager kosong = new CharacterManager();
        System.out.println("Rata-rata list kosong: " + kosong.getAverageLevel());
        System.out.println("Strongest list kosong: " + kosong.findStrongest());

        // ===== BAGIAN C: Fitur sendiri =====
        System.out.println("\n--- Karakter terkuat ---");
        Character terkuat = manager.findStrongest();
        System.out.println("Terkuat: " + terkuat);

        System.out.println("\n--- Daftar akhir ---");
        for (Character c : manager.getAllCharacters()) {
            System.out.println(c);
        }
    }
}