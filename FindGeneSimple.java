/*
* This Class receive a DNA and identify Genes 
* Genes fall between "ATG" and "TAA" in DNA celules
* @author: Victor Pereira
* @version: 20/12/2019

* Simplified Version - Doesn't check if gene length is multiple of 3

*/

import java.lang.String;

class FindGeneSimple {

    private static String START = "ATG";
    private static String STOP = "TAA";

    public String getGene(String DNA) {

        String result = "";

        int Start_index = DNA.indexOf(START);
        int Stop_index = DNA.indexOf(STOP, Start_index + 3);

        if (Start_index == -1 || Stop_index == -1) {
            return "Gene does not exist";
        }

        result = DNA.substring(Start_index, Stop_index + 3);
        
        if (result.length() % 3 != 0) {
            return "Gene does not exist. Length isn't multiple of 3";
        }

        return result;
    }

    public void testFindGene() {
        String dna = "AATGCGTAATATGGT";
        System.out.println("DNA strand is: " + dna);
        String gene = getGene(dna);
        System.out.println("Gene is: " + gene);

        dna = "AATGCTAGGGTATATGGT";
        System.out.println("DNA strand is: " + dna);
        gene = getGene(dna);
        System.out.println("Gene is: " + gene);

    }

    public static void main(String[] args) {
        FindGeneSimple find_genes = new FindGeneSimple();
        find_genes.testFindGene();
    }
}