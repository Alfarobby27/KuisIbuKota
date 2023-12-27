// mengimpor library dari java.io
import java.io.*;
import java.util.Scanner;
import java.util.InputMismatchException;

// membuat class Main (class utama)
public class Main {
    public static void main(String[] args) throws IOException{
        
        //Deklarasi untuk mengambil isi dari class config
        Config kuis = new Config();
        
        // Deklarasi untuk inputan Scanner
        Scanner s = new Scanner(System.in);


        // Membuat pilihan untuk di akhir program
        // jika pengguna ingin main lagi, maka program akan mereset / mengulangi program
        // disini kami menggunakan perulangan while
        
        // deklarasi untuk perbandingan nilai
        // jika variabel MainLagi bernilai true maka program menjalankan perulangan while ini
        boolean MainLagi = true;

        while (MainLagi) {
            
            //Mainkan Game
            kuis.cetakJudul(); //cetak judul aplikasi
            System.out.print("Silahkan tekan ENTER ⏎ untuk melanjutkan..."); 
            s.nextLine(); //untuk menahan tampilan judul, klik enter jika ingin memulai game
            
            // memanggil method MainGame = untuk menjalankan gamenya
            // disini kami memerlukan parameter atau argumen yaitu kuis dan s (scanner) untuk dipakai di method MainGame
            MainGame(kuis, s);

            // Minta input untuk bermain lagi
            // kami menggunakan try catch untuk menangkap error jika inputan dari pengguna tidak valid
            try {
                System.out.print("Mau main lagi? [y/t]: ");
                String mainkan = s.nextLine().toLowerCase();
                MainLagi = mainkan.equals("y"); 
                // membuat perbandingan jika pengguna input y maka perulangan while akan dijalankan                                
            } catch (InputMismatchException err) {
              System.out.println("Input tidak valid. Masukkan y atau t.");
            }
        }

        // Ketika pengguna menginput t maka tampilkan pesan terima kasih
        // dan program selesai
        System.out.println("Terima kasih! © Copyright 2023 Kuis Ibukota");
        System.exit(0);
    }

    
    
    // Membuat method MainGame untuk mainkan game
    private static void MainGame(Config kuis, Scanner s) throws IOException {
        
        //Deklarasi awal inputan provinsi dan ibukota
        int prv = 0; //provinsi
        int ibk = 0; //ibukota
        

        // untuk membuat pengulangan inputan provinsi jika pengguna salah menginput pilihan
        boolean validProvinsiInput = false;
        
        while (!validProvinsiInput) {
            try {
                //bersihkan tampilan
                kuis.clearScreen();
            
                //Provinsi menu
                System.out.println("Pilih Provinsi :");
            
                //mencetak provinsiArray untuk pilihan menu provinsi
                for (int i = 0; i < 6; i++) {
                    System.out.println((i + 1) + ". " + kuis.provinsiArray[i]);
                } 
            
                System.out.print("Pilih nomor (1-6) : ");
                prv = s.nextInt(); // menginput nilai provinsi
            
                if (prv < 1 || prv > 6) {
                    throw new InputMismatchException();
                }
                
                validProvinsiInput = true;
               
            } catch (InputMismatchException err) {
                System.out.println("Input tidak valid! Silahkan pilih nomor 1 sampai 6.");
                // untuk menghindari perulangan tak terbatas
                s.nextLine();               
            }
            
            //untuk menahan perulangan input provinsi
            System.out.print("Silahkan tekan ENTER ⏎ untuk melanjutkan..."); 
            s.nextLine();
        }
        
        
        
        // untuk membuat pengulangan inputan ibukota jika pengguna salah menginput pilihan
        boolean validIbukotaInput = false;
                
            while (!validIbukotaInput) {
                    
                try {
                
                    //bersihkan tampilan
                    kuis.clearScreen();
            
                    //Ibukota menu
                    System.out.println("Pilih nama ibukota " + kuis.provinsiArray[prv - 1] + " :");
            
                    //mencetak ibukotaArray untuk pilihan menu ibukota
                    for (int i = 0; i < 6; i++) {
                        System.out.println((i + 1) + ". " + kuis.ibukotaArray[i]);
                    }

                    System.out.print("Pilih nomor (1-6) : ");
                    ibk = s.nextInt(); // menginput nilai ibukota
                    
                    if (ibk < 1 || ibk > 6) {
                        throw new InputMismatchException();
                    }
                    
                    validIbukotaInput = true;
                        
                } catch (InputMismatchException err) {
                    System.out.println("Input tidak valid! Silahkan pilih nomor 1 sampai 6.");
                    // untuk menghindari perulangan tak terbatas
                    s.nextLine();               
                }
                
                //untuk menahan perulangan input provinsi
                System.out.print("Silahkan tekan ENTER ⏎ untuk melanjutkan..."); 
                s.nextLine();
            }
            
            
            
            //bersihkan tampilan
            kuis.clearScreen();
            
            // Manipulasi Objek
            kuis.setProvinsi(prv);
            kuis.setIbukota(ibk);
            
            //mencetak pilihan atau jawaban dan hasil kuis pengguna
            System.out.println("Provinsi   : " + kuis.getProvinsi());
            System.out.println("Ibukota    : " + kuis.getIbukota());
            kuis.cekHasil(kuis.provinsiArray[prv - 1]);
    }
}
