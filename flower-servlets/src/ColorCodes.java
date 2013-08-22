
public enum ColorCodes {
	COLOR_GREY("#AAA"),
	
	COLOR_SEED_1("#FFE711"),
	COLOR_SEED_2("#DAA312"),
	COLOR_SEED_3("#FFE711"),
	
	COLOR_TEXT_1("#5c3816")
	;
	
	private ColorCodes (final String text) {
        this.text = text;
    }

    private final String text;

    /* (non-Javadoc)
     * @see java.lang.Enum#toString()
     */
    @Override
    public String toString() {
        return text;
    }
}
