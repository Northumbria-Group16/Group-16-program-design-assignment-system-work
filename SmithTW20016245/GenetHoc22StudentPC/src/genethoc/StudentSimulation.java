/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package genethoc;

import java.util.*;

public class StudentSimulation extends GenHocDNADatabase {

    Map<String, String> databaseDNA = new HashMap<>();
    Map<String, String> databaseCrimeScenes = new HashMap<>();

    @Override
    public void addDNASequence(DNASequenceInterface it) {
        assert it != null;
        databaseDNA.put(it.getDnaSequence(), it.getDnaSequence());
        for (String C : it.getAllCrimeScenes()) {
            databaseCrimeScenes.put(C, C);
        }
        database.add(it);
    }

    @Override
    public void resetDatabase() {
        this.database = new ArrayList<>();
        this.databaseDNA = new HashMap<>();
        this.databaseCrimeScenes = new HashMap<>();
    }

    @Override
    public boolean containsWholeDNASequence(String wholeDNA) {
        return databaseDNA.containsKey(wholeDNA);
    }

    @Override
    public boolean searchForDNA(String dna) {
        return databaseDNA.containsKey(dna);
    }

    @Override
    public boolean testLookingForFragementPositive(int kFragementPositiveTests) {
        Random rn = this.dice;
        boolean result = true;

        for (int a = 0; a < kFragementPositiveTests; a++) {
            DNASequenceInterface existing = database.get(rn.nextInt(database.size()));

            String existString = existing.getDnaSequence();
            existString = existString.substring(rn.nextInt(existString.length() - 5),
                    existString.length());

            boolean foundlist = false;
            for (String it : databaseDNA.keySet()) {
                if (it.contains(existString)) {
                    foundlist = true;
                    break;
                }
            }
            if (!foundlist) {
                System.out.println("You made a mistake - could not find DNA *FRAGMENT* which existed  ");
                return false;
            }
        }
        return result;
    }

    @Override
    public boolean testLookingForCrimeSceneCodes(int howMany
    ) {
        List<String> knownExistingCodes = getSomeRandomCrimeScenes(howMany);
        for (String code : knownExistingCodes) {
            if (!databaseCrimeScenes.containsKey(code)) {
                System.out.println("CRIME SCENE CODE NOT FOUND");
                return false;
            }
        }
        return true;
    }

    /**
     * By Dr Andrew Chemist Chief technology officer GenetHoc Ltd. artificially
     * create duplicates by copying others
     */
    @Override
    public void testRemoveDuplicateDNASequnces(final int DUPLICATES
    ) {

        int before = database.size();
        assert DUPLICATES < database.size();
        List<DNASequenceInterface> duplicates = new ArrayList<>();

        for (int a = 0; a < DUPLICATES; a++) {
            DNASequenceInterface dup;
            do {
                DNASequenceInterface existing = pickRandomSeqence(dice);
                dup = makeDNASequence(existing.getDnaSequence());
            } while (duplicates.contains(dup) == true);
            duplicates.add(dup);
            addDNASequence(dup);
        }

        assert database.size() == before + DUPLICATES : "Error making duplicates";

        int removed = 0;
        for (DNASequenceInterface dupe : duplicates) {
            for (DNASequenceInterface original : database) {
                assert original != dupe;
                if (original.sameDNASequence(dupe.getDnaSequence())) {
                    original.addCrimeScenseFrom(dupe);
                    database.remove(dupe);
                    removed++;
                    break;
                }
            }
        }

        assert removed == DUPLICATES : "Number of duplicates found wrong Removed="
                + removed + " before " + before + " " + DUPLICATES + " "
                + database.size();
        assert database.size() == before;

    }

    static class StudentDNASqeuence extends DNASequence {

        protected Map<String, String> crimeScenesMap = null;

        public StudentDNASqeuence(String dnaSequence, String sampleID) {
            super(dnaSequence, sampleID);
            this.crimeScenesMap = new HashMap<>();
            this.crimeScenes = new ArrayList<String>();
        }

        @Override
        public void addCrimeScene(String whereID) {
            if (this.crimeScenesMap.containsKey(whereID)) {
                return; // must be 
            }
            this.crimeScenesMap.put(whereID, whereID);
            this.crimeScenes.add(whereID);
        }

        /**
         * By Dr Andrew Chemist Chief technology officer GenetHoc Ltd.
         *
         * @param whereID
         * @return
         */
        @Override
        public boolean linkedToCrimeScene(String whereID) {
            assert crimeScenes != null;
            return crimeScenesMap.containsKey(whereID);
        }
    }

//=================== END OF CLASS ===========================
    public DNASequence makeRandomDNASequence(int maxCrimeScens) {

        DNASequence it = new StudentDNASqeuence(
                DNASequenceInterface.generateRandomDNA(this.dice), ""
                + (++GenHocDNADatabase.idCode));
        it.addRandomCrimeLocations(it, this.dice, maxCrimeScens);
        return it;

    }

    /**
     * for assessment purposes don't change
     *
     * @param seed
     */
    public StudentSimulation(long seed) {
        super(seed);
    }

    public static void main(String[] args) {
        StudentSimulation db = new StudentSimulation(System.currentTimeMillis());
        db.everythingWhichShouldBeImproved();
    }

}
