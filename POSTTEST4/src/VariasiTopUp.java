import java.util.ArrayList;
    
public class VariasiTopUp extends Game{
    // deklarasi field
    private ArrayList<ArrayList<Integer>> JenisGame = new ArrayList<>();
    
    // constructor 
    public VariasiTopUp (String Game, String mataUang, ArrayList<Integer> jenis){
        // method super dari parentnya di class Game
        super(Game, mataUang);
        this.Game = Game;
        this.mataUang = mataUang;
        for (int i = 0 ; i < jenis.size() ; i+=2){
            this.JenisGame.add(new ArrayList<>());
            this.JenisGame.get(JenisGame.size()-1).add(jenis.get(i));
            this.JenisGame.get(JenisGame.size()-1).add(jenis.get(i+1));
        }
    }
    
    // method getter
    public int get_harga(int idx){
        return JenisGame.get(idx).get(1);
    }
    
    public String get_mataUang(){
        return mataUang;
    }
    
    public ArrayList<ArrayList<Integer>> getJenisGame() {
        return this.JenisGame;
    }
    
    // method setter utnuk variasi top up
    public void set_topUp(ArrayList<Integer> topUp, int idx){
        this.JenisGame.get(idx).set(0, topUp.get(0));
        this.JenisGame.get(idx).set(1, topUp.get(1));
    }
    
    // implementasi overloading
    public void set_topUp(ArrayList<Integer> topUp){
        int idx = 0;
        this.JenisGame.clear();
        for (int i = 0 ; i < topUp.size() ; i+=2){
            this.JenisGame.add(new ArrayList<>());
            this.JenisGame.get(idx).add(topUp.get(i));
            this.JenisGame.get(idx).add(topUp.get(i+1));
            idx++;
        }
    }

    // bikin biar outputnya rapi
    public void geser(int panjang){
        for (int i = 0 ; i < panjang ; i++){
            System.out.print(" ");
        }
    }

    @Override // override dari class Game
    public void display(){
        int jarak = this.Game.length()/2;
        geser(22-jarak);
        // overrride
        super.display();
        System.out.println("---------------------------------------------------");
        for (int j = 0 ; j < JenisGame.size() ; j++){
            System.out.printf("%15d %s", this.JenisGame.get(j).get(0), this.mataUang);
            System.out.printf("%10s%d %n", "\tRp", this.JenisGame.get(j).get(1));
        }
        System.out.println("===================================================");
    }

    // overloading
    public void display(boolean cek){
        if (cek == true){
            display();
        } else {
            super.display();
        }

    }

    // cek variasinya ada ato enggak
    public boolean cek_variasi(int cari){
        for (int i = 0 ; i < JenisGame.size() ; i++){
            if (JenisGame.get(i).get(0).equals(cari)){
                return true;
            }
        }
        return false;
    }

    // cari index variasinya
    public int idx_variasi(int cari){
        for (int i = 0 ; i < JenisGame.size() ; i++){
            if (JenisGame.get(i).get(0).equals(cari)){
                return i;
            }
        }
        return -1;
    }

}
