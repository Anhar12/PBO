public class Game {
    // deklarasi field
    protected String Game, mataUang;

    // constructor
    public Game (String nama_game, String matauang_game){
        this.Game = nama_game;
        this.mataUang = matauang_game;
    }

    // method setter getter
    public String getGame() {
        return this.Game;
    }

    public void setGame(String Game) {
        this.Game = Game;
    }

    public String getMataUang() {
        return this.mataUang;
    }
    
    public void setMataUang(String mataUang) {
        this.mataUang = mataUang;
    }
    
    // lihat daftar nama gamenya aja
    void display_user(int i){
        System.out.println("  [" + (i+1) + "]\t" + this.Game);
    }

}
