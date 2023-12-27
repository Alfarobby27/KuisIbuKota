// Membuat class Config yaitu turunan (subclass) dari class Main dengan cara menggunakan kata kunci extends.
class Config extends Main {
    
    //Deklarasi Atribut : //untuk menyimpan inputan pilihan dari pengguna
    private int provinsi; //deklarasi variabel provinsi bertipe data integer
    private int ibukota;  //deklarasi variabel ibukota bertipe data integer
    private String hasil; //deklarasi variabel hasil bertipe data String

    
    //Deklarasi variabel konstanta (bersifat tetap) dengan cara menggunakan kata kunci final
    // variabel provinsi dan ibukota ini bertipe data array string
    public final String[] provinsiArray = {"Jawa Timur", "Jawa Tengah", "Jawa Barat", "Banten", "DKI Jakarta", "DIY"};
    public final String[] ibukotaArray = {"Yogyakarta", "Surabaya", "Serang", "Bandung", "Jakarta", "Semarang"};

    
    //Konstruktor : berfungsi untuk deklarasi nilai awal dari variabel yang telah dibuat
    public Config() {
        provinsi = 0; //nilai awal provinsi 0
        ibukota = 0;  //nilai awal ibukota 0
        hasil = "";   //nilai awal hasil string kosong ("")
    }

    
    //Selector (Getter) : untuk menyeleksi atau mengembalikan nilai yang telah dipilih oleh pengguna

    public String getProvinsi() {
        return provinsiArray[provinsi - 1];
    }
    //karena indeks array dimulai dari 0. dan variabel provinsi berisi pilihan pengguna (antara angka 1 - 6) jadi kita kurangi 1
    //agar menyesuaikan indeks array.
    
    //Pilihan Provinsi :
    //1. Jawa Timur
    //2. Jawa Tengah
    //3. seterusnya
    
    //pilih nomor 1 - 6 : 1    <= pilihan pengguna
    
    // contoh : pengguna menginput angka 1 saat memilih provinsi yaitu Jawa Timur.
    
           // indeks =      0               1             2        seterusnya
    //provinsiArray = ["Jawa Timur", "Jawa Tengah", "Jawa Barat", ...]
    
    // provinsi Jawa Timur terletak pada indeks 0.
    // maka kita kurangi 1 si pilihan pengguna tersebut. 1 - 1 = 0.
    // Sekarang pilihan pengguna sudah sama dengan indeks Jawa Timur yaitu 0.
    // begitu juga dengan ibukota konsepnya seperti penjelasan diatas.

    public String getIbukota() {
        return ibukotaArray[ibukota - 1];
    }

    
    // Mutator (Setter) : untuk mengatur atau menyimpan pilihan dari pengguna
    // ini berguna saat manipulasi objek pada class Main
    // Setter menyimpan nilai dari pilihan pengguna
    public void setProvinsi(int p) {
        provinsi = p;
    }

    public void setIbukota(int k) {
        ibukota = k;
    }

    public void setHasil(String h) {
        hasil = h;
    }
    
    
    // Periksa Jawaban : ini digunakan untuk mengecek hasil jawaban apakah sesuai nama ibukota dari provinsi yang sudah dipilih
    public void cekHasil(String userProvinsi) {
        
        String jawaban = getIbukota(); //mengambil jawaban ibukota pilihan pengguna
        int provinsiIndex = provinsi - 1; //mengambil indeks provinsi pilihan pengguna

        // mengatur array jawaban ibukota agar sesuai dengan provinsinya 
        String[] jawabanIbukota = {
                ibukotaArray[1], ibukotaArray[5], ibukotaArray[3],
                ibukotaArray[2], ibukotaArray[4], ibukotaArray[0]
        };

        
        // Memeriksa apakah jawaban pengguna sesuai dengan jawaban yang benar
        // equals disini berfungsi untuk melakukan perbandingan.
        // apakah ibukota yang dipilih pengguna sesuai dengan provinsinya
        // disini kami menggunakan ternary operator (?:) untuk statement
        setHasil(jawaban.equals(jawabanIbukota[provinsiIndex])
                // jika jawaban pengguna benar maka variabel hasil menyimpan nilai ini
                ? "Yey jawaban kamu benar!"
                // jika salah maka variabel hasil menyimpan nilai ini
                : "Jawaban kamu salah, ibukota " + userProvinsi + " adalah: " + jawabanIbukota[provinsiIndex]);
                
        // cetak hasil jawaban
        System.out.println("Hasil      : " + hasil);
    }

    
    // Metode Tambahan

    // untuk menampilkan judul aplikasi
    public static void cetakJudul() {
        clearScreen();
        System.out.println("+---------------------------------------------+");
        System.out.println("|               Kuis Ibu Kota                 |");
        System.out.println("|           Provinsi di Pulau Jawa            |");
        System.out.println("+---------------------------------------------+");
        System.out.println("| 1. Alfarobby                 - 202243500497 |");
        System.out.println("| 2. Ahmad Badawi              - 202243500500 |");
        System.out.println("| 3. Abdur Rosyid Fachriansyah - 202243500501 |");
        System.out.println("| 4. Sangga Buana              - 202243500502 |");
        System.out.println("| 5. Riyan Rizaldy             - 202243500524 |");
        System.out.println("+---------------------------------------------+");
        System.out.println();
    }
    
    
    // untuk clear screen (membersihkan tampilan) : agar kelihatan rapi dan tidak menumpuk
    public static void clearScreen() {
        try {
            // apabila menggunakan os windows maka lakukan perintah cls di cmd
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();

            // apabila tidak menggunakan os windows dan support kode ANSI maka clear menggunakan kode ANSI
            } else if (isSupportANSICode()) {
                System.out.print("\033\143");
            }
        } catch (Exception ex) {
            System.err.println("Tidak bisa clear screen");
        }
    }
    
    // cek apakah console yang digunakan support kode ANSI atau tidak
    private static boolean isSupportANSICode() {
        return System.console() != null && System.getenv().get("TERM") != null;
    }
}
