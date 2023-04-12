// class final
public final class Pesanan extends Game{
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

    // method final gunanya untuk ngerapiin output
    static public final void geser(int panjang){
        for (int i = 0 ; i < panjang ; i++){
            System.out.print(" ");
        }
    }

    @Override
    // impelemtasi interface
    public void display() {
        String jumlahTopUpS = String.valueOf(this.jumlahTopUP);
        String TotalS = String.valueOf(this.Total);
        System.out.print("| " + this.Game);
        geser(23-this.Game.length());
        System.out.print("| " + this.ID);
        geser(14-this.ID.length());
        System.out.print("| " + this.Nickname);
        geser(16-this.Nickname.length());
        System.out.print("| " + this.jumlahTopUP + " " + this.mataUang);
        geser(15-jumlahTopUpS.length()-this.mataUang.length());
        System.out.print("| Rp" + this.Total);
        geser(14-TotalS.length());
        System.out.print("| " + this.Waktu);
        geser(26-this.Waktu.length());
        System.out.println("|");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------");       
    }

    public void update(){
        
    }
    // gaada setter soalnya cuma mau nyimpan riwayat transaksi
}
