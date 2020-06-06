public class MemberVo {

	private String GROUP_NAME;
	private int UNIQUE_NUMBER;
	private String NAME;
	private String PHONE_NUMBER;
	private String TAG;
	private String ADDRESS;
	private String NEWADDRESS;

	public MemberVo() {

	}

	public MemberVo(String GROUP_NAME, int UNIQUE_NUMBER, String NAME,
			        String PHONE_NUMBER, String TAG, String ADDRESS, String NEWADDRESS) {
		
		this.GROUP_NAME = GROUP_NAME;
		this.UNIQUE_NUMBER = UNIQUE_NUMBER;
		this.NAME = NAME;
		this.PHONE_NUMBER = PHONE_NUMBER;
		this.TAG = TAG;
		this.ADDRESS = ADDRESS;
		this.NEWADDRESS = NEWADDRESS;

	}

	public String getGROUP_NAME() {
		return GROUP_NAME;
	}

	public int getUNIQUE_NUMBER() {
		return UNIQUE_NUMBER;
	}

	public String getNAME() {
		return NAME;
	}

	public String getPHONE_NUMBER() {
		return PHONE_NUMBER;
	}

	public String getTAG() {
		return TAG;
	}
	
	public String getADDRESS() {
		return ADDRESS;
	}
	
	public String getNEWADDRESS() {
		return NEWADDRESS;
	}

}