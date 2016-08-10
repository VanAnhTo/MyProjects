package util;

public class MaterialEnum {

	public enum AttachmentType {
		CERTIFICATE(1), QUALITY(2), METHOD(3), OTHER(4);
		public int value;

		private AttachmentType(int value) {
			this.value = value;
		}
	}

	public enum OrderType {
		ALL(1), SPECIALOFNORMAL(2), NORMAL(3);
		public int value;

		private OrderType(int value) {
			this.value = value;
		}
	}
	
}
