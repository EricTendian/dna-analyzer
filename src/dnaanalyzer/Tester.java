package dnaanalyzer;

public class Tester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //TACTCGTAATTCACTCCG Ser-Ile-Lys 
        //CACCTGTACACAGAGGTAACTTAG  Cys-Leu-His
        //TATAATTACAGCATAATT  Ser-Tyr
        //GCCTTGATATGGAGAACTCATTAGATA    translatable DNA found
        //ACTACTACCGAACT  Met-Met-Ala
        //TTCACATACAACTTAATATATTTTGCCCGTACT  Leu-Asn-Tyr-Ile-Lys-Arg-Ala
        DNAStrand dna = new DNAStrand("TTCACATACAACTTAATATATTTTGCCCGTACT");
        System.out.println(dna);
        if (dna.toString().equals("DNA: TTCACATACAACTTAATATATTTTGCCCGTACT\nRNA: null")) {
            System.out.println("toString() correct");
        } else {
            System.out.println("toString() failed");
        }
        String mRNA = dna.getComplement().replaceAll("T", "U");
        System.out.println("mRNA: " + mRNA);
        if (mRNA.equals("AAGUGUAUGUUGAAUUAUAUAAAACGGGCAUGA")) {
            System.out.println("getComplement() correct");
        } else {
            System.out.println("getComplement() failed, correct answer: AAGUGUAUGUUGAAUUAUAUAAAACGGGCAUGA");
        }

        System.out.println("Proteins: " + dna.translate());
        if (dna.translate().equals("Leu-Asn-Tyr-Ile-Lys-Arg-Ala")) {
            System.out.println("translate() correct");
        } else {
            System.out.println("translate() failed, correct answer: Leu-Asn-Tyr-Ile-Lys-Arg-Ala");
        }
    }

}