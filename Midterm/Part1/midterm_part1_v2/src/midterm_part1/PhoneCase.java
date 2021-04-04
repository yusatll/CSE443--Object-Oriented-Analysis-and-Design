package midterm_part1;

public class PhoneCase {
    private String size;
    private String[] proofs;
    private String matter;
    private int proof_size;

    /**
     * Create a new specific PhoneCase
     * @param proof_size waterproof size
     */
    public PhoneCase(int proof_size)
    {
        this.proof_size = proof_size;
        this.proofs = new String[2];
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getProof1() {
        return proofs[0];
    }

    public void setProof1(String proof1) {
        this.proofs[0] = proof1;
    }

    public String getProof2() {
        return proofs[1];
    }

    public void setProof2(String proof2) {
        this.proofs[1] = proof2;
    }


    public String getMatter() {
        return matter;
    }

    public void setMatter(String matter) {
        this.matter = matter;
    }

    public int getProof_size() {
        return proof_size;
    }

    public void setProof_size(int proof_size) {
        this.proof_size = proof_size;
    }

    public String toString()
    {
        String name = "Phone Case: " + getSize() + ", ";
        if (getProof1() != null)
            name += getProof1() + ", ";
        if (getProof2() != null)
            name += getProof2() + ", ";
        name += getMatter() + " matter.\n";
        name += "Waterproof up to " + getProof_size() + " cm.\n";

        return name;
    }
}
