import java.util.Scanner;

public class freefire {

    public static void main(String[] args) {
        
        //deklarasi inputan
        Scanner input = new Scanner(System.in);

        //deklarasi variable
        int nyawaPemain = 70, nyawaMusuh = 80;
        int ronde = 1, itemPenyembuh = 3, penyembuhMusuh = 3;
        int pilihanAksi, pilihSenjata;
        double penambahanNyawa = 0;

        //judul-----------------------------------------------------------------------------------------
        System.out.println("==== Nilai Awal Permainan ====");
        System.out.println("Nyawa Pemain\t : " + nyawaPemain);
        System.out.println("Nyawa Musuh\t : " + nyawaMusuh);

        //start-----------------------------------------------------------------------------------------
        System.out.println("\n==== Pertarungan Free Fire dimulai! ====\n");

        //logic-----------------------------------------------------------------------------------------
        while (nyawaPemain > 0 && nyawaMusuh > 0) {
            //header ronde
            System.out.println(">> Ronde " + ronde + " <<");
            System.out.println("Musuh menyerang! Kamu kehilangan 15 HP.");
            nyawaPemain -= 15; //damage musuh
            System.out.println("Nyawa kamu sekarang : " + nyawaPemain);

            //cek apakah pemain masih hidup
            if (nyawaPemain <= 0) {
                System.out.println("Nyawa kamu habis! Kamu kalah!");
                break;
            }

            //opsi pilihan pemain
            System.out.println("Giliran kamu! Pilih aksi : ");
            System.out.println("1. Serang musuh");
            System.out.println("2. Gunakan item penyembuh (sisa " + itemPenyembuh + ")");
            System.out.println("3. Menghindar (tidak menyerang musuh)");

            //pilih
            System.out.print("");
            pilihanAksi = input.nextInt();

            //pilihan aksi
            //SERANG MUSUH
            if (pilihanAksi == 1) {
                System.out.println("Pilih senjata : 1. AK, 2. Famas");
                //pilih senjata
                System.out.print("");
                pilihSenjata = input.nextInt();

                //kondisi pilih senjata
                if (pilihSenjata == 1) { //pilih AK
                    nyawaMusuh -= 30; //damage AK
                    System.out.println("Kamu menyerang musuh dengan AK! Musuh kehilangan 30 HP.");
                    System.out.println("Nyawa musuh sekarang : " + nyawaMusuh);
                }
                else if (pilihSenjata == 2) { //pilih FAMAS
                    nyawaMusuh -= 20; //damage FAMAS
                    System.out.println("Kamu menyerang musuh dengan Famas! Musuh kehilangan 20 HP.");
                    System.out.println("Nyawa musuh sekarang : " + nyawaMusuh);
                }
            }

            //HEAL
            else if (pilihanAksi == 2) {
                //ketika item penyembuh masih ada
                if (itemPenyembuh > 0) {
                    System.out.println("Kamu menggunakan item penyembuh. Nyawa kamu bertambah 25 HP.");
                    nyawaPemain += 25; //efek healing
                    itemPenyembuh--; //pengurangan item heal
                    System.out.println("Nyawa kamu sekarang : " + nyawaPemain);
                }
                //ketika item penyembuh habis
                else if (itemPenyembuh <= 0) {
                    System.out.println("Item penyembuh telah habis.");
                    System.out.println("Nyawa kamu sekarang : " + nyawaPemain);
                }
            }

            //HINDAR
            else if (pilihanAksi == 3) {
                System.out.println("Kamu memilih untuk menghindar, sayang sekali!");
                //penambahan nyawa musuh
                if (nyawaPemain > nyawaMusuh) {
                    penambahanNyawa = 0.1 * nyawaMusuh; 
                    System.out.println("Nyawa musuh bertamah 10% yaitu : " + (int) penambahanNyawa);
                    nyawaMusuh += penambahanNyawa;
                    System.out.println("Nyawa musuh sekarang : " + nyawaMusuh);
                }
            }

            //PILIHAN TIDAK VALID
            else {
                System.out.println("Pilihan tidak valid, coba lagi!\n");
            }

            //heal otomatis musuh
            if (nyawaMusuh <= 10 && nyawaMusuh > 0 && penyembuhMusuh > 0) {
                System.out.println("Musuh melakukan heal otomatis, nyawa musuh bertambah 10 HP.");
                nyawaMusuh += 10; //penambahan nyawa musuh
                penyembuhMusuh--; //pengurangan heal musuh
                System.out.println("Nyawa musuh sekarang : " + nyawaMusuh);
            }

            //cek apakah musuh masih hidup
            if (nyawaMusuh <= 0) {
                System.out.println("Nyawa kamu habis! Kamu kalah!");
                break;
            }

            System.out.println("");
            ronde++;
        }

    }

}
