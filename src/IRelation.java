public interface IRelation {
    /**
     * Checks whether this relation contains a given word
     * 
     * @param v
     * @return
     */
    public boolean containsWord(Word v);

    /**
     * Checks whether this object is of type WordRelation
     * 
     * @return
     */
    public boolean isWordRelation();

    /**
     * Checks whether this object is of type ANDRelation
     * 
     * @return
     */
    public boolean isANDRelation();
}
