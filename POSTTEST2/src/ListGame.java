import java.util.ArrayList;
import java.util.Scanner;
    
public class ListGame {
    // deklarasi fieldnya
    private String Game, mataUang;
    private ArrayList<ArrayList<Integer>> JenisGame = new ArrayList<>();
    
    Scanner input = new Scanner(System.in);
    
    // constructor 
    public ListGame (String game, String matauang, ArrayList<Integer> jenis){
        this.Game = game;
        this.mataUang = matauang;
        for (int i = 0 ; i < jenis.size() ; i+=2){
            this.JenisGame.add(new ArrayList<>());
            this.JenisGame.get(JenisGame.size()-1).add(jenis.get(i));
            this.JenisGame.get(JenisGame.size()-1).add(jenis.get(i+1));
        }
    }
    
    // getter isi fieldnya
    public int get_harga(int idx){
        return JenisGame.get(idx).get(1);
    }
    
    public String get_mataUang(){
        return mataUang;
    }

    String get_game(){
        return Game;
    }

    public String getMataUang() {
        return this.mataUang;
    }
    
    public ArrayList<ArrayList<Integer>> getJenisGame() {
        return this.JenisGame;
    }
    
    // setter isi fieldnya
    public void set_game(String game){
        this.Game = game;
    }
    
    public void set_topUp(ArrayList<Integer> topUp, int idx){
        this.JenisGame.get(idx).set(0, topUp.get(0));
        this.JenisGame.get(idx).set(1, topUp.get(1));
    }
    
    // yang ini beda sendiri soalnya agak ribet make arraylist
    public void update(String game, ArrayList<Integer> topUp, String mata_uang){
        int idx = 0;
        this.Game = game;
        this.mataUang = mata_uang;
        this.JenisGame.clear();
        for (int i = 0 ; i < topUp.size() ; i+=2){
            this.JenisGame.add(new ArrayList<>());
            this.JenisGame.get(idx).add(topUp.get(i));
            this.JenisGame.get(idx).add(topUp.get(i+1));
            idx++;
        }
    }

    // bikin biar outputnya rapi
    void geser(int panjang){
        for (int i = 0 ; i < panjang ; i++){
            System.out.print(" ");
        }
    }

    // ini kalo mau display 1 objek doang
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

}
