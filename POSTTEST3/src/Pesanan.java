public class Pesanan extends Game{
    // deklarasi field
    private int jumlahTopUP, Total;
    private String ID, Nickname, Waktu;
    
    // constructor
    public Pesanan (int jumlah_TopUP, int total, String game, String id, String nickname, String waktu, String mata_uang){
        // method super ngambil field dari parentnya class Game
        super(game, mata_uang);
        this.Game = game;
        this.ID = id;
        this.Nickname = nickname;
        this.jumlahTopUP = jumlah_TopUP;
        this.Total = total;
        this.Waktu = waktu;
        this.mataUang = mata_uang;
    }
    
    // method getter
    public int getTotal() {
        return this.Total;
    }

    public int getJumlahTopUP() {
        return this.jumlahTopUP;
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

    // gaada setter soalnya cuma mau nyimpan riwayat transaksi
}
