import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Main {
    static InputStreamReader isr = new InputStreamReader(System.in);
    static BufferedReader br = new BufferedReader(isr);
    static ArrayList<ListGame> dataGame = new ArrayList<>();
    static ArrayList<Pesanan> dataPesanan = new ArrayList<>();

    // clear screen
    static public void cls(){
        System.out.print("\033[H\033[2J");  
        System.out.flush(); 
    }

    // time sleep 
    static public void delay(int millisecond){
        try {
            Thread.sleep(millisecond);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    // biar garis outputnya rapi
    static public void garis_tabel(int jarak){
        for (int i = 0 ; i < jarak ; i++){
            System.out.print(" ");
        }
        System.out.println("||");
    }

    // gaya gayaan aja
    static public void loading(int panjang){
        for (int j = 0 ; j < panjang ; j++){
            char loading = (char)22;
            System.out.print(loading);
            if (j % 10 == 0){
                delay(1000);
            }
        }
    }
    
    // disini emg gaada getch kah? sementara pake ini jdi pengganti getch
    static public String gtc;

    // cek ada game yang sama atau 
    static boolean cek_game(String game){
        for (int i = 0 ; i < dataGame.size() ; i++){
            if (dataGame.get(i).get_game().equals(game)){
                return false;
            }
        }
        return true;
    }

    // buat menu yang admin
    static private void admin() throws IOException{
        boolean menu = true;
        while (menu) {
            cls();
            System.out.println("===================================================");
            System.out.println("  >>  Selamat Datang Di Menu Admin Udin.TopUp  <<  ");
            System.out.println("===================================================");
            System.out.println("  [1]\tTambah Data Jenis Game");
            System.out.println("  [2]\tLihat Data Jenis Game");
            System.out.println("  [3]\tEdit Data Jenis Game");
            System.out.println("  [4]\tHapus Data Jenis Game");
            System.out.println("  [5]\tCari Data Jenis Game");
            System.out.println("  [6]\tLihat Riwayat Aktivitas Top UP");
            System.out.println("  [0]\tLogout");
            System.out.println("===================================================");
            System.out.print("Masukkan Pilihan Menu >> "); String pilih = br.readLine();
            switch (pilih){
                case "1":
                    cls();
                    Boolean loop = true;
                    ArrayList<Integer> jenis = new ArrayList<>();
                    System.out.println("===================================================");
                    System.out.println("     >>  Tambah Data Jenis Game Udin.TopUp  <<     ");
                    System.out.println("===================================================");
                    while (true){
                        System.out.print("Masukkan Nama Game             : "); String game = br.readLine();
                        if (cek_game(game) == true){
                            System.out.print("Masukkan Mata Uang Game        : "); String mataUang = br.readLine();
                            while (loop){
                                System.out.print("Masukkan Jumlah Variasi Top UP : "); int jenis_topup = Integer.parseInt(br.readLine());
                                System.out.print("Masukkan Harga Variasi Top UP  : Rp"); int harga_topup = Integer.parseInt(br.readLine());
                                jenis.add(jenis_topup);
                                jenis.add(harga_topup);
                                while (true){
                                    System.out.print("\nTambah Variasi Top Up Lagi [Y/N] ? "); String ulang = br.readLine();
                                    if (ulang.equalsIgnoreCase("n") || ulang.equalsIgnoreCase("N")){
                                        ListGame game_baru = new ListGame(game, mataUang, jenis);
                                        dataGame.add(game_baru);
                                        System.out.print("\nData Berhasil Ditambahkan! Tekan ENTER Untuk Melanjutkan..."); gtc = br.readLine();
                                        loop = false;
                                        break;
                                    } else if (ulang.equalsIgnoreCase("y") || ulang.equalsIgnoreCase("Y")){
                                        System.out.println("");
                                        break;
                                    } else {
                                        System.out.println("\nInput Anda Salah! Silahkan Input Ulang");
                                    }
                                }
                            }
                            break;
                        } else {
                            System.out.print("\nNama Game Sudah Ada, Silahkan input Yang Lain"); gtc = br.readLine();
                        }
                    }
                    break;
                case "2":
                    if (dataGame.size() > 0){
                        cls();
                        System.out.println("===================================================");
                        System.out.println(" >>  Data Seluruh Jenis Top Up Game Udin.TopUp  << ");
                        System.out.println("===================================================");
                        for (int i = 0 ; i < dataGame.size() ; i++){
                            dataGame.get(i).display();
                        }
                        System.out.print("\nTekan ENTER Untuk Melanjutkan..."); gtc = br.readLine();
                    } else {
                        System.out.print("\nData Jenis Game Masih Kosong, Silahkan Isi Data Dulu..."); gtc = br.readLine();
                    }
                    break;
                case "3":
                    if (dataGame.size() > 0){
                        cls();
                        System.out.println("==================================================");
                        System.out.println("  >>  Edit Data Jenis Top Up Game Udin.TopUp  <<  ");
                        System.out.println("==================================================");
                        for (int i = 0 ; i < dataGame.size() ; i++){
                            dataGame.get(i).display();
                        }
                        System.out.print("Masukkan Nama Game Yang Ingin Diedit : "); String edit = br.readLine();
                        for (int i = 0 ; i < dataGame.size() ; i++){
                            if (dataGame.get(i).get_game().equals(edit)){
                                String game_edit;
                                int cari_edit, variasi_edit, harga_edit;
                                ArrayList<Integer> data_edit = new ArrayList<>();
                                boolean loop_edit = true, edit_variasi = true;
                                while (loop_edit) {
                                    cls();
                                    loop_edit = false;
                                    System.out.println("===================================================");
                                    System.out.println("            >>    Data Ditemukan    <<             ");
                                    System.out.println("===================================================");
                                    dataGame.get(i).display();
                                    System.out.println("  [1]\tEdit Nama Game");
                                    System.out.println("  [2]\tEdit Jenis Variasi Top UP");
                                    System.out.println("  [3]\tEdit Semua");
                                    System.out.println("  [0]\tKembali");
                                    System.out.println("===================================================");
                                    System.out.print("Masukkan Pilihan Menu >> "); pilih = br.readLine();
                                    switch(pilih){
                                        case "1":
                                        while (true){
                                            cls();
                                            System.out.println("===================================================");
                                            System.out.println("          >>    Edit Data Nama Game    <<          ");
                                            System.out.println("===================================================");
                                            dataGame.get(i).display();
                                            System.out.print("Masukkan Nama Game Yang Baru : "); game_edit = br.readLine();
                                            if (cek_game(game_edit) == true){
                                                dataGame.get(i).edit_data(game_edit, 0, data_edit, 1);
                                                break;
                                            } else {
                                                System.out.print("\nNama Game Telah Digunakan, Silahkan Gunakan Nama Yang Lain..."); gtc = br.readLine();
                                            }
                                        }
                                        break;
                                    case "2":
                                        cls();
                                        System.out.println("===================================================");
                                        System.out.println("       >>    Edit Data Variasi Top Up     <<       ");
                                        System.out.println("===================================================");
                                        dataGame.get(i).display();
                                        System.out.print("Masukkan Jumlah Variasi Yang Ingin Diedit : "); cari_edit = Integer.parseInt(br.readLine());
                                        if (dataGame.get(i).cek_variasi(cari_edit) == true){
                                            System.out.print("Masukkan Variasi Top Up Yang Baru : "); variasi_edit = Integer.parseInt(br.readLine());
                                            System.out.print("Masukkan Harga Top Up Yang Baru   : Rp"); harga_edit = Integer.parseInt(br.readLine());
                                            data_edit.add(variasi_edit);
                                            data_edit.add(harga_edit);
                                            dataGame.get(i).edit_data("", dataGame.get(i).idx_variasi(cari_edit), data_edit, 2);
                                        } else {
                                            System.out.print("\nData Tidak Ditemukan!"); gtc = br.readLine();
                                        }
                                        break;
                                    case "3":
                                        while (true){
                                            cls();
                                            System.out.println("===================================================");
                                            System.out.println("     >>    Edit Semua Data Top Up Game     <<      ");
                                            System.out.println("===================================================");
                                            dataGame.get(i).display();
                                            System.out.print("Masukkan Nama Game Yang Baru      : "); String game = br.readLine();
                                            if (cek_game(game) == true){
                                                while (edit_variasi){
                                                    System.out.print("Masukkan Variasi Top Up Yang Baru : "); variasi_edit = Integer.parseInt(br.readLine());
                                                    System.out.print("Masukkan Harga Top Up Yang Baru   : Rp"); harga_edit = Integer.parseInt(br.readLine());
                                                    data_edit.add(variasi_edit);
                                                    data_edit.add(harga_edit);
                                                    while (true){
                                                        System.out.print("\nTambah Variasi Top Up Lagi [Y/N] ? "); String ulang = br.readLine();
                                                        if (ulang.equalsIgnoreCase("n") || ulang.equalsIgnoreCase("N")){
                                                            dataGame.get(i).edit_data(game, 0, data_edit, 3);
                                                            edit_variasi = false;
                                                            break;
                                                        } else if (ulang.equalsIgnoreCase("y") || ulang.equalsIgnoreCase("Y")){
                                                            System.out.println("");
                                                            break;
                                                        } else {
                                                            System.out.println("\nInput Anda Salah! Silahkan Input Ulang");
                                                        }
                                                    }
                                                }
                                                break;
                                            } else {
                                                System.out.print("\nNama Game Telah Digunakan, Silahkan Gunakan Nama Yang Lain..."); gtc = br.readLine();
                                            }
                                        }
                                        break;
                                    case "0":
                                        break;
                                    default:
                                        System.out.print("\nMenu Tidak Ditemukan! Silahkan Input Menu Kembali"); gtc = br.readLine();
                                        loop_edit = true;
                                    }
                                }
                                break;
                            } else if (i == dataGame.size()){
                                System.out.print("\nData Tidak Ditemukan..."); gtc = br.readLine();
                            }
                        }
                    } else {
                        System.out.print("\nData Jenis Game Masih Kosong, Silahkan Isi Data Dulu..."); gtc = br.readLine();
                    }
                    break;
                case "4":
                    if (dataGame.size() > 0){
                        cls();
                        System.out.println("===================================================");
                        System.out.println("  >>  Hapus Data Jenis Top Up Game Udin.TopUp  <<  ");
                        System.out.println("===================================================");
                        for (int i = 0 ; i < dataGame.size() ; i++){
                            dataGame.get(i).display();
                        }
                        System.out.print("Masukkan Nama Game Yang Ingin Dihapus : "); String hapus_game = br.readLine();
                        for (int i = 0 ; i < dataGame.size() ; i++){
                            if (dataGame.get(i).get_game().equals(hapus_game)){
                                while(true){
                                    cls();
                                    System.out.println("===================================================");
                                    System.out.println("            >>    Data Ditemukan    <<             ");
                                    System.out.println("===================================================");
                                    dataGame.get(i).display();
                                    System.out.print("Yakin Ingin Menghapus Jenis Top Up Game [y/n] : "); String meyakinkan = br.readLine();
                                    if (meyakinkan.equalsIgnoreCase("y") || meyakinkan.equalsIgnoreCase("Y")){
                                        dataGame.remove(i);
                                        System.out.print("\nData Berhasil Dihapus, Tekan ENTER Untuk Melanjutkan..."); gtc = br.readLine();
                                        break;
                                    } else if (meyakinkan.equalsIgnoreCase("n") || meyakinkan.equalsIgnoreCase("N")){
                                        System.out.print("\nBatal Menghapus Data, Tekan ENTER Untuk Melanjutkan..."); gtc = br.readLine();
                                        break;
                                    } else {
                                        System.out.print("\nInput Anda Salah! Silahkan Input Ulang"); gtc = br.readLine();
                                    }
                                }
                                break;
                            } else if (i == dataGame.size()-1) {
                                System.out.print("\nData Tidak Ditemukan..."); gtc = br.readLine();
                            }
                        }
                    } else {
                        System.out.print("\nData Jenis Game Masih Kosong, Silahkan Isi Data Dulu..."); gtc = br.readLine();
                    }
                    break;
                case "5":
                    if (dataGame.size() > 0){
                        cls();
                        System.out.println("===================================================");
                        System.out.println("  >>  Cari Data Jenis Top Up Game Udin.TopUp  <<   ");
                        System.out.println("===================================================");
                        System.out.print("Masukkan Nama Game Yang Ingin Dicari : "); String cari = br.readLine();
                        for (int i = 0 ; i < dataGame.size() ; i++){
                            if (dataGame.get(i).get_game().equals(cari)){
                                cls();
                                System.out.println("===================================================");
                                System.out.println("            >>    Data Ditemukan    <<             ");
                                System.out.println("===================================================");
                                dataGame.get(i).display();
                                System.out.print("\nTekan ENTER Untuk Melanjutkan..."); gtc = br.readLine();
                                break;
                            } else if (i == dataGame.size()-1){
                                System.out.print("\nData Tidak Ditemukan..."); gtc = br.readLine();
                            }
                        }
                    } else {
                        System.out.print("\nData Jenis Game Masih Kosong, Silahkan Isi Data Dulu..."); gtc = br.readLine();
                    }
                    break;
                case "6":
                    if (dataPesanan.size() > 0){
                        cls();
                        System.out.println("==================================================================================================================================");
                        System.out.println("|                             ~~~~~>>>     Data Riwayat Transaksi Top Up Udin.TopUp     <<<~~~~~                                 |");
                        System.out.println("==================================================================================================================================");
                        System.out.println("| No. |       Jenis Game       |    ID Akun    |  Nickname Akun  |  Jumlah Top Up  |   Total Harga   |      Waktu Transaksi      |");
                        System.out.println("==================================================================================================================================");
                        for (int i = 0 ; i < dataPesanan.size() ; i++){
                            dataPesanan.get(i).display(i);
                        }
                        System.out.print("\nTekan ENTER Untuk Melanjutkan..."); gtc = br.readLine();
                    } else {
                        System.out.print("\nData Riwayat Transaksi Masih Kosong..."); gtc = br.readLine();
                    }
                    break;
                case "0":
                    menu = false;
                    break;
                default:
                    System.out.print("\nMenu Tidak Ditemukan! Silahkan Input Menu Kembali"); gtc = br.readLine();
            }
        }
    }
    
    // buat customer kalo mau top up
    static private void user() throws IOException{
        boolean menu = true;
        while (menu) {
            cls();
            System.out.println("==================================================");
            System.out.println(" >> Selamat Datang Di Menu Customer Udin.TopUp << ");
            System.out.println("==================================================");
            System.out.println("  [1]\tLihat Seluruh Jenis Top Up Game");
            System.out.println("  [2]\tOrder Pesanan Top Up");
            System.out.println("  [0]\tKembali");
            System.out.println("==================================================");
            System.out.print("Masukkan Pilihan Menu >> "); String pilih = br.readLine();
            switch(pilih){
                case "1":
                    // display game yg bisa ditop up
                    cls();
                    System.out.println("===================================================");
                    System.out.println("   >>  Seluruh Jenis Top Up Game Udin.TopUp  <<    ");
                    System.out.println("===================================================");
                    for (int i = 0 ; i < dataGame.size() ; i++){
                        dataGame.get(i).display();
                    }
                    System.out.print("\nTekan ENTER Untuk Melanjutkan..."); gtc = br.readLine();
                    break;
                case "2":
                    // order top up
                    while (true){
                        cls();
                        System.out.println("===================================================");
                        System.out.println("   >>  Order Pesanan Top Up Game Udin.TopUp  <<    ");
                        System.out.println("===================================================");
                        for (int i = 0 ; i < dataGame.size() ; i++){
                            dataGame.get(i).display_user(i);
                        }
                        System.out.println("  [0]\tKembali");
                        System.out.println("===================================================");
                        System.out.print("Masukkan Pilihan Game : "); int idx_game = Integer.parseInt(br.readLine());
                        idx_game -= 1;
                        if (idx_game >= 0 && idx_game < dataGame.size()){
                            while (true){
                                cls();
                                System.out.println("===================================================");
                                System.out.println("   >>  Order Pesanan Top Up Game Udin.TopUp  <<    ");
                                System.out.println("===================================================");
                                dataGame.get(idx_game).display();
                                System.out.println("[0]\tKembali");
                                System.out.println("===================================================");
                                System.out.print("Masukkan Jumlah Top Up Yang Diinginkan : "); int TopUp = Integer.parseInt(br.readLine());
                                if (dataGame.get(idx_game).cek_variasi(TopUp) == true){
                                    System.out.print("Masukkan ID Dari Akun Game Anda        : "); String id = br.readLine();
                                    System.out.print("Masukkan Nickname Dari Akun Game Anda  : "); String nickname = br.readLine();
                                    int total = dataGame.get(idx_game).get_harga(dataGame.get(idx_game).idx_variasi(TopUp));
                                    String game_topup = dataGame.get(idx_game).get_game();
                                    String mataUang = dataGame.get(idx_game).get_mataUang();
                                    while (true){
                                        cls();
                                        System.out.println("===================================================");
                                        System.out.println("        >>    Transaksi Telah Dibuat    <<         ");
                                        System.out.println("===================================================");
                                        System.out.println("  Top Up Game        : " + game_topup);
                                        System.out.println("  ID AKun Game       : " + id);
                                        System.out.println("  Nickname AKun Game : " + nickname);
                                        System.out.println("  Jumlah Top Up      : " + TopUp + " " + mataUang);
                                        System.out.println("  Total Harga        : Rp" + total);
                                        System.out.println("===================================================");
                                        System.out.print("Lanjutkan Ke Tahap Pembayaran [y/n] : "); String meyakinkan = br.readLine();
                                        if (meyakinkan.equalsIgnoreCase("y") || meyakinkan.equalsIgnoreCase("Y")){
                                            LocalDateTime waktu = LocalDateTime.now();
                                            DateTimeFormatter formatwaktu = DateTimeFormatter.ofPattern("E, MMM dd yyyy HH:mm:ss");
                                            String waktuskrng = waktu.format(formatwaktu);
                                            System.out.println("\nMohon Tunggu Sebentar Hingga Proses Top Up Selesai...");
                                            loading(52);
                                            Pesanan pesananBaru = new Pesanan(TopUp, total, game_topup, id, nickname, waktuskrng, mataUang);
                                            dataPesanan.add(pesananBaru);
                                            cls();
                                            String TopUpS = String.valueOf(TopUp);
                                            String totalS = String.valueOf(total);
                                            System.out.println("======================================================");
                                            System.out.println("||      >>   Transaksi & Top Up Berhasil!   <<      ||");
                                            System.out.println("======================================================");
                                            System.out.print("||  Top Up Game        : " + game_topup);
                                            garis_tabel(51-(24+game_topup.length()));
                                            System.out.print("||  ID Akun Game       : " + id);
                                            garis_tabel(51-(24+id.length()));
                                            System.out.print("||  Nickname AKun Game : " + nickname);
                                            garis_tabel(51-(24+nickname.length()));
                                            System.out.print("||  Jumlah Top Up      : " + TopUp + " " + mataUang);
                                            garis_tabel(51-(25+TopUpS.length()+mataUang.length()));
                                            System.out.print("||  Total Harga        : Rp" + total);
                                            garis_tabel(51-(26+totalS.length()));
                                            System.out.print("||  Waktu Transaksi    : " + waktuskrng);
                                            garis_tabel(51-(24+waktuskrng.length()));
                                            System.out.println("======================================================");
                                            System.out.print("\nTekan ENTER Untuk Melanjutkan..."); gtc = br.readLine();
                                            break;
                                        } else if (meyakinkan.equalsIgnoreCase("n") || meyakinkan.equalsIgnoreCase("N")){
                                            System.out.print("\nTransaksi Dibatalkan..."); gtc = br.readLine();
                                            break;
                                        } else {
                                            System.out.print("\nInput Anda Salah, Silahkan Input Lagi..."); gtc = br.readLine();
                                        }
                                    }
                                    break;
                                } else if (TopUp == 0){
                                    break;
                                } else {
                                    System.out.print("\nPilihan Jumlah Top Up Tidak Ditemukan..."); gtc = br.readLine();
                                }
                            }
                            break;
                        } else if (idx_game == -1){
                            break;
                        } else {
                            System.out.print("\nPilihan Game Anda Tidak Ditemukan..."); gtc = br.readLine();
                        }
                    }
                    break;
                case "0":
                    menu = false;
                    break;
                default:
                    System.out.print("\nMenu Tidak Ditemukan! Silahkan Input Menu Kembali"); gtc = br.readLine();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        // data default biar otomatis ada biar gacape input trus
        int [] fifa = {150, 16000, 500, 49000, 1050, 79000, 2200, 159000, 5750, 399000, 12000, 799000};
        ArrayList<Integer> jenisDefault = new ArrayList<>();
        for (int i = 0 ; i < fifa.length ; i++){
            jenisDefault.add(fifa[i]);
        }
        ListGame gameDefault = new ListGame("Fifa Mobile", "POINTS", jenisDefault);
        Pesanan pesananDefault = new Pesanan(12000, 799000, "Fifa Mobile", "69696969", "UdinPetot777", "Tue, Mar 07 2023 03:07:26", "POINTS");
        dataGame.add(gameDefault);
        dataPesanan.add(pesananDefault);

        boolean menu = true;
        while (menu){
            cls();
            System.out.println("===================================================");
            System.out.println("    >>  Selamat Datang Di Sistem Udin.TopUp  <<    ");
            System.out.println("===================================================");
            System.out.println("  [1]\tLogin Sebagai Admin");
            System.out.println("  [2]\tMasuk Sebagai Customer");
            System.out.println("  [0]\tEXIT");
            System.out.println("===================================================");
            System.out.print("Masukkan Pilihan Menu >> "); String pilih = br.readLine();
            switch(pilih){
                case "1":
                    cls();
                    while (true){
                        System.out.println("======================================================");
                        System.out.println("      >>  Menu Login Admin Sistem Udin.TopUp  <<      ");
                        System.out.println("======================================================");
                        System.out.println("\nNote! Input 00 Pada Username & Password Untuk Kembali");
                        System.out.println("------------------------------------------------------");
                        System.out.print("\n  Username >> "); String username = br.readLine();
                        System.out.print("  Password >> "); String password = br.readLine();
                        if (username.equalsIgnoreCase("admin") && password.equalsIgnoreCase("admin")){
                            System.out.println("\nLogin Berhasil, Mohon Tunggu Sebentar...");
                            loading(55);
                            admin();
                            break;
                        } else if (username.equalsIgnoreCase("00") && password.equalsIgnoreCase("00")){
                            break;
                        } else {
                            System.out.print("\nUsername Atau Password Salah!"); gtc = br.readLine();
                        }
                    }
                    break;
                case "2":
                    System.out.println("\nMohon Tunggu Sebentar...");
                    loading(52);
                    user();
                    break;
                case "0":
                    cls();
                    System.out.println("==================================================");
                    System.out.println(" >> Terimakasih Telah Berkunjung Ke Udin.TopUp << ");
                    System.out.println("==================================================");
                    System.out.println("\nBentar Lagi Kita Bakal Pisah :(");
                    loading(50);
                    cls();
                    menu = false;
                    break;
                default:
                    System.out.print("\nPilihan Menu Tidak Ditemukan, Silahkan Pilih Menu Kembali..."); gtc = br.readLine();
            }
        }
    }

}
