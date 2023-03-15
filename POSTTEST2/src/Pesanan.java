public class Pesanan {
    // deklarasi field
    private int jumlahTopUP, Total;
    private String Game, ID, Nickname, Waktu, mataUang;
    
    // constructor buat nambah data
    public Pesanan (int jumlah_TopUP, int total, String game, String id, String nickname, String waktu, String mata_uang){
        this.Game = game;
        this.ID = id;
        this.Nickname = nickname;
        this.jumlahTopUP = jumlah_TopUP;
        this.Total = total;
        this.Waktu = waktu;
        this.mataUang = mata_uang;
    }
    
    // getter semua fieldnya
    public int getTotal() {
        return this.Total;
    }

    public int getJumlahTopUP() {
        return this.jumlahTopUP;
    }

    public String getGame(){
        return this.Game;
    }

    public String getID(){
        return this.ID;
    }
    
    public String getNickname(){
        return this.Nickname;
    }

    public String getWaktu(){
        return this.Waktu;
    }
    
    public String getMatauang(){
        return this.mataUang;
    }

    // bikin biar outputnya rapi
    void geser(int panjang){
        for (int i = 0 ; i < panjang ; i++){
            System.out.print(" ");
        }
    }

}
