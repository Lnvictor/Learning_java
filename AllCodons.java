
/*
 *
 * This is a improved of FindGenes. Gets a String dna
 * and print all genes in dna. 
 * 
 * It has too three diferent stop codons: "TAA", "TAG", "ATG".
 * 
 * @author: Victor Pereira
 * version: 1.0
 */

public class AllCodons {
    private String START = "atg";
    private int start_index;

    AllCodons() {
        this.start_index = 0;
    }

    public int findStop(int current_index, String dna, String stop) {
        int stop_index = dna.indexOf(stop, current_index + 3);

        do {
            if ((stop_index - current_index) % 3 == 0) {
                return stop_index;
            }

            if (stop_index == -1)
                break;

            stop_index = dna.indexOf(stop, stop_index + 3);
        } while (true);

        return -1;
    }

    public String findGene(String dna, int where) {

        int TAA = findStop(where, dna, "taa");
        int TAG = findStop(where, dna, "tag");
        int TGA = findStop(where, dna, "tga");

        int temp_Index = Math.min(TAA, TAG);

        if (TAA == -1 && TAG != -1) {
            temp_Index = TAG;
        }
        if (TAG == -1 && TAA != -1) {
            temp_Index = TAA;
        }

        int min_Index = Math.min(temp_Index, TGA);

        if (TGA == -1 && temp_Index != -1) {
            min_Index = temp_Index;
        }

        else if (TGA != -1 && temp_Index == -1) {
            min_Index = TGA;
        }

        if (min_Index == -1) {
            return "Not found genes";
        }

        return dna.substring(where, min_Index + 3);
    }

    public void printAllGenes(String dna) {
        start_index = dna.indexOf(START);
        String gene = "";

        System.out.println("DNA strand: " + dna);

        do {
            gene = findGene(dna, start_index);
            System.out.println("Gene is: " + gene + "\n");

            if (gene.equals("Not found genes"))
                break;

            start_index = dna.indexOf(START, start_index + 3);
        } while (true);
    }

    private void test_FindStop() {

        System.out.println("testing FindStop:");

        if (findStop(0, "atgulaulataa", "taa") == -1)
            System.out.println("Test 1 FAILED");

        if (findStop(0, "atgulaulatag", "tag") == -1)
            System.out.println("Test 2 FAILED");

        if (findStop(0, "atgulaulatga", "tga") == -1)
            System.out.println("Test 3 FAILED");

        System.out.println("tests finish\n");
    }

    private void test_FindGene() {

        System.out.println("testing FindGene:");

        if (findGene("atgyyytaaatgyyytagatguuutga", 9).equals("Not found genes"))
            System.out.println("Test 4 FAILED");

        if (findGene("atgyytaaatgyyytagatguuutga", 0).equals("atgyytaa"))
            System.out.println("Test 5 FAILED");

        System.out.println("tests finish\n");

    }

    private void test_PrintAll(String dna) {

        System.out.println("testing PrintAll\n");
        printAllGenes(dna);
    }

    public static void main(String[] args) {
        AllCodons Example = new AllCodons();

        Example.test_FindStop();
        Example.test_FindGene();
        Example.test_PrintAll(
                "agggttttaatcgttagacagtctagaccgtactgcctgggcgtggtcttaatcccacaggatacgtgctcgatgccatatgcctcttattcggtctaagaggtgacagtactaatactgtgacctctcgattgcagtcaatcacgccagcccttaaagccgcagaagcgatttataacgtattcacgtccgggcataatccggcactcctgagggaggagaacactcgtgtctataacaaccatccgaagggaacggaaaagatttgcctactaccgaagcaatatggtaactagctaaccgcgaccaacctagtagaggacacctggttttctatcttccaccggtacattctagtgctctttcaagcaggcttagccaggcttttccggcgccacgcaaggtctgggtcgagggcaggaccatgctgcacaggtctgcgacttatttgaccattcgcgatgtgattacaaaggacaagtggatgctttggaatgcgtatccgtgtaaagaggataatacgcgcctgcctcattcccacaatgggaatacttctatgctacgggcagcctaggtgcactctgttaa");
    }
}