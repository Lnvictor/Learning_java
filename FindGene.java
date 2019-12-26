/*
*
* This Class receive a DNA and identify Genes 
* Genes fall between "ATG" and "TAA" in DNA celules
*
* @author: Victor Pereira
* @version: 1.0

*/

class FindGene {

    private static String START = "ATG";
    private static String STOP = "TAA";

    public String getGene(String DNA) {

        int Start_index = DNA.indexOf(START);
        int Stop_index = DNA.indexOf(STOP, Start_index + 3);

        while (Stop_index != -1) {

            // Checking if substring is multiple of 3
            if ((Stop_index - Start_index) % 3 == 0) {
                return DNA.substring(Start_index, Stop_index + 3);
            }

            else {
                Stop_index = DNA.indexOf(STOP, Stop_index + 3);
            }

        }

        return "Not found";
    }

    public void testFindGene() {
        String dna = "AATGCGTAATATGGT";
        System.out.println("DNA strand is: " + dna);
        String gene = getGene(dna);
        System.out.println("Gene is: " + gene);

        dna = "AATGCTAGTAAGGTAATATGGT";
        System.out.println("DNA strand is: " + dna);
        gene = getGene(dna);
        System.out.println("Gene is: " + gene);

    }

    public static void main(String[] args) {
        FindGene find_genes = new FindGene();
        find_genes.testFindGene();
    }
}