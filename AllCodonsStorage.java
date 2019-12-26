
/*
 * This is a improved of AllCodons. Because  receives a String dna
 * and returns a list with all genes in dna. Making the code more reusable.
 * 
 * @author: Victor Pereira
 * @version: 1.0
 */

import edu.duke.*;

public class AllCodonsStorage extends AllCodons {
    private String START = "atg";
    private int start_index = 0;

    public StorageResource getAllGenes(String dna) {

        StorageResource sr = new StorageResource();
        start_index = dna.indexOf(START);
        String gene = "";

        System.out.println("DNA strand: " + dna + "\n");

        do {
            gene = findGene(dna, start_index);

            if (gene.equals("Not found genes"))
                break;

            sr.add(gene);
            start_index = dna.indexOf(START, start_index + 3);
        } while (true);

        return sr;
    }

    private void test_getAllCodons(String dna) {
        StorageResource sr = new StorageResource();
        sr = getAllGenes(dna);

        System.out.println("Testing get AllCodons");

        if (sr.data() == null) {
            System.out.println("TEST 1 FAILED");
        } else
            System.out.println("TESTS PASSED");

        System.out.println("TESTS FINISH");
    }

    public static void main(String[] args) {
        AllCodonsStorage Example = new AllCodonsStorage();
        Example.test_getAllCodons("atgsasasataaatghhhtga");
    }
}