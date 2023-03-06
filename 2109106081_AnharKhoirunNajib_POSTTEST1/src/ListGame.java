import java.util.ArrayList;
import java.util.Scanner;

public class ListGame {
    // deklarasi fieldnya
    String Game, mataUang;
    ArrayList<ArrayList<Integer>> JenisGame = new ArrayList<>();

    Scanner input = new Scanner(System.in);

    // constructor buat nambah data
    ListGame (String game, String matauang, ArrayList<Integer> jenis){
        this.Game = game;
        this.mataUang = matauang;
        for (int i = 0 ; i < jenis.size() ; i+=2){
            this.JenisGame.add(new ArrayList<>());
            this.JenisGame.get(JenisGame.size()-1).add(jenis.get(i));
            this.JenisGame.get(JenisGame.size()-1).add(jenis.get(i+1));
        }
    }
    
    // bikin biar outputnya rapi
    void geser(int panjang){
        for (int i = 0 ; i < panjang ; i++){
            System.out.print(" ");
        }
    }

    // lihat data
    void display(){
        int jarak = this.Game.length()/2;
        geser(25-jarak);
        System.out.println(this.Game);
        System.out.println("---------------------------------------------------");
        for (int j = 0 ; j < JenisGame.size() ; j++){
            System.out.printf("%15d %s", this.JenisGame.get(j).get(0), this.mataUang);
            System.out.printf("%10s%d %n", "\tRp", this.JenisGame.get(j).get(1));
        }
        System.out.println("===================================================");
    }

    // lihat daftar nama gamenya aja
    void display_user(int i){
        System.out.println("  [" + (i+1) + "]\t" + this.Game);
    }

    // cari nama game
    String get_game(){
        return Game;
    }
    
    // cek variasinya ada ato enggak
    boolean cek_variasi(int cari){
        for (int i = 0 ; i < JenisGame.size() ; i++){
            if (JenisGame.get(i).get(0).equals(cari)){
                return true;
            }
        }
        return false;
    }

    // cari index variasinya
    int idx_variasi(int cari){
        for (int i = 0 ; i < JenisGame.size() ; i++){
            if (JenisGame.get(i).get(0).equals(cari)){
                return i;
            }
        }
        return 0;
    }

    // cari harganya
    int get_harga(int idx){
        return JenisGame.get(idx).get(1);
    }

    // cari mata uang gamenya
    public String get_mataUang(){
        return mataUang;
    }

    // buat edit data
    void edit_data(String game, int idx, ArrayList<Integer> jenis, int pilih){
        if (pilih == 1){
            this.Game = game;
        } else if (pilih ==2){
            this.JenisGame.get(idx).set(0, jenis.get(0));
            this.JenisGame.get(idx).set(1, jenis.get(1));
        } else {
            this.Game = game;
            this.JenisGame.clear();
            for (int i = 0 ; i < jenis.size() ; i+=2){
                this.JenisGame.add(new ArrayList<>());
                this.JenisGame.get(idx).add(jenis.get(i));
                this.JenisGame.get(idx).add(jenis.get(i+1));
                idx++;
            }
        }
        System.out.print("\nData Berhasil Diedit! Tekan ENTER Untuk Melanjutkan..."); Main.gtc = input.nextLine();
    }

}
