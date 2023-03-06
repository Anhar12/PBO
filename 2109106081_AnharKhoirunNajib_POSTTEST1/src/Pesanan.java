public class Pesanan {
    // deklarasi field
    int jumlahTopUP, Total;
    String Game, ID, Nickname, Waktu, mataUang;

    // constructor buat nambah data
    Pesanan (int jumlah_TopUP, int total, String game, String id, String nickname, String waktu, String mata_uang){
        this.Game = game;
        this.ID = id;
        this.Nickname = nickname;
        this.jumlahTopUP = jumlah_TopUP;
        this.Total = total;
        this.Waktu = waktu;
        this.mataUang = mata_uang;
    }

    // bikin biar outputnya rapi
    void geser(int panjang){
        for (int i = 0 ; i < panjang ; i++){
            System.out.print(" ");
        }
    }

    // buat nampilin data
    void display(int i){
        i += 1;
        String iS = String.valueOf(i);
        String jumlahTopUpS = String.valueOf(this.jumlahTopUP);
        String TotalS = String.valueOf(this.Total);
        System.out.print("| " + iS);
        geser(4-iS.length());
        System.out.print("| " + this.Game);
        geser(23-this.Game.length());
        System.out.print("| " + this.ID);
        geser(14-this.ID.length());
        System.out.print("| " + this.Nickname);
        geser(16-this.Nickname.length());
        System.out.print("| " + this.jumlahTopUP + " " + mataUang);
        geser(15-jumlahTopUpS.length()-mataUang.length());
        System.out.print("| Rp" + this.Total);
        geser(14-TotalS.length());
        System.out.print("| " + this.Waktu);
        geser(26-this.Waktu.length());
        System.out.println("|");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------");
    }
}
