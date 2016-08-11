package page.material;

public class MaterialEnum {

	public enum AttachmentEnum {
		CERTIFICATE(1), QUALITY(2), METHOD(3), OTHER(4);
		public int value;

		private AttachmentEnum(int value) {
			this.value = value;
		}
	}

	public enum OrderTypeEnum {
		ALL(1), SPECIALOFNORMAL(2), NORMAL(3);
		public int value;

		private OrderTypeEnum(int value) {
			this.value = value;
		}
	}
	
}
