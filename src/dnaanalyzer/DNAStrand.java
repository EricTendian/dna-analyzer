package dnaanalyzer;

public class DNAStrand {
    private String DNA;
    private String RNA;
    private String Ala = "GCU GCC GCA GCG";
    private String Arg = "CGU CGC CGA CGG AGA AGG";
    private String Asn = "AAU AAC";
    private String Asp = "GAU GAC";
    private String Cys = "UGU UGC";
    private String Gln = "CAA CAG";
    private String Glu = "GAA GAG";
    private String Gly = "GGU GGC GGA GGG";
    private String His = "CAU CAC";
    private String Ile = "AUU AUC AUA";
    private String Leu = "UUA UUG CUU CUC CUA CUG";
    private String Lys = "AAA AAG";
    private String Met = "AUG";
    private String Phe = "UUU UUC";
    private String Pro = "CCU CCC CCA CCG";
    private String Ser = "UCU UCC UCA UCG AGU AGC";
    private String Thr = "ACU ACC ACA ACG";
    private String Trp = "UGG";
    private String Tyr = "UAU UAC";
    private String Val = "GUU GUC GUA GUG";
    private String Stop= "UAA UGA UAG";

    public DNAStrand() {
        DNA = "";
        RNA = "";
    }

    public DNAStrand(String strand) {
        setDNA(strand);
    }

    public String getDNA() {
        return DNA;
    }

    public void setDNA(String newDNA) {
        DNA = newDNA;
    }

    public String getRNA() {
        return RNA;
    }

    public void setRNA(String newRNA) {
        RNA = newRNA;
    }

    public String getComplement() {
        String comp = getDNA();
        comp=comp.replaceAll("T", "r");
        comp=comp.replaceAll("A", "b");
        comp=comp.replaceAll("G", "d");
        comp=comp.replaceAll("C", "h");
        comp=comp.replaceAll("r", "A");
        comp=comp.replaceAll("b", "T");
        comp=comp.replaceAll("d", "C");
        comp=comp.replaceAll("h", "G");
        return comp;
    }

    public String translate() {
        setRNA(getComplement().replaceAll("T", "U"));
        String protein[] = new String[RNA.length() / 3];
        Boolean started = false;
        for (int prot = 0; prot < (RNA.length() / 3); prot++) {
            String part = RNA.substring((prot*3),(prot*3)+3);
            if (part.equals("AUG") && started == false) {
                started = true;
                continue;
            }
            if (started==true) {
                if (Ala.indexOf(part)!=-1) {
                    protein[prot]="Ala-";
                } else if (Arg.indexOf(part)!=-1) {
                    protein[prot]="Arg-";
                } else if (Asn.indexOf(part)!=-1) {
                    protein[prot]="Asn-";
                } else if (Asp.indexOf(part)!=-1) {
                    protein[prot]="Asp-";
                } else if (Cys.indexOf(part)!=-1) {
                    protein[prot]="Cys-";
                } else if (Gln.indexOf(part)!=-1) {
                    protein[prot]="Gln-";
                } else if (Glu.indexOf(part)!=-1) {
                    protein[prot]="Glu-";
                } else if (Gly.indexOf(part)!=-1) {
                    protein[prot]="Gly-";
                } else if (His.indexOf(part)!=-1) {
                    protein[prot]="His-";
                } else if (Ile.indexOf(part)!=-1) {
                    protein[prot]="Ile-";
                } else if (Leu.indexOf(part)!=-1) {
                    protein[prot]="Leu-";
                } else if (Lys.indexOf(part)!=-1) {
                    protein[prot]="Lys-";
                } else if (Met.indexOf(part)!=-1) {
                    protein[prot]="Met-";
                } else if (Phe.indexOf(part)!=-1) {
                    protein[prot]="Phe-";
                } else if (Pro.indexOf(part)!=-1) {
                    protein[prot]="Pro-";
                } else if (Ser.indexOf(part)!=-1) {
                    protein[prot]="Ser-";
                } else if (Thr.indexOf(part)!=-1) {
                    protein[prot]="Thr-";
                } else if (Trp.indexOf(part)!=-1) {
                    protein[prot]="Trp-";
                } else if (Tyr.indexOf(part)!=-1) {
                    protein[prot]="Tyr-";
                } else if (Val.indexOf(part)!=-1) {
                    protein[prot]="Val-";
                } else if (Stop.indexOf(part)!=-1) {
                    protein[prot-1]=protein[prot-1].substring(0, protein[prot-1].length()-1);
                    break;
                }
            }
        }
        String out = "";
        for (int prot = 0; prot < (RNA.length() / 3)-1; prot++) {
            if (protein[prot]!=null) {
                out=out+protein[prot];
            }
        }
        if (out.length()>0) {
            if (out.substring(out.length()-1, out.length()).equals("-")) {
                return "Stop codon not found\nIncomplete protein sequence: "+out;
            } else {
                return out;
            }
        } else {
            return "*** No translatable DNA found ***";
        }
    }

    @Override
    public String toString() {
        return "DNA: "+getDNA()+"\nRNA: "+getRNA();
    }

}